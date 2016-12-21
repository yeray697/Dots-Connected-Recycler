package com.yeray697.dotsconnectedrecycler;

import android.content.Context;
import android.graphics.Color;

import java.util.ArrayList;

/**
 * Created by usuario on 21/12/16.
 */

public class CustomAdapter extends DotLineRecyclerAdapter {

    public CustomAdapter(Context context, ArrayList<RecyclerData> data) {
        super(context, data);
    }

    @Override
    public int getDotColor() {
        return Color.YELLOW;
    }

    @Override
    public int getDotBorderSize() {
        return 10;
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
    public int getColorLine() {
        return Color.RED;
    }

    @Override
    public int getDotBoderColor() {
        return Color.BLUE;
    }

    @Override
    public int getDotMarginTop() {
        return super.getDotMarginTop();
    }

    @Override
    public int getTextSubtitleColor() {
        return Color.CYAN;
    }
}
