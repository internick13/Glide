package android.galosoft.com.glide.Adapters;

import android.content.Context;
import android.content.Intent;
import android.galosoft.com.glide.AnimeActivity;
import android.galosoft.com.glide.Models.Anime;
import android.galosoft.com.glide.R;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class RecyclerViewAdapter extends  RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{

    private Context context;
    private List<Anime> mData;
    RequestOptions option;

    public RecyclerViewAdapter(Context context, List<Anime> mData) {
        this.context = context;
        this.mData = mData;
        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.anime_row_item, viewGroup, false);
        final MyViewHolder viewHolder = new MyViewHolder(view);

        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, AnimeActivity.class);
                i.putExtra("anime_name", mData.get(viewHolder.getAdapterPosition()).getName());
                i.putExtra("anime_description", mData.get(viewHolder.getAdapterPosition()).getDescription());
                i.putExtra("anime_studio", mData.get(viewHolder.getAdapterPosition()).getStudio());
                i.putExtra("anime_category", mData.get(viewHolder.getAdapterPosition()).getCategorie());
                i.putExtra("anime_nb_episode", mData.get(viewHolder.getAdapterPosition()).getNb_episode());
                i.putExtra("anime_rating", mData.get(viewHolder.getAdapterPosition()).getRating());
                i.putExtra("anime_img", mData.get(viewHolder.getAdapterPosition()).getImgage_url());

                context.startActivity(i);

            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.tv_name.setText(mData.get(i).getName());
        myViewHolder.tv_rating.setText(mData.get(i).getRating());
        myViewHolder.tv_studio.setText(mData.get(i).getStudio());
        myViewHolder.tv_category.setText(mData.get(i).getCategorie());

        //load image from internet
        Glide.with(context).load(mData.get(i).getImgage_url()).apply(option).into(myViewHolder.img_thumbnail);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_name, tv_rating, tv_studio, tv_category;
        ImageView img_thumbnail;
        LinearLayout view_container;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            view_container = itemView.findViewById(R.id.container);
            tv_name = itemView.findViewById(R.id.anime_name);
            tv_rating= itemView.findViewById(R.id.rating);
            tv_studio = itemView.findViewById(R.id.studio);
            tv_category = itemView.findViewById(R.id.category);
            img_thumbnail = itemView.findViewById(R.id.thumbnail);

        }
    }
}
