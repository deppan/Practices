-optimizationpasses 5
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-dontpreverify
-verbose
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*
-keepattributes *Annotation*

-keep public class * extends android.app.Fragment
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application 
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver 
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper 
-keep public class * extends android.preference.Preference
-keep public class com.android.vending.licensing.ILicensingService 

-dontwarn android.support.v4.**

-keep class android.support.v4.** { *; }
-keep interface android.support.v4.app.** { *; }
-keep public class * extends android.support.v4.**

-keepclasseswithmembernames class * {
    native <methods>;
}

-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet); 
}

-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet, int); 
}

-keepclassmembers class * extends android.app.Activity {
   public void *(android.view.View);
}

-keepclassmembers enum * { 
    public static **[] values(); 
    public static ** valueOf(java.lang.String); 
}

-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}

-keepnames class * implements java.io.Serializable

# Disable Log #
-assumenosideeffects class android.util.Log {
    public static int v(...);
    public static int i(...);
    public static int w(...);
    public static int d(...);
    public static int e(...);
}