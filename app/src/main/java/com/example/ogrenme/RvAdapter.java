package com.example.ogrenme;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.CvHolder> {
    private final Context mContext;
    private ArrayList<Kelimeler> kelimelerList;
    private Veritabani vt;

    public RvAdapter(Context mContext, ArrayList<Kelimeler> kelimelerList) {
        this.mContext = mContext;
        this.kelimelerList = kelimelerList;
    }


    public static class CvHolder extends RecyclerView.ViewHolder {
        private final TextView texting;
        private final TextView texttr;
        private final CardView cardview;

        public CvHolder(View itemView) {
            super(itemView);
            texting = itemView.findViewById(R.id.texting);
            texttr = itemView.findViewById(R.id.texttr);
            cardview = itemView.findViewById(R.id.cardview);

        }
    }

    @NonNull
    @Override
    public CvHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_card, parent, false);
        return new CvHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CvHolder holder, int position) {
        vt = new Veritabani(mContext);
        Kelimeler gelen = kelimelerList.get(position);
        holder.texting.setText(gelen.getKelime_ing());
        holder.texttr.setText(gelen.getKelime_tr());
        holder.cardview.setOnClickListener(view -> snackBar(view, gelen));
    }

    @Override
    public int getItemCount() {
        return kelimelerList.size();
    }

    public void snackBar(View v, Kelimeler gelen) {
        final Snackbar sb = Snackbar.make(v, "Silmek istiyor musunuz?", Snackbar.LENGTH_LONG);
        sb.setAction("Sil", view -> {
            sb.dismiss();
            KelimelerDao.kelimeSil(vt, gelen.getKelime_id());
            notifyItemRemoved(gelen.getKelime_id());
            kelimelerList = KelimelerDao.kelimeler(vt);
        });
        sb.show();
    }


}
