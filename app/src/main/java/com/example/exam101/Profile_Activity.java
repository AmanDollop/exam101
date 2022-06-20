package com.example.exam101;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class Profile_Activity extends AppCompatActivity {
    ImageView iv_Next_Arrow_Id;
    RelativeLayout rl_EditProfile_Id;
    LinearLayout ll_Bank_Id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        rl_EditProfile_Id = findViewById(R.id.rl_EditProfile_Id);
        ll_Bank_Id = findViewById(R.id.ll_Bank_Id);


        ll_Bank_Id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile_Activity.this, BankDetails_Activity.class);
                startActivity(intent);
            }
        });

        rl_EditProfile_Id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile_Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}