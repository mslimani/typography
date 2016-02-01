# Typography

Easy load fonts for Android

Use a delegate for AppCompatActivity for override the default typeface

For load a custom use android:fontFamily with the key passed in the configuration class (TypographyConfig)

# Initialization of the global configuration

Initialization in the Application class

```java
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        new TypographyConfig.Builder(this)
                .defaultFont("regular")
                .addFont("regular", "fonts/Roboto-Regular.ttf")
                .addFont("black", "fonts/Roboto-Black.ttf")
                .addFont("light", "fonts/Roboto-Light.ttf")
                .addFont("medium", "fonts/Roboto-Medium.ttf")
                .addFont("thin", "fonts/Roboto-Thin.ttf")
                .buildSingleton();
    }
}
```

# Used a customs fonts in activity

```java
public class MainActivity extends AppCompatActivity {

    @Override
    public AppCompatDelegate getDelegate() {
        return new TypographyAppCompatDelegate(this, super.getDelegate());
    }
    
    ...
    
}
```

# Use custom font in layout

```xml
<!-- load thin font -->
<TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="@string/hello_world"
            android:fontFamily="thin"/>
      
<!-- load medium font -->      
<TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="@string/hello_world"
            android:fontFamily="medium"/>
```



