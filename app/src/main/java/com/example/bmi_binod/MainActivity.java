package com.example.bmi_binod;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    private EditText Et_Height, Et_Weight;
    private TextView Tv_Output;
    private Button btnCompute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Et_Height = findViewById(R.id.Et_Height);
        Et_Weight = findViewById(R.id.Et_Weight);
        btnCompute = findViewById(R.id.btnCompute);
        Tv_Output = findViewById(R.id.Tv_Output);

        btnCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double height = Double.parseDouble(Et_Height.getText().toString());
                double weight = Double.parseDouble(Et_Weight.getText().toString());
                BMIWork bmi = new BMIWork();
                bmi.setHeight(height);
                bmi.setWeight(weight);
                double res = bmi.BMI();

                Tv_Output.setText(Double.toString(res) + "  kg/m^2");

                if(res<18.5){
                    Toast.makeText(MainActivity.this,"Underweight",Toast.LENGTH_LONG).show();
                }else if(res>=18.5 && res<=24.9){
                    Toast.makeText(MainActivity.this,"Normalweight",Toast.LENGTH_LONG).show();
                }else if(res>=25 && res<=29.9){
                    Toast.makeText(MainActivity.this,"Overweight",Toast.LENGTH_LONG).show();
                }else if(res>=30){
                    Toast.makeText(MainActivity.this,"Obesity",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
