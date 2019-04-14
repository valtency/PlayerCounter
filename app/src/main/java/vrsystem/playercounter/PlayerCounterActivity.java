package vrsystem.playercounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class PlayerCounterActivity extends AppCompatActivity {

    TextView tvPtVida1, tvCtVeneno1, tvNomePlayer1, tvPtVida2, tvCtVeneno2, tvNomePlayer2;
    Button btnPontos1player1, btnPontos5player1, btnPontos_1player1, btnPontos_5player1,
            btnPontos1player2, btnPontos5player2, btnPontos_1player2, btnPontos_5player2;
    SeekBar sbCtVeneno1, sbCtVeneno2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_counter);

        tvPtVida1 = findViewById(R.id.tvPtVidaPlayer1);
        tvCtVeneno1 = findViewById(R.id.tvCtVeneno1);
        sbCtVeneno1 = findViewById(R.id.sbCtVenenoPlayer1);
        tvNomePlayer1 = findViewById(R.id.tvNomePlayer1);
        btnPontos1player1 = findViewById(R.id.btnPontos1player1);
        btnPontos5player1 = findViewById(R.id.btnPontos5player1);
        btnPontos_1player1 = findViewById(R.id.btnPontos_1player1);
        btnPontos_5player1 = findViewById(R.id.btnPontos_5player1);
        sbCtVeneno1.setMax(10);
        controlaBarra(tvCtVeneno1, sbCtVeneno1);

        tvPtVida2 = findViewById(R.id.tvPtVidaPlayer2);
        tvCtVeneno2 = findViewById(R.id.tvCtVeneno2);
        sbCtVeneno2 = findViewById(R.id.sbCtVenenoPlayer2);
        tvNomePlayer2 = findViewById(R.id.tvNomePlayer2);
        btnPontos1player2 = findViewById(R.id.btnPontos1player2);
        btnPontos5player2 = findViewById(R.id.btnPontos5player2);
        btnPontos_1player2 = findViewById(R.id.btnPontos_1player2);
        btnPontos_5player2 = findViewById(R.id.btnPontos_5player2);
        sbCtVeneno2.setMax(10);
        controlaBarra(tvCtVeneno2, sbCtVeneno2);


        controlaBotao(tvPtVida1, btnPontos1player1);
        controlaBotao(tvPtVida1, btnPontos5player1);
        controlaBotao(tvPtVida1, btnPontos_1player1);
        controlaBotao(tvPtVida1, btnPontos_5player1);

        controlaBotao(tvPtVida2, btnPontos1player2);
        controlaBotao(tvPtVida2, btnPontos5player2);
        controlaBotao(tvPtVida2, btnPontos_1player2);
        controlaBotao(tvPtVida2, btnPontos_5player2);



    }//onCreate

    private void controlaBotao(final TextView tvPtVida, final Button botaoClicado) {
        final int qtdPontos = Integer.parseInt(botaoClicado.getText().toString());
        botaoClicado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pontosAtuais = Integer.parseInt(tvPtVida.getText().toString());
                pontosAtuais += qtdPontos;
                String pontosAtuaisTexto = String.valueOf(pontosAtuais);
                tvPtVida.setText(pontosAtuaisTexto);
                //controlaPontos(tvPtVida, qtdPontos);
            }
        });

    }//controlaBotao
    private void controlaBarra(final TextView tvVeneno, final SeekBar sbVeneno) {
        //tvVeneno.setText("Covered : " + sbVeneno.getProgress() + " / " +sbVeneno.getMax());
        tvVeneno.setText("" + sbVeneno.getProgress() );

        sbVeneno.setOnSeekBarChangeListener(
                    new SeekBar.OnSeekBarChangeListener() {

                        int progress_value;
                        @Override
                        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                            progress_value = progress;
                            tvVeneno.setText("" + progress );
//                            Toast.makeText(PlayerCounterActivity.this,"Marcador de Veneno",Toast.LENGTH_LONG).show();
                            Toast.makeText(PlayerCounterActivity.this,"Marcador de Veneno",Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onStartTrackingTouch(SeekBar seekBar) {
                            Toast.makeText(PlayerCounterActivity.this,"Marcador de Veneno",Toast.LENGTH_LONG).show();
                            //Toast.makeText(PlayerCounterActivity.this,"SeekBar in StartTracking",Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onStopTrackingTouch(SeekBar seekBar) {
                            /*
                            tvVeneno.setText("Covered : " + progress_value + " / " +sbVeneno.getMax());
                            Toast.makeText(PlayerCounterActivity.this,"SeekBar in StopTracking",Toast.LENGTH_LONG).show();
                            */
                        }
                    }
            );

    }//controlarBarra



}
