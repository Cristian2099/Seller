package programacion.proyecto.cristian.seller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;
import entidades.PojoProducto;

public class Catalogo extends Fragment implements View.OnClickListener {

    Button layoutRegisrarP;
    ListView listViewProductos;
    static ArrayList<PojoProducto> listaDetallesProductos = new ArrayList<>();
    static ArrayList<String> listaInfoProductos = new ArrayList<String>();
    static ArrayAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.catalogo,container, false);
        layoutRegisrarP = (Button) view.findViewById(R.id.btnAñadir);
        layoutRegisrarP.setOnClickListener(this);
        listViewProductos = (ListView) view.findViewById(R.id.listViewProductos);
        adapter = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,listaInfoProductos);
        listViewProductos.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        return view;
    }


    public void onClick(View v){
        Intent intent = new Intent(getContext(),RegistrarProducto.class);
        startActivity(intent);

    }
    public Catalogo(){
    }

}
