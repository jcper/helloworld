package app.informaticajcper.com.helloworld;

import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import static android.hardware.Sensor.TYPE_PROXIMITY;


public class MainActivity extends AppCompatActivity implements OnClickListener, SensorEventListener {
    ListView listView;
    TextView texto;
    EditText editText, enviar;
    Button boton, botonN, botonl, botonNuevo;
    ImageView imageView;
    LinearLayout ln;
    SensorManager sm;
    Sensor sensor;
    TextView tv;
    String[] valores= new String[]{"Holanda","España","USA","INDIA","MEXICO","CHINA","URUGUAY","BRASIL"};






    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto = (TextView) findViewById(R.id.texto);
        editText = (EditText) findViewById(R.id.edittext);
        enviar = (EditText) findViewById(R.id.enviar);
        boton = (Button) findViewById(R.id.boton);
        botonN = (Button) findViewById(R.id.botonN);
        botonNuevo = (Button) findViewById(R.id.botonNueva);
        imageView = (ImageView) findViewById(R.id.imagen);
        listView = (ListView) findViewById(R.id.lista);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, valores);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 Toast.makeText(getApplicationContext(),"Position"+position,Toast.LENGTH_SHORT).show();
            }

        });

        boton.setOnClickListener(this);
        botonN.setOnClickListener(this);
        botonl = (Button) findViewById(R.id.botonL);
        botonl.setOnClickListener(this);
        botonNuevo.setOnClickListener(this);
        ln = (LinearLayout) findViewById(R.id.linear);
        tv = (TextView) findViewById(R.id.texto1);
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sm.getDefaultSensor(TYPE_PROXIMITY);
        sm.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);

    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        String texto = String.valueOf(event.values[0]);
        tv.setText(texto);

        float valor = Float.parseFloat(texto);
        if (valor == 0) {
            ln.setBackgroundColor(Color.BLUE);
            System.out.println("azul");

        } else {
            ln.setBackgroundColor(Color.YELLOW);
            System.out.println("amarillo");
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.boton:
                String dato = editText.getText().toString();
                texto.setText(dato);
                break;

            case R.id.botonN:
                texto.setText("boton 2!!!!!!!");
                break;

            case R.id.botonL:
                Toast.makeText(getApplicationContext(), "Esto es un mensaje ToasT", Toast.LENGTH_SHORT).show();
                break;

            case R.id.botonNueva:
                String dato1 = enviar.getText().toString();
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("Dato1", dato1);
                startActivity(intent);
                break;


        }
    }




}
