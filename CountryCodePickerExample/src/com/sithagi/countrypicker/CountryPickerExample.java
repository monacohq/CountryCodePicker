package com.sithagi.countrypicker;

import com.sithagi.countrycodepicker.CountryPicker;
import com.sithagi.countrycodepicker.CountryPickerListener;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;

public class CountryPickerExample extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_picker);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        CountryPicker picker = new CountryPicker(CountryPicker.Mode.Currency);
        picker.setListener(new CountryPickerListener() {
            @Override
            public void onSelectCountry(String name, String code, String dialCode, String currencySymbol, String Currency, String flagDrawableName) {
                Toast.makeText(
                        CountryPickerExample.this,
                        "Country Name: " + name + " - Code: " + code
                                + " - Currency: "
                                + CountryPicker.getCurrencyCode(code) + " - Dial Code: " + dialCode + " - FLag: " + flagDrawableName,
                        Toast.LENGTH_SHORT).show();
            }
        });

        transaction.replace(R.id.home, picker);
        transaction.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.country_picker, menu);
        MenuItem item = menu.findItem(R.id.show_dialog);
        item.setOnMenuItemClickListener(new OnMenuItemClickListener() {

            @Override
            public boolean onMenuItemClick(MenuItem item) {
                CountryPicker picker = CountryPicker.newInstance("SelectCountry");
                picker.setListener(new CountryPickerListener() {

                    @Override
                    public void onSelectCountry(String name, String code, String dialCode, String currencySymbol, String Currency, String flagDrawableName) {
                        Toast.makeText(
                                CountryPickerExample.this,
                                "Country Name: " + name + " - Code: " + code
                                        + " - Currency: "
                                        + CountryPicker.getCurrencyCode(code) + " - Dial Code: " + dialCode + " - FLag: " + flagDrawableName,
                                Toast.LENGTH_SHORT).show();
                    }
                });

                picker.show(getSupportFragmentManager(), "COUNTRY_CODE_PICKER");
                return false;
            }
        });
        return true;
    }
}
