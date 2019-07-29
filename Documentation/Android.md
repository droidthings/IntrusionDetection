# Android

## Installation

Download the latest version of [Android] studio according to your preferred operating system. Install the latest Android SDK (API 29) once the Android studio is installed. 
The current Android application targets
```
 minSdkVersion 19
 targetSdkVersion 29
```
It runs on devices with os from Android KitKat till Android Q.

## Data source configuration
As it is explained in architecture of the application the data source for the Android application is [ThingSpeak] analytics portal.

### Configuration
The API exposed from ThingSpeak portal
```
https://api.thingspeak.com/channels/790451/feeds.json?api_key=0YOTCS4MZRKZBFDV&results=1
```

Using Retrofit HTTP client for Android we can configure the API in a singleton class so that api can be accessed from anywhere in the application.

```
public static String BASE_URL = "https://api.thingspeak.com/channels/790451/";
```

```
public interface RtesAPI {
    @GET("feeds.json?api_key=0YOTCS4MZRKZBFDV&results=1")
    Observable<ChannelFeedData> getChannelFeeds();

}
```

_ChannelFeedData_ will have all the objects of the JSON data which it is receiving from ThingSpeak network.

```
{
    "channel": {
        "id": 790451,
        "name": "ESP32 Test channel",
        "description": "Testing to connect ESP32",
        "latitude": "0.0",
        "longitude": "0.0",
        "field1": "X",
        "field2": "Y",
        "created_at": "2019-05-29T09:51:24Z",
        "updated_at": "2019-07-20T14:33:11Z",
        "last_entry_id": 671
    },
    "feeds": [
        {
            "created_at": "2019-07-25T22:16:52Z",
            "entry_id": 671,
            "field1": "908",
            "field2": "236"
        }
    ]
}
```

Set-up the base Retrofit API necessary for the application

```
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
```

## Implementation

As this is a REST API, on the Andorid application we need to create a thread which runs in background every minute. Since, The ESP32 sends the data to ThingSpeak on per minute cycle. _CHANNEL_INTERVAL_ is set to 1 minute

```
 Runnable channelRunnable = new Runnable() {
        @Override
        public void run() {
            ProgressUtils.showProgress(HomeActivity.this, "Loading Channel Data");
            homePresenter.getChannelFeeds();
            mHandler.postDelayed(channelRunnable,  Constants.CHANNEL_INTERVAL);
        }
 ```
 
When the data is received for the first time it is stored on Android [SharedPreference] which is a local key-value storage interface.
And then sent to display on UI. When the data is received in next minute it is compared with previously stored data, if the difference between  acceleration values is more than 500 units (X-axis) or 700 units (Y-axis) it is considered as an intrusion and at this point there will be a spike on the ThingSpeak graph which shows sudden imbalance in the values and user is notified.

![mob-1]

Since the app is just a prototype only X and Y axis values are considered. The calculations are made on the state graph on ThingSpeak.
Might not be 100% accurate in terms of detecting intrusion as values need to be studied to arrive at the difference between consecutive values to be considered an intrusion.


----


[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)


   [Android]: <https://developer.android.com/studio>
   [ThingSpeak]: <https://thingspeak.com>
   [Retrofit]: <https://square.github.io/retrofit/>
   [SharedPreference]: <https://developer.android.com/reference/android/content/SharedPreferences>
   [mob-1]: <https://user-images.githubusercontent.com/10976047/62008036-02462a00-b155-11e9-98e4-8bc8e68b0f5a.PNG>

   [nr-6]: <https://user-images.githubusercontent.com/10976047/61996321-5ab4f300-b093-11e9-82b9-58edbf451421.png>
   [nr-7]: <https://user-images.githubusercontent.com/10976047/61995874-3276c580-b08e-11e9-99a5-8e84b7d61cd2.PNG>
   [nr-8]: <https://user-images.githubusercontent.com/10976047/61995884-3e628780-b08e-11e9-8792-5335720c817b.PNG>
   [flows]: <https://github.com/ambinabhi/IntrusionDetection/blob/master/Code/Node-RED%20flows/flows.json>
   [nr-9]: <https://user-images.githubusercontent.com/10976047/61996163-846d1a80-b091-11e9-9fb1-a9727958e478.PNG>
   [nr-10]: <https://user-images.githubusercontent.com/10976047/61996185-cdbd6a00-b091-11e9-9b65-5cd7816b9885.PNG>
   [nr-11]: <https://user-images.githubusercontent.com/10976047/61996185-cdbd6a00-b091-11e9-9b65-5cd7816b9885.PNG>
   [nr-12]: <https://user-images.githubusercontent.com/10976047/61996213-25f46c00-b092-11e9-9b88-c5156c96eb3b.PNG>
   [nr-13]: <https://user-images.githubusercontent.com/10976047/62005208-14fa3800-b130-11e9-80e3-77e73a9c8ba2.PNG>
