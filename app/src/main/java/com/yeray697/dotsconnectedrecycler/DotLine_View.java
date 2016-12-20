package com.yeray697.dotsconnectedrecycler;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Created by yeray697 on 20/12/16.
 */

public class DotLine_View extends RelativeLayout {
    View line;
    View dot;

    int dotBorderColor;
    int dotColor;
    int colorLine;
    int dotSize;
    int dotBorderWidth;

    //Constructors
    public DotLine_View(Context context, AttributeSet attrs, int defStyle){
        super(context, attrs, defStyle);
        initialize(attrs);
    }

    public DotLine_View(Context context) {
        super(context);
        initialize(null);
    }

    public DotLine_View(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(attrs);
    }

    //Privated methods
    private void initialize(AttributeSet attrs) {
        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li =
                (LayoutInflater)getContext().getSystemService(infService);
        li.inflate(R.layout.dot_line_view, this, true);

        line = findViewById(R.id.line);
        dot = findViewById(R.id.dot);

        if (attrs != null) {
            getXMLValues(attrs);
            line.setBackgroundColor(colorLine);
            GradientDrawable bgShape = (GradientDrawable)dot.getBackground();
            bgShape.setColor(dotColor);
            bgShape.setStroke(dotBorderWidth, dotBorderColor);
            dot.getLayoutParams().width = dotSize;
            dot.getLayoutParams().height = dotSize;
        }
        else {
            defaultAttributes();
        }
    }

    private void defaultAttributes() {
        dotColor = Color.WHITE;
        colorLine = Color.BLACK;
        dotBorderColor = colorLine;
        dotBorderWidth = 2;
        dotSize = 15;
    }

    private void getXMLValues(AttributeSet attrs) {
        TypedArray a = getContext().getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.DotLine_View,
                0, 0);

        try {
            dotColor = a.getColor(R.styleable.DotLine_View_dotColor, Color.WHITE);
            colorLine = a.getColor(R.styleable.DotLine_View_lineColor, Color.BLACK);
            dotBorderColor = a.getColor(R.styleable.DotLine_View_dotBorderColor, Color.BLACK);
            dotBorderWidth = (int) a.getDimension(R.styleable.DotLine_View_dotBorderWidth, 2);
            dotSize = (int) a.getDimension(R.styleable.DotLine_View_dotSize,15);
        } finally {
            a.recycle();
        }
    }

    //Getters and setters
    public int getColorLine() {
        return colorLine;
    }

    public void setColorLine(int colorLine) {
        this.colorLine = colorLine;
    }

    public int getDotBorderWidth() {
        return dotBorderWidth;
    }

    public void setDotBorderWidth(int dotBorderWidth) {
        this.dotBorderWidth = dotBorderWidth;
    }

    public int getDotColor() {
        return dotColor;
    }

    public void setDotColor(int dotColor) {
        this.dotColor = dotColor;
    }

    public int getDotBorderColor() {
        return dotBorderColor;
    }

    public void setDotBorderColor(int dotBorderColor) {
        this.dotBorderColor = dotBorderColor;
    }

    public void setHeigth(int heigth) {
        ViewGroup.LayoutParams params = line.getLayoutParams();
        params.height = heigth;
        line.setLayoutParams(params);
    }

    public int getDotSize() {
        return dotSize;
    }

    public void setDotSize(int dotSize) {
        this.dotSize = dotSize;
    }
}
