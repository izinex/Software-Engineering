package edu.qc.seclass.glm;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static edu.qc.seclass.glm.R.color.colorChecked;

public class ItemsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    HashMap<String,List> data;
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

    private class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvItem;
        public ViewHolder(View itemView, OnItemClickListener list)
        {
            super(itemView);
            tvItem = itemView.findViewById(android.R.id.text1);
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

        public void bind(String item)
        {
            tvItem.setText(item);
        }

    }

    public ItemsAdapter(HashMap<String,List> data)
    {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        //v.setBackgroundColor(Color.rgb(233,63,63));
        v.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        return new ViewHolder(v, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Object firstKey = data.keySet().toArray()[position];
        if (firstKey != null) {

            String val1 = String.valueOf(firstKey);
            //String checkedMark = "\u2610";
           // String result = checkedMark.concat(" ").concat(val1);
            ((ViewHolder) holder).bind(val1);
        }
        {
            //we can then create an intent here and start a new activity
            //with our data
        }
    }

    @Override
    public int getItemCount() {
        return data.keySet().size();
    }




}
