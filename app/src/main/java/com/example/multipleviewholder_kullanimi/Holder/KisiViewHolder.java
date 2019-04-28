package com.example.multipleviewholder_kullanimi.Holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.multipleviewholder_kullanimi.Model.Kisi;
import com.example.multipleviewholder_kullanimi.R;

public class KisiViewHolder extends RecyclerView.ViewHolder {

    private TextView tvAdSoyad,tvYas;
    private ImageView ivResim;

    public KisiViewHolder(@NonNull View itemView) {

        super(itemView);

        ivResim = itemView.findViewById(R.id.ivResim);
        tvAdSoyad = itemView.findViewById(R.id.tvAdSoyad);
        tvYas = itemView.findViewById(R.id.tvYas);
    }

    public void showDetails(Kisi kisi){
        tvAdSoyad.setText(kisi.getAdSoyad());
        tvYas.setText(""+kisi.getYas());
        ivResim.setImageResource(kisi.getResimId());
    }
}
