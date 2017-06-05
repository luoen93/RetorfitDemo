package com.example.eloit.retorfitdemo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Eloit on 2017/6/1.
 */


public interface gitapi {
    @GET("book/{id}")
    Call<BookSearchResponse> getSearchBooks(@Path("id") int id);
}

