package com.example.exam101;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class UpdateBankDetails_Activity extends AppCompatActivity {
    TextView btn_Submit_Id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_bank_details);
        btn_Submit_Id=findViewById(R.id.btn_Submit_Id);

        btn_Submit_Id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(UpdateBankDetails_Activity.this,Profile_Activity.class);
                startActivity(intent);
            }
        });
    }
}