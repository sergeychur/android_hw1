package com.example.hw_1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.Locale;

public class NumberFragment extends Fragment {
    private final static String NUMBER = "num";
    private final static String COLOR = "color";
    private int number;
    private int color;

    public NumberFragment() {
        super();
    }

    static NumberFragment newInstance(NumberItem item) {
        NumberFragment fragment = new NumberFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(NUMBER, item.num);
        bundle.putInt(COLOR, item.color);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            number = bundle.getInt(NUMBER);
            color = bundle.getInt(COLOR);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_number, parent, false);
        TextView textView = view.findViewById(R.id.number_frag);
        textView.setText(String.format(Locale.getDefault(), "%d", number));
        textView.setTextColor(color);
        return view;
    }


}
