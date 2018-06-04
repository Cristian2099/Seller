package programacion.proyecto.cristian.seller;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bumptech.glide.util.Util;

import java.util.ArrayList;

import entidades.PojoCliente;

public class Registro extends Fragment implements View.OnClickListener {

    EditText nombreNegocio;
    EditText nombre;
    EditText apellido;
    EditText identificacion;
    EditText telefono;
    EditText direccion;

    Button registrar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.registro,container,false);

        nombreNegocio = (EditText) view.findViewById(R.id.edTxtNomNegocio);
        nombre = (EditText) view.findViewById(R.id.edTxtNombre);
        apellido = (EditText) view.findViewById(R.id.edTxtApellido);
        identificacion = (EditText) view.findViewById(R.id.edTxtIdentificacion);
        telefono = (EditText) view.findViewById(R.id.edTxtTelefono);
        direccion = (EditText) view.findViewById(R.id.edTxtDireccion);

        registrar = (Button) view.findViewById(R.id.registrando);
        registrar.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        AdminSQLiteOpenHelper conn = new AdminSQLiteOpenHelper(getContext(), "bd_seller", null,1);
        registrar();

        SQLiteDatabase db = conn.getReadableDatabase();
        PojoCliente pojoCliente = null;

        Cursor cursor = db.rawQuery("select * from "+ Utilidades.TABLA_CLIENTES,null);
        pojoCliente = new PojoCliente();
        cursor.moveToLast();
        pojoCliente.setNombreNegocio(cursor.getString(0));
        pojoCliente.setNombre(cursor.getString(1));
        pojoCliente.setApellido(cursor.getString(2));
        pojoCliente.setCedula(cursor.getString(3));
        pojoCliente.setTelefono(cursor.getString(4));
        pojoCliente.setDireccion(cursor.getString(5));

        Cliente.listaClientes.add(pojoCliente);
        Cliente.listaInfo.add(Cliente.listaClientes.get(Cliente.listaClientes.size()-1).getNombreNegocio() + "   -   " +
                Cliente.listaClientes.get(Cliente.listaClientes.size()-1).getNombre());
        Cliente.adapter.notifyDataSetChanged();
    }

    public void registrar(){
        try(AdminSQLiteOpenHelper conn = new AdminSQLiteOpenHelper(getContext(), "bd_seller", null,1)){
            SQLiteDatabase db = conn.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(Utilidades.CAMPO_NOMBRE_NEGOCIO,nombreNegocio.getText().toString());
            values.put(Utilidades.CAMPO_NOMBRE_CLIENTE,nombre.getText().toString());
            values.put(Utilidades.CAMPO_APELLIDO,apellido.getText().toString());
            values.put(Utilidades.CAMPO_CEDULA,identificacion.getText().toString());
            values.put(Utilidades.CAMPO_TELEFONO,telefono.getText().toString());
            values.put(Utilidades.CAMPO_DIRECCION,direccion.getText().toString());

            Long resultado = db.insert(Utilidades.TABLA_CLIENTES,null,values);
            Toast.makeText(getContext(),"Registrado " + resultado,Toast.LENGTH_SHORT).show();

            nombreNegocio.setText("");
            nombre.setText("");
            apellido.setText("");
            identificacion.setText("");
            telefono.setText("");
            direccion.setText("");

        }catch (SQLiteException e){
            Toast.makeText(getContext(),"No se ingresó ningún valor " ,Toast.LENGTH_LONG).show();
        }
    }


}
