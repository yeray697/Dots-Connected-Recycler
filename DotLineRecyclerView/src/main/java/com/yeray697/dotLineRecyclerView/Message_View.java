package com.yeray697.dotLineRecyclerView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * Message view component
 * @author yeray697
 * @version 1.0
 * Created on 21/12/16.
 */
public class Message_View extends RelativeLayout {
    private TextView tvTitle;
    private TextView tvSubTitle;

    private String textTitle;
    private String textSubTitle;
    private int textTitleColor;
    private int textSubTitleColor;
    private float textTitleSize;
    private float textSubTitleSize;

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
    /**
     * Inflate the view and set the attributes if they  are not null
     * @param attrs XML Attributes
     */
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

    /**
     * Setting default attributes
     */
    private void defaultAttributes() {
        setTextTitle("Title");
        setTextSubTitle("Subtitle");
        setTextTitleColor(Color.BLACK);
        setTextSubTitleColor(Color.BLACK);
        setTextTitleSize(17);
        setTextSubTitleSize(12);
    }

    /**
     * Get attributes from xml declaration
     * @param attrs XML Attribues
     */
    private void getXMLValues(AttributeSet attrs) {
        TypedArray a = getContext().getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.Message_View,
                0, 0);

        try {
            setTextTitle(a.getString(R.styleable.Message_View_textTitle));
            setTextSubTitle(a.getString(R.styleable.Message_View_textSubtitle));
            setTextTitleColor(a.getColor(R.styleable.Message_View_textTitleColor, Color.BLACK));
            setTextSubTitleColor(a.getColor(R.styleable.Message_View_textSubtitleColor, 2));
            setTextTitleSize(a.getDimension(R.styleable.Message_View_textTitleSize, 17));
            setTextSubTitleSize(a.getDimension(R.styleable.Message_View_textSubtitleSize, 12));
        } finally {
            a.recycle();
        }
    }

    //Getters and setters

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
    }

    public int getTextTitleColor() {
        return textTitleColor;
    }

    public void setTextTitleColor(int textTitleColor) {
        this.textTitleColor = textTitleColor;
        this.tvTitle.setTextColor(this.textTitleColor);
    }

    public float getTextTitleSize() {
        return textTitleSize;
    }

    public void setTextTitleSize(float textTitleSize) {
        this.textTitleSize = textTitleSize;
        this.tvTitle.setTextSize(this.textTitleSize);
    }

    public float getTextSubTitleSize() {
        return textSubTitleSize;
    }

    public void setTextSubTitleSize(float textSubTitleSize) {
        this.textSubTitleSize = textSubTitleSize;
        this.tvSubTitle.setTextSize(this.textSubTitleSize);
    }
}
