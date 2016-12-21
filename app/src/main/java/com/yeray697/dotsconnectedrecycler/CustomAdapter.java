package com.yeray697.dotsconnectedrecycler;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by yeray697 on 20/12/16.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.Holder> {
    ArrayList<RecyclerData> list;
    private final int SEPARATOR = 60;

    public CustomAdapter(ArrayList<RecyclerData> data){
        this.list = data;
    }
    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(final Holder holder, int position) {
        final boolean[] changed = new boolean[1];
        RecyclerData aux = list.get(position);
        if (aux.isImageADrawable()){
            holder.iv_item.setImageDrawable(aux.getImage());
        } else if (aux.isImageAResource()){
            holder.iv_item.setImageResource(aux.getImageResource());
        } else if (aux.isImageAnURL()){
            Picasso.with(holder.iv_item.getContext())
                    .load(aux.getImageUrl())
                    .error(R.mipmap.ic_launcher)
                    .into(holder.iv_item);
        } else
            holder.iv_item.setImageDrawable(null);
        holder.message.setTextTitle(aux.getTitle());
        holder.message.setTextSubTitle(aux.getSubtitle());

        holder.rlItem.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                if (!changed[0]) {
                    int heigth = bottom - top; // = holder.rlText.getHeight();
                    holder.line_and_dot.setHeigth(heigth + SEPARATOR);
                    changed[0] = true;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        RelativeLayout rlItem;
        ImageView iv_item;
        Message_View message;
        DotLine_View line_and_dot;

        public Holder(View itemView) {
            super(itemView);
            rlItem = (RelativeLayout) itemView.findViewById(R.id.rlItem);
            iv_item = (ImageView) itemView.findViewById(R.id.iv_item);
            message = (Message_View) itemView.findViewById(R.id.message_item);
            line_and_dot = (DotLine_View) itemView.findViewById(R.id.line_and_dot);
        }
    }
}
