package programacion.proyecto.cristian.seller;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Inicio extends AppCompatActivity implements View.OnClickListener {

    EditText usuario;
    EditText contrasena;
    Button btnInicio;
    Button btnUsuarios;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);
        btnInicio = (Button) findViewById(R.id.btn_iniciarSession);
        btnInicio.setOnClickListener(this);
        btnUsuarios = (Button) findViewById(R.id.btn_crearUsuarios);
        usuario = (EditText) findViewById(R.id.txtUsuario);
        contrasena = (EditText) findViewById(R.id.txtContrasena);
    }

    public void onClick(View view){

        try(AdminSQLiteOpenHelper conn = new AdminSQLiteOpenHelper(view.getContext(),"bd_seller",null,1)){
            SQLiteDatabase db = conn.getReadableDatabase();
            Cursor cursor = db.rawQuery("select * from "+ Utilidades.TABLA_USUARIOS,null);
            while (cursor.moveToNext()){

                if (cursor.getString(0).equals(usuario.getText().toString()) && cursor.getString( 1).equals(contrasena.getText().toString())){
                    Intent intent = new Intent(view.getContext(),Contenido.class);
                    startActivity(intent);
                    Toast.makeText(view.getContext(),"Datos correctos",Toast.LENGTH_SHORT).show();
                    usuario.setText("");
                    contrasena.setText("");
                    break;

                }else if(cursor.getPosition() != 0){
                    Toast.makeText(view.getContext(),"Datos incorrectos",Toast.LENGTH_SHORT).show();
                }

            }
        }catch(SQLiteException e){
            Toast.makeText(view.getContext(),"Ha ocurrido un error en la validación" + e,Toast.LENGTH_SHORT).show();
        }
    }

    public void crearUsuarios(View view){
        AdminSQLiteOpenHelper conn = new AdminSQLiteOpenHelper(getApplicationContext(),"bd_seller",null,1);
        SQLiteDatabase db = conn.getWritableDatabase();
        ContentValues values;

        values =  new ContentValues();
        values.put(Utilidades.CAMPO_USUARIO,"lina");
        values.put(Utilidades.CAMPO_CONTRASENA,"9876");
        db.insert(Utilidades.TABLA_USUARIOS,null,values);

        values = new ContentValues();
        values.put(Utilidades.CAMPO_USUARIO,"cristian2099");
        values.put(Utilidades.CAMPO_CONTRASENA,"1234");
        db.insert(Utilidades.TABLA_USUARIOS,null,values);

        Toast.makeText(view.getContext(),"Se han creado los usuarios",Toast.LENGTH_SHORT).show();
        btnUsuarios.setVisibility(View.INVISIBLE);

    }
}
