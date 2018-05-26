package programacion.proyecto.cristian.seller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Producto extends Fragment{

    private String nombre;
    private String descripcion;
    private int precio;
    private int foto;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.producto,container, false);
        return view;
    }

    public Producto(){
    }

}
