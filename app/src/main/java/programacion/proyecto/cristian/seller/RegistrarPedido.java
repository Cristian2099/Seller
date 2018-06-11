package programacion.proyecto.cristian.seller;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import entidades.PojoCliente;

public class RegistrarPedido extends AppCompatActivity{

    TextView nombreEmpresa;
    Spinner productosSpin;
    Button agregarProdLista;
    TextView listaProductos;
    TextView total;
    Button registrarPedido;

    String nombreEmpresaI;
    ArrayList <Integer> preciosProductos = new ArrayList<>();
    ArrayList <String> nombresProductos = new ArrayList<>();
    ArrayAdapter adapter;
    public RegistrarPedido(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrarpedido);
        nombreEmpresa = (TextView) findViewById(R.id.txtNombreEmpresaPedido);
        productosSpin = (Spinner) findViewById(R.id.spinProductos);
        agregarProdLista = (Button) findViewById(R.id.btnAgregarProdLista);
        listaProductos = (TextView) findViewById(R.id.txtListaProductos);
        listaProductos.setText("        NOMBRE                                          PRECIO"+ "\n");

        total = (TextView) findViewById(R.id.txtTotalValor);
        registrarPedido = (Button) findViewById(R.id.btnRegistrarPedido);

        nombreEmpresaI = getIntent().getStringExtra("nombreEmpresa");
        nombreEmpresa.setText(nombreEmpresaI);

        AdminSQLiteOpenHelper conn = new AdminSQLiteOpenHelper(this, "bd_seller",null,1);
        SQLiteDatabase db = conn.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from "+ Utilidades.TABLA_PRODUCTOS,null);
        while(cursor.moveToNext()){
            nombresProductos.add(cursor.getString(0));
            preciosProductos.add(Integer.parseInt(cursor.getString(3)));
        }

        adapter = new ArrayAdapter(this,R.layout.spinner_item_tab1,nombresProductos);

        productosSpin.setAdapter(adapter);
    }

    public void agregarProducto(View view){
        String productoAgregado = productosSpin.getSelectedItem().toString();
        int precioProducto = preciosProductos.get(productosSpin.getSelectedItemPosition());
        listaProductos.setText(listaProductos.getText().toString()
                + "         "+productoAgregado + "                                              " + precioProducto + "\n");
    }

}
