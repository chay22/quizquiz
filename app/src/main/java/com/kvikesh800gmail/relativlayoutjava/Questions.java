package com.kvikesh800gmail.relativlayoutjava;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.github.lzyzsd.circleprogress.DonutProgress;

import java.util.ArrayList;
import java.util.Collections;

public class Questions extends AppCompatActivity {
    DonutProgress donutProgress;
    int variable =0;
    TextView ques;
    Button OptA, OptB, OptC, OptD;
    Button play_button;
    boolean isDataReady = false;
    String get;
    //Objects of different classes
    books Books;
    sports Sports;
    currency Currency;
    computer Computer;
    capitals Capitals;
    english English;
    general General;
    ProgressDialog progressBar;
    inventions Inventions;
    maths Maths;
    science Science;
    public int visibility = 0, c1 = 0, c2 = 0, c3 = 0, c4 = 0, c5 = 0, c6 = 0, c7 = 0, c8 = 0, c9 = 0, c10 = 0, i, j = 0, k = 0, l = 0;
    String global = null, Ques, Opta, Optb, Optc, Optd;
    ArrayList<Integer> list = new ArrayList<>();
    Toast toast;
    MediaPlayer mediaPlayer;
    boolean goNext = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SharedPreferences shared = getSharedPreferences("Score", Context.MODE_PRIVATE);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();//recieving the intent send by the Navigation activity
        get = intent.getStringExtra(Navigation_Activity.Message);//converting that intent message to string using the getStringExtra() method
        toast = new Toast(this);
        //attribute of the circular progress bar
        donutProgress = (DonutProgress) findViewById(R.id.donut_progress);
        donutProgress.setMax(100);
        donutProgress.setFinishedStrokeColor(Color.parseColor("#FFFB385F"));
        donutProgress.setTextColor(Color.parseColor("#FFFB385F"));
        donutProgress.setKeepScreenOn(true);
        SharedPreferences sp = getSharedPreferences("Score", Context.MODE_PRIVATE);
        //To play background sound
        if (sp.getInt("Sound", 0) == 0) {
            mediaPlayer = MediaPlayer.create(this, R.raw.abc);
            mediaPlayer.start();
            mediaPlayer.setLooping(true);
        }

        //Now the linking of all the datbase files with the Question activity
        Books = new books(this);
        Books.createDatabase();
        Books.openDatabase();
        Books.getWritableDatabase();

        Capitals = new capitals(this);
        Capitals.createDatabase();
        Capitals.openDatabase();
        Capitals.getWritableDatabase();

        Computer = new computer(this);
        Computer.createDatabase();
        Computer.openDatabase();
        Computer.getWritableDatabase();

        Currency = new currency(this);
        Currency.createDatabase();
        Currency.openDatabase();
        Currency.getWritableDatabase();

        English = new english(this);
        English.createDatabase();
        English.openDatabase();
        English.getWritableDatabase();

        General = new general(this);
        General.createDatabase();
        General.openDatabase();
        General.getWritableDatabase();

        Inventions = new inventions(this);
        Inventions.createDatabase();
        Inventions.openDatabase();
        Inventions.getWritableDatabase();

        Maths = new maths(this);
        Maths.createDatabase();
        Maths.openDatabase();
        Maths.getWritableDatabase();

        Science = new science(this);
        Science.createDatabase();
        Science.openDatabase();
        Science.getWritableDatabase();

