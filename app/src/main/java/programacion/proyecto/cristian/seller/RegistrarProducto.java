package programacion.proyecto.cristian.seller;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

import entidades.PojoProducto;

public class RegistrarProducto extends AppCompatActivity implements View.OnClickListener{

    Button btnRegistrarProducto;
    ImageButton imagen;
    String rutaImagen;
    EditText nombreProducto;
    EditText descripcion;
    EditText cantidad;
    EditText precio;

    private static final int SELECTED_FILE = 1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrarproducto);
        imagen = (ImageButton) findViewById(R.id.imgProducto);
        nombreProducto = (EditText) findViewById(R.id.edTxtNomProducto);
        descripcion = (EditText) findViewById(R.id.edTxtDescripcion);
        cantidad = (EditText) findViewById(R.id.edTxtCantidad);
        precio = (EditText) findViewById(R.id.edTxtPrecio);
        btnRegistrarProducto = (Button) findViewById(R.id.btnNuevoProd);
        btnRegistrarProducto.setOnClickListener(this);
        imagen = (ImageButton) findViewById(R.id.imgProducto);

    }


    public void cargarImagen(View view){
        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(intent.createChooser(intent,"Seleccione imagen"),10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnIntent);
        Uri selectedImageUri = null;
        Uri selectedImage = null;
        String filePath = null;

        if (resultCode == RESULT_OK){
            Uri path = imageReturnIntent.getData();
            imagen.setImageURI(path);
            imagen.setBackgroundResource(R.color.md_grey_200);
            rutaImagen = path.toString();
        }

    }

    public void onClick(View v){
        registrarProducto();
        Catalogo.listaDetallesProductos.clear();
        AdminSQLiteOpenHelper conn = new AdminSQLiteOpenHelper(getApplicationContext(), "bd_seller", null,1);
        SQLiteDatabase db = conn.getReadableDatabase();
        PojoProducto pojoProducto = null;

        Cursor cursor = db.rawQuery("select * from "+ Utilidades.TABLA_PRODUCTOS,null);
        while(cursor.moveToNext()){
            pojoProducto = new PojoProducto();
            pojoProducto.setNombre(cursor.getString(0));
            pojoProducto.setDescripcion(cursor.getString(1));
            pojoProducto.setCantidad(cursor.getString(2));
            pojoProducto.setPrecio(cursor.getString(3));
            pojoProducto.setRutaImagen(cursor.getString(4));
            Catalogo.listaDetallesProductos.add(pojoProducto);
        }

        Catalogo.listaInfoProductos.add("Nombre: " + Catalogo.listaDetallesProductos.get(Catalogo.listaDetallesProductos.size()-1).getNombre() +
                "  -  " + "Precio: " + Catalogo.listaDetallesProductos.get(Catalogo.listaDetallesProductos.size()-1).getPrecio());
        Catalogo.adapter.notifyDataSetChanged();
    }

    public void registrarProducto(){
        try(AdminSQLiteOpenHelper conn = new AdminSQLiteOpenHelper(getApplicationContext(), "bd_seller", null,1)){
            SQLiteDatabase db = conn.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(Utilidades.CAMPO_NOMBRE_PRODUCTO,nombreProducto.getText().toString());
            values.put(Utilidades.CAMPO_DESCRIPCION,descripcion.getText().toString());
            values.put(Utilidades.CAMPO_CANTIDAD_DISPONIBLE,cantidad.getText().toString());
            values.put(Utilidades.CAMPO_PRECIO,precio.getText().toString());
            values.put(Utilidades.CAMPO_RUTA_IMAGEN,rutaImagen);

            Long resultado = db.insert(Utilidades.TABLA_PRODUCTOS,null,values);
            Toast.makeText(getApplicationContext(),"Producto registrado " + resultado,Toast.LENGTH_SHORT).show();

            nombreProducto.setText("");
            descripcion.setText("");
            cantidad.setText("");
            precio.setText("");
            imagen.setImageResource(R.drawable.nophotobig);

        }catch (SQLiteException e){
            Toast.makeText(getApplicationContext(),"No se ingresó ningún valor " ,Toast.LENGTH_SHORT).show();
        }
    }
}
