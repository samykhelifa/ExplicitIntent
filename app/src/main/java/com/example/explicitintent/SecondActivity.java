package com.example.explicitintent;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private static final String TAG = SecondActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView textView = findViewById(R.id.textView);

        StringBuilder msg = new StringBuilder("Welcome \n");

        Intent intent = getIntent();        // Get the reference to the incoming Intent object.
        Bundle b = intent.getExtras();      // Extract the Bundle residing inside the Intent.

        if (b.containsKey(Constants.KEY_NAME)) { // Just to be Safe
            String name = b.getString(Constants.KEY_NAME, "my default name");
            msg.append(name);
            Log.i(TAG, "Name : " + name);
            textView.setText(msg);
        }
        if (b.containsKey(Constants.KEY_AGE)) { // Just to be Safe
            int age = b.getInt(Constants.KEY_AGE, 56);
            msg.append("\n").append(age).append(" years old");
            Log.i(TAG, "Age : " + age);

        }
        textView.setText(msg);


    }
}
