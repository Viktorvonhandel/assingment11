package com.example.assingment11;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddGroceryActivity extends AppCompatActivity {

    private EditText editGroceryName, GroceryNote;
    private Button buttonAddGrocery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_grocery);

        editGroceryName = findViewById(R.id.editGroceryName);
        GroceryNote = findViewById(R.id.GroceryNote);
        buttonAddGrocery = findViewById(R.id.buttonAddGrocery);


        buttonAddGrocery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String groceryName = editGroceryName.getText().toString().trim();
                String groceryNote = GroceryNote.getText().toString().trim();

                if (!groceryName.isEmpty()) {
                    ListGrocery.getInstance().addGrocery(new Grocery(groceryName, groceryNote));
                    Toast.makeText(AddGroceryActivity.this, "Grocery added successfully", Toast.LENGTH_SHORT).show();
                    setResult(RESULT_OK);

                    finish();
                } else {
                    Toast.makeText(AddGroceryActivity.this, "Please enter a grocery name", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
