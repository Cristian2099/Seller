package programacion.proyecto.cristian.seller;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RegistrarPedido extends AppCompatActivity{

    TextView nombreEmpresa;
    Spinner productosSpin;
    Button agregarProdLista;
    TextView listaProductos;
    TextView total;
    Button registrarPedido;

    String nombreEmpresaI;
    ArrayList <Integer> preciosProductos = new ArrayList<>();
    static ArrayList <String> nombresProductos = new ArrayList<>();
    ArrayAdapter adapter;
    String productosTotales = "";
    int acumulado = 0;

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
        listaProductos.setMovementMethod(new ScrollingMovementMethod());

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
        productosTotales += productoAgregado + " ";
        int precioProducto = preciosProductos.get(productosSpin.getSelectedItemPosition());
        listaProductos.setText(listaProductos.getText().toString()
                + "         "+productoAgregado + "                                              " + precioProducto + "\n");
        acumulado = precioProducto + acumulado;
        total.setText("");
        total.setText("Total: $" + acumulado);
    }

    public void registrarPedido(View view){
        try(AdminSQLiteOpenHelper conn = new AdminSQLiteOpenHelper(this, "bd_seller", null,1)){
            SQLiteDatabase db = conn.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(Utilidades.CAMPO_NOMBRE_NEGOCIO, nombreEmpresa.getText().toString());

            int contadorProductos = 0;

            values.put(Utilidades.CAMPO_TOTAL_PRODUCTOS, productosTotales);

            values.put(Utilidades.CAMPO_PRECIO_TOTAL,total.getText().toString());

            Long resultado = db.insert(Utilidades.TABLA_PEDIDOS,null,values);
            Toast.makeText(this,"Pedido registrado " + resultado,Toast.LENGTH_SHORT).show();

        }catch (SQLiteException e){
            Toast.makeText(this,"No se ingresó ningún valor " ,Toast.LENGTH_LONG).show();
        }
    }

}
