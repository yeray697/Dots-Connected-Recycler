package com.yeray697.dotsconnectedrecycler;

import android.graphics.Color;

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

    @Override
    public int getDotColor() {
        return Color.BLUE;
    }

    @Override
    public int getDotBorderSize() {
        return 5;
    }

    @Override
    public int getDotSize() {
        return 40;
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
        return 10;
    }
}
