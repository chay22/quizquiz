package com.kvikesh800gmail.relativlayoutjava;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SplashActivity extends AppCompatActivity {

    Button show, show2, getStarted, Continue;
    EditText edit_password, edit_name, edit_email, edit_password2;
    TextView toast, name_display, forget;
    MediaPlayer mediaPlayer;
    ImageView icon_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final SharedPreferences sharedPreferences = getSharedPreferences("Content_main", Context.MODE_PRIVATE);
        final String Default = "N/A";

        String name_file = sharedPreferences.getString("name", Default);
        String pass_file = sharedPreferences.getString("password", Default);
        String email_file = sharedPreferences.getString("email", Default);
        String gender_file = sharedPreferences.getString("gender", Default);
        SharedPreferences sp = getSharedPreferences("Score", Context.MODE_PRIVATE);
        if (sp.getInt("Sound", 0) == 0) {
            mediaPlayer = MediaPlayer.create(this, R.raw.abc);
            mediaPlayer.start();
            mediaPlayer.setLooping(true);
        }

        if (name_file.equals(Default) || pass_file.equals(Default) || email_file.equals(Default) || gender_file.equals(Default)) {
            SharedPreferences.Editor editorMock = sharedPreferences.edit();
            editorMock.putString("name", "mock");
            editorMock.putString("password", "mock");
            editorMock.putString("email", "mock@mock.com");
            editorMock.putString("gender", "Male");
            editorMock.commit();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(SplashActivity.this, Navigation_Activity.class);
                    startActivity(intent);
                    finish();
                }
            }, 3500);
        } else {
            setContentView(R.layout.activity_splash);
//            setContentView(R.layout.activity_splash);

//            icon_user = (ImageView) findViewById(R.id.image_icon);
//            icon_user.setImageResource(R.drawable.man);            name_display = (TextView) findViewById(R.id.name_display);
//            name_display.setText(name_file);
//            edit_password2 = (EditText) findViewById(R.id.password2);
//            show2 = (Button) findViewById(R.id.show2);
//            forget = (TextView) findViewById(R.id.forget);
//            Continue = (Button) findViewById(R.id.Continue);
        }
    }

    //Used to add some time so that user cannot directly press and exity out of the activity
    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 4000);

    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sp = getSharedPreferences("Score", Context.MODE_PRIVATE);
        if (sp.getInt("Sound", 0) == 0)
            mediaPlayer.pause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        SharedPreferences sp = getSharedPreferences("Score", Context.MODE_PRIVATE);
        if (sp.getInt("Sound", 0) == 0)
            mediaPlayer.start();
    }
}