package com.example.ptstugas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.example.ptstugas.databinding.ActivityMainBinding;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        //String heroes[] = getResources().getStringArray(R.array.heroes_name);
        ArrayList<Movie> movies = getListMovies();

        Log.d("AHAH", movies.get(12).getDescription());

        MovieAdapter adapter = new MovieAdapter(movies);
        LinearLayoutManager layout = new GridLayoutManager(this, 2);
        binding.rvHero.setLayoutManager(layout);
        binding.rvHero.setAdapter(adapter);

        Log.d("AHAH", Integer.toString(adapter.getItemCount()));
    }

    private ArrayList<Movie> getListMovies(){
        String[] name = getResources().getStringArray(R.array.movies_name);
        String[] descrption = getResources().getStringArray(R.array.movie_description);
        TypedArray poster =getResources().obtainTypedArray(R.array.movies_poster);

        ArrayList<Movie> movies = new ArrayList<>();

        for (int i = 0; i< name.length; i++){
            //buat obejek baru,dan berikan data nama, description ke objek baru tersebut
            Movie movie = new Movie();
            movie.setName(name[i]);
            movie.setDescription(descrption[i]);
            movie.setPoster(poster.getResourceId(i,-1));

            //tambahkan objek baru tersebut ke variabel list hero
            movies.add(movie);
        }
        return movies;
    }
}