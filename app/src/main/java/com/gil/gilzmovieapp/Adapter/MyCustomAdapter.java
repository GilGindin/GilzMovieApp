package com.gil.gilzmovieapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gil.gilzmovieapp.DataBase.MyMovie;
import com.gil.gilzmovieapp.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.MyViewHolder> {

    private OnItemClickListener listener;
    private Context mContext;
    private List<MyMovie> moives = new ArrayList<>();

    public MyCustomAdapter(Context context, List<MyMovie> moives) {
        mContext = context;
        this.moives = moives;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_detail, viewGroup, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        MyMovie currentMovire = moives.get(i);

        if (currentMovire.getTitle() != null) {
            myViewHolder.text_view_title.setText(currentMovire.getTitle());
        } else {
            myViewHolder.text_view_title.setText("No Movie Title");
        }
        if (currentMovire.getReleaseYear() != 0) {
            myViewHolder.text_view_realse_year.setText(String.valueOf(currentMovire.getReleaseYear()));
        } else {
            myViewHolder.text_view_realse_year.setText("No year of release");
        }


        if (currentMovire.getImage() != null) {
            String photo = currentMovire.getImage();
            Glide.with(mContext).load(photo).into(myViewHolder.image_view);
        } else {
            Glide.with(mContext).load(R.drawable.noimage).into(myViewHolder.image_view);
        }


        // myViewHolder.image_view.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.fade_transation_animation));
         // myViewHolder.container.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.fade_scale_animation));

    }

    @Override
    public int getItemCount() {
        return moives.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView text_view_title, text_view_realse_year;
        private ImageView image_view;
        private RelativeLayout container;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            text_view_title = itemView.findViewById(R.id.text_view_title);
            text_view_realse_year = itemView.findViewById(R.id.text_view_realse_year);
            image_view = itemView.findViewById(R.id.image_view);
            container = itemView.findViewById(R.id.container);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(moives.get(position));
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(MyMovie myMovie);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
