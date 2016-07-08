package com.example.ganeshc.applicationadd;
 import com.pushbots.push.Pushbots;

import java.io.File;
import java.net.URL;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferObserver;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferUtility;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.internal.Constants;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.ResponseHeaderOverrides;

public class MainActivity extends Activity {

    static int TAKE_PIC =1;
    Uri outPutfileUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		Pushbots.sharedInstance().init(this);
        setContentView(R.layout.activity_main);
        Pushbots.sharedInstance().init(this);
    }
    public void CameraClick(View v) {

       /* Intent intent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File file = new File(Environment.getExternalStorageDirectory(),
                "MyPhoto.jpg");
        outPutfileUri = Uri.fromFile(file);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, outPutfileUri);
        startActivityForResult(intent, TAKE_PIC);
        intent.setType("image*//*");
        AmazonS3 s3 = new AmazonS3Client( new BasicAWSCredentials( "AKIAJW62LTFBVTMMD4CA", "GdDFvSUpo7OW1Z+hkZm6jbGTYejfOZtTpGc3J4Sd" ) );
        s3.setRegion(Region.getRegion(Regions.DEFAULT_REGION));
        TransferUtility transferUtility = new TransferUtility(s3,MainActivity.this );
        TransferObserver observer = transferUtility.upload(
                "learning-testing",     *//* The bucket to upload to *//*
                file.getName(),    *//* The key for the uploaded object *//*
                file        *//* The file where the data to upload exists *//*
        );*/
       /* AmazonS3Client s3Client = new AmazonS3Client( new BasicAWSCredentials( "AKIAJW62LTFBVTMMD4CA", "GdDFvSUpo7OW1Z+hkZm6jbGTYejfOZtTpGc3J4Sd" ) );
        s3Client.createBucket( "gagagaga" );
        PutObjectRequest por = new PutObjectRequest( Constants.getPictureBucket(), Constants.PICTURE_NAME, outPutfileUri );
        s3Client.putObject( por );
        ResponseHeaderOverrides override = new ResponseHeaderOverrides();
        override.setContentType( "image/jpeg" );
        GeneratePresignedUrlRequest urlRequest = new GeneratePresignedUrlRequest( Constants.getPictureBucket(), Constants.PICTURE_NAME );
        urlRequest.setExpiration( new Date( System.currentTimeMillis() + 3600000 ) );  // Added an hour's worth of milliseconds to the current time.
        urlRequest.setResponseHeaders( override );
        URL url = s3Client.generatePresignedUrl( urlRequest );
        startActivity( new Intent( Intent.ACTION_VIEW, Uri.parse( url.toURI().toString() ) ) );*/
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data)
    {
        if (requestCode == TAKE_PIC && resultCode==RESULT_OK){
            Toast.makeText(this, outPutfileUri.toString(),Toast.LENGTH_LONG).show();
        }
    }
}