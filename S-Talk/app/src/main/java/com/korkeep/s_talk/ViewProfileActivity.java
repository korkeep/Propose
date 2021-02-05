package com.korkeep.s_talk;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.korkeep.s_talk.Model.User;

public class ViewProfileActivity extends BottomSheetDialogFragment {

    String uid;
    DatabaseReference reference;
    TextView username, bio_et;
    ImageView profile_img;
    static Context mContext;

    public ViewProfileActivity() {
    }

    public static ViewProfileActivity newInstance(String uid, Context context) {
        Bundle args = new Bundle();
        args.putString("uid",uid);
        mContext = context;
        ViewProfileActivity fragment = new ViewProfileActivity();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_view_profile,container,false);
        if(getArguments()!=null){
            uid = getArguments().getString("uid");
            profile_img =  view.findViewById(R.id.view_profile_image);
            username = view.findViewById(R.id.view_username);
            bio_et = view.findViewById(R.id.view_bio_et);

            reference = FirebaseDatabase.getInstance().getReference("Users").child(uid);
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    User user = dataSnapshot.getValue(User.class);
                    username.setText(user.getUsername());
                    bio_et.setText(user.getBio());
                    if (user.getImageURL().equals("default")){
                        profile_img.setImageResource(R.drawable.profile_img);
                    } else {
                        Glide.with(mContext.getApplicationContext()).load(user.getImageURL()).into(profile_img);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                }
            });
        }
        return view;
    }
}
