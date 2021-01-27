
# S-Talk #

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
<br>- When you change database settings, you likely will need to uninstall and reinstall apps to avoid app crashes due to app caches.