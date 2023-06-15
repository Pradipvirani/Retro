package com.example.register_retrofit_demo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class retro_instance {
    public static Api_interface callApi() {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pradipecommerce.000webhostapp.com/MySite/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api_interface api_interface = retrofit.create(Api_interface.class);

        return api_interface;

    }
}
