package br.senac.es.conversor;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

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


        //INSTACIA DE UM ELEMENTO TEXTO DO ANDROID
        final TextView txtPes = (TextView) findViewById(R.id.txtPes);

        //INSTACIA DE UM ELEMENTO TEXTO DO ANDROID
        final SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);

        //DEFININDO TAMANHO MAXIMO DA SEEKBAR
        seekBar.setMax(230);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {


            @Override //DEFININDO A SEEKBAR PARA EXIBIR O VALOR NA TELA ENQUANTO SELECIONAMOS O TAMANHO
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                alturaEmCentimentros = progress;
                String texto = formataValorComDoisDigitos(progress / 100.0);
                texto += " m. ";
                txtMetros.setText(texto);
            }

            @Override //DIFININDO TEXTO EXIBIDO ENQUANTO NÃO CLICAMOS EM CONVERTER
            public void onStartTrackingTouch(SeekBar seekBar) {
                txtPes.setText("Toque em Converter");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //INSTANCIA DO BOTÃO DE CONVERSÃO
        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override //SETANDO FUNCÃO DO BOTÃO AO CLICAR
            public void onClick(View v) {
                double alturaEmPes = alturaEmCentimentros / 30.48;

                String texto = formataValorComDoisDigitos(alturaEmPes);
                texto += " pé(s)";
                txtPes.setText(texto);
            }
        });
    }

    private String formataValorComDoisDigitos(double valor) {
        return String.format(Locale.FRANCE, "%.2f", valor);

    }
}
