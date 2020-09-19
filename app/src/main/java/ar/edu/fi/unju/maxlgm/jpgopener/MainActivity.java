package ar.edu.fi.unju.maxlgm.jpgopener;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity

{

    private final int SELECT_PICTURE = 100;
    private ImageView imageView;
    Button btnFoto;
    Button btnCerrar; //Se declaran los botones y la imageview del proyecto
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.setPicture);
        btnFoto = (Button) findViewById(R.id.btnFoto);
        btnCerrar=(Button) findViewById(R.id.btnCerrar);


        btnCerrar.getBackground().setAlpha(0);
        btnCerrar.setEnabled(false);
        //Al iniciar la aplicación, el botón cerrar y su opacidad se deshabilitan



        btnFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //Al hacer click en el boton Abrir este queda deshabilitado
                btnFoto.getBackground().setAlpha(0);
                btnFoto.setEnabled(false);

            //Se habilita el botón cerrar
                btnCerrar.getBackground().setAlpha(255);
                btnCerrar.setEnabled(true);

            //Se crea un objeto intent para buscar las imagenes en el dispositivo
                Intent intent = new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.setType("image/jpg image/jpeg");
            //Se asigna el tipo de archivos que tiene que buscar, en este caso imagenes jpg y jpeg
                startActivityForResult(intent.createChooser(intent,
                        "Seleccione gestor de imagen: "), SELECT_PICTURE);

            }
        });

        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Al hacer click en el botón cerrar, el imageview muestra una imagen transparente
                    imageView.setImageResource(android.R.color.transparent);
                    btnFoto.getBackground().setAlpha(255);
                    btnFoto.setEnabled(true);
                //El botón Abrir vuelve a ser visible y funcional
                Toast toast = Toast.makeText(getApplicationContext(), "Cerrando imagen...",
                        Toast.LENGTH_LONG);
                    toast.show();
                //Se muestra un mensaje indicando que se esta cerrando la imagen
                    btnCerrar.getBackground().setAlpha(0);
                    btnCerrar.setEnabled(false);
                //Se deshabilita el botón Cerrar y su opacidad
            }
        });

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    //Una vez seleccionada la imagen se carga la dirección de la misma
        switch (requestCode){
            case SELECT_PICTURE:
                if (resultCode == RESULT_OK){
                 Uri path = data.getData(); //Se asigna la dirección de la imagen a la variable

                        imageView.setImageURI(path);
                    //Se muestra la imagen de la dirección guardada
                        Toast toast=Toast.makeText(getApplicationContext(),
                                "Abriendo imagen...",Toast. LENGTH_LONG);
                        toast.show();
                    //Se muestra un mensaje indicando que la imagen se está abriendo
                }
        }
    }
}
