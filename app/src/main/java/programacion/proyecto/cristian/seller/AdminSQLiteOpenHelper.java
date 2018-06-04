package programacion.proyecto.cristian.seller;

import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.io.Closeable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper implements Closeable{

    public AdminSQLiteOpenHelper(Context context, String nombre, SQLiteDatabase.CursorFactory factory, int version){
        super(context, nombre,factory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db){

        db.execSQL(Utilidades.CREAR_TABLA_CLIENTES);
        db.execSQL(Utilidades.CREAR_TABLA_PEDIDOS);
        db.execSQL(Utilidades.CREAR_TABLA_PRODUCTOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int version, int version2){
        //BORRA LAS TABLAS EXISTENTES
        db.execSQL(Utilidades.BORRAR_TABLA_CLIENTES);
        db.execSQL(Utilidades.BORRAR_TABLA_PEDIDOS);
        db.execSQL(Utilidades.BORRAR_TABLA_PRODUCTOS);

        //CREA LAS TABLAS CON LA NUEVA VERSIÓN DE LA BASE DE DATOS
        db.execSQL(Utilidades.CREAR_TABLA_CLIENTES);
        db.execSQL(Utilidades.CREAR_TABLA_PEDIDOS);
        db.execSQL(Utilidades.CREAR_TABLA_PRODUCTOS);
    }

}
