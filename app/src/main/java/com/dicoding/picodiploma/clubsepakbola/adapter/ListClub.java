package com.dicoding.picodiploma.clubsepakbola.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dicoding.picodiploma.clubsepakbola.R;
import com.dicoding.picodiploma.clubsepakbola.model.Club;

import java.util.ArrayList;

public class ListClub extends RecyclerView.Adapter<ListClub.ListViewHolder> {

    private ArrayList<Club> listClub;
    private OnItemClickCallBack onItemClickCallBack;
    private Context context;

    ListClub(Context context){
        this.context = context;
    }

    public void setOnItemClickCallBack(OnItemClickCallBack onItemClickCallBack){
        this.onItemClickCallBack = onItemClickCallBack;
    }

    public ListClub (ArrayList<Club> list){
        this.listClub = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_club, viewGroup, false);
        return new ListViewHolder(view);
    }

    public interface OnItemClickCallBack{
        void onItemClicked(Club data);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Club Club = listClub.get(position);
        Glide.with(holder.itemView.getContext())
                .load(Club.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);
        holder.tvTitle.setText(Club.getTitle());
        holder.tvDetail.setText(Club.getDetail());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallBack.onItemClicked(listClub.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listClub.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvTitle, tvDetail;

        ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.item_photo);
            tvTitle = itemView.findViewById(R.id.item_title);
            tvDetail = itemView.findViewById(R.id.item_detail);
        }

    }
}