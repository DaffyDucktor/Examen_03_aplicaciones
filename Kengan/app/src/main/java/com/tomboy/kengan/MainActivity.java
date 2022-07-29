package com.tomboy.kengan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageButton supportButton;
    private RecyclerView recyclerView;
    private PhotoAdapter photoAdapter;
    private ArrayList<PhotoModel> photoModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getData();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        supportButton = findViewById(R.id.support_button);
        recyclerView = findViewById(R.id.photoRecyclerView);


        photoAdapter = new PhotoAdapter(photoModel);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(MainActivity.this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(photoAdapter);

        /*supportButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CameraActivity.class);

            startActivity(intent);
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.image_icon:
                Intent intent = new Intent(MainActivity.this, CameraActivity.class);

                startActivity(intent);
                break;
        }
        return true;
    }
    private void getData(){
        photoModel = new ArrayList<>();
        photoModel.add(new PhotoModel("1.John Xina", "data:image/jpeg;base64,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"));
        photoModel.add(new PhotoModel("2.The Wock", "2wCEAAoHCBUWFRgVFhUYFRgYEhUYGBgYGBgRGBgRGBgZGRgYGBgcIS4lHB4rIRgYJjgmKy8xNTU1GiQ7QDs0Py40NTEBDAwMEA8QGhISHjQhISE0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0PzQ"));
        photoModel.add(new PhotoModel("3.Xie Hua Piao", "https://i1.sndcdn.com/artworks-kcPjC82yB64PYNeS-yFnttw-t500x500.jpg"));
        photoModel.add(new PhotoModel("4.Super Idol", "https://p16-sign-va.tiktokcdn.com/tos-maliva-avt-0068/12f512f06ab577e1758e068044c0d489~c5_720x720.jpeg?x-expires=1659168000&x-signature=CvMAEcwZRk5VcC0%2FqiDRQlYXpII%3D"));
        photoModel.add(new PhotoModel("5.Bald Guy", "https://i.ytimg.com/vi/HKjazBW9Gy8/hqdefault.jpg"));
        photoModel.add(new PhotoModel("6.neck", "https://i.ytimg.com/vi/g79nVTZedWw/hqdefault.jpg"));
        photoModel.add(new PhotoModel("7.Yelling Guy", "https://i.ytimg.com/vi/pf6UtRY1AgA/hqdefault.jpg"));
        photoModel.add(new PhotoModel("8.Advice Guy", "https://i1.sndcdn.com/artworks-zTBa4vecuoqyemdw-KMRdVw-t500x500.jpg"));



    }




}