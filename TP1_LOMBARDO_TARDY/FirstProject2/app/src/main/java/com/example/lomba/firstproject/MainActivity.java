package com.example.lomba.firstproject;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnToast;
    private ImageView btnSend;
    private Button btnShare;
    private ImageView imgViewClose;
    private EditText editText;
    private List<String> commentsList;
    private RelativeLayout commentsLayout;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgViewClose = findViewById(R.id.closeButton);
        btnShare = findViewById(R.id.btnShare);
        btnSend = findViewById(R.id.btnSend);
        editText = findViewById(R.id.editTextSend);
        commentsLayout = findViewById(R.id.commentsLayout);

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
    }

    private void sendIt(View v) {
        final EditText nameField = (EditText) findViewById(R.id.editTextSend);
        Log.d("test2", nameField.getText().toString());
        RelativeLayout.LayoutParams lparams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.);
        TextView tv=new TextView(this);
        tv.setLayoutParams(lparams);
        tv.setText("test");
        this.commentsLayout.addView(tv);
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
