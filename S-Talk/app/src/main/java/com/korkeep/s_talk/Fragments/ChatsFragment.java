package com.korkeep.s_talk.Fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.korkeep.s_talk.Adapter.OnItemClick;
import com.korkeep.s_talk.Adapter.UserAdapter;
import com.korkeep.s_talk.Model.Chatlist;
import com.korkeep.s_talk.Model.User;
import com.korkeep.s_talk.Notifications.Token;
import com.korkeep.s_talk.R;

import java.util.ArrayList;
import java.util.List;


public class ChatsFragment extends Fragment {

    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private List<User> mUsers;

    FrameLayout frameLayout;
    TextView es_descp, es_title;

    FirebaseUser fuser;
    DatabaseReference reference;

    private List<Chatlist> usersList;
    static OnItemClick onItemClick;

    public static ChatsFragment newInstance(OnItemClick click) {
        onItemClick = click;
        Bundle args = new Bundle();

        ChatsFragment fragment = new ChatsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chats, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        frameLayout = view.findViewById(R.id.es_layout);
        es_descp = view.findViewById(R.id.es_descp);
        es_title = view.findViewById(R.id.es_title);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        fuser = FirebaseAuth.getInstance().getCurrentUser();
        usersList = new ArrayList<>();

        reference = FirebaseDatabase.getInstance().getReference("Chatlist").child(fuser.getUid());
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                usersList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Chatlist chatlist = snapshot.getValue(Chatlist.class);
                    usersList.add(chatlist);
                }
                if(usersList.size()==0){
                    frameLayout.setVisibility(View.VISIBLE);
                }
                else{
                    frameLayout.setVisibility(View.GONE);
                }
                chatList();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        updateToken(FirebaseInstanceId.getInstance().getToken());
        return view;
    }

    private void updateToken(String token){
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Tokens");
        Token token1 = new Token(token);
        reference.child(fuser.getUid()).setValue(token1);
    }

    private void chatList() {
        mUsers = new ArrayList<>();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mUsers.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    User user = snapshot.getValue(User.class);
                    for (Chatlist chatlist : usersList){
                        if (user!= null && user.getId()!=null && chatlist!=null && chatlist.getId()!= null &&
                                user.getId().equals(chatlist.getId())){
                            mUsers.add(user);
                        }
                    }
                }
                userAdapter = new UserAdapter(getContext(), onItemClick,mUsers, true);
                recyclerView.setAdapter(userAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
}
