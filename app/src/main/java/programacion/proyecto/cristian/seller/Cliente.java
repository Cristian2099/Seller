package programacion.proyecto.cristian.seller;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import entidades.PojoCliente;

public class Cliente extends Fragment{

    static ArrayList<String> listaInfo = new ArrayList<>();
    static ArrayList<PojoCliente> listaClientes = new ArrayList<>();
    static ArrayAdapter adapter;
    ListView listViewClientes;
    AdminSQLiteOpenHelper conn;


    public Cliente(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cliente,container,false);
        listaClientes.clear();
        listaInfo.clear();
        conn = new AdminSQLiteOpenHelper(getContext(),"bd_seller",null,1);
        listViewClientes = (ListView) view.findViewById(R.id.listViewClientes);
        consultarListaClientes();
        adapter = new ArrayAdapter(getContext(),R.layout.spinner_item_tab1,listaInfo);
        listViewClientes.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        listViewClientes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PojoCliente cliente = listaClientes.get(position);
                Intent intent = new Intent(getView().getContext(),DetallesCliente.class);
                intent.putExtra("nombreEmpresa", cliente.getNombreNegocio());
                intent.putExtra("nombre", cliente.getNombre());
                intent.putExtra("apellido", cliente.getApellido());
                intent.putExtra("identificacion", cliente.getCedula());
                intent.putExtra("telefono", cliente.getTelefono());
                intent.putExtra("direccion", cliente.getDireccion());
                startActivity(intent);
            }
        });


        return view;

    }

    public void consultarListaClientes(){

        SQLiteDatabase db = conn.getReadableDatabase();
        PojoCliente pojoCliente = null;

        Cursor cursor = db.rawQuery("select * from "+ Utilidades.TABLA_CLIENTES,null);
        while(cursor.moveToNext()){
            pojoCliente = new PojoCliente();
            pojoCliente.setNombreNegocio(cursor.getString(0));
            pojoCliente.setNombre(cursor.getString(1));
            pojoCliente.setApellido(cursor.getString(2));
            pojoCliente.setCedula(cursor.getString(3));
            pojoCliente.setTelefono(cursor.getString(4));
            pojoCliente.setDireccion(cursor.getString(5));

            listaClientes.add(pojoCliente);

        }
        obtenerLista();
    }

    private void obtenerLista() {

        for(int i=0; i<listaClientes.size();i++){
            listaInfo.add("Empresa: " + listaClientes.get(i).getNombreNegocio() + "    |    Cliente: "+listaClientes.get(i).getNombre());
        }
    }

}
