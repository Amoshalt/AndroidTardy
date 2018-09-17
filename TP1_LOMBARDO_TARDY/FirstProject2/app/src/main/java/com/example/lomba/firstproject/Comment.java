package com.example.lomba.firstproject;

public class Comment {
    private String userName;
    private String text;

    public Comment(String userName, String text) {
        this.setUserName(userName);
        this.setText(text);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
