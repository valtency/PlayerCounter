package vrsystem.playercounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class PlayerCounterActivity extends AppCompatActivity {

    TextView ptVida1;
    SeekBar ctVeneno1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_counter);
        ptVida1 = findViewById(R.id.tvPtVidaPlayer1);
        ctVeneno1 = findViewById(R.id.sbCtVenenoPlayer1);
        ctVeneno1.setMax(10);


        controlaBarra1();
    }

    private void controlaBarra1() {
        ptVida1.setText("Covered : " + ctVeneno1.getProgress() + " / " +ctVeneno1.getMax());

        ctVeneno1.setOnSeekBarChangeListener(
                    new SeekBar.OnSeekBarChangeListener() {

                        int progress_value;
                        @Override
                        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                            progress_value = progress;
                            ptVida1.setText("Covered : " + progress + " / " +ctVeneno1.getMax());
                            Toast.makeText(PlayerCounterActivity.this,"SeekBar in progress",Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onStartTrackingTouch(SeekBar seekBar) {
                            Toast.makeText(PlayerCounterActivity.this,"SeekBar in StartTracking",Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onStopTrackingTouch(SeekBar seekBar) {
                            ptVida1.setText("Covered : " + progress_value + " / " +ctVeneno1.getMax());
                            Toast.makeText(PlayerCounterActivity.this,"SeekBar in StopTracking",Toast.LENGTH_LONG).show();
                        }
                    }
            );

    }
}
