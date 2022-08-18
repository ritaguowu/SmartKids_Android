package ca.wu.smartkids;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowManager;


public class SignUpActivity extends AppCompatActivity {
    Toolbar toolbarSignupActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //Make app use full screen
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            getWindow().getInsetsController().hide(WindowInsets.Type.statusBars());
        } else {
            getWindow().setFlags(
                    WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN
            );
        }
        toolbarSignupActivity = (Toolbar) findViewById(R.id.toolbarSignupActivity);

        setupActionBar();

    }

    private void setupActionBar() {
        setSupportActionBar(toolbarSignupActivity);
        toolbarSignupActivity.setNavigationIcon(R.drawable.ic_black_back_24dp);
        toolbarSignupActivity.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}