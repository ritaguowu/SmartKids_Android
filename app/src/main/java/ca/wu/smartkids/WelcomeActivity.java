package ca.wu.smartkids;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener{

    TextView tvAppName, tvSignInIntro, tvLogo;

    private Button btnSignupIntro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        btnSignupIntro = findViewById(R.id.btnSignup);
        tvSignInIntro = findViewById(R.id.tvSignIn);
        tvAppName = findViewById(R.id.tvAppName);
        tvLogo = findViewById(R.id.tvLogo);

        //Use font downloaded from below website:
        // https://www.1001fonts.com/free-for-commercial-use-fonts.html
        Typeface typeFace = Typeface.createFromAsset(getAssets(), "sacramento.ttf");
        tvAppName.setTypeface(typeFace);


        Typeface typeFaceLogo = Typeface.createFromAsset(getAssets(), "BLKCHCRY.TTF");
        tvLogo.setTypeface(typeFaceLogo);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            getWindow().getInsetsController().hide(WindowInsets.Type.statusBars());
        } else {
            getWindow().setFlags(
                    WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN
            );
        }
        tvSignInIntro.setOnClickListener(this);
        btnSignupIntro.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id==R.id.tvSignIn){
            startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
        }
        else if(id==R.id.btnSignup){
            startActivity(new Intent(WelcomeActivity.this, SignUpActivity.class));
        }
    }
}
