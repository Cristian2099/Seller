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

        db.execSQL(Utilidades.CREAR_TABLA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int version, int version2){
        db.execSQL(Utilidades.BORRAR_TABLA);
        db.execSQL(Utilidades.CREAR_TABLA);
    }

}
