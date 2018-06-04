package programacion.proyecto.cristian.seller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import entidades.PojoCliente;

public class DetallesCliente extends AppCompatActivity{

    TextView nombreEmpresa;
    TextView nombre;
    TextView identificacion;
    TextView telefono;
    TextView direccion;

    String nombreEmpresaI;
    String nombreI;
    String apellidoI;
    String identificacionI;
    String telefonoI;
    String direccionI;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalles_cliente);

        nombreEmpresa = (TextView) findViewById(R.id.lblNombreEmpresa);
        nombre = (TextView) findViewById(R.id.lblNombre);
        identificacion = (TextView) findViewById(R.id.lblIdentificacion);
        telefono = (TextView) findViewById(R.id.lblTelefono);
        direccion = (TextView) findViewById(R.id.lblDireccion);

        nombreEmpresaI = getIntent().getStringExtra("nombreEmpresa");
        nombreI = getIntent().getStringExtra("nombre");
        apellidoI = getIntent().getStringExtra("apellido");
        identificacionI = getIntent().getStringExtra("identificacion");
        telefonoI = getIntent().getStringExtra("telefono");
        direccionI = getIntent().getStringExtra("direccion");

        nombreEmpresa.setText(nombreEmpresa.getText().toString() + nombreEmpresaI);
        nombre.setText(nombre.getText().toString() + nombreI + " " + apellidoI);
        identificacion.setText(identificacion.getText().toString() + identificacionI);
        telefono.setText(telefono.getText().toString() + telefonoI);
        direccion.setText(direccion.getText().toString() + direccionI);

    }

}
