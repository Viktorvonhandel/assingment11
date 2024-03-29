package com.example.assingment11;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;

public class GroceryListAdapter extends RecyclerView.Adapter<GroceryListAdapter.GroceryViewHolder> {

    private ArrayList<Grocery> groceries;
    private boolean isEditMode = false;
    private int currentPosition = RecyclerView.NO_POSITION;

    public GroceryListAdapter(ArrayList<Grocery> groceries) {
        this.groceries = groceries;
    }

    @NonNull
    @Override
    public GroceryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_grocery, parent, false);
        return new GroceryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GroceryViewHolder holder, int position) {
        Grocery grocery = groceries.get(position);
        holder.textGroceryNote.setText(grocery.getNote());

        if (isEditMode && position == currentPosition) {
            holder.textGroceryName.setVisibility(View.GONE);
            holder.editTextGroceryName.setVisibility(View.VISIBLE);
            holder.editTextGroceryName.setText(grocery.getName());
        } else {
            holder.textGroceryName.setVisibility(View.VISIBLE);
            holder.editTextGroceryName.setVisibility(View.GONE);
            holder.textGroceryName.setText(grocery.getName());
        }

        holder.imageDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                groceries.remove(position);
                notifyDataSetChanged();
                Toast.makeText(v.getContext(), "Grocery removed", Toast.LENGTH_SHORT).show();
            }
        });

        holder.imageEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isEditMode = !isEditMode;
                int currentPosition = holder.getAdapterPosition();
                if (isEditMode) {
                    currentPosition = holder.getAdapterPosition();
                    holder.textGroceryName.setVisibility(View.GONE);
                    holder.editTextGroceryName.setVisibility(View.VISIBLE);
                    holder.editTextGroceryName.requestFocus();
                    InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.showSoftInput(holder.editTextGroceryName, InputMethodManager.SHOW_IMPLICIT);
                } else {
                    String newName = holder.editTextGroceryName.getText().toString();
                    holder.textGroceryName.setText(newName);
                    holder.textGroceryName.setVisibility(View.VISIBLE);
                    holder.editTextGroceryName.setVisibility(View.GONE);

                    Grocery grocery = groceries.get(currentPosition);
                    grocery.setName(newName);
                    notifyDataSetChanged();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return groceries.size();
    }

    public static class GroceryViewHolder extends RecyclerView.ViewHolder {
        public TextView textGroceryName;
        public EditText editTextGroceryName;
        public EditText textGroceryNote;
        public ImageView imageDelete;
        public ImageView imageEdit;

        public GroceryViewHolder(@NonNull View itemView) {
            super(itemView);
            textGroceryName = itemView.findViewById(R.id.textGroceryName);
            editTextGroceryName = itemView.findViewById(R.id.editTextGroceryName);
            textGroceryNote = itemView.findViewById(R.id.editTextGroceryNote);
            imageDelete = itemView.findViewById(R.id.imageDelete);
            imageEdit = itemView.findViewById(R.id.imageEdit);
        }
    }
}

