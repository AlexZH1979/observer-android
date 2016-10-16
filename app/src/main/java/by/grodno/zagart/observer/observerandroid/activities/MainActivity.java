package by.grodno.zagart.observer.observerandroid.activities;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import by.grodno.zagart.observer.observerandroid.BuildConfig;
import by.grodno.zagart.observer.observerandroid.R;
import by.grodno.zagart.observer.observerandroid.singleton.ContextHolder;
import by.grodno.zagart.observer.observerandroid.http.HttpGetRequestTask;

/**
 * Application main activity.
 */
public class MainActivity extends AppCompatActivity {
    public static final String URL = "http://10.0.2.2:8080/Observer/AndroidRequestHandler";

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActionBar bar = getSupportActionBar();
        if (bar != null) {
            bar.hide();
        }
        setContentView(R.layout.main_activity);
    }

    public void onExitClick(View view) {
        this.finish();
    }

    public void onInfoClick(View view) {
        final String appInfo = String.format(
                getString(R.string.app_info_toast),
                BuildConfig.BUILD_TYPE,
                BuildConfig.FLAVOR_country,
                BuildConfig.APP_COST);
        Toast.makeText(this, appInfo, Toast.LENGTH_LONG).show();
    }

    public void onLoginClick(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

    public void onSettingsClick(View view) {
        ContextHolder.set(this);
        final HttpGetRequestTask task = new HttpGetRequestTask(URL);
        task.execute();
    }
}
