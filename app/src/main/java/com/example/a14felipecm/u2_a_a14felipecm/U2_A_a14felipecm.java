package com.example.a14felipecm.u2_a_a14felipecm;

import android.app.Activity;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class U2_A_a14felipecm extends Activity {

    private EditText textoEntrada;
    private TextView textoSalida;
    private CheckBox checkClear;
    private Spinner spinnerProvincias;
    private ImageView imagenMostrada;
    private Chronometer temporizator;
    private Switch  switchButton;
    private int tempoAutodestrucion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u2__a_a14felipecm);

        textoEntrada = (EditText) findViewById(R.id.editText_principal);
        textoSalida = (TextView) findViewById(R.id.textView_final);
        checkClear = (CheckBox) findViewById(R.id.checkBox_clear);
        spinnerProvincias = (Spinner) findViewById(R.id.spin_provincias);
        imagenMostrada = (ImageView) findViewById(R.id.imageView_foto);
        temporizator = (Chronometer) findViewById(R.id.temporizador);
        switchButton = (Switch) findViewById(R.id.switch_tempo);

        //Deslizamiento
        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                tempoAutodestrucion = 15;
                if (isChecked) {
                    // The toggle is enabled
                    temporizator.setBase(SystemClock.elapsedRealtime());
                    temporizator.start();
                } else {
                    // The toggle is disabled
                    temporizator.stop();
                    temporizator.setBase(SystemClock.elapsedRealtime());
                }
            }
        });

        spinnerProvincias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
               if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase(getResources().getString(R.string.arrprov_leon))){
                   Toast.makeText(getApplicationContext(),getResources().getString(R.string.text_toast_no_gal),Toast.LENGTH_SHORT).show();
               }else{
                   Toast.makeText(getApplicationContext(),getResources().getString(R.string.text_toast_gal), Toast.LENGTH_SHORT).show();
               }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        //Control del tiempo y finish
        temporizator.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                long tempoPasado = SystemClock.elapsedRealtime()
                        - chronometer.getBase();
                int tempoSeg = (int) tempoPasado / 1000;
                if (tempoSeg == tempoAutodestrucion) {
                    finish();
                }
            }
        });
    }

    /*Método para añadir texto
    *
    * */
    public void engadirClick(View v){
        if(checkClear.isChecked()){
            textoSalida.setText("");
        }else{
            textoSalida.append(" "+textoEntrada.getText());
            textoEntrada.setText("");
        }
    }

    /*Método para cambiar el color del texto
    *
    * */
    public void cambiarCorTexto(View v){
        switch (v.getId()){
            case R.id.radioButton_rojo:
                textoSalida.setTextColor(getResources().getColor(R.color.rojo));
                break;
            case R.id.radioButton_azul:
                textoSalida.setTextColor(getResources().getColor(R.color.azul));
                break;
        }
    }

    /*Método para manejar el switch del temporizador
    *
    * */
    public void pulsarChrono(View v){
        tempoAutodestrucion = 15;
        if(switchButton.isChecked()){
            temporizator.setBase(SystemClock.elapsedRealtime());
            temporizator.start();
        }else{
            temporizator.stop();
            temporizator.setBase(SystemClock.elapsedRealtime());
        }
    }

    public void mostrarTagImagen(View v){
        Toast.makeText(getApplicationContext(),imagenMostrada.getTag().toString(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_u2__a_a14felipecm, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
