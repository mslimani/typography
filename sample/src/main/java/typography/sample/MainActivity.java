package typography.sample;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.app.TypographyAppCompatDelegate;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by mehdi on 31/01/2016.
 */
public class MainActivity extends AppCompatActivity {

    @NonNull
    @Override
    public AppCompatDelegate getDelegate() {
        return new TypographyAppCompatDelegate(this, super.getDelegate());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
