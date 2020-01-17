package edu.qc.seclass.glm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {
    public ArrayList<List> database;
    public OnItemClickListener listener;

    public interface OnItemClickListener {
        void OnItemClick(int position);

        void OnDeleteClick(int position);

        void OnEditClick(int position);

        void onCheckClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public static class ListViewHolder extends RecyclerView.ViewHolder {
        public TextView listName;
        public TextView reminderNumber;
        public ImageView delete;
        public ImageView edit;
        public CheckBox checkBox;

        public ListViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            listName = itemView.findViewById(R.id.listName);
            reminderNumber = itemView.findViewById(R.id.reminderNumber);
            delete = itemView.findViewById(R.id.delete);
            edit = itemView.findViewById(R.id.edit);
            checkBox = itemView.findViewById(R.id.checkBox);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.OnItemClick(position);
                        }
                    }
                }
            });

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.OnDeleteClick(position);
                        }
                    }
                }
            });
            edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.OnEditClick(position);
                        }
                    }
                }
            });


            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onCheckClick(position);
                        }
                    }
                }
            });
        }
    }

    public ListAdapter(ArrayList<List> database) {
        this.database = database;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list, parent, false);
        ListViewHolder lvh = new ListViewHolder(v, listener);
        return lvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        List listItem = database.get(position);

        holder.listName.setText(listItem.name);
        holder.reminderNumber.setText(listItem.reminders.size() + " reminders");
        holder.checkBox.setChecked(listItem.check);
    }

    @Override
    public int getItemCount() {
        return database.size();
    }
}