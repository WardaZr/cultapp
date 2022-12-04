package com.tubes.kelompok9.cultapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

import com.tubes.kelompok9.cultapp.entity.ContentNotes;
import com.tubes.kelompok9.cultapp.R;

public class ContentNotesAdapter extends RecyclerView.Adapter<ContentNotesAdapter.RecyclerViewHolder> {

    private ArrayList<ContentNotes> listContentNotes ;
    private Context mcontext;

    public ContentNotesAdapter(ArrayList<ContentNotes> recyclerDataArrayList, Context mcontext) {
        this.listContentNotes = recyclerDataArrayList;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate Layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        // Set the data to textview and imageview.
        ContentNotes recyclerData = listContentNotes.get(position);
        holder.courseTV.setText(recyclerData.getJudul());
        holder.courseIV.setImageResource(recyclerData.getImgid());
    }

    @Override
    public int getItemCount() {
        // this method returns the size of recyclerview
        return listContentNotes.size();
    }

    // View Holder Class to handle Recycler View.
    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private TextView courseTV;
        private ImageView courseIV;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            courseTV = itemView.findViewById(R.id.tv_item_judul);
            courseIV = itemView.findViewById(R.id.img_konten);
        }
    }
}
