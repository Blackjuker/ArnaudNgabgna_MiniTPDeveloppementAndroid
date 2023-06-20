package com.example.tpf2i.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tpf2i.R;
import com.example.tpf2i.model.Personnage;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class PersonnageAdapter extends RecyclerView.Adapter<PersonnageAdapter.PersonnageViewHolder>{

    private Context context;
    private List<Personnage> personnageList;

    public PersonnageAdapter(Context context, List<Personnage> personnageList) {
        this.context = context;
        this.personnageList = personnageList;
    }

    @NonNull
    @Override
    public PersonnageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.personnage_item,parent,false);
        return new PersonnageViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull PersonnageViewHolder holder, int position) {
        Personnage personnage = personnageList.get(position);
        holder.txtName.setText(personnage.getName());

        //animation
        holder.cardViewPersonne.setAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(),R.anim.anim_three));

        Glide.with(context)
                .load(personnage.getImageUrl())
                .placeholder(R.drawable.film_loading)
                .centerCrop()
                .into(holder.imgView);
    }

    @Override
    public int getItemCount() {
        return personnageList.size();
    }

    public class PersonnageViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgView;
        private TextView txtName;
        private MaterialCardView cardViewPersonne;

        public PersonnageViewHolder(@NonNull View itemView) {
            super(itemView);

            imgView = itemView.findViewById(R.id.image_thumbnail_path);
            txtName = itemView.findViewById(R.id.name);
            cardViewPersonne = itemView.findViewById(R.id.cardViewPersonne);
        }
    }
}
