package com.example.patel.interactivestoryapp.Model;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.patel.interactivestoryapp.Presenter.Page;
import com.example.patel.interactivestoryapp.Presenter.Story;
import com.example.patel.interactivestoryapp.R;

import java.util.Stack;

public class StoryActivity extends AppCompatActivity {

    private String name;
    private ImageView storyImageView;
    private TextView storyTextView;
    private Button choice1Button;
    private Button choice2Button;
    private Story story;
    private Stack<Integer> pageStack = new Stack<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = getIntent();
        name = intent.getStringExtra(getString(R.string.key_name));
        if(name == null || name.isEmpty())
        {
            name = "Friend";
        }

        story = new Story();

        storyImageView = findViewById(R.id.storyImageView);
        storyTextView = findViewById(R.id.storyTextView);
        choice1Button = findViewById(R.id.choice1Button);
        choice2Button = findViewById(R.id.choice2Button);

        loadPage(0);

    }

    public void loadPage(int pageNumber)
    {
        pageStack.push(pageNumber);

        final Page page = story.getPage(pageNumber);
        Drawable drawable = getDrawable(page.getImageId());
        storyImageView.setImageDrawable(drawable);

        String pageText = getString(page.getTextId());
        pageText = String.format(pageText,name);
        storyTextView.setText(pageText);

        if(page.isFinalPage())
        {
            choice1Button.setVisibility(View.INVISIBLE);
            choice2Button.setText(R.string.play_again_button_text);
            choice2Button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loadPage(0);
                }
            });
        }
        else {
            loadButtons(page);
        }
    }

    private void loadButtons(final Page page) {

        choice1Button.setVisibility(View.VISIBLE);

        choice1Button.setText(getString(page.getChoice1().getTextId()));
        choice1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadPage(page.getChoice1().getNextPage());
            }
        });


        choice2Button.setText(getString(page.getChoice2().getTextId()));
        choice2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadPage(page.getChoice2().getNextPage());
            }
        });
    }

    @Override
    public void onBackPressed() {
        pageStack.pop();
        if (pageStack.isEmpty())
            super.onBackPressed();
        else
            loadPage(pageStack.pop());
    }


}
