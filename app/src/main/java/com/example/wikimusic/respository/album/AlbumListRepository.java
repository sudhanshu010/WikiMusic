package com.example.wikimusic.respository.album;

import androidx.lifecycle.MutableLiveData;

import com.example.wikimusic.api.RetrofitClient;
import com.example.wikimusic.models.Album.Album;
import com.example.wikimusic.models.Album.AlbumList;
import com.example.wikimusic.models.Album.AlbumListResponse;
import com.example.wikimusic.models.genre.GenreListResponse;
import com.example.wikimusic.util.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumListRepository {

    private static AlbumListRepository instance;
    private AlbumListResponse albumListResponse;
    private MutableLiveData<List<Album>> mAlbumList;

    public static AlbumListRepository getInstance(){
        if(instance==null)
            instance = new AlbumListRepository();
        return instance;
    }

    public MutableLiveData<List<Album>> getmAlbumList(String genreName){

        if(mAlbumList == null){
            mAlbumList = new MutableLiveData<>();
            loadData(genreName);
        }
        return mAlbumList;
    }

    private void loadData(String genreName) {

        String genre = genreName;
        Call<AlbumListResponse> albumListResponseCall = RetrofitClient.getInstance().getApi().getAlbumList(genreName, Constants.apiKey);
        albumListResponseCall.enqueue(new Callback<AlbumListResponse>() {
            @Override
            public void onResponse(Call<AlbumListResponse> call, Response<AlbumListResponse> response) {
                if (response.isSuccessful()) {
                    AlbumListResponse albumListResponse = response.body();
                    mAlbumList.postValue(albumListResponse.getAlbumList().getAlbumList());
                }
            }

            @Override
            public void onFailure(Call<AlbumListResponse> call, Throwable t) {

            }

        });
    }
}
