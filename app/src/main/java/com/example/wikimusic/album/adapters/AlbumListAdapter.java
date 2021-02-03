package com.example.wikimusic.album.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wikimusic.BR;
import com.example.wikimusic.R;
import com.example.wikimusic.album.models.Album;
import com.example.wikimusic.album.viewmodels.AlbumListViewModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AlbumListAdapter extends RecyclerView.Adapter<AlbumListAdapter.ViewHolder> {

    private List<Album> albumList;
    private AlbumListViewModel albumListViewModel;
    private Context context;

    public AlbumListAdapter(List<Album> albumList, AlbumListViewModel albumListViewModel, Context context) {
        this.albumList = albumList;
        this.albumListViewModel = albumListViewModel;
        this.context = context;
    }

    @NonNull
    @Override
    public AlbumListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.album_row, parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumListAdapter.ViewHolder holder, int position) {

        Album album = albumList.get(position);
        holder.bind(album,albumListViewModel);
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ViewDataBinding binding;
        private ImageView albumImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public ViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            albumImage = binding.getRoot().findViewById(R.id.albumImage);
        }

        public void bind(Album album, AlbumListViewModel albumListViewModel){
            this.binding.setVariable(BR.album,album);
            this.binding.setVariable(BR.albumListViewModel,albumListViewModel);
            this.binding.executePendingBindings();
            String imageUrl = album.getImageList().get(2).getUrl();
            if(imageUrl!=null)
                Picasso.get().load(imageUrl).into(albumImage);

        }
    }
}
