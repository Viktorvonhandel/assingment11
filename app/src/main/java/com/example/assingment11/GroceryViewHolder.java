package com.example.assingment11;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GroceryViewHolder extends RecyclerView.ViewHolder {
    public TextView textGroceryName;
    public EditText editTextGroceryName;
    public EditText GroceryNote; // Muuta muuttujan nimi tässä
    public ImageView imageDelete;
    public ImageView imageEdit;

    public GroceryViewHolder(@NonNull View itemView) {
        super(itemView);
        textGroceryName = itemView.findViewById(R.id.textGroceryName);
        editTextGroceryName = itemView.findViewById(R.id.editTextGroceryName);
        GroceryNote = itemView.findViewById(R.id.editTextGroceryNote); // Muuta muuttujan nimi tässä
        imageDelete = itemView.findViewById(R.id.imageDelete);
        imageEdit = itemView.findViewById(R.id.imageEdit);
    }
}
