package com.yeray697.dotsconnectedrecycler;

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
 * DotLineRecycler's adapter
 * @author yeray697
 * @version 1.0
 * Created on 21/12/16.
 */
public abstract class DotLineRecyclerAdapter extends RecyclerView.Adapter<DotLineRecyclerAdapter.Holder> {


    private final int DOT_BORDER_COLOR = Color.BLACK;
    private final int DOT_COLOR = Color.WHITE;
    private final int DOT_SIZE = 30;
    private final int DOT_BORDER_SIZE = 2;

    private final int TEXT_TITLE_COLOR = Color.GRAY;
    private final int TEXT_SUBTITLE_COLOR  = Color.GRAY;

    private ArrayList<RecyclerData> list;
    private int SEPARATOR = 10;
    private int dotMarginLeft;

    private static final int DEFAULT_DOT_MARGIN_RIGHT = 120;

    //Constructors
    public DotLineRecyclerAdapter(ArrayList<RecyclerData> data) {
        this.list = data;
        this.dotMarginLeft = DEFAULT_DOT_MARGIN_RIGHT;
    }

    public DotLineRecyclerAdapter(ArrayList<RecyclerData> data, int dotMarginLeft) {
        this.list = data;
        this.dotMarginLeft = (dotMarginLeft >= 0 ? dotMarginLeft :0);
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(final Holder holder, int position) {
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

    /**
     * Called from onBindViewHolder, it sets settings on the view components
     * @param holder
     */
    private void setHolderSettings(Holder holder) {
        holder.dot.setDotBorderColor(getDotBoderColor());
        holder.dot.setDotColor(getDotColor());
        holder.dot.setDotSize(getDotSize());
        holder.dot.setDotBorderSize(getDotBorderSize());
        holder.dot.setDotMarginLeft(getDotMarginLeft());

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
        DotView dot;

        public Holder(View itemView) {
            super(itemView);
            rlItem = (RelativeLayout) itemView.findViewById(R.id.rlItem);
            iv_item = (ImageView) itemView.findViewById(R.id.iv_item);
            message = (Message_View) itemView.findViewById(R.id.message_item);
            dot = (DotView) itemView.findViewById(R.id.line_and_dot);
        }
    }

    /**
     * Returns the item at X position
     * @param position Item position
     * @return Return the item
     */
    public RecyclerData getItemAtPosition(int position){
        return list.get(position);
    }

    public final int getDotMarginLeft() {
        return dotMarginLeft;
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
