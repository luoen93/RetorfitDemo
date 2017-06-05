package com.example.eloit.retorfitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Button test_button;
    TextView show_test;

    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        show_test = (TextView) findViewById(R.id.show_json);
        test_button = (Button) findViewById(R.id.test_button);

        get_retorfit();

        test_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //接口调用
                gitapi service = retrofit.create(gitapi.class);
                //传递参数
                Call<BookSearchResponse> call_data = service.getSearchBooks(1003078);

                //
                call_data.enqueue(new Callback<BookSearchResponse>() {
                    @Override
                    public void onResponse(Call<BookSearchResponse> call, Response<BookSearchResponse> response) {

                        BookSearchResponse result = response.body();

                        String title = result.getTitle();

                        System.out.println("|||" + title);

//                        System.out.println(result);
                    }

                    @Override
                    public void onFailure(Call<BookSearchResponse> call, Throwable t) {
                        t.printStackTrace();
                    }
                });


            }
        });

    }

    private void get_retorfit() {
        retrofit = new Retrofit.Builder()
                //URL地址
                .baseUrl("https://api.douban.com/v2/")
                //添加支持
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }
}
