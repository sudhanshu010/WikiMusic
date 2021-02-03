package com.example.wikimusic.genre.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wikimusic.BR;
import com.example.wikimusic.R;

import com.example.wikimusic.genre.models.Genre;
import com.example.wikimusic.genre.viewmodels.GenreListViewModel;

import java.util.List;

public class GenreListAdapter extends RecyclerView.Adapter<GenreListAdapter.ViewHolder> {

    private List<Genre> genreList;
    private GenreListViewModel genreListViewModel;
    private Context context;
    private boolean expand;

    public GenreListAdapter(List<Genre> genreList, GenreListViewModel genreListViewModel, Context context) {
        this.genreList = genreList;
        this.genreListViewModel = genreListViewModel;
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
        holder.bind(genre,genreListViewModel);
    }


    @Override
    public int getItemCount() {
            return genreList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding binding;

        public ViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Genre genre,GenreListViewModel genreListViewModel) {
            this.binding.setVariable(BR.genre,genre);
            this.binding.setVariable(BR.genreListViewModel,genreListViewModel);
            this.binding.executePendingBindings();
        }

    }
}
