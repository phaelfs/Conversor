package br.senac.es.conversor;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

//METODO E FUNCAO = MESMA COISA
//DEFINICAO DA CLASSE        ---    HERDA ATRIBUTOS DE OUTRA CLASSE
public class MainActivity extends AppCompatActivity {

    //DECLARACAO DE VARIAVEL    --   0 SIGNIFICA QUE O VALOR INICIAL É ZERO
    int alturaEmCentimentros = 0;

    int altura1 = 0;
    int altura2 = 1;
    int altura3 = 2;


    //DECLARACAO DE VARIAVEL DO TIPO DOUBLE      -     O QUE ESTA ENTRE PARENTESES É ARGUMENTO / PARAMETRO
    private String formataValorComDoisDigitos(double valor) {

        //DECLARA A STRING E CONVERTE O VALOR INT EM TEXTO
        String retorno = String.format(Locale.FRANCE, "%.2f", valor);

        return retorno;
    }
    /*
     * Protected - Somente classe atual e herdeiros podem usar
     * Void - Retorna Vazio
     * OnCreate - Nome do método
     * Override - Sobrescrito*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //QUANDO POSSUI O SUPER ELE HERDA TODO O METODO
        super.onCreate(savedInstanceState);

        //Metodo que liga a MaisActivity.JAVA no activity_mais.xml (TELA)
        setContentView(R.layout.activity_main);

        /*
        Classe - Declara os componentes
        Instancia - Objeto Criado
         */

        final TextView txtMedia = (TextView) findViewById(R.id.txtMedia);
        txtMedia.setText("MEDIA");


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

            //SOBRESCREVE O METODO HERDADO
            @Override
            //DEFININDO A SEEKBAR PARA EXIBIR O VALOR NA TELA ENQUANTO SELECIONAMOS O TAMANHO
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                //DECLARANDO NOVO VALOR À VARIAVEL
                alturaEmCentimentros = progress;

                //FORMATA O VALOR "TEXTO" PARA EXIBIR DOIS DIGITOS
                String texto = formataValorComDoisDigitos(progress / 100.0);

                texto += " m. ";
//
                txtMetros.setText(texto);
            }

            @Override //DIFININDO TEXTO EXIBIDO ENQUANTO NÃO CLICAMOS EM CONVERTER
            public void onStartTrackingTouch(SeekBar seekBar) {//metodo
                txtPes.setText("Toque em Converter");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //INSTANCIA DO BOTÃO DE CONVERSÃO
        //
        final Button button = (Button) findViewById(R.id.button);

        //ADICIONANDO NOVO EVENTO
        button.setOnClickListener(new View.OnClickListener() {

            @Override //SETANDO FUNCÃO DO BOTÃO AO CLICAR
            public void onClick(View v) {

                //PEGA VARIAVEL "alturaEmPes'  E ATRIBUI 'alturaEmCentimentros' (Valor da SeekBar) Dividido por 30.48
                double alturaEmPes = alturaEmCentimentros / 30.48;

                //DEFINE VALOR À STRING TEXTO
                String texto = formataValorComDoisDigitos(alturaEmPes);

                //TEXTO CONCATENADO COM A STRING
                texto += " pé(s)";
                txtPes.setText(texto);
            }
        });

        int media = calcularMedia(altura1, altura2, altura3);

    }

    private int calcularMedia(int altura1, int altura2, int altura3) {
        int media = altura1 + altura2 + altura3 / 3;
        return media;
    }

}

