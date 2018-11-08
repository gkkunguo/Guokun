package com.example.helenkellercompute.guokun.i;

import com.example.helenkellercompute.guokun.entity.Translation;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Carson_Ho on 17/3/20.
 */

public interface GetRequest_Interface {


    @GET("ajax.php?a=fy&f=auto&t=auto&w=i%20love%20you")
    Call<Translation> getCall();
}
