package com.example.hw_1;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NumberListFragment extends Fragment {
    private NumberItemAdapter adapter;
    private List<NumberItem> numbers = new ArrayList<>();
    private static String ELEMS_NUM_KEY = "ELEMS_NUM";

    public NumberListFragment() {
        super();
    }

    static NumberListFragment newInstance() {
        NumberListFragment fragment = new NumberListFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int elemsNum = getResources().getInteger(R.integer.elements_num);
        if (savedInstanceState != null) {
            elemsNum = savedInstanceState.getInt(ELEMS_NUM_KEY, elemsNum);
        }
        for (int i = 0; i < elemsNum; ++i) {
            numbers.add(createItemToAdd());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_number_list, parent, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycleview);
        NumberItemAdapter.NumberClicker listener = (NumberItemAdapter.NumberClicker) getActivity();
        adapter = new NumberItemAdapter(numbers, listener);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), getResources().getInteger(R.integer.columns_num)));
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle state) {
        super.onSaveInstanceState(state);
        state.putInt(ELEMS_NUM_KEY, numbers.size());
    }


    void addItem() {
        NumberItem item = createItemToAdd();
        numbers.add(item);
        adapter.notifyItemInserted(item.num - 1);
    }

    private NumberItem createItemToAdd() {
        int index = numbers.size() + 1;
        return new NumberItem(index, getResources().getColor(index % 2 == 0 ? R.color.evenNumber : R.color.oddNumber));
    }

}
