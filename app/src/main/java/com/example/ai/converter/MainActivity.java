package com.example.ai.converter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    private Spinner firstSpinner;
    private Spinner secondSpinner;
    private int selected1;
    private int selected2;
    private TextView firstTextView;
    private TextView secontTextView;
    private EditText firstEdit;
    private EditText secondEdit;
    private ArrayAdapter adapterLength;
    private ArrayAdapter adapterWeight;
    private ArrayAdapter adapterVolume;

    Converter converter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //адапторы
        adapterLength = ArrayAdapter.createFromResource(this,
                R.array.length, android.R.layout.simple_spinner_item);
        adapterLength.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapterWeight = ArrayAdapter.createFromResource(this,
                R.array.weight, android.R.layout.simple_spinner_item);
        adapterWeight.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapterVolume = ArrayAdapter.createFromResource(this,
                R.array.volume, android.R.layout.simple_spinner_item);
        adapterVolume.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //элементы активити
        firstSpinner = (Spinner) findViewById(R.id.spinner);
        secondSpinner = (Spinner) findViewById(R.id.spinner2);
        firstTextView = (TextView) findViewById(R.id.textView);
        secontTextView = (TextView) findViewById(R.id.textView2);
        firstEdit = (EditText) findViewById(R.id.editText);
        secondEdit = (EditText) findViewById(R.id.editText2);

        //поведение первого спиннера при изменении
        firstSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                firstTextView.setText(String.valueOf(firstSpinner.getSelectedItem()));
                selectSecondSpinnerAdaptor(firstSpinner.getSelectedItemPosition());
                converter.setSelect1(firstSpinner.getSelectedItemPosition());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //поведение сторого спиннера при изменении
        secondSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                secontTextView.setText(String.valueOf(secondSpinner.getSelectedItem()));
                converter.setSelect2(secondSpinner.getSelectedItemPosition());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        firstEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return false;
            }
        });
        secondEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return false;
            }
        });
    }


    private void selectSecondSpinnerAdaptor (int selected) {
        switch (selected) {
            case 0:
            case 1:
            case 2:
                secondSpinner.setAdapter(adapterLength);
                break;
            case 3:
            case 4:
            case 5:
                secondSpinner.setAdapter(adapterWeight);
                break;
            case 6:
            case 7:
            case 8:
                secondSpinner.setAdapter(adapterVolume);
                break;
            default: break;
        }
    }
}
