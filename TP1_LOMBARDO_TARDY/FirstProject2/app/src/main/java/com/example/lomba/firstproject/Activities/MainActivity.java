package com.example.lomba.firstproject.Activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.lomba.firstproject.Adapter.CommentAdapter;
import com.example.lomba.firstproject.Manager.MovieManager;
import com.example.lomba.firstproject.Model.Comment;
import com.example.lomba.firstproject.Model.Movie;
import com.example.lomba.firstproject.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageView btnSend;
    private ImageView mImage;
    private Button btnShare;
    private Button btnLike;
    private Button btnComment;
    private RelativeLayout backLayout;
    private ImageView imgViewClose;
    private EditText editText;
    private int indexComments;
    private LinearLayout tempCommentLayout;
    private Comment tempComment;
    private RelativeLayout commentsLayout;
    private RecyclerView recyclerView;
    private List<Comment> commentList;
    private ScrollView scrollView;
    private TextView mTitle;
    private TextView mOriginalTitle;
    private TextView mDescription;
    private TextView mKeyWords;


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
        tempCommentLayout = findViewById(R.id.comment1);
        scrollView= findViewById(R.id.scrollView);
        commentList = new ArrayList<>();
        recyclerView = findViewById(R.id.commentsLayout);
        mTitle = findViewById(R.id.movieTileD);
        mOriginalTitle= findViewById(R.id.originalMovieTitleD);
        mDescription= findViewById(R.id.descriptionText);
        mKeyWords= findViewById(R.id.keyWordsText);
        mImage = findViewById(R.id.imageMovie);

        CommentAdapter commentAdapter = new CommentAdapter();
        commentAdapter.setmComments(commentList);
        recyclerView.setAdapter(commentAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        tempComment = new Comment(null,"Pas de commentaires",0);
        commentList.add(tempComment);

        imgViewClose.setOnClickListener(new View.OnClickListener() {

            //detect a click occured on the Convert button
            public void onClick(View v) {

                getWindow().closeAllPanels();

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

        Intent i = getIntent();

        Movie movie = MovieManager.getInstance().getMovieById(i.getIntExtra("MOVIE_ID",0));

        mTitle.setText(movie.getmTitle());
        mOriginalTitle.setText(movie.getmOriginalTitle());
        mDescription.setText(movie.getmDescription());
        mKeyWords.setText(movie.getmKeyWords());
        mImage.setImageResource(R.mipmap.godfather);

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

        if (commentList.contains(tempComment)) {
            commentList.remove(tempComment);
        }
        this.commentList.add(new Comment("User 1",nameField.getText().toString(),0));
        refreshData();
    }

    private void refreshData() {

        if (this.recyclerView != null && this.recyclerView.getAdapter() != null) {
            this.recyclerView.getAdapter().notifyDataSetChanged();
        }
    }

    private void shareIt(View v) {
        TextView tvTitle = findViewById(R.id.movieTileD);
        TextView tvOriginalTitle = findViewById(R.id.originalMovieTitleD);
        TextView tvDescription = findViewById(R.id.descriptionText);
        TextView tvKeyWords = findViewById(R.id.keyWordsText);
        ImageView tvImage = findViewById(R.id.imageMovie);

        String title = tvTitle.getText().toString();
        String originalTitle = tvOriginalTitle.getText().toString();
        String description = tvDescription.getText().toString();
        String keyWords = tvKeyWords.getText().toString();

        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("image/jpeg");
        sharingIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        String shareBody = "Title: " + title+ "\n"
                + "Original title: " + originalTitle +  "\n"
                + "Description: " + description +  "\n"
                + "Key words: " + keyWords +  "\n";
        Uri imageUri = Uri.parse("android.resource://" + getPackageName()
                + "/mipmap/" + "godfather");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        sharingIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));

    }


    public static Drawable setTint(Drawable d, int color) {
        Drawable wrappedDrawable = DrawableCompat.wrap(d);
        DrawableCompat.setTint(wrappedDrawable, color);
        return wrappedDrawable;
    }

}
