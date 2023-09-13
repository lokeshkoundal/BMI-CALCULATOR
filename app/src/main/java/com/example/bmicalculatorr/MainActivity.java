package com.example.bmicalculatorr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText Ft,Inch,Weight;
        Button Btn;
        TextView result;
        LinearLayout ll;

        Ft = findViewById(R.id.editHeightFt);
        Inch = findViewById(R.id.editHeightInch);
        Weight = findViewById(R.id.editWeight);
        Btn = findViewById(R.id.button);
        result = findViewById(R.id.result);
        ll = findViewById(R.id.llMain);

        Btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
               int wt =  Integer.parseInt(Weight.getText().toString());
               int ft = Integer.parseInt(Ft.getText().toString());
               int inch = Integer.parseInt(Inch.getText().toString());

              int totalInch = ft * 12 + inch ;
              double cm = totalInch * 2.53;
              double totalM = cm/100;

              double bmi = wt / (totalM * totalM);

              if(bmi > 25){
                  result.setText("You are Overweight!!");
                  ll.setBackgroundColor(getResources().getColor(R.color.Overweight));
              }
              else if(bmi < 18 ){
                  result.setText("You are underweight!!");
                  ll.setBackgroundColor(getResources().getColor(R.color.underweight));
              }
              else{
                  result.setText("You are Healthy!!");
                  ll.setBackgroundColor(getResources().getColor(R.color.healthy));
              }

            }
        });
    }
}