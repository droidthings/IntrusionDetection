package com.abi.rtes.data.api;


import com.abi.rtes.data.api.channel.ChannelFeedData;

import java.util.List;

import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

//https://api.thingspeak.com/channels/790451/feeds.json?api_key=0YOTCS4MZRKZBFDV&results=2

public interface RtesAPI {

    @GET("feeds.json?api_key=0YOTCS4MZRKZBFDV&results=1")
    Observable<ChannelFeedData> getChannelFeeds();

}

