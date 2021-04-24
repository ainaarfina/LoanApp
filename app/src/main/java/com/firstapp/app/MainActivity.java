package com.firstapp.app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;


public class MainActivity extends AppCompatActivity {

    EditText et1,et2, et3;
    TextView tv2;
    Button reset, enter;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        AdView adView = new AdView(this);

        adView.setAdSize(AdSize.BANNER);

        adView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");


        et1 = (EditText)findViewById(R.id.editText1);
        et2 = (EditText)findViewById(R.id.editText2);
        et3 = (EditText)findViewById(R.id.editText3);
        tv2 = (TextView)findViewById(R.id.textView2);
        enter = (Button)findViewById(R.id.button);
        reset = (Button)findViewById(R.id.button2);



    }
    public void showResult(View view) {

        if (et2 == null || et3 == null){
            Toast.makeText(getApplicationContext(), "Both Loan and Duration are required", Toast.LENGTH_LONG).show();
        }
        else {
            String cust = et1.getText().toString();
            double loan = Double.parseDouble(et2.getText().toString());
            int duration =Integer.parseInt(et3.getText().toString());

            double intValue = loan * 0.03;
            double yearly = (intValue + loan)/duration;
            String msg = "Yearly is " + yearly;

            tv2.setText(msg.toString());

            //Toast toast = Toast.makeText(getApplicationContext(),
            //        msg, Toast.LENGTH_SHORT);
            //toast.show();
        }

    }
    public void resetResult(View view) {
        et1.setText("");
        et2.setText("");
        et3.setText("");
        tv2.setText("");
    }

}