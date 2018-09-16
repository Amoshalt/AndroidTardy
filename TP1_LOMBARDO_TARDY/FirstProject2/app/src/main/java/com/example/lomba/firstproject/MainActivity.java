package com.example.lomba.firstproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnToast;
    private ImageView btnSend;
    private Button btnShare;
    private Button btnLike;
    private Button btnComment;
    private ImageView imgViewClose;
    private EditText editText;
    private int indexComments;
    private TextView tempComment;
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
        editText = findViewById(R.id.editTextSend);
        commentsLayout = findViewById(R.id.commentsLayout);
        tempComment = findViewById(R.id.comment1);


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
                commentIt(v);
            }
        });


    }

    private void commentIt(View v) {
        EditText editTextToFocus = findViewById(R.id.editTextSend);
        editTextToFocus.setText("");
        editTextToFocus.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);

    }

    private void likeIt(View v) {
        Drawable drawable = getResources().getDrawable(R.drawable.ic_thumb_up_green_24dp);
//        drawable = DrawableCompat.wrap(drawable);
//        DrawableCompat.setTint(drawable, getResources().getColor(R.color.colorPrimary));
        btnLike.setCompoundDrawables(drawable,null,null,null);
    }

    private void sendIt(View v) {
        final EditText nameField = (EditText) findViewById(R.id.editTextSend);

        RelativeLayout.LayoutParams lparams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        lparams.addRule(RelativeLayout.BELOW, tempComment.getId());

        TextView tv=new TextView(this);
        tv.setId(View.generateViewId());
        tv.setLayoutParams(lparams);
        tv.setText(nameField.getText().toString());

        this.commentsLayout.addView(tv);
        this.commentsLayout.removeView(findViewById(R.id.comment1));
        this.tempComment = tv;
    }

    private void shareIt(View v) {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = "Your friend want to share this movie with you:" + "''";
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));

    }


    @Override
    public void onClick(View view) {
    }



}
