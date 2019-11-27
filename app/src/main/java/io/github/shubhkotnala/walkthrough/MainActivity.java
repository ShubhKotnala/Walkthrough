package io.github.shubhkotnala.walkthrough;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import io.github.shubhkotnala.walkthrough.model.WalkthroughItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnStartWalkthrough).setOnClickListener((v) -> {
            startActivity(new Intent(MainActivity.this, WalkthroughDemo.class));
        });

    }
}
