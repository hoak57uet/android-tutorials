package com.kingsofts.androidtutorial.activities;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kingsofts.androidtutorial.R;
import com.kingsofts.androidtutorial.Song;
import com.kingsofts.androidtutorial.SongAdapter;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class Mp3Activity extends AppCompatActivity {
    private final String SONG_URL = "http://www.mocky.io/v2/5e625929300000de8a4d59be";
    private RecyclerView mp3Rv;
    private ImageView artistImg;
    private TextView artistNameTv;

    private List<Song> songs = new ArrayList<>();
    private SongAdapter songAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp3);
        mp3Rv = findViewById(R.id.mp3_list_song);
        artistImg = findViewById(R.id.mp3_artist_img);
        artistNameTv = findViewById(R.id.mp3_artist_name_tv);

        songAdapter = new SongAdapter(songs);
        mp3Rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mp3Rv.setAdapter(songAdapter);

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(SONG_URL, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                handleResponse(response);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.e("!!!!!!!!!!!", responseString);
            }
        });
    }

    private void handleResponse(JSONObject response) {
        try {
            String artistImageUrl = response.getString("thumbnail");
            Picasso.get().load(artistImageUrl).into(artistImg);
            artistNameTv.setText(response.getString("artists_names"));
            JSONArray arr = response.getJSONObject("songs").getJSONArray("items");
            convertJsonArrayToSong(arr);


            Log.e("#########", response.getString("thumbnail"));
        } catch (Exception e) {
            Log.e("#####", e.getMessage());
        }
    }

    private void convertJsonArrayToSong(JSONArray arr) {
        try {
            for (int i = 0; i < arr.length(); i++) {
                JSONObject songJson = arr.getJSONObject(i);
                Song s = new Song();
                s.setTitle(songJson.getString("title"));
                s.setThumbnail(songJson.getString("thumbnail"));
                songs.add(s);
            }
            songAdapter.notifyDataSetChanged();
        } catch (Exception e) {
            Log.e("!!!!!!!!!!!", e.getMessage());
        }
    }
}
