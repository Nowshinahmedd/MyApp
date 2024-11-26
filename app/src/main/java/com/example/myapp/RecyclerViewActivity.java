package com.example.myapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView.Adapter myAdapter;
    private List<String> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        // Initialize RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Sample data for RecyclerView
        dataList = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            dataList.add("Item " + i);
        }

        // Set up RecyclerView Adapter
        myAdapter = new MyAdapter(dataList);
        recyclerView.setAdapter(myAdapter);

        // Button to dynamically add new items
        Button buttonAddItem = findViewById(R.id.buttonAddItem);
        buttonAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Dynamically add new item to the list
                addNewItem();
            }
        });
    }
    private void addNewItem() {
        dataList.add("New Item " + (dataList.size() + 1));
        myAdapter.notifyItemInserted(dataList.size() - 1);
    }

    // Adapter class to bind data to RecyclerView
    public static class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

        private List<String> dataList;

        public MyAdapter(List<String> dataList) {
            this.dataList = dataList;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // Inflate the layout for each item in the list
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(android.R.layout.simple_list_item_1, parent, false);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            // Bind data to each item view
            String item = dataList.get(position);
            holder.textView.setText(item);
        }

        @Override
        public int getItemCount() {
            return dataList.size();
        }

        public static class MyViewHolder extends RecyclerView.ViewHolder {

            TextView textView;

            public MyViewHolder(View itemView) {
                super(itemView);
                textView = itemView.findViewById(android.R.id.text1); // TextView in the item layout
            }
        }
    }
}