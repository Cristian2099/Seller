package programacion.proyecto.cristian.seller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity{

    EditText nombreNegocio;
    EditText nombre;
    EditText apellido;
    EditText documentoIdentidad;
    EditText telefono;
    EditText direccion;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);
        nombreNegocio = (EditText)findViewById(R.id.nombrenegocio);
        nombre = (EditText)findViewById(R.id.nombre);
        apellido = (EditText)findViewById(R.id.apellido);
        documentoIdentidad = (EditText)findViewById(R.id.identificacion);
        telefono = (EditText)findViewById(R.id.telefono);
        direccion = (EditText)findViewById(R.id.direccion);
    }

    public void toastear(View view){
        Toast.makeText(getApplicationContext(),"alsdjf",Toast.LENGTH_LONG).show();
    }

}
