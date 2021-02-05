
# S-Talk
## Project Goal
보안 기능이 향상된 Android 메신저 앱 개발

## Features
- 공개키 기반 메시지 암·복호화
- TEE를 활용하여 개인키 유출 방지
- 지문 정보를 이용한 2단계 인증
- SSL/TLS를 이용한 데이터 전송

## To-Do List
- 공개키 기반 메시지 암·복호화
- TEE 환경에 개인키 저장
- 지문 정보를 이용한 2단계 인증
- SSL/TLS를 이용한 데이터 전송

## Application UI
### Login Activity
![image](https://user-images.githubusercontent.com/20378368/107027252-37721480-67ef-11eb-9c95-283c3e25f60e.png)
- **Login**: 로그인 기능
- **Register**: 회원 가입 기능
- **Reset**: 비밀번호 재설정 기능
### Main Activity
![main](https://user-images.githubusercontent.com/20378368/106858375-e8e84b80-6704-11eb-8f3a-7951e3476dce.PNG)
- **USERS**: 채팅 상대 리스트
- **CHATS**: User의 채팅 리스트
- **PROFILE**: User의 프로필 정보
### Chat Activity
![chat](https://user-images.githubusercontent.com/20378368/106858325-d5d57b80-6704-11eb-9e12-60b26c219010.PNG)
- **Push**: Push 알림을 통한 메시지 수신
- **Chat**: 실시간 채팅 메시지 송·수신

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
