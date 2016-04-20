package com.example.ai.converter;

/**
 * Created by AI on 19.04.16.
 */
public class Converter {

    private int select1;
    private int select2;

    private float value1;
    private float value2;

    private float multiplier;

    private String changeParam;

    public void setSelect1(int select1) {
        this.select1 = select1;
    }

    public void setSelect2(int select2) {
        this.select2 = select2;
    }

    public float getValue1() {
        return value1;
    }

    public void setValue1(float value1) {
        this.value1 = value1;
        convertAll();
    }

    public float getValue2() {
        return value2;
    }

    public void setValue2(float value2) {
        this.value2 = value2;
        convertAll();
    }

    public void setChangeParam(String changeParam) {
        this.changeParam = changeParam;
    }

    private void convertAll() {
        switch (this.select1) {
            case 0:
                convertMeters();
                break;
            case 1:
                convertFoots();
                break;
            case 2:
                convertMiles();
                break;
            case 3:
                convertKg();
                break;
            case 4:
                convertLb();
                break;
            case 5:
                convertOz();
                break;
            case 6:
                convertLiters();
                break;
            case 7:
                convertGal();
                break;
            case 8:
                convertBarrel();
                break;
            default: break;
        }
        if (String.valueOf(this.changeParam) == "first") {
            this.value2 = this.value1*this.multiplier;
        } else if (String.valueOf(this.changeParam) == "second") {
            if (this.multiplier!=0){
                this.value1 = this.value2/this.multiplier;
            }
            else {
                this.value1 = 0;
            }
        } else {
            this.value1 = 0;
            this.value2 = 0;
        }
    }

    private void convertMeters() {

        switch (this.select2) {
            case 0:
                this.multiplier = 1;
                break;
            case 1:
                this.multiplier = (float) 3.280833333333;
                break;
            case 2:
                this.multiplier = (float) 0.000621369949495;
                break;
        }
    }
    private void convertMiles() {
        switch (this.select2) {
            case 0:
                this.multiplier = (float) 1609.347218694;
                break;
            case 1:
                this.multiplier = (float) 5280.01056002;
                break;
            case 2:
                this.multiplier = 1;
                break;
        }
    }
    private void convertFoots() {
        switch (this.select2) {
            case 0:
                this.multiplier = (float) 0.3048;
                break;
            case 1:
                this.multiplier = 1;
                break;
            case 2:
                this.multiplier = (float) 0.0001893935606061;
                break;
        }
    }

    private void convertKg() {
        switch (this.select2) {
            case 0:
                this.multiplier = 1;
                break;
            case 1:
                this.multiplier = (float) 2.204622621849;
                break;
            case 2:
                this.multiplier = (float) 35.27396194958;
                break;
        }
    }
    private void convertLb() {
        switch (this.select2) {
            case 0:
                this.multiplier = (float) 0.45359237;
                break;
            case 1:
                this.multiplier = 1;
                break;
            case 2:
                this.multiplier = (float) 16;
                break;
        }

    }
    private void convertOz() {
        switch (this.select2) {
            case 0:
                this.multiplier = (float) 0.028349523125;
                break;
            case 1:
                this.multiplier = (float) 0.0625;
                break;
            case 2:
                this.multiplier = 1;
                break;
        }
    }

    private void convertLiters() {
        switch (this.select2) {
            case 0:
                this.multiplier = 1;
                break;
            case 1:
                this.multiplier = (float) 0.2642;
                break;
            case 2:
                this.multiplier = (float) 0.00629;
                break;
        }
    }
    private void convertGal() {
        switch (this.select2) {
            case 0:
                this.multiplier = (float) 3.785;
                break;
            case 1:
                this.multiplier = 1;
                break;
            case 2:
                this.multiplier = (float) 0.02381;
                break;
        }
    }
    private void convertBarrel() {
        switch (this.select2) {
            case 0:
                this.multiplier = (float) 159;
                break;
            case 1:
                this.multiplier = (float) 42;
                break;
            case 2:
                this.multiplier = 1;
                break;
        }
    }
}
