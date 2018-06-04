package app.informaticajcper.com.helloworld;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;


public class SecondActivity extends AppCompatActivity {
     TextView texto;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        texto=(TextView)  findViewById(R.id.texto);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if(extras!=null){
            String dato=extras.getString("Dato1");
            texto.setText(dato);
        }
    }

}

