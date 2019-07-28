package com.abi.rtes.ui.activity.home;

import android.util.Log;

import com.abi.rtes.base.NetworkInitiateSingleton;
import com.abi.rtes.constants.Constants;
import com.abi.rtes.data.api.RtesAPI;
import com.abi.rtes.data.api.channel.ChannelFeedData;
import com.abi.rtes.preference.IAPreference;

import rx.functions.Action1;
import rx.schedulers.Schedulers;

import static rx.android.schedulers.AndroidSchedulers.mainThread;

public class HomePresenterImpl implements HomePresenter {
    private HomeView mHomeView;

    public HomePresenterImpl(HomeView homeView) {
        this.mHomeView = homeView;
    }

    @Override
    public void getChannelFeeds() {
        RtesAPI restInterface = NetworkInitiateSingleton.getInstance().initiateOkHttp();
        restInterface.getChannelFeeds()
                .observeOn(mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<ChannelFeedData>() {
                    @Override
                    public void call(ChannelFeedData channelFeedData) {
                        mHomeView.onSuccess(channelFeedData);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mHomeView.onError(throwable.getLocalizedMessage());
                    }
                });
    }

    @Override
    public void detectIntrusion(ChannelFeedData channelFeedData) {

        if (channelFeedData != null) {
            Log.d("Actual Value", String.valueOf(Math.abs(Integer.valueOf(channelFeedData.getFeeds().get(0).getField2()))));
            Log.d("Actual Value", String.valueOf(Math.abs(Integer.valueOf(channelFeedData.getFeeds().get(0).getField1()))));
            if(IAPreference.getString(Constants.SP_ACC_X) != null && IAPreference.getString(Constants.SP_ACC_Y) != null){
                Log.d("Calc ValueX", String.valueOf(Math.abs(Integer.valueOf(IAPreference.getString(Constants.SP_ACC_X)) -
                        Integer.valueOf(channelFeedData.getFeeds().get(0).getField1()))));
                Log.d("Calc ValueY", String.valueOf(Math.abs(Integer.valueOf(IAPreference.getString(Constants.SP_ACC_Y)) -
                        Integer.valueOf(channelFeedData.getFeeds().get(0).getField2()))));
                if (Math.abs(Integer.valueOf(IAPreference.getString(Constants.SP_ACC_X)) -
                        Integer.valueOf(channelFeedData.getFeeds().get(0).getField1())) > 500) {
                    mHomeView.onIntrusion(true, channelFeedData);
                } else if (Math.abs(Integer.valueOf(IAPreference.getString(Constants.SP_ACC_Y)) -
                        Integer.valueOf(channelFeedData.getFeeds().get(0).getField2())) > 700) {
                    mHomeView.onIntrusion(true, channelFeedData);
                } else {
                    mHomeView.onIntrusion(false, channelFeedData);
                }
            }else{
                mHomeView.onIntrusion(false, channelFeedData);
            }
        } else {
            mHomeView.onError("Something went wrong!");
        }
        IAPreference.setString(Constants.SP_ACC_X, channelFeedData.getFeeds().get(0).getField1());
        IAPreference.setString(Constants.SP_ACC_Y, channelFeedData.getFeeds().get(0).getField2());
    }
}
