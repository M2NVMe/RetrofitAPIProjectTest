package com.example.retrofitapiproject.recycler;

import com.example.retrofitapiproject.Teams;

import java.util.List;

public class ItemsMe {
    String title;
    String badge;
    private List<Teams> teams;

    public ItemsMe(String title, String badge) {
        this.title = title;
        this.badge = badge;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBadge() {
        return badge;
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }
}
