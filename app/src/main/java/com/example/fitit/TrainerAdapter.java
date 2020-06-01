package com.example.fitit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;


import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.fitit.Model.Trainer;
import com.example.fitit.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TrainerAdapter extends RecyclerView.Adapter<TrainerAdapter.trainerviewholder> {

    Trainer_itemclick itemclick;
    List<Trainer> mdata;

    @NonNull
    @Override
    public trainerviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_trainer,parent,false);
        return new trainerviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull trainerviewholder holder, int position) {
        GlideApp.with(holder.itemView.getContext()).load(mdata.get(position).getDrawableResources()).transform(new CenterCrop(),new RoundedCorners(16)).into(holder.imgLogo);

        holder.ratingBar.setRating(4.4f);
        holder.name.setText(mdata.get(position).getName());
        holder.trainertitle.setText(mdata.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public TrainerAdapter(List<Trainer> mdata,Trainer_itemclick itemclick)
    {
        this.mdata=mdata;
        this.itemclick=itemclick;
    }

    public class trainerviewholder extends RecyclerView.ViewHolder{

        ImageView imgLogo;
        TextView trainertitle,name;
        RatingBar ratingBar;


        public trainerviewholder(@NonNull View itemView)
        {
            super(itemView);

          //  imgFav=itemView.findViewById(R.id.fav_imgi);
            imgLogo=itemView.findViewById(R.id.trainerpic);
            trainertitle=itemView.findViewById(R.id.trainer_title);
            name=itemView.findViewById(R.id.name);
            ratingBar=itemView.findViewById(R.id.ratingBari);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    //  Intent intent=new Intent(this,)

                    itemclick.onTrainerClick(mdata.get(getAdapterPosition()),imgLogo);
                }
            });


        }

    }
}
