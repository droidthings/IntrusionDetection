package com.abi.rtes.ui.activity.home;

import com.abi.rtes.data.api.channel.ChannelFeedData;

public interface HomePresenter {

    void getChannelFeeds();

    void detectIntrusion(ChannelFeedData channelFeedData);
}
