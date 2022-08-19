package ca.wu.smartkids.util;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import ca.wu.smartkids.R;

public class UITools extends AppCompatActivity {
    public void setupActionBar(Toolbar toolbarSignupActivity) {
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
