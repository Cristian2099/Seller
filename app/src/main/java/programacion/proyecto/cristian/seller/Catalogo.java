package programacion.proyecto.cristian.seller;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import entidades.PojoCliente;
import entidades.PojoProducto;

public class Catalogo extends Fragment implements View.OnClickListener {

    Button layoutRegisrarP;
    ListView listViewProductos;
    static ArrayList<PojoProducto> listaDetallesProductos = new ArrayList<>();
    static ArrayList<String> listaInfoProductos = new ArrayList<>();
    static ArrayAdapter adapter;

    public Catalogo(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.catalogo,container, false);
        listaDetallesProductos.clear();
        listaInfoProductos.clear();
        consultarListaProductos();
        layoutRegisrarP = (Button) view.findViewById(R.id.btnAñadir);
        layoutRegisrarP.setOnClickListener(this);
        listViewProductos = (ListView) view.findViewById(R.id.listViewProductos);
        adapter = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,listaInfoProductos);
        listViewProductos.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        listViewProductos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PojoProducto producto = listaDetallesProductos.get(position);
                Intent intent = new Intent(getView().getContext(),DetallesProducto.class);
                intent.putExtra("nombre", producto.getNombre());
                intent.putExtra("descripcion", producto.getDescripcion());
                intent.putExtra("cantidad", producto.getCantidad());
                intent.putExtra("precio", producto.getPrecio());
                intent.putExtra("ruta", producto.getRutaImagen());
                startActivity(intent);
            }
        });
        return view;
    }


    public void onClick(View v){
        Intent intent = new Intent(getContext(),RegistrarProducto.class);
        startActivity(intent);

    }

    public void consultarListaProductos(){
        AdminSQLiteOpenHelper conn = new AdminSQLiteOpenHelper(getContext(),"bd_seller",null,1);
        SQLiteDatabase db = conn.getReadableDatabase();
        PojoProducto pojoProducto = null;

        Cursor cursor = db.rawQuery("select * from "+ Utilidades.TABLA_PRODUCTOS,null);
        while(cursor.moveToNext()){
            pojoProducto = new PojoProducto();
            pojoProducto.setNombre(cursor.getString(0));
            pojoProducto.setDescripcion(cursor.getString(1));
            pojoProducto.setCantidad(cursor.getString(2));
            pojoProducto.setPrecio(cursor.getString(3));
            pojoProducto.setRutaImagen(cursor.getString(4));

            listaDetallesProductos.add(pojoProducto);

        }
        obtenerLista();
    }

    private void obtenerLista() {

        for(int i=0; i<listaDetallesProductos.size();i++){
            listaInfoProductos.add(listaDetallesProductos.get(i).getNombre() + "    -    " + listaDetallesProductos.get(i).getPrecio());
        }
    }

}
