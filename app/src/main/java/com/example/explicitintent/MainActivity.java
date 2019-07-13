package com.example.explicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * A demo app of Explicit Intent.
 * - How to start a new Activity.
 * - How to share data between the Activities.
 **/

// Passing Data to another Activity
// Using Bundle directly

public class MainActivity extends AppCompatActivity {
    private Button submitBtn;
    private EditText nameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submitBtn = findViewById(R.id.submitBtn);
        nameEditText = findViewById(R.id.nameEditText);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToSecondActivity_FirstWay();
            }


        });

    }

    /**
     * Using Bundle directly to store the data to be shared to the Target Activity.
     */
    private void moveToSecondActivity_FirstWay() {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);

        Bundle b = new Bundle();
        b.putString(Constants.KEY_NAME, nameEditText.getText().toString());
        b.putInt(Constants.KEY_AGE, 23);

        intent.putExtras(b);

        startActivity(intent);
    }

}
