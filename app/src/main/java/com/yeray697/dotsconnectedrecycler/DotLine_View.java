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

        this.line = findViewById(R.id.line);
        this.dot = findViewById(R.id.dot);

        if (attrs != null) {
            getXMLValues(attrs);
            this.line.setBackgroundColor(colorLine);
            GradientDrawable bgShape = (GradientDrawable)dot.getBackground();
            bgShape.setColor(dotColor);
            bgShape.setStroke(dotBorderWidth, dotBorderColor);
            this.dot.getLayoutParams().width = dotSize;
            this.dot.getLayoutParams().height = dotSize;
        }
        else {
            defaultAttributes();
        }
    }

    private void defaultAttributes() {
        this.dotColor = Color.WHITE;
        this.colorLine = Color.BLACK;
        this.dotBorderColor = colorLine;
        this.dotBorderWidth = 2;
        this.dotSize = 15;
    }

    private void getXMLValues(AttributeSet attrs) {
        TypedArray a = getContext().getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.DotLine_View,
                0, 0);

        try {
            this.dotColor = a.getColor(R.styleable.DotLine_View_dotColor, Color.WHITE);
            this.colorLine = a.getColor(R.styleable.DotLine_View_lineColor, Color.BLACK);
            this.dotBorderColor = a.getColor(R.styleable.DotLine_View_dotBorderColor, Color.BLACK);
            this.dotBorderWidth = (int) a.getDimension(R.styleable.DotLine_View_dotBorderWidth, 2);
            this.dotSize = (int) a.getDimension(R.styleable.DotLine_View_dotSize,15);
        } finally {
            a.recycle();
        }
    }

    //Getters and setters
    public int getColorLine() {
        return this.colorLine;
    }

    public void setColorLine(int colorLine) {
        this.colorLine = colorLine;
        this.line.setBackgroundColor(this.colorLine);
    }

    public int getDotBorderWidth() {
        return this.dotBorderWidth;
    }

    public void setDotBorderWidth(int dotBorderWidth) {
        this.dotBorderWidth = dotBorderWidth;
        GradientDrawable bgShape = (GradientDrawable)dot.getBackground();
        bgShape.setStroke(this.dotBorderWidth, this.dotBorderColor);
    }

    public int getDotColor() {
        return this.dotColor;
    }

    public void setDotColor(int dotColor) {
        this.dotColor = dotColor;
        GradientDrawable bgShape = (GradientDrawable)dot.getBackground();
        bgShape.setColor(this.dotColor);
    }

    public int getDotBorderColor() {
        return this.dotBorderColor;
    }

    public void setDotBorderColor(int dotBorderColor) {
        this.dotBorderColor = dotBorderColor;
        GradientDrawable bgShape = (GradientDrawable)dot.getBackground();
        bgShape.setStroke(this.dotBorderWidth, this.dotBorderColor);
    }

    public void setHeigth(int heigth) {
        ViewGroup.LayoutParams params = this.line.getLayoutParams();
        params.height = heigth;
        this.line.setLayoutParams(params);
    }

    public int getDotSize() {
        return this.dotSize;
    }

    public void setDotSize(int dotSize) {
        this.dotSize = dotSize;
        this.dot.getLayoutParams().width = dotSize;
        this.dot.getLayoutParams().height = dotSize;
    }
}
