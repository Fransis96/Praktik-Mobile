Buka file ``build.gradle (Module: app)`` dan tambahkan dependensi berikut:  
```kotlin
// Retrofit dan Gson
implementation ("com.squareup.retrofit2:retrofit:2.9.0")
implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
// ViewModel
implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.7")
// coil
implementation("io.coil-kt.coil3:coil-compose:3.0.4")
implementation("io.coil-kt.coil3:coil-network-okhttp:3.0.4") 
```
