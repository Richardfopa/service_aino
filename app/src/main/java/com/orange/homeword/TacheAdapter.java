package com.orange.homeword;

import static java.lang.Math.toIntExact;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.LinkedList;
import java.util.Map;


public class TacheAdapter extends RecyclerView.Adapter<TacheAdapter.TacheHolder> {

    private final LinkedList<Tache> tachesList;
    private final LayoutInflater mInflater;

    public TacheAdapter(Context context) {
        this.mInflater = LayoutInflater.from(context);
        this.tachesList = new LinkedList<>();
        FirebaseUtil.getReferenceFirestore(FirebaseUtil.TASK_COLLECTION)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        if (error != null){
                            Log.w("error:",error);
                        }
                        for (DocumentChange dc : value.getDocumentChanges()){
                            switch (dc.getType()){
                                case ADDED:
                                    Log.d("ADD:",dc.getDocument().getData().toString());
//                                    Tache tache = dc.getDocument().toObject(Tache.class);
                                    Tache task = new Tache(toIntExact(dc.getDocument().getLong("tCheckboxe")),
                                            dc.getDocument().getString("tLabel")
                                    ,dc.getDocument().getTimestamp("date"));
                                    tachesList.add(task);
                                    TacheAdapter.this.notifyItemInserted(0);
                                    break;
                                case MODIFIED:
                                    break;
                                case REMOVED:
                                    break;
                            }
                        }
                    }
                });
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
