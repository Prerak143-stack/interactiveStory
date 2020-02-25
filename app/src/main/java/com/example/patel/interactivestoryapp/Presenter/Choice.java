package com.example.patel.interactivestoryapp.Presenter;

public class Choice {

    private int textId;
    private int nextPage;

    public Choice(int textId, int nextPage) {
        this.textId = textId;
        this.nextPage = nextPage;
    }

    public int getTextId() {
        return textId;
    }

    public int getNextPage() {
        return nextPage;
    }

}
