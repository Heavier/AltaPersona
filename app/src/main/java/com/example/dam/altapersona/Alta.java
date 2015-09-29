package com.example.dam.altapersona;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class Alta extends AppCompatActivity {

    private EditText etNombre, etApellidos, etNif, etFecha;
    private RadioButton rbHombre, rbMujer;
    private TextView tvNombre, tvApellidos, tvNif, tvFecha, tvGenero, tvError;
    private Button btRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta);
        iniciar();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_alta, menu);
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


    private void iniciar() {
        etNombre = (EditText)findViewById(R.id.etNombre);
        etApellidos = (EditText)findViewById(R.id.etApellidos);
        etNif = (EditText)findViewById(R.id.etNif);
        etFecha = (EditText)findViewById(R.id.etFecha);
        rbHombre = (RadioButton)findViewById(R.id.rbHombre);
        rbMujer = (RadioButton)findViewById(R.id.rbMujer);
        tvError = (TextView)findViewById(R.id.tvError);
        btRegistrar = (Button)findViewById(R.id.btRegistrar);

        tvNombre = (TextView)findViewById(R.id.tvNombre);
        tvApellidos = (TextView)findViewById(R.id.tvApellidos);
        tvNif = (TextView)findViewById(R.id.tvNif);
        tvFecha = (TextView)findViewById(R.id.tvFecha);
        tvGenero = (TextView)findViewById(R.id.tvGenero);

    }

    public void registro(View v) {
        if (etNombre.getText().toString().equals("") || etApellidos.getText().toString().equals("") || etNif.getText().toString().equals("") || etFecha.getText().toString().equals("") || !rbHombre.isChecked() && !rbMujer.isChecked()){
            tvError.setText(R.string.sierror);
        }else{
            Intent i = new Intent(this,Info.class);
            Bundle b = new Bundle();
            b.putString("nombre", etNombre.getText().toString());
            b.putString("apellidos", etApellidos.getText().toString());
            b.putString("nif", etNif.getText().toString());
            b.putString("fecha", etFecha.getText().toString());

            if (rbHombre.isChecked()) {
                b.putString("genero", "Hombre");
            }else{
                b.putString("genero", "Mujer");
            }
            i.putExtras(b);
            startActivity(i);
        }
    }
}
