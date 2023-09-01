package com.andresdiaz.explorarpaletaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextClock;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private TextClock textClock;
    private CheckBox cbTransparente, cbColor, cbTamano;
    private ImageView ivLogo;
    private Switch sOcultar;

//Referenciar
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vista_principal);

        radioGroup = findViewById(R.id.radio_group);

        textClock = findViewById(R.id.tc_hora);

        sOcultar = findViewById(R.id.s_ocultar);
        ivLogo = findViewById(R.id.iv_logo);
        cbTransparente = findViewById(R.id.cb_transparente);
        cbColor = findViewById(R.id.cb_color);
        cbTamano = findViewById(R.id.cb_tamano);



        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                RadioButton rb = findViewById(checkedId);

                if (rb.getId() == R.id.rb_beijing){
                    textClock.setTimeZone("Etc/GMT-8");
                } else if (rb.getId() == R.id.rb_london){
                    textClock.setTimeZone("Europe/London");
                } else if (rb.getId() == R.id.rb_bogota){
                    textClock.setTimeZone("America/Bogota");
                } else if (rb.getId() == R.id.rb_nueva_york){
                    textClock.setTimeZone("America/New_York");
                }
                textClock.setFormat24Hour("HH:mm");

            }
        });

        sOcultar.setChecked(true);
        sOcultar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    ivLogo.setVisibility(View.VISIBLE);
                } else{
                    ivLogo.setVisibility(View.INVISIBLE);
                }

            }
        });

        cbTransparente.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (cbTransparente.isChecked()){
                    ivLogo.setAlpha(0.1f);
                } else{
                    ivLogo.setAlpha(1f);
                }

            }
        });

        cbColor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (cbColor.isChecked()){
                    ivLogo.setColorFilter(Color.argb(255, 200, 0, 0));
                }
                else {
                    ivLogo.setColorFilter(Color.argb(0,0,0,0));
                }
            }
        });

        cbTamano.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(cbTamano.isChecked()){
                    ivLogo.setScaleX(2);
                    ivLogo.setScaleY(2);
                }
                else {
                    ivLogo.setScaleX(1);
                    ivLogo.setScaleY(1);
                }
            }
        });
    }
}