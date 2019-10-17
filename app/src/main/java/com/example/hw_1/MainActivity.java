package com.example.hw_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements NumberItemAdapter.NumberClicker {
    private final static String SAVED_STATE = "isNumberActivity";
    private boolean isNumberActivity = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            isNumberActivity = savedInstanceState.getBoolean(SAVED_STATE, false);
        }
        if (!isNumberActivity) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, NumberListFragment.newInstance())
                    .commit();
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle state) {
        super.onSaveInstanceState(state);
        state.putBoolean(SAVED_STATE, isNumberActivity);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        isNumberActivity = false;
    }

    @Override
    public void onNumberClicked(NumberItem item) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, NumberFragment.newInstance(item))
                .addToBackStack(null)
                .commit();
        isNumberActivity = true;
    }


    public void onButtonClick(View view) {
        NumberListFragment fragment = (NumberListFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (fragment != null) {
            fragment.addItem();
        }
    }
}
