package com.example.moviedb.adapter;

import android.content.Context;
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
import com.example.moviedb.model.UpComing;

import java.util.List;

public class UpComingAdapter extends RecyclerView.Adapter<UpComingAdapter.UpComingViewHolder> {

    public UpComingAdapter() {}

    private Context context;
    private List<UpComing.Results> listUpComing;
    public static boolean loading = false;

    public UpComingAdapter(Context context) {
        this.context = context;
    }

    private List<UpComing.Results> getListUpComing() {
        return listUpComing;
    }

    public void setListUpComing(List<UpComing.Results> listUpComing) {
        this.listUpComing = listUpComing;
    }

    public void addItem(UpComing.Results results) {
        this.listUpComing.add(results);
    }

    @NonNull
    @Override
    public UpComingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_up_coming, parent, false);
        return new UpComingAdapter.UpComingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UpComingViewHolder holder, int position) {
        final UpComing.Results results = getListUpComing().get(position);
        Glide.with(context).load(Const.IMG_URL + results.getPoster_path()).into(holder.img_upcoming);
        holder.title_upcoming.setText(results.getTitle());
        holder.overview_upcoming.setText(results.getOverview());
        holder.release_date_upcoming.setText(results.getRelease_date());

        holder.upcoming_cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("upcoming", results);
                Navigation.findNavController(view).navigate(R.id.action_upComingFragment_to_movieDetailsFragment, bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getListUpComing().size();
    }

    public void setLoading(boolean loading) {
        this.loading = loading;
    }

    public class UpComingViewHolder extends RecyclerView.ViewHolder {

        private ImageView img_upcoming;
        private TextView title_upcoming, release_date_upcoming, overview_upcoming;
        private CardView upcoming_cv;

        public UpComingViewHolder(@NonNull View itemView) {
            super(itemView);
            img_upcoming = itemView.findViewById(R.id.img_upcoming_fragment);
            title_upcoming = itemView.findViewById(R.id.title_upcoming_fragment);
            release_date_upcoming = itemView.findViewById(R.id.releasedate_upcoming_fragment);
            overview_upcoming = itemView.findViewById(R.id.synopsis_upcoming_fragment);
            upcoming_cv = itemView.findViewById(R.id.cv_card_upcoming);
        }
    }
}

