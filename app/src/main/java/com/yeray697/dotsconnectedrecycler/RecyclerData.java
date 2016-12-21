package com.yeray697.dotsconnectedrecycler;

import android.graphics.drawable.Drawable;
import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Data used in DotLineRecyclerView
 * @author yeray697
 * @version 1.0
 * Created on 20/12/16.
 */
public class RecyclerData {

    private int imageResource;
    private Drawable image;
    private String imageUrl;

    private String title;
    private String subtitle;

    private final int EMPTY_RESOURCE = -1;
    private final String EMPTY_URL = "-1";

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({Priority.LOW, Priority.MEDIUM, Priority.HIGH})
    public @interface Priority {
        int LOW = 1;
        int MEDIUM = 2;
        int HIGH = 3;
    }

    //Constructors
    //TODO constructors with priority
    public RecyclerData(String imageUrl, String title, String subtitle) {

        this.imageUrl = imageUrl;
        this.title = title;
        this.subtitle = subtitle;
        this.imageResource = EMPTY_RESOURCE;
        this.image = null;
    }

    public RecyclerData(int imageResource, String title, String subtitle) {
        this.imageResource = imageResource;
        this.title = title;
        this.subtitle = subtitle;
        this.image = null;
        this.imageUrl = EMPTY_URL;
    }

    public RecyclerData(Drawable image, String title, String subtitle) {
        this.image = image;
        this.title = title;
        this.subtitle = subtitle;
        this.imageResource = EMPTY_RESOURCE;
        this.imageUrl = EMPTY_URL;
    }

    public RecyclerData(String title, String subtitle) {
        this.title = title;
        this.subtitle = subtitle;
        this.image = null;
        this.imageResource = EMPTY_RESOURCE;
        this.imageUrl = EMPTY_URL;
    }

    //Methods
    /**
     * Return if there is a drawable associated
     * @return Return if there is a drawable associated
     */
    public boolean isImageADrawable(){
        return image != null;
    }

    /**
     * Return if there is an URL associated
     * @return Return if there is an URL associated
     */
    public boolean isImageAnURL(){
        return !imageUrl.equals(EMPTY_URL);
    }

    /**
     * Return if there is a resource associated
     * @return Return if there is a resource associated
     */
    public boolean isImageAResource(){
        return imageResource != EMPTY_RESOURCE;
    }

    //Getters and setters
    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
        this.imageUrl = EMPTY_URL;
        this.image = null;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
        this.imageResource = EMPTY_RESOURCE;
        this.imageUrl = EMPTY_URL;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String image) {
        this.imageUrl = image;

        this.imageResource = EMPTY_RESOURCE;
        this.image = null;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
}
