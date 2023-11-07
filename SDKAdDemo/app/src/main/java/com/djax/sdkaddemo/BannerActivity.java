package com.djax.sdkaddemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

import com.ad.sdk.adserver.BannerAds;
import com.ad.sdk.adserver.Listener.BannerListener;

import java.util.ArrayList;


public class BannerActivity extends AppCompatActivity implements BannerListener {

    ArrayList<WebView> multiView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);

        String zone_id = AppApplication.sharedPreferences.getString("Zone_ID", "");
        System.out.println("@ zone_id " + zone_id);

        WebView wb1 = findViewById(R.id.banner1);

        multiView = new ArrayList<WebView>();

        multiView.add(wb1);



        /*AdView adv1 = new AdView(this, this);
        adv1.setZoneid(zone_id); //Place Your Zone id
        //adv1.setWebView(wb1);
        adv1.setMultipleViewList(multiView);
        adv1.LoadAd(adv1);*/

        new BannerAds().loadBannerAd(this, multiView);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                wb1.setVisibility(View.VISIBLE);
            }
        }, 1200);

        /*FrameLayout frameLayout = (FrameLayout)findViewById(R.id.f);

        new Banner_image().loadmediationAdShow(BannerActivity.this,frameLayout);*/
        //new Banner_image().loadmediationAdShow(BannerActivity.this,wb1);


    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(BannerActivity.this, HomeActivity.class));
        finish();
    }

    @Override
    public void AdLoaded() {

    }

    @Override
    public void AdFailed() {

    }

}