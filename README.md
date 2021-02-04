
# S-Talk
## Project Goal
Android based secure messenger application.

## To-Do List
- Message data encryption & decryption
- Secondary password using fingerprint

## Application UI
### Sign up & Sign in
![start](https://user-images.githubusercontent.com/20378368/106858846-98bdb900-6705-11eb-83c4-e690581e7ae0.PNG)
- **Sign up**: 회원 가입 기능
- **Sign in**: 로그인 기능
### Reset Password
![reset](https://user-images.githubusercontent.com/20378368/106859126-f5b96f00-6705-11eb-9574-a25868ab7d14.PNG)
- **Reset**: 비밀번호 재설정 기능
- **E-mail Link**: 이메일 링크 클릭 시 재설정 가능
### Main Activity
![main](https://user-images.githubusercontent.com/20378368/106858375-e8e84b80-6704-11eb-8f3a-7951e3476dce.PNG)
- **USERS**: 채팅 가능한 상대 검색
- **CHATS**: User의 채팅 세션 리스트
- **PROFILE**: User의 프로필 정보
### Chat Activity
![chat](https://user-images.githubusercontent.com/20378368/106858325-d5d57b80-6704-11eb-9e12-60b26c219010.PNG)
- **Push message**: Push 알림을 통한 메시지 수신
- **Chat session**: 실시간 채팅 메시지 송·수신

## Firebase
![firebase](https://user-images.githubusercontent.com/20378368/106859640-ade71780-6706-11eb-89ff-dbe02cceebd4.png){: width="40%" height="40%"}{: .center}
### Firebase Project Create
- **Step 1**: [Firebase 콘솔 접속 & 프로젝트 생성](https://console.firebase.google.com/)
- **Step 2**: [google-services.json 파일을 Android Studio의 프로젝트에 추가](https://firebase.google.com/docs/android/setup?hl=ko)
### Firebase Authentication
![image](https://user-images.githubusercontent.com/20378368/106860755-28fcfd80-6708-11eb-8278-8fc809c97c53.png)
- **Step 3**: Authentication 기능 활성화
### Firebase Realtime Database
![image](https://user-images.githubusercontent.com/20378368/106860905-62356d80-6708-11eb-916a-57fad6d40494.png)
- **Step 4**: Realtime Database 기능 활성화
- **Step 5**: Realtime Database 규칙을 true로 설정
### Firebase Storage
![image](https://user-images.githubusercontent.com/20378368/106861009-8729e080-6708-11eb-966a-de7ff8ca0f78.png)
- **Step 6**: Storage 기능 활성화
- **Step 7**: Storage 규칙을 "allow read, write: if true != null;"로 설정
## Firebase Cloud Messaging
![image](https://user-images.githubusercontent.com/20378368/106861863-b2f99600-6709-11eb-8fb7-937220d61596.png)
- **Step 8**: 서버 키를 APIService.java에 붙여넣기

<!--
If you want a APK then create an issue, i'll send the link..
<br><b>ChatApp is a real time one to one chat application with Push Notifications made using Firebase...</b>

Add yours google-services.json
<br><b> Change Authorization:key with your key from firebase project</b>

<br>Implementation Guide 
<br>1 - Project
<br>1 - Open the Project in your android studio;
<br>2 - *IMPORTANT* Change the Package Name. (https://stackoverflow.com/questions/16804093/android-studio-rename-package)

<br>2 - Firebase Panel
<br>- Create Firebase Project (https://console.firebase.google.com/);
<br>- Import the file google-service.json into your project
<br>- Connect to firebase console authentication and database from your IDE
<br>- in firebase Storage Rules, change value of "allow read, write:" from "if request.auth != null" to "if true;"
<br>- For sending notification, paste your Firebase project key into your project APIService.java
<br>- When you change database settings, you likely will need to uninstall and reinstall apps to avoid app crashes due to app caches. -->