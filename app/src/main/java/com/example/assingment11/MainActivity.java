package com.example.assingment11;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageAlphabet;
    private ImageView imageTime;
    private RecyclerView recyclerView;
    private ListGrocery listGrocery;
    private GroceryListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageAlphabet = findViewById(R.id.imageAlphabet);
        imageTime = findViewById(R.id.imageTime);
        recyclerView = findViewById(R.id.rvGroceries);

        listGrocery = ListGrocery.getInstance();
        listGrocery.sortGroceriesByTime();

        adapter = new GroceryListAdapter(listGrocery.getGroceries());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        imageAlphabet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listGrocery.sortGroceriesByAlphabet();
                adapter.notifyDataSetChanged();
            }
        });

        imageTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listGrocery.sortGroceriesByTime();
                adapter.notifyDataSetChanged();
            }
        });
    }

    public void openAddGroceryActivity(View view) {
        Intent intent = new Intent(this, AddGroceryActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                adapter.notifyDataSetChanged();
            }
        }
    }
}
