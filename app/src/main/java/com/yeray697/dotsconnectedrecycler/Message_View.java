package com.yeray697.dotsconnectedrecycler;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TableRow;
import android.widget.TextView;

/**
 * Created by usuario on 21/12/16.
 */

public class Message_View extends RelativeLayout {
    private TextView tvTitle;
    private TextView tvSubTitle;

    private String textTitle;
    private String textSubTitle;
    private int textTitleColor;
    private int textSubTitleColor;

    private final int pico = 20;

    //Constructors
    public Message_View(Context context, AttributeSet attrs, int defStyle){
        super(context, attrs, defStyle);
        initialize(attrs);
    }

    public Message_View(Context context) {
        super(context);
        initialize(null);
    }

    public Message_View(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(attrs);
    }

    //Privated methods
    private void initialize(AttributeSet attrs) {
        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li =
                (LayoutInflater)getContext().getSystemService(infService);
        li.inflate(R.layout.message_view, this, true);

        tvTitle = (TextView) findViewById(R.id.tvTitle_item);
        tvSubTitle = (TextView) findViewById(R.id.tvSubTitle_item);

        if (attrs != null) {
            getXMLValues(attrs);

        }
        else {
            defaultAttributes();
        }
    }

    private void defaultAttributes() {
        textTitle = "Title";
        textSubTitle = "Subtitle";
        textTitleColor = Color.BLACK;
        textSubTitleColor = Color.BLACK;
    }

    private void getXMLValues(AttributeSet attrs) {
        TypedArray a = getContext().getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.Message_View,
                0, 0);

        try {
            textTitle = a.getString(R.styleable.Message_View_textTitle);
            textSubTitle = a.getString(R.styleable.Message_View_textSubtitle);
            textTitleColor = a.getColor(R.styleable.Message_View_textTitleColor, Color.BLACK);
            textSubTitleColor = a.getColor(R.styleable.Message_View_textSubtitleColor, 2);
        } finally {
            a.recycle();
        }
    }

    public String getTextSubTitle() {
        return textSubTitle;
    }

    public void setTextSubTitle(String textSubTitle) {
        if (TextUtils.isEmpty(textSubTitle))
            tvSubTitle.setVisibility(View.GONE);
        else
            tvSubTitle.setVisibility(View.VISIBLE);
        this.textSubTitle = textSubTitle;
        this.tvSubTitle.setText(this.textSubTitle);
        updateMarginTop();
    }

    public int getTextSubTitleColor() {
        return textSubTitleColor;
    }

    public void setTextSubTitleColor(int textSubTitleColor) {
        this.textSubTitleColor = textSubTitleColor;
        this.tvSubTitle.setTextColor(this.textSubTitleColor);
    }

    public String getTextTitle() {
        return textTitle;
    }

    public void setTextTitle(String textTitle) {
        this.textTitle = textTitle;
        this.tvTitle.setText(this.textTitle);
        updateMarginTop();
    }

    public int getTextTitleColor() {
        return textTitleColor;
    }

    public void setTextTitleColor(int textTitleColor) {
        this.textTitleColor = textTitleColor;
        this.tvTitle.setTextColor(this.textTitleColor);
    }

    private void updateMarginTop() {
        /*int top = (this.getLayoutParams().height + pico) / 2;
        LayoutParams params  = (LayoutParams) tvTitle.getLayoutParams();
        params.setMargins(0,top,0,0);
        */
    }
}
