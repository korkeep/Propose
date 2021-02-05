
# S-Talk
## Project Goal
보안 기능이 향상된 Android 메신저 앱 개발

## Features
- 공개키 기반 메시지 암·복호화
- TEE를 활용하여 개인키 유출 방지
- 지문 정보를 이용한 2단계 인증
- SSL/TLS를 이용한 데이터 전송

## To-Do List
- 회원 가입 과정에서의 인증 기능 추가
- 공개키 기반 메시지 암·복호화
- TEE 환경에 개인키 저장
- 지문 정보를 이용한 2단계 인증
- SSL/TLS를 이용한 데이터 전송

## Application UI
### Sign up & Sign in
![start](https://user-images.githubusercontent.com/20378368/106858846-98bdb900-6705-11eb-83c4-e690581e7ae0.PNG)
- **Sign up**: 회원 가입 기능
- **Sign in**: 로그인 기능
### Reset Password
![reset](https://user-images.githubusercontent.com/20378368/106859126-f5b96f00-6705-11eb-9574-a25868ab7d14.PNG)
- **Reset**: 비밀번호 재설정 기능
- **E-mail link**: 이메일 링크 클릭 시 재설정 가능
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
![firebase](https://user-images.githubusercontent.com/20378368/106863007-454e6980-670b-11eb-9a32-a37c2c0bf8d0.png)
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
### Firebase Cloud Messaging
![image](https://user-images.githubusercontent.com/20378368/106861863-b2f99600-6709-11eb-8fb7-937220d61596.png)
- **Step 8**: Firebase의 서버 키를 APIService.java에 붙여넣기
