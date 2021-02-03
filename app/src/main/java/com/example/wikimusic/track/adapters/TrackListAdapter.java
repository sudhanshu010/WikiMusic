package com.example.wikimusic.track.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wikimusic.BR;
import com.example.wikimusic.R;
import com.example.wikimusic.models.images.Image;
import com.example.wikimusic.track.models.Track;
import com.example.wikimusic.track.viewmodels.TrackListViewModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TrackListAdapter extends RecyclerView.Adapter<TrackListAdapter.ViewHolder> {

    private List<Track> trackList;
    private TrackListViewModel trackListViewModel;
    private Context context;

    public TrackListAdapter(List<Track> trackList, TrackListViewModel trackListViewModel, Context context) {
        this.trackList = trackList;
        this.trackListViewModel = trackListViewModel;
        this.context = context;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.track_item,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Track track = trackList.get(position);
        holder.bind(track,trackListViewModel);

    }

    @Override
    public int getItemCount() {
        return trackList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ViewDataBinding binding;
        private ImageView trackImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public ViewHolder(ViewDataBinding binding){
            super(binding.getRoot());
            this.binding = binding;
            trackImage = binding.getRoot().findViewById(R.id.trackImage);
        }

        public void bind(Track track, TrackListViewModel trackListViewModel){
            this.binding.setVariable(BR.track,track);
            this.binding.executePendingBindings();
            String imageUrl = track.getImageList().get(2).getUrl();
            if(imageUrl!=null)
                Picasso.get().load(imageUrl).into(trackImage);
        }
    }
}