        Sports = new sports(this);
        Sports.createDatabase();
        Sports.openDatabase();
        Sports.getWritableDatabase();
        //Till here we are linking the database file
        OptA = (Button) findViewById(R.id.OptionA);
        OptB = (Button) findViewById(R.id.OptionB);
        OptC = (Button) findViewById(R.id.OptionC);
        OptD = (Button) findViewById(R.id.OptionD);
        ques = (TextView) findViewById(R.id.Questions);
        play_button = (Button) findViewById(R.id.play_button);//Play button to start the game

    }


    public void onClick(View v) {//When this method is executed then there will be new question came and also same method for play button
        final SharedPreferences shared = getSharedPreferences("Score", Context.MODE_PRIVATE);
        k++;
        if (visibility == 0) {
            //showing the buttons which were previously invisible
            OptA.setVisibility(View.VISIBLE);
            OptB.setVisibility(View.VISIBLE);
            OptC.setVisibility(View.VISIBLE);
            OptD.setVisibility(View.VISIBLE);
            play_button.setVisibility(View.GONE);
            donutProgress.setVisibility(View.VISIBLE);
            visibility = 1;
            new CountDownTimer(50000, 1000) {//countdowntimer
                int i = 100;

                @Override
                public void onTick(long millisUntilFinished) {
                    i = i - 2;
                    donutProgress.setProgress(i);


                }

                @Override
                public void onFinish() {
                    toast.cancel();
                    SharedPreferences.Editor editor = shared.edit();//here we are saving the data when the countdown timer will finish and it is saved in shared prefrence file that is defined in onCreate method as score
                    editor.putInt("Questions", k).commit();
                    if (get.equals("c1") && shared.getInt("Computer", 0) < l)
                        editor.putInt("Computer", l * 10).apply();
                    else if (get.equals("c2") && shared.getInt("Sports", 0) < l)
                        editor.putInt("Sports", l * 10).apply();
                    else if (get.equals("c3") && shared.getInt("Inventions", 0) < l)
                        editor.putInt("Inventions", l * 10).apply();
                    else if (get.equals("c4") && shared.getInt("General", 0) < l)
                        editor.putInt("General", l * 10).apply();
                    else if (get.equals("c5") && shared.getInt("Science", 0) < l)
                        editor.putInt("Science", l * 10).apply();
                    else if (get.equals("c6") && shared.getInt("English", 0) < l)
                        editor.putInt("English", l * 10).apply();
                    else if (get.equals("c7") && shared.getInt("Books", 0) < l)
                        editor.putInt("Books", l * 10).apply();
                    else if (get.equals("c8") && shared.getInt("Maths", 0) < l)
                        editor.putInt("Maths", l * 10).apply();
                    else if (get.equals("c9") && shared.getInt("Capitals", 0) < l)
                        editor.putInt("Capitals", l * 10).apply();
                    else if (get.equals("c10") && shared.getInt("Currency", 0) < l)
                        editor.putInt("Currency", l * 10).apply();
                    donutProgress.setProgress(0);
                    if(variable==0) {
                        Intent intent = new Intent(Questions.this, Result.class);
                        intent.putExtra("correct", l);
                        intent.putExtra("attemp", k);
                        startActivity(intent);
                        finish();
                    }
                }
            }.start();
        }

        if (global != null) {
            if (global.equals("A")) {
                if (v.getId() == R.id.OptionA) {
                    //Here we use the snackbar because if we use the toast then they will be stacked an user cannot idetify which questions answer is it showing
                    Snackbar.make(v, "         Correct ☺", Snackbar.LENGTH_SHORT).show();

                    l++;
                } else {
                    Snackbar.make(v, "Incorrect\t      Answer :" + Opta + "", Snackbar.LENGTH_SHORT).show();
                }

            } else if (global.equals("B")) {
                if (v.getId() == R.id.OptionB) {
                    Snackbar.make(v, "          Correct ☺", Snackbar.LENGTH_SHORT).show();
                    l++;
                } else {
                    Snackbar.make(v, "Incorrect\t      Answer :" + Optb + "", Snackbar.LENGTH_SHORT).show();
                }

            } else if (global.equals("C")) {
                if (v.getId() == R.id.OptionC) {

                    Snackbar.make(v, "         Correct ☺", Snackbar.LENGTH_SHORT).show();
                    l++;
                } else {
                    Snackbar.make(v, "Incorrect\tAnswer :" + Optc + "", Snackbar.LENGTH_SHORT).show();
                }
            } else if (global.equals("D")) {
                if (v.getId() == R.id.OptionD) {
                    Snackbar.make(v, "        Correct ☺", Snackbar.LENGTH_SHORT).show();
                    l++;
                } else {

                    Snackbar.make(v, "Incorrect\tAnswer :" + Optd + "", Snackbar.LENGTH_SHORT).show();
                }
            }
        }

        if (isDataReady) {
            loadQuiz();
        } else {
            isDataReady = true;
            list = LoadData.init(get);

            loadQuiz();
        }
    }

    private void deployQuiz(String type) {
        switch (type) {
            case "c1":
                Ques = Computer.readQuestion(list.get(j));
                Opta = Computer.readOptionA(list.get(j));
                Optb = Computer.readOptionB(list.get(j));
                Optc = Computer.readOptionC(list.get(j));
                Optd = Computer.readOptionD(list.get(j));
                global = Computer.readAnswer(list.get(j++));
            break;
            case "c2":
                Ques = Sports.readQuestion(list.get(j));
                Opta = Sports.readOptionA(list.get(j));
                Optb = Sports.readOptionB(list.get(j));
                Optc = Sports.readOptionC(list.get(j));
                Optd = Sports.readOptionD(list.get(j));
                global = Sports.readAnswer(list.get(j++));
            break;
            case "c3":
                Ques = Inventions.readQuestion(list.get(j));
                Opta = Inventions.readOptionA(list.get(j));
                Optb = Inventions.readOptionB(list.get(j));
                Optc = Inventions.readOptionC(list.get(j));
                Optd = Inventions.readOptionD(list.get(j));
                global = Inventions.readAnswer(list.get(j++));
            break;
            case "c4":
                Ques = General.readQuestion(list.get(j));
                Opta = General.readOptionA(list.get(j));
                Optb = General.readOptionB(list.get(j));
                Optc = General.readOptionC(list.get(j));
                Optd = General.readOptionD(list.get(j));
                global = General.readAnswer(list.get(j++));
            break;
            case "c5":
                Ques = Science.readQuestion(list.get(j));
                Opta = Science.readOptionA(list.get(j));
                Optb = Science.readOptionB(list.get(j));
                Optc = Science.readOptionC(list.get(j));
                Optd = Science.readOptionD(list.get(j));
                global = Science.readAnswer(list.get(j++));
            break;
            case "c6":
                Ques = English.readQuestion(list.get(j));
                Opta = English.readOptionA(list.get(j));
                Optb = English.readOptionB(list.get(j));
                Optc = English.readOptionC(list.get(j));
                Optd = English.readOptionD(list.get(j));
                global = English.readAnswer(list.get(j++));
            break;
            case "c7":
                Ques = Books.readQuestion(list.get(j));
                Opta = Books.readOptionA(list.get(j));
                Optb = Books.readOptionB(list.get(j));
                Optc = Books.readOptionC(list.get(j));
                Optd = Books.readOptionD(list.get(j));
                global = Books.readAnswer(list.get(j++));
            break;
            case "c8":
                Ques = Maths.readQuestion(list.get(j));
                Opta = Maths.readOptionA(list.get(j));
                Optb = Maths.readOptionB(list.get(j));
                Optc = Maths.readOptionC(list.get(j));
                Optd = Maths.readOptionD(list.get(j));
                global = Maths.readAnswer(list.get(j++));
            break;
            case "c9":
                Ques = Capitals.readQuestion(list.get(j));
                Opta = Capitals.readOptionA(list.get(j));
                Optb = Capitals.readOptionB(list.get(j));
                Optc = Capitals.readOptionC(list.get(j));
                Optd = Capitals.readOptionD(list.get(j));
                global = Capitals.readAnswer(list.get(j++));
            break;
            case "c10":
                Ques = Currency.readQuestion(list.get(j));
                Opta = Currency.readOptionA(list.get(j));
                Optb = Currency.readOptionB(list.get(j));
                Optc = Currency.readOptionC(list.get(j));
                Optd = Currency.readOptionD(list.get(j));
                global = Currency.readAnswer(list.get(j++));
            break;
        }

        ques.setText("" + Ques);
        OptA.setText(Opta);
        OptB.setText(Optb);
        OptC.setText(Optc);
        OptD.setText(Optd);
    }

    private void loadQuiz() {
        if (list.size() > j + 1) {
            deployQuiz(get);
        } else {
            final SharedPreferences shared = getSharedPreferences("Score", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = shared.edit();//here we are saving the data when the countdown timer will finish and it is saved in shared prefrence file that is defined in onCreate method as score
            editor.putInt("Questions", k).commit();
            if (get.equals("c1") && shared.getInt("Computer", 0) < l)
                editor.putInt("Computer", l * 10).apply();
            else if (get.equals("c2") && shared.getInt("Sports", 0) < l)
                editor.putInt("Sports", l * 10).apply();
            else if (get.equals("c3") && shared.getInt("Inventions", 0) < l)
                editor.putInt("Inventions", l * 10).apply();
            else if (get.equals("c4") && shared.getInt("General", 0) < l)
                editor.putInt("General", l * 10).apply();
            else if (get.equals("c5") && shared.getInt("Science", 0) < l)
                editor.putInt("Science", l * 10).apply();
            else if (get.equals("c6") && shared.getInt("English", 0) < l)
                editor.putInt("English", l * 10).apply();
            else if (get.equals("c7") && shared.getInt("Books", 0) < l)
                editor.putInt("Books", l * 10).apply();
            else if (get.equals("c8") && shared.getInt("Maths", 0) < l)
                editor.putInt("Maths", l * 10).apply();
            else if (get.equals("c9") && shared.getInt("Capitals", 0) < l)
                editor.putInt("Capitals", l * 10).apply();
            else if (get.equals("c10") && shared.getInt("Currency", 0) < l)
                editor.putInt("Currency", l * 10).apply();

            progressBar = new ProgressDialog(this);//Create new object of progress bar type
            progressBar.setCancelable(false);//Progress bar cannot be cancelled by pressing any wher on screen
            progressBar.setMessage("Preparing Result ...");//Title shown in the progress bar
            progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);//Style of the progress bar
            progressBar.setProgress(0);//attributes
            progressBar.setMax(100);//attributes
            progressBar.show();//show the progress bar
            //This handler will add a delay of 3 seconds
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    //Intent start to open the navigation drawer activity
                    progressBar.cancel();//Progress bar will be cancelled (hide from screen) when this run function will execute after 3.5seconds
                    Intent intent = new Intent(Questions.this, Result.class);
                    intent.putExtra("correct", l);
                    intent.putExtra("attemp", k);
                    startActivity(intent);
                    finish();
                }
            }, 2000);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        variable =1;
        SharedPreferences sp = getSharedPreferences("Score", Context.MODE_PRIVATE);
        if (sp.getInt("Sound", 0) == 0)
            mediaPlayer.pause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        variable =1;
        SharedPreferences sp = getSharedPreferences("Score", Context.MODE_PRIVATE);
        if (sp.getInt("Sound", 0) == 0)
            mediaPlayer.start();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        variable = 1;
        finish();
    }
}
