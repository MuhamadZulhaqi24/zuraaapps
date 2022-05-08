package com.html.zuraaapps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/** NIM   : 10119231
 * Nama   : Muhamad Zulhaqi
 * Kelas  : IF-6
 * Tanggal Pengerjaan : 08-05-2022
 */

public class GalleryAdapt extends RecyclerView.Adapter<GalleryAdapt.ViewHolder> {

    Context context;
    int[] images;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView rowImage;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            rowImage = itemView.findViewById(R.id.imageView);
        }

    }

    public GalleryAdapt(Context context, int[] images){
        this.context = context;
        this.images = images;
    }

    @NonNull
    @Override
    public GalleryAdapt.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_item, parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryAdapt.ViewHolder holder, int position) {
        holder.rowImage.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }
}

