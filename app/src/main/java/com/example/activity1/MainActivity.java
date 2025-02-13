package com.example.activity1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    TextInputLayout lastNameTextInputLayout, givenNameTextInputLayout;
    TextInputEditText lastNameEditText, givenNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lastNameTextInputLayout = findViewById(R.id.lastName_TextInputLayout);
        givenNameTextInputLayout = findViewById(R.id.givenName_TextInputLayout);
        lastNameEditText = findViewById(R.id.last_Name);
        givenNameEditText = findViewById(R.id.given_Name);

        setupAsteriskBehavior(lastNameTextInputLayout, lastNameEditText, "Last Name*");
        setupAsteriskBehavior(givenNameTextInputLayout, givenNameEditText, "Given Name*");
    }

    private void setupAsteriskBehavior(TextInputLayout textInputLayout, TextInputEditText editText, String originalHint) {
        final String simpleHint = originalHint.replace("*", ""); // Remove asterisk for focus

        editText.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                textInputLayout.setHint(simpleHint);
                resetOtherFields(textInputLayout); // Reset other fields
            } else if (editText.getText().toString().trim().isEmpty()) {
                textInputLayout.setHint(Html.fromHtml(originalHint));
            }
        });
    }
    private void resetOtherFields(TextInputLayout activeField) {
        if (activeField != lastNameTextInputLayout) {
            lastNameTextInputLayout.setHint(Html.fromHtml("Last Name*"));
        }
        if (activeField != givenNameTextInputLayout) {
            givenNameTextInputLayout.setHint(Html.fromHtml("Given Name*"));
        }
    }
}

