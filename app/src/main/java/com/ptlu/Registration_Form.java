package com.ptlu;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class Registration_Form extends AppCompatActivity {


    EditText etdob;
    int date,month,year;
    String dob = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration__form);


        etdob = (EditText)findViewById(R.id.et_dob);
        etdob.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean focus) {
                if (focus){
                    final Dialog dialog = new Dialog(Registration_Form.this);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setCancelable(false);
                    dialog.setContentView(R.layout.custom_date_picker);

                    final DatePicker datePicker = (DatePicker) dialog.findViewById(R.id.dp_dob);
                    Button btdobsubmit = (Button)dialog.findViewById(R.id.bt_dob_submit);
                    dialog.show();
                    btdobsubmit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            date = datePicker.getDayOfMonth();
                            month = datePicker.getMonth();
                            year = datePicker.getYear();
                            dob = date+"-"+month+"-"+year;
                            dialog.dismiss();
                            etdob.setText(dob);
                            etdob.setEnabled(false);
                        }
                    });


                }else {

                    if (etdob.getText().toString().equals(null)){
                        Toast.makeText(Registration_Form.this,"Please Enter Date Of Birth",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
