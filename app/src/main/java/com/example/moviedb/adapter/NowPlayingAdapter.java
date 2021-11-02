package com.example.moviedb.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.moviedb.R;
import com.example.moviedb.helper.Const;
import com.example.moviedb.model.NowPlaying;
import com.example.moviedb.view.activities.MovieDetailsActivity;

import java.util.List;

public class NowPlayingAdapter extends RecyclerView.Adapter<NowPlayingAdapter.CardViewHolder> {

    private Context context;
    private List<NowPlaying.Results> listNowPlaying;
    private List<NowPlaying.Results> getListNowPlaying(){return listNowPlaying;}
    public void setListNowPlaying(List<NowPlaying.Results> listNowPlaying){
        this.listNowPlaying = listNowPlaying;
    }
    public NowPlayingAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public NowPlayingAdapter.CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_now_playing, parent,
                false);
        return new NowPlayingAdapter.CardViewHolder((view));
    }

    @Override
    public void onBindViewHolder(@NonNull NowPlayingAdapter.CardViewHolder holder, int position) {
        final NowPlaying.Results results = getListNowPlaying().get(position);
        holder.lbl_title.setText(results.getTitle());
        holder.lbl_overview.setText(results.getOverview());
        holder.lbl_release_date.setText(results.getRelease_date());
//        holder.lbl_vote_count.set(results.getVote_count());
        Glide.with(context)
                .load(Const.IMG_URL + results.getPoster_path())
                .into(holder.img_poster);

        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(context, MovieDetailsActivity.class);
//                intent.putExtra("movie_id", " " + results.getId());
//                intent.putExtra("movie_title", "" + results.getTitle());
//                intent.putExtra("movie_overview", "" + results.getOverview());
//                intent.putExtra("movie_releasedate", "" + results.getRelease_date());
//                intent.putExtra("movie_rate", "" + results.getVote_average());
//                intent.putExtra("movie_language", "" + results.getOriginal_language());
//                intent.putExtra("movie_popular", "" + results.getPopularity());
//                intent.putExtra("movie_votecount", "" + results.getVote_count());
//                intent.putExtra("movie_img", "" + Glide.with(context)
//                        .load(Const.IMG_URL + results.getPoster_path())
//                        .into(holder.img_poster));
//                context.startActivity(intent);

                Bundle bundle = new Bundle();
                bundle.putString("movie_id", "" + results.getId());
                bundle.putString("movie_title", "" + results.getTitle());
                bundle.putString("movie_overview", "" + results.getOverview());
                bundle.putString("movie_releasedate", "" + results.getRelease_date());
                bundle.putString("movie_rate", "" + results.getVote_average());
                bundle.putString("movie_langguae", "" + results.getOriginal_language());
//                bundle.putParcelable("movie", results);

                Navigation.findNavController(view).navigate(R.id.
                    action_nowPlayingFragment_to_movieDetailsFragment, bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getListNowPlaying().size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView img_poster;
        TextView lbl_title, lbl_overview, lbl_release_date, lbl_vote_count;
        CardView cv;


        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            img_poster = itemView.findViewById(R.id.img_poster_card_nowplaying);
            lbl_title = itemView.findViewById(R.id.lbl_title_card_nowplaying);
//            lbl_vote_count = itemView.findViewById(R.id.lbl_votecount_card_nowplaying);
            lbl_overview = itemView.findViewById(R.id.lbl_overview_card_nowplaying);
            lbl_release_date = itemView.findViewById(R.id.lbl_releasedate_card_nowplaying);
            cv = itemView.findViewById(R.id.cv_card_nowplaying);


        }
    }
}
