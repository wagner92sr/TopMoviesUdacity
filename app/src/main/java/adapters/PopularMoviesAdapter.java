package adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import br.wagnerrodrigues.com.topmoviesudacity.R;

public class PopularMoviesAdapter extends RecyclerView.Adapter<PopularMoviesAdapter.PopularMovieViewHolder> {
    Context mContext;
    ArrayList<String> mMoviesList;

    public PopularMoviesAdapter(Context context) {
        mContext = context;
        mMoviesList = new ArrayList<>();
    }

    @Override
    public PopularMovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View inflatedView = inflater.inflate(R.layout.popular_movies_list_items, parent, false);
        return new PopularMovieViewHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(PopularMovieViewHolder holder, int position) {
        holder.mMovieInfoTextView.setText(mMoviesList.get(position));
    }

    @Override
    public int getItemCount() {
        return (mMoviesList != null) ? mMoviesList.size() : 0;
    }

    public void swapMoviesList(ArrayList<String> moviesList) {
        if (mMoviesList != null) {
            mMoviesList = moviesList;
            notifyDataSetChanged();
        }
    }

    class PopularMovieViewHolder extends RecyclerView.ViewHolder {

        TextView mMovieInfoTextView;

        public PopularMovieViewHolder(View itemView) {
            super(itemView);
            mMovieInfoTextView = itemView.findViewById(R.id.text_movie_info);
        }
    }
}