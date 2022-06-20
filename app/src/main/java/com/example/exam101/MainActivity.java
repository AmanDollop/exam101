package com.example.exam101;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.card.MaterialCardView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    TextView btn_Save_Id;
    MaterialCardView cardPic,cardProfileOne;
    ImageView ivPiyushId;
    Spinner simpleSpinner;



    private String from = "";

    public static final int CAMERA_PERMISSION= 100;
    public static final int STORAGE_PERMISSION = 200;




    String[] countryNames={"India","China","Australia","Portugle","America","New Zealand"};
    int flags[] = {R.drawable.ic_india, R.drawable.ic_china, R.drawable.ic_flag_of_australia, R.drawable.ic_portugal, R.drawable.ic_flag_of_australia, R.drawable.ic_new_zealand};


   /* int number[] ={+91,+91,+91,+91,+91,+91};*/
  /* String[] number={"India","China","Australia","Portugle","America","New Zealand"};
    int flagsone[] = {R.drawable.ic_india, R.drawable.ic_china, R.drawable.ic_flag_of_australia, R.drawable.ic_portugal, R.drawable.ic_flag_of_australia, R.drawable.ic_new_zealand};*/









    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_Save_Id=findViewById(R.id.btn_Save_Id);
        cardPic=findViewById(R.id.cardPic);
        ivPiyushId=findViewById(R.id.ivPiyushId);
        cardProfileOne=findViewById(R.id.cardProfileOne);




        simpleSpinner =findViewById(R.id.simpleSpinner);

        simpleSpinner.setOnItemSelectedListener(this);
        CustomAdapter customAdapter=new CustomAdapter(getApplicationContext(),flags,countryNames);
        simpleSpinner.setAdapter(customAdapter);






        cardPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkPermission(Manifest.permission.CAMERA,CAMERA_PERMISSION)) {
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    startActivityForResult(intent, STORAGE_PERMISSION);
                }
            }
        });


        btn_Save_Id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Profile_Activity.class);
                startActivity(intent);
            }
        });
    }




    private boolean checkPermission(String camera, int cameraPermission) {

        if (ContextCompat.checkSelfPermission(MainActivity.this, camera) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, new String[]{camera}, cameraPermission);
            return false;
        } else {
            Toast.makeText(this, "permission already granted", Toast.LENGTH_SHORT).show();
            return true;
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == CAMERA_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Camera Permission Granted", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this, "Camera Permission Denied", Toast.LENGTH_SHORT).show();
            }
        } else if (requestCode == STORAGE_PERMISSION) {
            if (requestCode == CAMERA_PERMISSION) {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Storage Permission Granted", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(this, "Storage Permission Denied", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == STORAGE_PERMISSION && resultCode == Activity.RESULT_OK) {
            Bitmap photos = (Bitmap) data.getExtras().get("data");
            ivPiyushId.setImageBitmap(photos);
        }




    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
      //  Toast.makeText(getApplicationContext(), countryNames[position], Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // TODO Auto-generated method stub
    }



}