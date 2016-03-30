package com.devehab.tasbeehcounter;

import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity {
    // Vibrator 1
    Vibrator mVibrator;
    Window window;
    ImageButton btnVibrate;
    ImageButton restz;
    boolean isTureVibrator =true;

    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // FULL SCREEN
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // -- FULL SCREEN

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdView mAdView = (AdView) findViewById(R.id.ad_view);
          AdRequest adRequest = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).addTestDevice("YOUR_DEVICE_HASH").build();
        //  AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        final TextView myTextView = (TextView) findViewById(R.id.textAd);

        ImageButton btnVibrate=(ImageButton)findViewById(R.id.CounntAdd);
        final ImageButton resftz = (ImageButton)findViewById(R.id.restz);
        final ImageButton BTureVibrator = (ImageButton)findViewById(R.id.addvibrator);
        // Vibrator 2
        mVibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        btnVibrate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Vibrates 3 : for 100 Milliseconds
                if(isTureVibrator){ mVibrator.vibrate(100);}

                count++;
                myTextView.setText( ""+count);

            }
        });

        resftz.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Vibrates 3 : for 100 Milliseconds
                if(isTureVibrator){ mVibrator.vibrate(100);}
                count = 0;
                myTextView.setText( ""+count);

                //screenBrightness
              //  WindowManager.LayoutParams layout = getWindow().getAttributes();
              //  layout.screenBrightness = 1F; // 0.0F to 1.0F -- 20% = 0.2f
              ///  getWindow().setAttributes(layout);
            }
        });

        BTureVibrator.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Vibrates 3 : for 100 Milliseconds
                mVibrator.vibrate(100);
                if(isTureVibrator){
                    isTureVibrator=false;
                    BTureVibrator.setImageResource(R.drawable.vibrate_off);
                }
                else {
                    isTureVibrator=true;
                    BTureVibrator.setImageResource(R.drawable.vibrate_on);
                }

            }
        });



    }

}
