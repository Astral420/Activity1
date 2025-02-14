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

    TextInputLayout lastNameTextInputLayout, givenNameTextInputLayout, barangayTextInputLayout;
    TextInputEditText lastName, givenName, barangay;
    Spinner spinCity;

    public String [] city = {
            "Malolos", "Meycauayan", "San Jose del Monte", "Baliuag", "Santa Maria", "Marilao", "San Miguel", "Plaridel", "Pulilan",
            "Hagonoy", "Bustos", "Calumpit", "Guiguinto", "San Ildefonso", "San Rafael", "Doña Remedios Trinidad", "Obando", "Paombong",
            "Norzagaray", "Angat"
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lastNameTextInputLayout = findViewById(R.id.lastName_TextInputLayout);
        givenNameTextInputLayout = findViewById(R.id.givenName_TextInputLayout);
        barangayTextInputLayout = findViewById(R.id.barangay_TextInputLayout);

        lastName = findViewById(R.id.last_Name);
        givenName = findViewById(R.id.given_Name);
        barangay = findViewById(R.id.barangay);

        setupAsteriskBehavior(lastNameTextInputLayout, lastName, "Last Name*");
        setupAsteriskBehavior(givenNameTextInputLayout, givenName, "Given Name*");
        setupAsteriskBehavior(barangayTextInputLayout,barangay,"Barangay*");
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
        if (activeField != barangayTextInputLayout){
            barangayTextInputLayout.setHint(Html.fromHtml("Barangay*"));
        }
    }
}

