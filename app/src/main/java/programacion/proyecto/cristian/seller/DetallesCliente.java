package programacion.proyecto.cristian.seller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import entidades.PojoCliente;

public class DetallesCliente extends AppCompatActivity{

    Button capaRegistrarPedido;
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

        capaRegistrarPedido = (Button) findViewById(R.id.btnCapaCrearPedido);
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

        final String nombreEmpresaPedido = nombreEmpresa.getText().toString();

        capaRegistrarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegistrarPedido.class);
                intent.putExtra("nombreEmpresa", nombreEmpresaPedido);
                startActivity(intent);
            }
        });
    }

}
