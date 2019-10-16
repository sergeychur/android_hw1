package com.example.hw_1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collection;
import java.util.List;

public class NumberItemAdapter extends RecyclerView.Adapter<NumberItemAdapter.NumberViewHolder> {

    private List<NumberItem> numbersList;

    public NumberItemAdapter(List<NumberItem> items) {
        setItems(items);
    }

    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_number, parent, false);
        return new NumberViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NumberViewHolder holder, int position) {
        holder.number = numbersList.get(position);
    }

    @Override
    public int getItemCount() {
        return numbersList.size();
    }

    private void setItems(Collection<NumberItem> items) {
        numbersList.addAll(items);
        notifyDataSetChanged();
    }

    public void clearItems() {
        numbersList.clear();
        notifyDataSetChanged();
    }

    public void addItem(NumberItem item) {
        numbersList.add(item);
        notifyDataSetChanged();
    }

    class NumberViewHolder extends RecyclerView.ViewHolder {
        public NumberItem number;
        public final View view;
        NumberViewHolder(View itemView) {
            super(itemView);
            view = itemView;

        }

    }
}