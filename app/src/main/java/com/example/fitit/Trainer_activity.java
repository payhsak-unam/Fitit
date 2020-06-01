package com.example.fitit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.example.fitit.Model.Trainer;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class Trainer_activity extends AppCompatActivity implements Trainer_itemclick{

    private RecyclerView rv;
    private List mdata;
    private TrainerAdapter trainerAdapter;

    private DocumentReference docref= FirebaseFirestore.getInstance().document("Details/TrainerDetails");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainer_activity);

        initViews();
        initmatainterns();
        setUpTrainerAdapter();
        System.out.println("cashit");
    }

    private void setUpTrainerAdapter()
    {
        trainerAdapter=new TrainerAdapter(mdata,this);
        rv.setAdapter(trainerAdapter);
    }
    private void initmatainterns()
    {
        mdata=new ArrayList<>();

        docref.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        String s =document.getString("Name");
                        String[] s1=s.split(",");

                        String[] s2=document.getString("TrainerTitle").split(",");
                        String[] s4=document.getString("exp").split(",");
                        String[] s6=document.getString("trainerimg").split(",");
                        for(int i=0;i<s1.length;i++)
                        {
                            mdata.add(new Trainer(s1[i],s2[i],Integer.parseInt(s4[i]),4.1f,s6[i]));
                        }
                        trainerAdapter.notifyDataSetChanged();
//                        String g=document.getString("aaa");
//                        System.out.println("kashit"+g+s[0]);

                    } else {
                        Log.d("tag", "No such document");
                    }
                } else {
                    Log.d("tag", "get failed with ", task.getException());
                }
            }
        });

     //   int x=R.drawable.apple_logo;
      //  System.out.println("Amazon"+R.drawable.amazon+"apple"+x+"Coca"+R.drawable.coca+"Google"+R.drawable.google+"NASA"+R.drawable.nasa);

    }
    private void initViews()
    {

        rv=findViewById(R.id.rvintern);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setHasFixedSize(true);



    }

//    @Override
//    public void onInternClick(Trainer intern, ImageView internlog) {
//        Intent intent=new Intent(this,JobDetailsinfo.class);
//
//
//        //    startActivity(intent);
//        System.out.println(intern.getDescription());
//        intent.putExtra("name",intern.getCompany());
//        intent.putExtra("Trainerimg",intern.getDrawableResources());
//        intent.putExtra("Trainertitle",intern.getJob());
//        intent.putExtra("exp",intern.getDescription());
//        ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(Trainer_activity.this,internlog,"sharedpic");
//
//        startActivity(intent,options.toBundle());
//        //  Toast.makeText(this,intern.getCompany(),Toast.LENGTH_SHORT).show();
//    }

    @Override
    public void onTrainerClick(Trainer trainer, ImageView trainerLog) {
        Intent intent=new Intent(this,TrainerDetailsInfo.class);
        System.out.println("eyoo");
        intent.putExtra("name",trainer.getName());
        intent.putExtra("Trainerimg",trainer.getDrawableResources());
        intent.putExtra("Trainertitle",trainer.getTitle());
        intent.putExtra("exp",trainer.getExp());
        ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(Trainer_activity.this,trainerLog,"sharedpic");

        startActivity(intent,options.toBundle());
    }
}


















