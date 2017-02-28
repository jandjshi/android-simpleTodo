package com.netflix.simpletodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {
    EditText etUpdateItem;

    String selectedText;
    int selectedPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        selectedText = getIntent().getStringExtra("selectedText");
        selectedPosition = getIntent().getIntExtra("selectedPosition", 0);

        if(!selectedText.isEmpty()) {
            etUpdateItem = (EditText) findViewById(R.id.etUpdateItem);
            etUpdateItem.setText(selectedText);
            etUpdateItem.setSelection(selectedText.length());
        }
    }

    public void onSubmit(View v) {
        // closes the activity and returns to first screen
        String newValue = etUpdateItem.getText().toString();

        if (!newValue.isEmpty()) {
            Intent data = new Intent();
            data.putExtra("newValue", newValue);
            data.putExtra("selectedPosition", selectedPosition);
            // Activity finished ok, return the data
            setResult(RESULT_OK, data); // set result code and bundle data for response
            finish(); // closes the activity, pass data to parent
        }

    }
}
