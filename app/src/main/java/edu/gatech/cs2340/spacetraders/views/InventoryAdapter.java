package edu.gatech.cs2340.spacetraders.views;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableRow;
import android.widget.TextView;

import org.w3c.dom.Text;

import edu.gatech.cs2340.spacetraders.model.Good;
import edu.gatech.cs2340.spacetraders.model.Inventory;
import edu.gatech.cs2340.spacetraders.R;

public class InventoryAdapter extends RecyclerView.Adapter<InventoryAdapter.MyViewHolder> {
    private Inventory inventory;
    private Inventory playerInventory;
    private int selectedPosition = -1;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TableRow tableRow;
        public MyViewHolder(TableRow v) {
            super(v);
            tableRow= v;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public InventoryAdapter(Inventory inventory, Inventory playerInventory) {
        this.inventory = inventory;
        this.playerInventory = playerInventory;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public InventoryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        // create a new view
        TableRow v = (TableRow) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.inventory_item, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Good good = Good.values()[position];

        TextView goodName = (TextView) holder.tableRow.getChildAt(0);
        TextView goodPrice = (TextView) holder.tableRow.getChildAt(1);
        TextView marketStock = (TextView) holder.tableRow.getChildAt(2);
        TextView playerStock = (TextView) holder.tableRow.getChildAt(3);

        goodName.setText(good.toString());
        goodPrice.setText(String.format("$%.2f", inventory.getPrice(good)));
        marketStock.setText(String.format("%d", inventory.getStock(good)));
        playerStock.setText(String.format("%d", playerInventory.getStock(good)));

        holder.tableRow.setOnClickListener(view -> {
            selectedPosition = good.ordinal();
            holder.tableRow.setBackgroundColor(Color.parseColor("#baefcd"));
            notifyDataSetChanged();
            updateColor(holder, position);

        });

        updateColor(holder, position);


    }

    public int getSelectedPosition() {
        return selectedPosition;
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return Good.values().length;
    }

    public void updateColor(MyViewHolder holder, int position) {
        if (position == selectedPosition) {
            holder.tableRow.setBackgroundColor(Color.parseColor("#baefcd"));
        } else {
            holder.tableRow.setBackgroundColor(Color.parseColor("#95d4ab"));
        }
    }

}