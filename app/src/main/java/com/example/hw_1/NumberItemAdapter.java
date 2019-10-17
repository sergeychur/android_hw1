package com.example.hw_1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collection;
import java.util.List;
import java.util.Locale;

public class NumberItemAdapter extends RecyclerView.Adapter<NumberItemAdapter.NumberViewHolder> {

    private List<NumberItem> numbersList;

    NumberItemAdapter(List<NumberItem> items) {
        numbersList = items;
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
        NumberItem number = numbersList.get(position);
        holder.view.setText(String.format(Locale.getDefault(),"%d", number.num));
        holder.view.setTextColor(number.color);
    }

    @Override
    public int getItemCount() {
        return numbersList.size();
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
        final TextView view;
        NumberViewHolder(View itemView) {
            super(itemView);
            view = itemView.findViewById(R.id.number);

        }

    }
}