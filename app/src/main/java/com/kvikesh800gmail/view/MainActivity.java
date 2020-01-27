package com.kvikesh800gmail.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.kvikesh800gmail.adapter.MenuAdapter;
import com.kvikesh800gmail.adapter.NavigationAdapter;
import com.kvikesh800gmail.helper.RecyclerViewListener;
import com.kvikesh800gmail.model.Menu;
import com.kvikesh800gmail.model.MenuNavigation;
import com.kvikesh800gmail.relativlayoutjava.Help;
import com.kvikesh800gmail.relativlayoutjava.Questions;
import com.kvikesh800gmail.relativlayoutjava.R;
import com.kvikesh800gmail.relativlayoutjava.ScoreCard;
import com.kvikesh800gmail.relativlayoutjava.SettingActivity;

import java.util.ArrayList;
import java.util.List;

//import android.content.DialogInterface;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvMenuNavigation, rvMenu;
    private NavigationAdapter navigationAdapter;
    private MenuAdapter menuAdapter;
    private List<MenuNavigation> menuNavigationList = new ArrayList<>();
    private List<Menu> menuList = new ArrayList<>();
    private ProgressDialog progressBar;
    public final static String Message = "com.kvikesh800gmail.relativlayoutjava.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.green));

        rvMenuNavigation = (RecyclerView) findViewById(R.id.rv_list_quiz);
        rvMenu = (RecyclerView) findViewById(R.id.rv_menu);

        navigationAdapter = new NavigationAdapter(this, menuNavigationList);
        rvMenuNavigation.setLayoutManager(new GridLayoutManager(this, 2));
        rvMenuNavigation.setAdapter(navigationAdapter);

        menuAdapter = new MenuAdapter(this, menuList);
        rvMenu.setLayoutManager(new GridLayoutManager(this, 3));
        rvMenu.setAdapter(menuAdapter);

        recyclerViewListener();

        prepareData();
    }

    private void recyclerViewListener() {
        rvMenuNavigation.addOnItemTouchListener(new RecyclerViewListener(this, rvMenuNavigation, new RecyclerViewListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                progressBar = new ProgressDialog(view.getContext());//Create new object of progress bar type
                progressBar.setCancelable(false);//Progress bar cannot be cancelled by pressing any wher on screen
                progressBar.setMessage("Getting Questions Ready ...");//Title shown in the progress bar
                progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);//Style of the progress bar
                progressBar.setProgress(0);//attributes
                progressBar.setMax(100);//attributes
                progressBar.show();//show the progress bar

                new Handler().postDelayed(() -> {
                    progressBar.cancel();
                    Intent intent;
                    switch (position) {
                        // Base on menuNavigationList List Array Position
                        case 0:
                            intent = new Intent(MainActivity.this, Questions.class);
                            intent.putExtra(Message, "c7");
                            startActivity(intent);
                            break;
                        case 1:
                            intent = new Intent(MainActivity.this, Questions.class);
                            intent.putExtra(Message, "c9");
                            startActivity(intent);
                            break;
                        case 2:
                            intent = new Intent(MainActivity.this, Questions.class);
                            intent.putExtra(Message, "c1");
                            startActivity(intent);
                            break;
                        case 3:
                            intent = new Intent(MainActivity.this, Questions.class);
                            intent.putExtra(Message, "c10");
                            startActivity(intent);
                            break;
                        case 4:
                            intent = new Intent(MainActivity.this, Questions.class);
                            intent.putExtra(Message, "c6");
                            startActivity(intent);
                            break;
                        case 5:
                            intent = new Intent(MainActivity.this, Questions.class);
                            intent.putExtra(Message, "c4");
                            startActivity(intent);
                            break;
                        case 6:
                            intent = new Intent(MainActivity.this, Questions.class);
                            intent.putExtra(Message, "c3");
                            startActivity(intent);
                            break;
                        case 7:
                            intent = new Intent(MainActivity.this, Questions.class);
                            intent.putExtra(Message, "c8");
                            startActivity(intent);
                            break;
                        case 8:
                            intent = new Intent(MainActivity.this, Questions.class);
                            intent.putExtra(Message, "c5");
                            startActivity(intent);
                            break;
                        case 9:
                            intent = new Intent(MainActivity.this, Questions.class);
                            intent.putExtra(Message, "c2");
                            startActivity(intent);
                            break;
                    }

                }, 2000);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));

        rvMenu.addOnItemTouchListener(new RecyclerViewListener(this, rvMenu, new RecyclerViewListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position) {
                    // Base on menuList List Array position.
                    case 0:
                        startActivity(new Intent(MainActivity.this, ScoreCard.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this, SettingActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this, Help.class));
                        break;
                }
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));
    }

    private void prepareData() {
        menuNavigationData();

        menuData();
    }

    private void menuData() {
        Menu menu = new Menu("Score Board", R.drawable.scorecard_drwaer);
        menuList.add(menu);

        menu = new Menu("Settings", R.drawable.setting_drawer);
        menuList.add(menu);

        menu = new Menu("Help", R.drawable.help_drawer);
        menuList.add(menu);

        menuAdapter.notifyDataSetChanged();
    }

    private void menuNavigationData() {
        MenuNavigation menuNavigation = new MenuNavigation("Authors", R.drawable.books);
        menuNavigationList.add(menuNavigation);

        menuNavigation = new MenuNavigation("Capitals", R.drawable.capital);
        menuNavigationList.add(menuNavigation);

        menuNavigation = new MenuNavigation("Computer", R.drawable.computer);
        menuNavigationList.add(menuNavigation);

        menuNavigation = new MenuNavigation("Currency", R.drawable.currency);
        menuNavigationList.add(menuNavigation);

        menuNavigation = new MenuNavigation("English", R.drawable.english);
        menuNavigationList.add(menuNavigation);

        menuNavigation = new MenuNavigation("General Knowledge", R.drawable.general);
        menuNavigationList.add(menuNavigation);

        menuNavigation = new MenuNavigation("Inventions", R.drawable.invention);
        menuNavigationList.add(menuNavigation);

        menuNavigation = new MenuNavigation("Mathematics", R.drawable.maths);
        menuNavigationList.add(menuNavigation);

        menuNavigation = new MenuNavigation("Science", R.drawable.science);
        menuNavigationList.add(menuNavigation);

        menuNavigation = new MenuNavigation("Sports", R.drawable.sports);
        menuNavigationList.add(menuNavigation);

        navigationAdapter.notifyDataSetChanged();
    }
}
