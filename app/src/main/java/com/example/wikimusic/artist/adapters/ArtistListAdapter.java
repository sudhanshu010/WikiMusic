package com.example.wikimusic.artist.adapters;

import android.content.Context;
import android.provider.ContactsContract;
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
import com.example.wikimusic.artist.models.Artist;
import com.example.wikimusic.artist.viewmodels.ArtistListViewModel;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArtistListAdapter extends RecyclerView.Adapter<ArtistListAdapter.ViewHolder> {

    private List<Artist> artistList;
    private ArtistListViewModel artistListViewModel;
    private Context context;

    public ArtistListAdapter(List<Artist> artistList, ArtistListViewModel artistListViewModel, Context context) {
        this.artistList = artistList;
        this.artistListViewModel = artistListViewModel;
        this.context = context;
    }

    @NonNull
    @Override
    public ArtistListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.artist_row,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtistListAdapter.ViewHolder holder, int position) {

        Artist artist = artistList.get(position);
        holder.bind(artist,artistListViewModel);
    }

    @Override
    public int getItemCount() {
        return artistList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ViewDataBinding binding;
        private ImageView artistImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public ViewHolder(ViewDataBinding binding){
            super(binding.getRoot());
            this.binding = binding;
            artistImage = binding.getRoot().findViewById(R.id.artistImage);
        }

        public void bind(Artist artist,ArtistListViewModel artistListViewModel){

           this.binding.setVariable(BR.artist,artist);
           this.binding.setVariable(BR.artistListViewModel,artistListViewModel);
           this.binding.executePendingBindings();
           String imageUrl = artist.getImageList().get(3).getUrl();
           if(imageUrl!=null)
               Picasso.get().load(imageUrl).into(artistImage);
        }
    }


}
