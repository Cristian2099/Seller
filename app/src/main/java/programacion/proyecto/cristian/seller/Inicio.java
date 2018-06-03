package programacion.proyecto.cristian.seller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Inicio extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);
        Button btn = (Button) findViewById(R.id.btn_iniciarSession);
        btn.setOnClickListener(this);

    }

    public void onClick(View view){
        Intent intent = new Intent(view.getContext(),Contenido.class);
        startActivity(intent);
    }
}
