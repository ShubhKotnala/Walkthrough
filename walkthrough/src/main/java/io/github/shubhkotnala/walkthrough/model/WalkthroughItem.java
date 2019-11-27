package io.github.shubhkotnala.walkthrough.model;

public class WalkthroughItem {
    private String imageURL;
    private String accentColor;
    private String title;
    private String description;
    private Integer drawableResource;

    public WalkthroughItem(String imageURL, String accentColor, String title, String description) {
        this.imageURL = imageURL;
        this.accentColor = accentColor;
        this.title = title;
        this.description = description;
    }

    public WalkthroughItem(Integer drawableResource, String accentColor, String title, String description) {
        this.drawableResource = drawableResource;
        this.accentColor = accentColor;
        this.title = title;
        this.description = description;
    }

    public Integer getDrawableResource() {
        return drawableResource;
    }

    public void setDrawableResource(Integer drawableResource) {
        this.drawableResource = drawableResource;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getAccentColor() {
        return accentColor;
    }

    public void setAccentColor(String accentColor) {
        this.accentColor = accentColor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
