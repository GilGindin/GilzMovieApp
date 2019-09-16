package com.gil.gilzmovieapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gil.gilzmovieapp.DataBase.MyMovie;
import com.gil.gilzmovieapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.MyViewHolder> {

    private OnItemClickListener listener;
    private Context mContext;
    private List<MyMovie> moives;
    ArrayList<MyMovie> getAllMovies;

    public MyCustomAdapter(Context context, List<MyMovie> moives) {
        mContext = context;
        this.moives = moives;
        getAllMovies = new ArrayList<>(moives);
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
        Collections.sort(moives);

        myViewHolder.text_view_title.setText(currentMovire.getTitle());
        myViewHolder.text_view_realse_year.setText(String.valueOf(currentMovire.getReleaseYear()));

        if (currentMovire.getImage() != null) {
            String photo = currentMovire.getImage();
            Picasso.with(mContext).load(photo).into(myViewHolder.image_view);
        }

    }

    @Override
    public int getItemCount() {
        return moives.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView text_view_title, text_view_realse_year;
        private ImageView image_view;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            text_view_title = itemView.findViewById(R.id.text_view_title);
            text_view_realse_year = itemView.findViewById(R.id.text_view_realse_year);
            image_view = itemView.findViewById(R.id.image_view);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(getAllMovies.get(position));
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
