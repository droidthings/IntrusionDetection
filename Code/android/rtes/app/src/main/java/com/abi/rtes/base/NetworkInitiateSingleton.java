package com.abi.rtes.base;

import com.abi.rtes.constants.ConstantsURL;
import com.abi.rtes.data.api.RtesAPI;
import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;


public class NetworkInitiateSingleton extends NetworkInitiateFactory {
  private static NetworkInitiateSingleton ourInstance = new NetworkInitiateSingleton();

  private NetworkInitiateSingleton() {
  }

  public static NetworkInitiateSingleton getInstance() {
    return ourInstance;
  }

  public RtesAPI initiateOkHttp() {
    OkHttpClient okHttpClient = new OkHttpClient();
    okHttpClient.setConnectTimeout(20, TimeUnit.SECONDS);
    okHttpClient.setReadTimeout(20, TimeUnit.SECONDS);
    okHttpClient.setWriteTimeout(60, TimeUnit.SECONDS);
    Retrofit retrofit = new Retrofit.Builder().baseUrl(ConstantsURL.BASE_URL)
        .client(okHttpClient)
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build();
    ///making object of RestAdapter
    return retrofit.create(RtesAPI.class);
  }

}
