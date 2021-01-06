package com.example.sec4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.net.URI;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout ;
    ViewPager viewPager ;
    fragments fragment1 ;

    static final int CAMERA_REQUEST_CODE = 1 ;
    static final int GALLERY_REQUEST_CODE = 2 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tab1);
        viewPager = findViewById(R.id.pager);
        fragment1 = new fragments (getSupportFragmentManager());

        fragment1.add(new Fragment1() , "tab1");
        fragment1.add(new Fragment2() , "tab3");
        fragment1.add(new Fragment3() , "tab3");

        viewPager.setAdapter(fragment1);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

       MenuInflater inflater = getMenuInflater();
       inflater.inflate(R.menu.menu1,menu);
       return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.camera :
                request_camera();
               // Toast.makeText(getApplicationContext() ,"permission is granted " ,Toast.LENGTH_LONG).show();
                return true;

            case R.id.gallery:

                request_gallery ();
               // Toast.makeText(getApplicationContext() ,"permission granted " ,Toast.LENGTH_LONG).show();
                return true;

            case R.id.check:
                // Toast.makeText(getApplicationContext() ,"Checked" ,Toast.LENGTH_LONG).show();
                Intent intent = new Intent();
                intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                Uri uri = Uri.fromParts("package",getPackageName() ,null);
                intent.setData(uri);
                startActivity(intent);
                return true;
        }

        return false;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == CAMERA_REQUEST_CODE)
        {
            if(grantResults.length > 0 && grantResults[0]  == PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(getApplicationContext() ,"permission is granted " ,Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(getApplicationContext() ,"permission is denied " ,Toast.LENGTH_LONG).show();
            }
        }
        else if (requestCode == GALLERY_REQUEST_CODE)
        {
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(getApplicationContext() ,"permission is granted " ,Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(getApplicationContext() ,"permission is denied " ,Toast.LENGTH_LONG).show();
            }
        }

    }

    public void request_camera ()
    {
        if (ContextCompat.checkSelfPermission(MainActivity.this , Manifest.permission.CAMERA ) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(MainActivity.this ,new String []{Manifest.permission.CAMERA },CAMERA_REQUEST_CODE);
        }
        else {
                    open_camera();
        }
    }

    public void request_gallery ()
    {
        if (ContextCompat.checkSelfPermission(MainActivity.this , Manifest.permission.READ_EXTERNAL_STORAGE ) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(MainActivity.this ,new String []{Manifest.permission.READ_EXTERNAL_STORAGE},GALLERY_REQUEST_CODE);
        }
        else {
            open_gallery();
        }
    }
    private void open_camera ()
    {
        Intent intent2 = new Intent();
        intent2.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(intent2);
    }

    private void open_gallery ()
    {
        Intent intent3 = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivity(intent3);
    }
}