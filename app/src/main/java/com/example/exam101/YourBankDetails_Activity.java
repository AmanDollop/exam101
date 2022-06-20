package com.example.exam101;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class YourBankDetails_Activity extends AppCompatActivity {
    TextView btn_Update_Bank_Details_Id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_bank_details);
        btn_Update_Bank_Details_Id=findViewById(R.id.btn_Update_Bank_Details_Id);


        btn_Update_Bank_Details_Id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(YourBankDetails_Activity.this,UpdateBankDetails_Activity.class);
                startActivity(intent);
            }
        });
    }
}