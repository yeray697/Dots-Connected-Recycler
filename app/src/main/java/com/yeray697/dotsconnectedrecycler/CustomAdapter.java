package com.yeray697.dotsconnectedrecycler;

import android.graphics.Color;

import com.yeray697.dotLineRecyclerView.DotLineRecyclerAdapter;
import com.yeray697.dotLineRecyclerView.RecyclerData;

import java.util.ArrayList;

/**
 * Custom adapter that extends from DotLineRecyclerAdapter used as example
 * @author yeray697
 * @version 1.0
 * Created on 21/12/16.
 */
public class CustomAdapter extends DotLineRecyclerAdapter {

    public CustomAdapter(ArrayList<RecyclerData> data) {
        super(data);
    }

    public CustomAdapter(ArrayList<RecyclerData> data, int dotMarginLeft) {
        super(data, dotMarginLeft);
    }

    public CustomAdapter(ArrayList<RecyclerData> data, ArrayList<Integer> colorList) {
        super(data, colorList);
    }

    public CustomAdapter(ArrayList<RecyclerData> data, int dotMarginLeft, ArrayList<Integer> colorList) {
        super(data, dotMarginLeft, colorList);
    }

    @Override
    public int getDotColor() {
        return Color.WHITE;
    }

    @Override
    public int getDotBorderSize() {
        return 10;
    }

    @Override
    public int getDotSize() {
        return 10;
    }

    @Override
    public int getTextTitleColor() {
        return Color.GRAY;
    }

    @Override
    public int getDotBoderColor() {
        return Color.GRAY;
    }

    @Override
    public int getTextSubtitleColor() {
        return Color.GRAY;
    }

    @Override
    public int getSeparator() {
        return 50;
    }
}
