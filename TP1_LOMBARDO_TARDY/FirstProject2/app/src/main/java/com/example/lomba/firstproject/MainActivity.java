package com.example.lomba.firstproject;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageView btnSend;
    private Button btnShare;
    private Button btnLike;
    private Button btnComment;
    private RelativeLayout backLayout;
    private ImageView imgViewClose;
    private EditText editText;
    private int indexComments;
    private LinearLayout tempCommentLayout;
    private TextView tempCommentTV;
    private RelativeLayout commentsLayout;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        indexComments = 1;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgViewClose = findViewById(R.id.closeButton);
        btnShare = findViewById(R.id.btnShare);
        btnSend = findViewById(R.id.btnSend);
        btnLike = findViewById(R.id.btnLike);
        btnComment = findViewById(R.id.btnComment);
        backLayout = findViewById(R.id.backLayout);
        imgViewClose = findViewById(R.id.closeButton);
        editText = findViewById(R.id.editTextSend);
        commentsLayout = findViewById(R.id.commentsLayout);
        tempCommentLayout = findViewById(R.id.comment1);
        tempCommentTV = findViewById(R.id.commentTV);


        imgViewClose.setOnClickListener(new View.OnClickListener() {

            //detect a click occured on the Convert button
            public void onClick(View v) {

                getWindow().closeAllPanels();
                    Log.i("  ocou"," coi  ");
                    //close the page

            }
        });

        btnShare.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                shareIt(v);
            }
        });

        btnSend.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sendIt(v);
            }
        });

        btnLike.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                likeIt(v);
            }
        });

        btnComment.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                focusOnIt(v);
            }
        });

        editText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                focusOnIt(v);
            }
        });

        editText.clearFocus();

        imgViewClose.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                closeIt(v);
            }
        });
        backLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                closeIt(v);
            }
        });




    }

    private void closeIt(View v) {
        finishAffinity();
        System.exit(0);
    }

    private void focusOnIt(View v) {
        EditText editTextToFocus = findViewById(R.id.editTextSend);
        editTextToFocus.setText("");
        editTextToFocus.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);

    }

    private void likeIt(View v) {

        Drawable drawable = btnLike.getCompoundDrawablesRelative()[0];

        if (btnLike.getDefaultFocusHighlightEnabled() == false) {
            setTint(drawable,Color.parseColor("#04A736"));
            btnLike.setTextColor(Color.parseColor("#04A736"));
            btnLike.setDefaultFocusHighlightEnabled(true);
        }else {
            setTint(drawable,Color.parseColor("#000000"));
            btnLike.setTextColor(Color.parseColor("#000000"));
            btnLike.setDefaultFocusHighlightEnabled(false);
        }



        btnLike.setCompoundDrawablesRelative(drawable,null,null,null);

    }

    private void sendIt(View v) {
        final EditText nameField = (EditText) findViewById(R.id.editTextSend);

        RelativeLayout.LayoutParams lparams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);

        lparams.addRule(RelativeLayout.BELOW, tempCommentLayout.getId());
lparams.setMargins(2,2,2,2);

        LinearLayout ll = new LinearLayout(this);

        ll.setId(View.generateViewId());
        ll.setLayoutParams(lparams);
        TextView tv = new TextView(this);
        tv.setLayoutParams(lparams);
        tv.setText(nameField.getText().toString());
        tv.setTextColor(Color.parseColor("#ffffff"));
        ll.addView(tv);
        tv.setBackgroundColor(Color.parseColor("#262626"));
        this.commentsLayout.addView(ll);
        this.commentsLayout.removeView(findViewById(R.id.comment1));
        this.tempCommentLayout = ll;
    }

    private void shareIt(View v) {
        TextView tvTitle = findViewById(R.id.movieTileD);
        TextView tvOriginalTitle = findViewById(R.id.originalMovieTitleD);
        TextView tvDescription = findViewById(R.id.descriptionText);
        TextView tvKeyWords = findViewById(R.id.keyWordsText);


        String title = tvTitle.getText().toString();
        String originalTitle = tvOriginalTitle.getText().toString();
        String description = tvDescription.getText().toString();
        String keyWords = tvKeyWords.getText().toString();

        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = "Title: " + title+ "\n"
                + "Original title: " + originalTitle +  "\n"
                + "Description: " + description +  "\n"
                + "Key words: " + keyWords +  "\n";
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));

    }


    public static Drawable setTint(Drawable d, int color) {
        Drawable wrappedDrawable = DrawableCompat.wrap(d);
        DrawableCompat.setTint(wrappedDrawable, color);
        return wrappedDrawable;
    }

}
