package com.example.tareaunidad3;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyReclyclerViewAdapter extends RecyclerView.Adapter<MyReclyclerViewAdapter.ViewHolder> {

    private List<Ruta> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    public MyReclyclerViewAdapter(Context context, ArrayList<Ruta> data, ItemClickListener listener) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.mClickListener = listener;
    }

    public void setOnClickListener(MainActivity mainActivity) {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recycler_view_item, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String nombre = mData.get(position).getNombre();
        int imagen = mData.get(position).getImagen();
        holder.myTextView.setText(nombre);
        holder.myImageView.setImageResource(imagen);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView myTextView;
        ImageView myImageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.textView1);
            myImageView = itemView.findViewById(R.id.imageView1);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(mClickListener != null){
                mClickListener.onItemClick(view, getAdapterPosition());
            }
        }
    }

    public String getItem(int id){
        return String.valueOf(mData.get(id));
    }

    public void setClickListener(ItemClickListener itemClickListener){
        this.mClickListener = itemClickListener;
    }
}
