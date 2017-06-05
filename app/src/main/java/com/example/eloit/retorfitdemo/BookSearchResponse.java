package com.example.eloit.retorfitdemo;

import com.google.gson.annotations.Expose;

/**
 * Created by Eloit on 2017/6/1.
 */
public class BookSearchResponse {
    @Expose
    private String title;



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
