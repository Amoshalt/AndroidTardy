package com.example.lomba.firstproject;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnToast;
    private Button btnLog;
    private Button btnCustomToast;
    private final String TAG = "HELLOTAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnToast = (Button) findViewById(R.id.btnToast);
        btnCustomToast = (Button) findViewById(R.id.btnCustomToast);
        btnLog = (Button) findViewById(R.id.btnLog);
        btnToast.setOnClickListener(this);
        btnCustomToast.setOnClickListener(this);
        btnLog.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.equals(btnToast)) {
            Toast.makeText(this, "displaying a toast !", Toast.LENGTH_LONG).show();
        }
        else if (v.equals(btnCustomToast)) {
//display custom toast
        }
        else if (v.equals(btnLog)) {
            Log.i(TAG,"displaying a log !");
        }


    }

    private void displayCustomToast() {
        LayoutInflater inflater = getLayoutInflater();
//construct view using xml layout
        View layout = inflater.inflate(R.layout.toast_layout,
                (ViewGroup) findViewById(R.id.toast_layout_root));
//get textView component
        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText("This is a custom toast");
//prepare the toast and display to
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }



}
