Juice
=====
A simple UI library that aims to extend the functionality of Android's default UI elements.

Written in Kotlin. Juice requires at minimum Android API 14.

Gradle 
------
app.gradle
```
compile 'com.jelletenbrinke:lib:0.4'
```
project gradle
```
allprojects {
    repositories {
        mavenCentral()
        maven { url 'https://dl.bintray.com/doppie/Android'}
        ..
    }
}
```

Usage
-----
ScalingView
The scaling button layout gives the user scaling feedback when the view is used as a button. A smooth and fun experience. 
It is a simple extended LinearLayout and can be used like every other LinearLayout. 

Sample button: 
```
<com.jelletenbrinke.lib.ScalingLinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="@color/accent"
        android:clickable="true"
        android:foreground="?attr/selectableItemBackground"
        android:orientation="vertical"
        app:scaleDp="16dp">
      
        ... put some content views here
        
</com.jelletenbrinke.lib.ScalingLinearLayout>
```

