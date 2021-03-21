package com.example.javafragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int TYPE_RECEIVER =1;
    public static final int TYPE_SENDER =2;

    private ArrayList<Message> localDataSet;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public ViewHolder(@NonNull View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            textView = (TextView) view.findViewById(R.id.textView);
        }

        public TextView getTextView() {
            return textView;
        }
    }

    public static class ViewHolderSender extends RecyclerView.ViewHolder {
        private final TextView textView;

        public ViewHolderSender(@NonNull View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            textView = (TextView) view.findViewById(R.id.textViewSender);
        }

        public TextView getTextView() {
            return textView;
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public CustomAdapter(ArrayList<Message> dataSet) {
        localDataSet = dataSet;
    }

    @Override
    public int getItemViewType(int position) {
        if(localDataSet.get(position).getType()==TYPE_RECEIVER){
    return TYPE_RECEIVER;
        }
        else {
            return TYPE_SENDER;
        }

    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view;
        if (viewType==TYPE_RECEIVER) {
            view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.text_row_item, viewGroup, false);
            return new ViewHolder(view);
        }
        else   {
            view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.text_row_item2, viewGroup, false);
            return new ViewHolderSender(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        if(getItemViewType(position)==TYPE_RECEIVER) {
            ((ViewHolder)viewHolder).getTextView().setText(localDataSet.get(position).getMessage());
        }
        else {
            ((ViewHolderSender)viewHolder).getTextView().setText(localDataSet.get(position).getMessage());
        }
    }

    // Replace the contents of a view (invoked by the layout manager)


    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}