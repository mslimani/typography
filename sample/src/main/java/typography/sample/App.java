package typography.sample;

import android.app.Application;

import typography.TypographyConfig;

/**
 * Created by mehdi on 31/01/2016.
 */
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
