package programacion.proyecto.cristian.seller;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetallesProducto extends AppCompatActivity{

    Button capaRegistrarPedido;
    ImageView imagenProductoDetalle;
    TextView nombre;
    TextView descripcion;
    TextView cantidad;
    TextView precio;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalles_producto);

        imagenProductoDetalle = (ImageView) findViewById(R.id.imgProductoDetalle);
        nombre = (TextView) findViewById(R.id.lblNombreProducto);
        cantidad = (TextView) findViewById(R.id.lblCantidad);
        precio = (TextView) findViewById(R.id.lblPrecio);
        descripcion = (TextView) findViewById(R.id.lblDescripcion);

        String nombreI = getIntent().getStringExtra("nombre");
        String descripcionI = getIntent().getStringExtra("descripcion");
        String cantidadI = getIntent().getStringExtra("cantidad");
        String precioI = getIntent().getStringExtra("precio");
        String rutaI = getIntent().getStringExtra("ruta");
        Uri ruta = Uri.parse(rutaI);
        Toast.makeText(getApplicationContext(),"Ruta " + rutaI,Toast.LENGTH_LONG).show();
        //int imageResource = getResources().getIdentifier(rutaI,null,getPackageName());
        //Drawable imagen = ContextCompat.getDrawable(getApplicationContext(),imageResource);

        nombre.setText(nombre.getText().toString() + nombreI);
        cantidad.setText(cantidad.getText().toString() + cantidadI);
        precio.setText(precio.getText().toString() + precioI);
        descripcion.setText(descripcion.getText().toString() + descripcionI);

        imagenProductoDetalle.setBackgroundResource(R.drawable.gaseosa);
    }

}
