package com.example.ptstugas;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDate;
import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {


    private ArrayList<Movie> localDataSet;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvHeroName;
        private final TextView tvHeroDescription;
        private final ImageView imgHeroPoster;


        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            tvHeroName = view.findViewById(R.id.movie_name);
            tvHeroDescription = view.findViewById(R.id.movie_description);
            imgHeroPoster = view.findViewById(R.id.movie_poster);
        }


        // public TextView getTextView() {
        // return textView;
        // }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public MovieAdapter (ArrayList<Movie> dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.movie_row_item, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        Log.d("AHAH", "i");
        String name = localDataSet.get(position).getName();
        String description = localDataSet.get(position).getDescription();
        int poster = localDataSet.get(position).getPoster();

        viewHolder.tvHeroName.setText(name);
//        Log.d("AHAH", description);
        viewHolder.tvHeroDescription.setText(description);
        viewHolder.imgHeroPoster.setImageResource(poster);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(viewHolder.itemView.getContext(), DetailActivity.class);
                //
                intent.putExtra("movie_nama",name);
                intent.putExtra("movie_Description",description);
                intent.putExtra("poster",poster);
//                viewHolder.itemView.getContext().startActivity(intent);

            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}