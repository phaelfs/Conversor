package br.senac.es.conversor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int alturaEmCentimentros = 0;
 /*
* Protected - Somente classe atual e herdeiros podem usar
* Void - Retorna Vazio
* OnCreate - Nome do método
* Override - Sobrescrito*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Metodo que liga a MaisActivity.JAVA no activity_mais.xml (TELA)
        setContentView(R.layout.activity_main);
        /*
        Classe - Declara os componentes
        Instancia - Objeto Criado
         */

        //INSTACIA DE UM ELEMENTO TEXTO DO ANDROID
        final TextView txtMetros = (TextView) findViewById(R.id.txtMetros);
        //EXEMPLO CONVENCIONAL DE INSTANCIAR OBJETO NO JAVA
        //final TextView txtMetros = new TextView();

        final TextView txtPes = ()
    }
}
