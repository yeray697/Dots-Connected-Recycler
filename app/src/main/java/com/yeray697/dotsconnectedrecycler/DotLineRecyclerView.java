package com.yeray697.dotsconnectedrecycler;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by usuario on 21/12/16.
 */

public class DotLineRecyclerView extends RelativeLayout {
    private View line;
    private RecyclerView recyclerView;

    private int lineColor;

    //Constructors
    public DotLineRecyclerView(Context context, AttributeSet attrs, int defStyle){
        super(context, attrs, defStyle);
        initialize(attrs);
    }

    public DotLineRecyclerView(Context context) {
        super(context);
        initialize(null);
    }

    public DotLineRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(attrs);
    }

    //Privated methods
    private void initialize(AttributeSet attrs) {
        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li =
                (LayoutInflater)getContext().getSystemService(infService);
        li.inflate(R.layout.dot_line_recycler_view, this, true);

        recyclerView = (RecyclerView) findViewById(R.id.rvCustomDot);
        line = findViewById(R.id.lineView);

        if (attrs != null) {
            getXMLValues(attrs);

        }
        else {
            defaultAttributes();
        }
    }

    private void defaultAttributes() {
        lineColor = Color.BLACK;
    }

    private void getXMLValues(AttributeSet attrs) {
        TypedArray a = getContext().getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.DotLineRecyclerView,
                0, 0);

        try {
            lineColor = a.getColor(R.styleable.DotLineRecyclerView_lineColor, Color.BLACK);
        } finally {
            a.recycle();
        }
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public int getLineColor() {
        return lineColor;
    }

    public void setLineColor(int lineColor) {
        this.lineColor = lineColor;
        line.setBackgroundColor(this.lineColor);
    }
}
