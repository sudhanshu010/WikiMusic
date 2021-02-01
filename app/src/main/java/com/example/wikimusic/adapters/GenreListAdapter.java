package com.example.wikimusic.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wikimusic.BR;
import com.example.wikimusic.R;
import com.example.wikimusic.models.genre.Genre;
import com.example.wikimusic.models.genre.GenreList;

import java.util.List;

public class GenreListAdapter extends RecyclerView.Adapter<GenreListAdapter.ViewHolder> {

    private List<Genre> genreList;
    private Context context;

    public GenreListAdapter(List<Genre> genreList, Context context) {
        this.genreList = genreList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.genre_row,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Genre genre = genreList.get(position);
        holder.bind(genre);
    }


    @Override
    public int getItemCount() {
        //Log.i("Sudhanshu","size "+genreList.size());
        return genreList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding binding;

        public ViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Object obj) {
            this.binding.setVariable(BR.genre,obj);
            this.binding.executePendingBindings();
        }
    }
}
