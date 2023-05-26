package com.project.waterify30;

public class MainModelFriendList {

    String name, email;

    MainModelFriendList()
    {

    }

    public MainModelFriendList(String name,String email)
    {
        this.name = name;
        this.email = email;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }


}
