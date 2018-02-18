package com.udacity.exploreindia;

import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.udacity.exploreindia.main.GetDataAdapter;
import com.udacity.exploreindia.main.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<GetDataAdapter> GetDataAdapter1; // data adapter
    RecyclerView.Adapter recyclerViewadapter; // recycler adapter
    RecyclerView recyclerView;
    LinearLayout linearLayout_2;
    Context context = this;
    RecyclerView.LayoutManager recyclerViewlayoutManager;
    private String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //-                                                                                          declarations
        recyclerView = findViewById(R.id.activity_main_recyclerView);
        linearLayout_2 = findViewById(R.id.activity_main_ll_top);
        GetDataAdapter1 = new ArrayList<>();

        //-                                                                                          actions

        // RecyclerView set-up
        recyclerView.setHasFixedSize(true);
        recyclerViewlayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(recyclerViewlayoutManager);

        /*
         * Creating Recycler Adapter and View in createRecycler();
         *
         * states getting from string.xml
         *
         */
        // TODO: (In future) can store state and City/Town data on SharedPreference and use here.
        createRecycler(getResources().getStringArray(R.array.states));

        // Semi transparent background for nice look.
        linearLayout_2.setAlpha(Float.parseFloat("0.7"));
    }


    public void createRecycler(String a[]) {
        // Clearing data adapter
        GetDataAdapter1.clear();

        // Loop through data Array and pass through Adapter
        for (int i = 0; i < a.length; i++) {
            GetDataAdapter GetDataAdapter2 = new GetDataAdapter();
            GetDataAdapter2.setName(a[i]);
            GetDataAdapter2.setId(i + "");
            Log.d(TAG, "\n" + a[i] + " > " + i);
            GetDataAdapter1.add(GetDataAdapter2);
        }
        
        recyclerViewadapter = new RecyclerViewAdapter(GetDataAdapter1, context);
        recyclerView.setAdapter(recyclerViewadapter);
    }
}
