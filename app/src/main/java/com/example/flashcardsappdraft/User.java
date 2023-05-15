package com.example.flashcardsappdraft;

public class User {
    public String Name;
    public String Desc;
    public int Id;
    public boolean hasFollowed;

    public User(){}

    public User(String name, String desc, int id, boolean hasFollowed) {
        Name = name;
        Desc = desc;
        Id = id;
        this.hasFollowed = hasFollowed;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public boolean isHasFollowed() {
        return hasFollowed;
    }

    public void setHasFollowed(boolean hasFollowed) {
        this.hasFollowed = hasFollowed;
    }
}
