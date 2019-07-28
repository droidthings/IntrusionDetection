package com.abi.rtes.ui.activity.home;

import com.abi.rtes.data.api.channel.ChannelFeedData;

public interface HomeView {
    void onSuccess(ChannelFeedData channelFeedData);

    void onError(String localizedMessage);

    void onIntrusion(boolean isIntruded, ChannelFeedData channelFeedData);
}
