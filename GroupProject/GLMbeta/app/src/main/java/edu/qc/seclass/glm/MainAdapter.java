package edu.qc.seclass.glm;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder>
{
    //this class is the adapter for the layout in listpage
    private ArrayList<Reminder> reminderslist;
    private OnItemClickListener listener;
    private View.OnLongClickListener longListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnClickListener(OnItemClickListener list)
    {
        listener = list;
    }

    public void setOnLongClickListener(View.OnLongClickListener list) {longListener = list;}

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvItem;
        //super(tvItem);
        public ViewHolder(@NonNull View itemView, OnItemClickListener list) {
            super(itemView);

            tvItem = itemView.findViewById(android.R.id.text1);
            //tvItem.setTextColor(Color.rgb(0,0,0));

            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    if(listener != null)
                    {
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION)
                        {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener()
            {
                @Override
                public boolean onLongClick(View v)
                {
                    if(longListener != null)
                    {
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION)
                        {
                            longListener.onLongClick(v);
                            return true;
                        }
                    }
                    return false;
                }
            });

        }
    }

    public MainAdapter(ArrayList<Reminder> reminders) {
        reminderslist = reminders;
    }

    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        view.setBackgroundColor(Color.parseColor("#FAA9A9"));
        view.setLayoutParams(new ViewGroup.LayoutParams(MATCH_PARENT, 100));
        return new ViewHolder(view,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder holder, int position) {
        String unckecked = "\u2750".concat(" "); //empty box
        holder.tvItem.setText(unckecked.concat(reminderslist.get(position).allInfo()));

    }

    @Override
    public int getItemCount() {
        return reminderslist.size();
    }




}