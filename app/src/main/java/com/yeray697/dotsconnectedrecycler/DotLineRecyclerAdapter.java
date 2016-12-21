package com.yeray697.dotsconnectedrecycler;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by yeray697 on 20/12/16.
 */

public abstract class DotLineRecyclerAdapter extends RecyclerView.Adapter<DotLineRecyclerAdapter.Holder> {


    private final int DOT_BORDER_COLOR = Color.BLACK;
    private final int DOT_COLOR = Color.WHITE;
    private final int DOT_SIZE = 30;
    private final int DOT_BORDER_SIZE = 2;
    private final int DOT_MARGIN_TOP = 15;
    private final int DOT_MARGIN_RIGHT = 0;
    private final int DOT_MARGIN_LEFT = 0;
    private final int DOT_MARGIN_BOTTOM = 0;

    private final int TEXT_TITLE_COLOR = Color.GRAY;
    private final int TEXT_SUBTITLE_COLOR  = Color.GRAY;
    private Context context;

    private ArrayList<RecyclerData> list;
    private int SEPARATOR = 10;

    public DotLineRecyclerAdapter(Context context, ArrayList<RecyclerData> data){
        this.list = data;
        this.context = context;
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
        setHolderSettings(holder);
    }

    private void setHolderSettings(Holder holder) {
        //line_and_dot component
        holder.line_and_dot.setDotBorderColor(getDotBoderColor());
        holder.line_and_dot.setDotColor(getDotColor());
        holder.line_and_dot.setDotSize(getDotSize());
        holder.line_and_dot.setDotBorderSize(getDotBorderSize());
        holder.line_and_dot.setDotMarginTop(getDotMarginTop());
        holder.line_and_dot.setDotMarginBottom(getDotMarginBottom());
        holder.line_and_dot.setDotMarginLeft(getDotMarginLeft());
        holder.line_and_dot.setDotMarginRight(getDotMarginRight());

        holder.message.setTextSubTitleColor(getTextSubtitleColor());
        holder.message.setTextTitleColor(getTextTitleColor());

        ViewGroup.MarginLayoutParams relativeParams = (ViewGroup.MarginLayoutParams) holder.rlItem.getLayoutParams();
        relativeParams.setMargins(5, 0, 5, getSeparator() * 4);
        holder.rlItem.setLayoutParams(relativeParams);
        holder.rlItem.requestLayout();
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

    public Context getContext() {
        return context;
    }

    //Methods to override
    public int getDotBoderColor() {
        return DOT_BORDER_COLOR;
    }

    public int getDotBorderSize() {
        return DOT_BORDER_SIZE;
    }

    public int getDotColor() {
        return DOT_COLOR;
    }

    public int getDotMarginBottom() {
        return DOT_MARGIN_BOTTOM;
    }

    public int getDotMarginLeft() {
        return DOT_MARGIN_LEFT;
    }

    public int getDotMarginRight() {
        return DOT_MARGIN_RIGHT;
    }

    public int getDotMarginTop() {
        return DOT_MARGIN_TOP;
    }

    public int getDotSize() {
        return DOT_SIZE;
    }

    public int getTextSubtitleColor() {
        return TEXT_SUBTITLE_COLOR;
    }

    public int getTextTitleColor() {
        return TEXT_TITLE_COLOR;
    }

    public int getSeparator(){
        return SEPARATOR;
    }
}
