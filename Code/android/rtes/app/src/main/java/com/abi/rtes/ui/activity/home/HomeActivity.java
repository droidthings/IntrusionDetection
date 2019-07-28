package com.abi.rtes.ui.activity.home;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

import com.abi.rtes.R;
import com.abi.rtes.constants.Constants;
import com.abi.rtes.data.api.channel.ChannelFeedData;
import com.abi.rtes.utils.ProgressUtils;
import com.abi.rtes.utils.Utils;

import org.w3c.dom.Text;

public class HomeActivity extends AppCompatActivity implements HomeView {

    HomePresenter homePresenter;
    TextView mTextChannelName;
    TextView mTextChannelDesc;
    TextView mTextAccX;
    TextView mTextAccY;
    TextView mDateCreated;
    ImageView mImageIntr;
    TextView mTextIntr;
    Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextChannelName =  (TextView) this.findViewById(R.id.channel_name);
        mTextChannelDesc =  (TextView) this.findViewById(R.id.channel_desc);
        mDateCreated =  (TextView) this.findViewById(R.id.date_created);
        mTextAccX =  (TextView) this.findViewById(R.id.channel_accX);
        mTextAccY =  (TextView) this.findViewById(R.id.channel_accY);
        mImageIntr = (ImageView)this.findViewById(R.id.intr_image);
        mTextIntr = (TextView)this.findViewById(R.id.intr_text);
        mHandler = new Handler();
        homePresenter = new HomePresenterImpl(this);
        ProgressUtils.showProgress(this, "Loading Channel Data");
        homePresenter.getChannelFeeds();
        mHandler.postDelayed(channelRunnable, Constants.CHANNEL_INTERVAL);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    Runnable channelRunnable = new Runnable() {
        @Override
        public void run() {
            ProgressUtils.showProgress(HomeActivity.this, "Loading Channel Data");
            homePresenter.getChannelFeeds();
            mHandler.postDelayed(channelRunnable,  Constants.CHANNEL_INTERVAL);
        }
    };


    @Override
    public void onSuccess(ChannelFeedData channelFeedData) {
        ProgressUtils.hideProgress();
        mTextChannelName.setText(channelFeedData.getChannel().getName());
        mTextChannelDesc.setText(channelFeedData.getChannel().getDescription());
        mDateCreated.setText(Utils.convertDate(channelFeedData.getFeeds().get(0).getCreatedAt()));
        mTextAccX.setText(channelFeedData.getFeeds().get(0).getField1());
        mTextAccY.setText(channelFeedData.getFeeds().get(0).getField2());

        homePresenter.detectIntrusion(channelFeedData);
        //sendNotification(channelFeedData.getChannel().getDescription());
    }

    @Override
    public void onError(String localizedMessage) {
        ProgressUtils.hideProgress();
        Toast.makeText(this, localizedMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onIntrusion(boolean isIntruded, ChannelFeedData channelFeedData) {
        if(isIntruded){
            mImageIntr.setBackgroundResource(R.drawable.unsafe);
            mTextIntr.setText("INTRUDER ALERT!!!");
            mTextIntr.setTextColor(ContextCompat.getColor(this, R.color.colorDanger));
            sendNotification(channelFeedData.getChannel().getDescription());
        }else{
            mImageIntr.setBackgroundResource(R.drawable.safe);
            mTextIntr.setText("SAFE ENVIRONMENT");
            mTextIntr.setTextColor(ContextCompat.getColor(this, R.color.colorSafe));
        }
    }

    public void sendNotification(String description) {

        NotificationManager notificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel notificationChannel = new NotificationChannel("ID", "Name", importance);
            notificationManager.createNotificationChannel(notificationChannel);
            builder = new NotificationCompat.Builder(getApplicationContext(), notificationChannel.getId());
        } else {
            builder = new NotificationCompat.Builder(getApplicationContext());
        }

        builder = builder
                .setSmallIcon(R.mipmap.safe_icon)
                .setColor(ContextCompat.getColor(this, R.color.colorAccent))
                .setContentTitle("Intruder alert!!")
                .setContentText("Intruder at " + description)
                .setDefaults(Notification.DEFAULT_ALL)
                .setAutoCancel(true);
        notificationManager.notify(1, builder.build());
    }
}
