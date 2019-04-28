package com.example.multipleviewholder_kullanimi.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.multipleviewholder_kullanimi.Holder.KisiViewHolder;
import com.example.multipleviewholder_kullanimi.Holder.ReklamViewHolder;
import com.example.multipleviewholder_kullanimi.Model.Kisi;
import com.example.multipleviewholder_kullanimi.Model.Reklam;
import com.example.multipleviewholder_kullanimi.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Object> list;
    private final static int TIP_KISI = 1, TIP_REKLAM = 2;
    private Context context;

    public RecyclerViewAdapter() {
    }

    public RecyclerViewAdapter(List<Object> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        /*
        List içerisindeki gelen tipi yakalayabileceğimiz metot
         */
        if (list.get(position) instanceof Kisi) { // Tipler eşit ise true döner
            return TIP_KISI;
        } else if (list.get(position) instanceof Reklam) {
            return TIP_REKLAM;
        }
        return -1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        int layout = 0;
        RecyclerView.ViewHolder viewHolder;
        switch (i) {
            case TIP_KISI:
                layout = R.layout.layout_kisi;
                View kisiView =
                        LayoutInflater
                                .from(viewGroup.getContext())
                                .inflate(layout,viewGroup,false);
                viewHolder = new KisiViewHolder(kisiView);
                break;
            case TIP_REKLAM:
                layout = R.layout.layout_reklam;
                View reklamView =
                        LayoutInflater
                                .from(viewGroup.getContext())
                                .inflate(layout,viewGroup,false);
                viewHolder = new ReklamViewHolder(reklamView);
                break;
            default:
                viewHolder = null;
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        int viewType = holder.getItemViewType();
        switch (viewType){
            case TIP_KISI:
                Kisi kisi = (Kisi)list.get(position);
                ((KisiViewHolder)holder).showDetails(kisi);
                break;
            case TIP_REKLAM:
                Reklam reklam = (Reklam)list.get(position);
                ((ReklamViewHolder)holder).showDetails(reklam);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
