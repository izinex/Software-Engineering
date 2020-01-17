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

public class ReminderAdapter extends RecyclerView.Adapter<ReminderAdapter.ReminderViewHolder> {
    public ArrayList<Reminder> reminders;
    public OnItemClickListener listener;

    public interface OnItemClickListener {
        void OnDeleteClick(int position);

        void OnEditClick(int position);

        void onCheckClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public static class ReminderViewHolder extends RecyclerView.ViewHolder {
        public TextView reminderName;
        public TextView reminderTime;
        public ImageView delete;
        public ImageView edit;
        public CheckBox checkBox;

        public ReminderViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            reminderName = itemView.findViewById(R.id.reminderName);
            reminderTime = itemView.findViewById(R.id.reminderTime);
            delete = itemView.findViewById(R.id.delete);
            edit = itemView.findViewById(R.id.edit);
            checkBox = itemView.findViewById(R.id.checkBox);

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

    public ReminderAdapter(ArrayList<Reminder> reminders) {
        this.reminders = reminders;
    }

    @NonNull
    @Override
    public ReminderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.reminder, parent, false);
        ReminderViewHolder rvh = new ReminderViewHolder(v, listener);
        return rvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ReminderViewHolder holder, int position) {
        Reminder reminderItem = reminders.get(position);

        holder.reminderName.setText(reminderItem.name);
        if (reminderItem.month == 0) {
            holder.reminderTime.setText("Edit to enter time");
        } else {
            String s;
            if (reminderItem.ampm == false) {
                s = "am";
            } else {
                s = "pm";
            }
            holder.reminderTime.setText(reminderItem.month + "/" + reminderItem.day + " " + reminderItem.hour + ":" + reminderItem.minute + " " + s);
        }
        holder.checkBox.setChecked(reminderItem.check);
    }

    @Override
    public int getItemCount() {
        return reminders.size();
    }
}