package com.example.myapplication.dataModel;

public class UserData {
    private boolean isLogin;
    private String username;

    public UserData(){

    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
