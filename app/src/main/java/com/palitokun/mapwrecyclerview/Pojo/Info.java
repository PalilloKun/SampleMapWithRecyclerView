package com.palitokun.mapwrecyclerview.Pojo;

/**
 * This class content Data
 *
 * TypeLayout: type of layout to generate in recyclerview
 *
 */

public class Info {


    public String TypeLayout;
    public String Title;
    public String Content;

    public Info(String typeLayout, String title, String content) {
        TypeLayout = typeLayout;
        Title = title;
        Content = content;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getTypeLayout() {
        return TypeLayout;
    }

    public void setTypeLayout(String typeLayout) {
        TypeLayout = typeLayout;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }



}
