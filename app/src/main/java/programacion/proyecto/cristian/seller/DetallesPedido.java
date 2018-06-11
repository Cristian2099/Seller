package programacion.proyecto.cristian.seller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.StringTokenizer;

public class DetallesPedido extends AppCompatActivity{

    TextView nombreEmpresa;
    TextView productosTotales;
    TextView totalPrecio;

    String nombreEmpresaI;
    String productosTotalesI;
    String totalPrecioI;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalles_pedido);
        nombreEmpresa = (TextView) findViewById(R.id.lblNombreEmpresaDetallesPedido);
        productosTotales = (TextView) findViewById(R.id.lblProductosDetallesPedido);
        totalPrecio = (TextView) findViewById(R.id.lblTotalDetallesPedido);

        nombreEmpresaI = getIntent().getStringExtra("nombreNegocio");
        productosTotalesI = getIntent().getStringExtra("totalProductos");
        totalPrecioI = getIntent().getStringExtra("precioTotal");

        StringTokenizer cantidadTokens = new StringTokenizer(productosTotalesI);

        int contadorProductos = 0;
        String productosAgrupados = "";

        while (cantidadTokens.hasMoreTokens()){

            String tokenActual = cantidadTokens.nextToken();

            if (productosAgrupados.contains(tokenActual)){

                productosAgrupados = productosAgrupados.replace(tokenActual + "x" + contadorProductos,tokenActual);
                contadorProductos++;
                productosAgrupados = productosAgrupados.replace(tokenActual,tokenActual + "x"+contadorProductos);

            }else{
                productosAgrupados+=" " +tokenActual;
                contadorProductos = 1;
            }

        }


        nombreEmpresa.setText(nombreEmpresaI);
        productosTotales.setText(productosTotales.getText().toString() + productosAgrupados);
        totalPrecio.setText(totalPrecioI);
    }


}
