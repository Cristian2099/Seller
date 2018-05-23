package programacion.proyecto.cristian.seller;

import android.content.ContentValues;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    public AdminSQLiteOpenHelper(Context context, String nombre, SQLiteDatabase.CursorFactory factory, int version){
        super(context, nombre,factory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db){

        db.execSQL(Nombres.CREAR_TABLA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int version, int version2){
        db.execSQL(Nombres.BORRAR_TABLA);
        db.execSQL(Nombres.CREAR_TABLA);
    }

}
