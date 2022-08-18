package ca.wu.smartkids;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.TextView;


public class SplashActivity extends AppCompatActivity {
    TextView tvAppName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        tvAppName = findViewById(R.id.tvAppName);

        //Make app use full screen
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            getWindow().getInsetsController().hide(WindowInsets.Type.statusBars());
        } else {
            getWindow().setFlags(
                    WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN
            );
        }

        //Use font downloaded from below website:
//        // https://www.1001fonts.com/free-for-commercial-use-fonts.html
        Typeface typeFace = Typeface.createFromAsset(getAssets(), "sacramento.ttf");
        tvAppName.setTypeface(typeFace);


        //Jump to IntroActivity after 2.5s
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, WelcomeActivity.class));
                finish();
            }
        }, 2500);
    }
}
