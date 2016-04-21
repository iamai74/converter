package com.example.ai.converter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
    private TextView firstTextView;
    private TextView secontTextView;
    private EditText firstEdit;
    private EditText secondEdit;
    private ArrayAdapter adapterLength;
    private ArrayAdapter adapterWeight;
    private ArrayAdapter adapterVolume;
    private ArrayAdapter adapterMain;
    private ArrayAdapter lastAdaptor;
    private ArrayAdapter newAdaptor;

    Converter converter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        converter = new Converter();

        //адапторы
        adapterMain = ArrayAdapter.createFromResource(this,
                R.array.first, android.R.layout.simple_spinner_item);
        adapterMain.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
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

        firstSpinner.setAdapter(adapterMain);
        firstEdit.setText(String.valueOf(0));

        //поведение первого спиннера при изменении
        firstSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                firstTextView.setText(String.valueOf(firstSpinner.getSelectedItem()));
                firstColumnEdit();
                selectSecondSpinnerAdaptor(firstSpinner.getSelectedItemPosition());
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
                firstColumnEdit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        firstEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                firstColumnEdit();
                return false;
            }
        });
        firstEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if(!hasFocus) {
                    firstColumnEdit();
                }
            }
        });
        secondEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                secondColumnEdit();
                return false;
            }
        });
        secondEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                secondColumnEdit();
            }
        });
    }
    private void firstColumnEdit() {
        converter.setSelect1(firstSpinner.getSelectedItemPosition());
        converter.setSelect2(secondSpinner.getSelectedItemPosition());
        converter.setChangeParam("first");
        try {
            converter.setValue1(Float.parseFloat(firstEdit.getText().toString()));
        }catch (Exception e){
            Log.i("Exeption","emty valuue to float");
            converter.setValue1((float) 0);
            firstEdit.setText(String.valueOf(0));
        }
        secondEdit.setText(String.valueOf(converter.getValue2()));
    }
    private void secondColumnEdit() {
        converter.setSelect1(firstSpinner.getSelectedItemPosition());
        converter.setSelect2(secondSpinner.getSelectedItemPosition());
        converter.setChangeParam("second");
        try {
            converter.setValue2(Float.parseFloat(secondEdit.getText().toString()));
        } catch (Exception e) {
            Log.i("Exeption","emty valuue to float");
            converter.setValue2((float) 0);
            secondEdit.setText(String.valueOf(0));
        }
        firstEdit.setText(String.valueOf(converter.getValue1()));
    }

    private void selectSecondSpinnerAdaptor (int selected) {
        lastAdaptor = (ArrayAdapter) secondSpinner.getAdapter();
        switch (selected) {
            case 0:
            case 1:
            case 2:
                newAdaptor = adapterLength;
                break;
            case 3:
            case 4:
            case 5:
                newAdaptor = adapterWeight;
                break;
            case 6:
            case 7:
            case 8:
                newAdaptor = adapterVolume;
                break;
            default: break;
        }
        if (lastAdaptor!=newAdaptor){
            secondSpinner.setAdapter(newAdaptor);
        }
    }
}
