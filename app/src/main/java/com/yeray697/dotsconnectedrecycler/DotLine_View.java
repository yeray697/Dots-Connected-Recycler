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
    private View dot;

    private int dotBorderColor;
    private int dotColor;
    private int dotSize;
    private int dotBorderWidth;
    private int dotMarginTop;
    private int dotMarginRight;
    private int dotMarginLeft;
    private int dotMarginBottom;

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

        //this.line = findViewById(R.id.line);
        this.dot = findViewById(R.id.dot);

        if (attrs != null) {
            getXMLValues(attrs);
            //this.line.setBackgroundColor(lineColor);
            //this.line.getLayoutParams().height = this.lineHeight;
            GradientDrawable bgShape = (GradientDrawable)dot.getBackground();
            bgShape.setColor(dotColor);
            bgShape.setStroke(dotBorderWidth, dotBorderColor);
            this.dot.getLayoutParams().width = dotSize;
            this.dot.getLayoutParams().height = dotSize;
            ((LayoutParams)this.dot.getLayoutParams()).setMargins(dotMarginLeft,dotMarginTop, dotMarginRight,dotMarginBottom);
        }
        else {
            defaultAttributes();
        }
    }

    private void defaultAttributes() {
        this.dotColor = Color.WHITE;
        this.dotBorderColor = Color.BLACK;
        this.dotBorderWidth = 2;
        this.dotSize = 15;
        this.dotMarginTop = 8;
        this.dotMarginLeft= 0;
        this.dotMarginRight = 0;
        this.dotMarginBottom = 0;
    }

    private void getXMLValues(AttributeSet attrs) {
        TypedArray a = getContext().getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.DotLine_View,
                0, 0);

        try {
            this.dotColor = a.getColor(R.styleable.DotLine_View_dotColor, Color.WHITE);
            this.dotBorderColor = a.getColor(R.styleable.DotLine_View_dotBorderColor, Color.BLACK);
            this.dotBorderWidth = (int) a.getDimension(R.styleable.DotLine_View_dotBorderWidth, 2);
            this.dotSize = (int) a.getDimension(R.styleable.DotLine_View_dotSize,15);
            this.dotMarginTop = (int) a.getDimension(R.styleable.DotLine_View_dotMarginTop, 0);
            this.dotMarginLeft = (int) a.getDimension(R.styleable.DotLine_View_dotMarginLeft, 0);
            this.dotMarginRight = (int) a.getDimension(R.styleable.DotLine_View_dotMarginRight, 0);
            this.dotMarginBottom = (int) a.getDimension(R.styleable.DotLine_View_dotMarginBottom, 0);
        } finally {
            a.recycle();
        }
    }

    //Getters and setters
    public int getDotBorderWidth() {
        return this.dotBorderWidth;
    }

    public void setDotBorderSize(int dotBorderWidth) {
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

    public int getDotSize() {
        return this.dotSize;
    }

    public void setDotSize(int dotSize) {
        this.dotSize = dotSize;
        this.dot.getLayoutParams().width = dotSize;
        this.dot.getLayoutParams().height = dotSize;
    }

    public int getDotMarginTop() {
        return this.dotMarginTop;
    }

    public void setDotMarginTop(int dotMarginTop) {
        this.dotMarginTop = dotMarginTop;
        ((LayoutParams)this.dot.getLayoutParams()).setMargins(dotMarginLeft,dotMarginTop, dotMarginRight,dotMarginBottom);
    }

    public int getDotMarginBottom() {
        return dotMarginBottom;
    }

    public void setDotMarginBottom(int dotMarginBottom) {
        this.dotMarginBottom = dotMarginBottom;
        ((LayoutParams)this.dot.getLayoutParams()).setMargins(dotMarginLeft,dotMarginTop, dotMarginRight,dotMarginBottom);
    }

    public int getDotMarginLeft() {
        return dotMarginLeft;
    }

    public void setDotMarginLeft(int dotMarginLeft) {
        this.dotMarginLeft = dotMarginLeft;
        ((LayoutParams)this.dot.getLayoutParams()).setMargins(dotMarginLeft,dotMarginTop, dotMarginRight,dotMarginBottom);
    }

    public int getDotMarginRight() {
        return dotMarginRight;
    }

    public void setDotMarginRight(int dotMarginRight) {
        this.dotMarginRight = dotMarginRight;
        ((LayoutParams)this.dot.getLayoutParams()).setMargins(dotMarginLeft,dotMarginTop, dotMarginRight,dotMarginBottom);
    }

}
