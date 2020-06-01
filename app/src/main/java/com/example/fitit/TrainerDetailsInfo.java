package com.example.fitit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;

public class TrainerDetailsInfo extends AppCompatActivity {

    ImageView pic;
    TextView name;
    TextView type;
    TextView exp;
    Button avail;
    TextView bio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainer_details_info);

        initViews();
        setData();

        avail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url="https://www.google.com/";
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

    }
    public void initViews()
    {
        pic=findViewById(R.id.trainerpic);
        name=findViewById(R.id.name);
        type=findViewById(R.id.type);
        exp=findViewById(R.id.exp);
        bio=findViewById(R.id.bio);
        avail=findViewById(R.id.signup);
    }
    public void setData()
    {
        String namee="Name : "+(String)getIntent().getExtras().get("name");
        String imgg=(String)getIntent().getExtras().get("Trainerimg");
        String typee="Trainer Type : "+(String)getIntent().getExtras().get("Trainertitle");
        String expp="Experience Training : "+(int)getIntent().getExtras().get("exp");
        String bio="Bio:\n"+(String)getIntent().getExtras().get("bio");
        name.setText(namee);
        type.setText(typee);
        GlideApp.with(this).load(imgg).transform(new CenterCrop(),new RoundedCorners(16)).into(pic);
        exp.setText(expp);




//
//        intent.putExtra("name",trainer.getCompany());
//        intent.putExtra("Trainerimg",trainer.getDrawableResources());
//        intent.putExtra("Trainertitle",trainer.getJob());
//        intent.putExtra("exp",trainer.getDescription());
    }
}
