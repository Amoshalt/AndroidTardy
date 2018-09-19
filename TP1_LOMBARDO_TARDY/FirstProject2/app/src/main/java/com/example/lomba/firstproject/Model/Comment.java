package com.example.lomba.firstproject.Model;

public class Comment {
    private String userName;
    private String text;
    private int userImageId;

    public Comment(String userName, String text, int userImageId) {
        this.setUserName(userName);
        this.setText(text);
        this.setuserImageId(userImageId);
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

    public int getuserImageId() {
        return userImageId;
    }

    public void setuserImageId(int userImageId) {
        this.userImageId = userImageId;
    }
}
