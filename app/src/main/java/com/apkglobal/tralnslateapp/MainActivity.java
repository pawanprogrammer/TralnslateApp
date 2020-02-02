package com.apkglobal.tralnslateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mannan.translateapi.Language;
import com.mannan.translateapi.TranslateAPI;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv= findViewById(R.id.tv);
        b= findViewById(R.id.b);


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TranslateAPI translateAPI = new TranslateAPI(Language.AUTO_DETECT,   //Source Language
                        Language.TAMIL,         //Target Language
                        "What if everything I communicated could be translated");           //Query Text

                translateAPI.setTranslateListener(new TranslateAPI.TranslateListener() {
                    @Override
                    public void onSuccess(String translatedText) {
                        //Log.d(TAG, "onSuccess: "+translatedText);
                        tv.setText(translatedText);
                    }

                    @Override
                    public void onFailure(String ErrorText) {
                        //Log.d(TAG, "onFailure: "+ErrorText);
                    }
                });
            }
        });
    }
}
