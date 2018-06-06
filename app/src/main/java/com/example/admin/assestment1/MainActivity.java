package com.example.admin.assestment1;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    EditText message;
    EditText phoneNumber;
    ImageView picture;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        message = findViewById(R.id.te_message);
        phoneNumber = findViewById(R.id.et_phoneNumber);
        picture = findViewById(R.id.Iv_TakenPicture);

    }

    public void toTakeAPicture(View view) {
        //TODO implementar el tomar una foto;
        requestCameraPermissions();
        Intent launchCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(launchCamera, Constants.CAM_REQUEST);



    }

    public void toSendMessage(View view) {
        Intent sendMessage = new Intent();
        sendMessage.setAction(Intent.ACTION_SEND_MULTIPLE);
        sendMessage.putExtra(Intent.EXTRA_TEXT, message.getText());
        sendMessage.setType("text/plain");
        startActivity(sendMessage);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == Constants.CAM_REQUEST && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            picture.setImageBitmap(imageBitmap);
        }
    }

    public void requestCameraPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.CAMERA}, 1);
            }
        }
    }

    public void toCall(View view) {


        Intent intentToCall = new Intent();
        intentToCall.setAction(Intent.ACTION_DIAL);
        intentToCall.setData(Uri.parse("tel:" + phoneNumber.getText().toString()));
        startActivity(intentToCall);

    }
}
