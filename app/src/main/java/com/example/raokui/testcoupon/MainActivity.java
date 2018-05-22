package com.example.raokui.testcoupon;

import android.arch.lifecycle.LiveData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lv = findViewById(R.id.lv);
        Adapter adapter = new Adapter(this);
        lv.setAdapter(adapter);
//        couponViewT.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (couponViewT.isEx()) {
//                    tv4.setVisibility(View.GONE);
//                    couponViewT.setEx(false);
//                } else {
//                    tv4.setVisibility(View.VISIBLE);
//                    couponViewT.setEx(true);
//                }
//            }
//        });
    }
}
