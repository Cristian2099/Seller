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
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import entidades.PojoPedido;

public class Pedido extends Fragment{

    static ArrayList <PojoPedido> listaDetallesPedido = new ArrayList<>();
    static ArrayList <String> listaInfoPedido = new ArrayList<>();
    ArrayAdapter adapter;

    ListView listaPedidos;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pedido,container,false);
        listaDetallesPedido.clear();
        listaInfoPedido.clear();
        listaPedidos = (ListView) view.findViewById(R.id.listViewPedidos);
        consultarListaPedidos();
        adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, listaInfoPedido);
        listaPedidos.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        listaPedidos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PojoPedido pedido = listaDetallesPedido.get(position);
                Intent intent = new Intent(getView().getContext(),DetallesPedido.class);
                intent.putExtra("nombreNegocio", pedido.getNombreNegocio());
                intent.putExtra("totalProductos", pedido.getTotalProductos());
                intent.putExtra("precioTotal", pedido.getPrecioTotal());
                startActivity(intent);
            }
        });
        return view;
    }

    public void consultarListaPedidos(){
        AdminSQLiteOpenHelper conn = new AdminSQLiteOpenHelper(getContext(),"bd_seller",null,1);
        SQLiteDatabase db = conn.getReadableDatabase();
        PojoPedido pojoPedido = null;

        Cursor cursor = db.rawQuery("select * from "+ Utilidades.TABLA_PEDIDOS,null);
        while(cursor.moveToNext()){
            pojoPedido = new PojoPedido();
            pojoPedido.setNombreNegocio(cursor.getString(0));
            pojoPedido.setTotalProductos(cursor.getString(1));
            pojoPedido.setPrecioTotal(cursor.getString(2));
            listaDetallesPedido.add(pojoPedido);

        }
        obtenerLista();
    }

    private void obtenerLista() {

        for(int i=0; i<listaDetallesPedido.size();i++){
            listaInfoPedido.add(listaDetallesPedido.get(i).getNombreNegocio() + "    -    $"
                    + listaDetallesPedido.get(i).getPrecioTotal());
        }
    }

}
