package com.example.sougataghosh.navigationdrawer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class FormActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    EditText fullName, regNumber, phoneNumber_1, phoneNumber_2, vehicleType, misc;
    TextView textShow;
    Button updateButton, backButton;
    String country, state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form);

        fullName = (EditText) findViewById(R.id.fullName);
        phoneNumber_1 = (EditText) findViewById(R.id.phoneNumber_1);
        phoneNumber_2 = (EditText) findViewById(R.id.phoneNumber_2);
        regNumber = (EditText) findViewById(R.id.regNumber);
        vehicleType = (EditText) findViewById(R.id.vehicleType);
        misc = (EditText) findViewById(R.id.misc);
        updateButton = (Button) findViewById(R.id.updateButton);
        backButton = (Button) findViewById(R.id.backButton);
        textShow = (TextView) findViewById(R.id.show);

        Spinner dropdown_1 = findViewById(R.id.countrySpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.countries, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown_1.setAdapter(adapter);

        dropdown_1.setOnItemSelectedListener(this);

        Spinner dropdown_2 = findViewById(R.id.statesSpinner);
        ArrayAdapter<CharSequence> adapter_2 = ArrayAdapter.createFromResource(this,
                R.array.india_states, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown_2.setAdapter(adapter_2);

        dropdown_2.setOnItemSelectedListener(this);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentx1 = new Intent(FormActivity.this, MainActivity.class);
                startActivity(intentx1);
            }
        });

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSend, detail;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(regNumber.getText().toString());
                stringBuilder.append("_");
                stringBuilder.append(phoneNumber_1.getText().toString());
                toSend = stringBuilder.toString();

                StringBuilder stringBuilder_2 = new StringBuilder();
                stringBuilder_2.append(fullName.getText().toString());
                stringBuilder_2.append("_");
                stringBuilder_2.append(regNumber.getText().toString());
                stringBuilder_2.append("_");
                stringBuilder_2.append(phoneNumber_1.getText().toString());
                stringBuilder_2.append("_");
                stringBuilder_2.append(phoneNumber_2.getText().toString());
                stringBuilder_2.append("_");
                stringBuilder_2.append(vehicleType.getText().toString());
                stringBuilder_2.append("_");
                stringBuilder_2.append(misc.getText().toString());
                stringBuilder_2.append("_");
                stringBuilder_2.append(country);
                stringBuilder_2.append("_");
                stringBuilder_2.append(state);
                detail = stringBuilder_2.toString();

                textShow.setText(detail);
            }
        });
    }

    @Override
    public void onClick(View v) {

    }

    public void Communicate(){
        // code to connect and send
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        switch (parent.getId()) {
            case R.id.countrySpinner:
                country = (String) parent.getItemAtPosition(position);
                break;
            case R.id.statesSpinner:
                state = (String) parent.getItemAtPosition(position);
                break;
            default:
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
