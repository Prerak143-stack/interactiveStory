package com.example.patel.interactivestoryapp.Presenter;

public class Page {

    private int imageId;
    private int textId;
    private Choice choice1;
    private Choice choice2;
    private boolean isFinalPage = false;


    public Page(int imageId, int textId, Choice choice1, Choice choice2) {
        this.imageId = imageId;
        this.textId = textId;
        this.choice1 = choice1;
        this.choice2 = choice2;
    }

    public Page(int imageId, int textId) {
        this.imageId = imageId;
        this.textId = textId;
        isFinalPage = true;
    }

    public int getImageId() {
        return imageId;
    }

    public int getTextId() {
        return textId;
    }

    public Choice getChoice1() {
        return choice1;
    }

    public Choice getChoice2() {
        return choice2;
    }

    public boolean isFinalPage()
    {
        return isFinalPage;
    }
}
