package com.orange.homeword;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;


public class TacheAdapter extends RecyclerView.Adapter<TacheAdapter.TacheHolder> {

    private final LinkedList<Tache> tachesList;
    private final LayoutInflater mInflater;
    private final CardView card;

    public TacheAdapter(Context context, LinkedList<Tache> tachesList, LinearLayout mInflater, CardView card) {
        this.mInflater = LayoutInflater.from(context);
        this.tachesList = tachesList;
        this.card = card;
    }

    @NonNull
    @Override
    public TacheAdapter.TacheHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.taches_item, parent, false);
        return new TacheAdapter.TacheHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull TacheAdapter.TacheHolder holder, int position) {
        Tache mCurenttache = tachesList.get(position);
        CardView card = holder.cardtaches;
        card.cancelLongPress();
        Log.d("Tache :", mCurenttache.toString());
        //set value of current ckecbox
        CheckBox checkBox = holder.checkBox;
        checkBox.setText(mCurenttache.gettLabel());
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return tachesList.size();
    }

    public class TacheHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final CardView cardtaches;
        public final CheckBox checkBox;
        final TacheAdapter adapter;

        public TacheHolder(@NonNull View itemView,TacheAdapter adapter) {
            super(itemView);
            this.cardtaches = itemView.findViewById(R.id.cardtaches);
            this.checkBox = itemView.findViewById(R.id.checkBox);
            this.adapter = adapter;
            this.checkBox.setOnClickListener(this);
        }

        public void onClick(View view) {
            int position = getLayoutPosition();
            Tache tache = tachesList.get(position);
            Toast.makeText(view.getContext(),"Vous avez cliquer sur "+tache.gettCheckboxe(),Toast.LENGTH_LONG);

        }
    }
}
