package programacion.proyecto.cristian.seller;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Inicio extends AppCompatActivity implements View.OnClickListener {

    EditText usuario;
    EditText contrasena;
    Button btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);
        btn = (Button) findViewById(R.id.btn_iniciarSession);
        btn.setOnClickListener(this);

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
                }else {
                    Toast.makeText(view.getContext(),"Datos incorrectos",Toast.LENGTH_SHORT).show();
                }
            }
        }catch(SQLiteException e){
            Toast.makeText(view.getContext(),"Ha ocurrido un error en la validación" + e,Toast.LENGTH_SHORT).show();
        }



    }
}
