package programacion.proyecto.cristian.seller;

import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    public AdminSQLiteOpenHelper(Context context, String nombre, SQLiteDatabase.CursorFactory factory, int version){
        super(context, nombre,factory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table usuario(dni integer primary key, nombre text, ciudad text, numero integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int version, int version2){
        db.execSQL("drop table if exists usuario");
        db.execSQL("create table usuario(dni integer primary key, nombre text, ciudad text, numero integer)");
    }
}
