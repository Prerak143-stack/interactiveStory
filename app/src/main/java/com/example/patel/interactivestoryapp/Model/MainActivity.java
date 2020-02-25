package com.example.patel.interactivestoryapp.Model;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.patel.interactivestoryapp.R;

public class MainActivity extends AppCompatActivity {

    private EditText nameEditText;
    private Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.nameEditText);
        startButton = findViewById(R.id.startButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                startStory(name);
            }
        });
    }

    private void startStory(String name) {
        Intent intent= new Intent(this,StoryActivity.class);
//        Resources resources = getResources();
//        String key = resources.getString(R.string.key_name);
        intent.putExtra(getString(R.string.key_name),name);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        nameEditText.setText("");
    }
}
