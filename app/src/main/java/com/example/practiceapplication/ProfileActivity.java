package com.example.practiceapplication;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private ConstraintLayout parent;
    private RelativeLayout relativeWrap;
    private ImageView imgAvatar;
    private TextView txtTitle, txtAuthor;
    private Button btnAllBook, btnCurrentRead, btnAlreadyBook, btnWishList, btnSeeFavorites, btnAbout;
    private static final String TAG = "ProfileActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        initViews();
    }

    private void initViews() {
        btnAllBook = findViewById(R.id.btnAllBook);
        btnCurrentRead = findViewById(R.id.btnCurrentRead);
        btnAlreadyBook = findViewById(R.id.btnAlreadyBook);
        btnWishList = findViewById(R.id.btnWishList);
        btnSeeFavorites = findViewById(R.id.btnSeeFavorites);
        btnAbout = findViewById(R.id.btnAbout);

        // catch event
        btnAllBook.setOnClickListener(this);
        btnCurrentRead.setOnClickListener(this);
        btnAlreadyBook.setOnClickListener(this);
        btnWishList.setOnClickListener(this);
        btnSeeFavorites.setOnClickListener(this);
        btnAbout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btnAllBook:
                intent = new Intent(ProfileActivity.this, SecondActivity.class);
                startActivity(intent);
                break;
            case R.id.btnCurrentRead:
                intent = new Intent(ProfileActivity.this, CurrentReadBook.class);
                startActivity(intent);
                break;
            case R.id.btnAlreadyBook:
                intent = new Intent(ProfileActivity.this, AlreadyReadBookActivity.class);
                startActivity(intent);
                break;
            case R.id.btnWishList:
                intent = new Intent(ProfileActivity.this, WantToReadActivity.class);
                startActivity(intent);
                break;

            case R.id.btnSeeFavorites:
                intent = new Intent(ProfileActivity.this, FavoriteBook.class);
                startActivity(intent);
                break;
            case R.id.btnAbout:
                AlertDialog.Builder builder = new AlertDialog.Builder(ProfileActivity.this);
                builder.setTitle(getString(R.string.app_name));
                builder.setMessage("Designed and develop with love by Meisam ay meiCode.org\n" +
                        "Check my website for more awesome applications");
                builder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                builder.setPositiveButton("Visit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(ProfileActivity.this, WebsiteActivity.class);
                        intent.putExtra("url","https://google.com/");
                        startActivity(intent);
                    }
                });
                builder.create().show();
                break;
        }
    }
}
