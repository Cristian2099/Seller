package programacion.proyecto.cristian.seller;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TabHost;
import android.widget.TextView;

import org.w3c.dom.Text;


public class Contenido extends AppCompatActivity{

    TabHost tabHostJava;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contenido);


        tabHostJava = (TabHost) findViewById(R.id.THContenido);
        tabHostJava.setup();

        TabHost.TabSpec clientes =tabHostJava.newTabSpec("clientes");
        TabHost.TabSpec registros =tabHostJava.newTabSpec("registro");
        TabHost.TabSpec pedidos =tabHostJava.newTabSpec("pedidos");
        TabHost.TabSpec productos =tabHostJava.newTabSpec("productos");

        clientes.setContent(R.id.cliente);
        clientes.setIndicator("Cliente");

        registros.setContent(R.id.registro);
        registros.setIndicator("Registro");

        pedidos.setContent(R.id.pedido);
        pedidos.setIndicator("Pedido");

        productos.setContent(R.id.producto);
        productos.setIndicator("Producto");

        tabHostJava.addTab(clientes);
        tabHostJava.addTab(registros);
        tabHostJava.addTab(pedidos);
        tabHostJava.addTab(productos);

    }


}
