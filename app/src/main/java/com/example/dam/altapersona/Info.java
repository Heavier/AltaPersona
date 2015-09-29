package com.example.dam.altapersona;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Intent i = getIntent();
        Bundle b = i.getExtras();

        String nombre = b.getString("nombre");
        String apellidos = b.getString("apellidos");
        String nif = b.getString("nif");
        String fecha = b.getString("fecha");
        String genero = b.getString("genero");

        TextView tvNombre = (TextView)findViewById(R.id.tvNombre);
        TextView tvApellidos = (TextView)findViewById(R.id.tvApellidos);
        TextView tvNif = (TextView)findViewById(R.id.tvNif);
        TextView tvFecha = (TextView)findViewById(R.id.tvFecha);
        TextView tvGenero = (TextView)findViewById(R.id.tvGenero);

        tvNombre.setText(nombre);
        tvApellidos.setText(apellidos);
        tvNif.setText(nif);
        tvFecha.setText(fecha);
        tvGenero.setText(genero);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_info, menu);
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
