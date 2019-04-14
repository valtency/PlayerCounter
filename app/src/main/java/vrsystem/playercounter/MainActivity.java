package vrsystem.playercounter;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Opcao> opcoes;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.menu_aboutUs:
                Intent intentAboutUs = new Intent(this, AboutUsActivity.class);
                startActivity(intentAboutUs);
                return true;

            case R.id.menu_repositorio:
                String url = "https://github.com/valtency/PlayerCounter";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        opcoes = new ArrayList<>();
        opcoes.add(new Opcao("Duel", "Partida para dois jogadores", "Standard", 2));
        opcoes.add(new Opcao("Battle Royale", "Partida para quatro jogadores", "Standard", 4));
        opcoes.add(new Opcao("Commander", "Partida para dois jogadores, modo Commander", "Commander", 2));
        opcoes.add(new Opcao("Commander Royale", "Partida para quatro jogadores, modo Commander", "Commander", 4));
        opcoes.add(new Opcao("Sobre", "Dados sobre o aplicativo", "sobre", 0));
        opcoes.add(new Opcao("Repositório", "Visite nosso repositório", "repositorio", 0));

        OpcaoAdapter adapter = new OpcaoAdapter(this, opcoes);

        ListView listView = findViewById(R.id.list_view);

        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                Opcao opcaoEscolhida = opcoes.get(position);
                String nome = opcaoEscolhida.getNomePartida();
                int qtdJogadores = opcaoEscolhida.getQtdJogadores();
                String modalidade = opcaoEscolhida.getModalidadePartida();
                if(qtdJogadores == 0){
                    if(modalidade == "sobre") {
                        intent = new Intent(MainActivity.this, AboutUsActivity.class);
                    }
                    if(modalidade == "repositorio") {
                        String url = "https://github.com/valtency/PlayerCounter";
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    }else{
                        //caso nenhuma opcao seja valida, inicializa a activity sobre
                        intent = new Intent(MainActivity.this, AboutUsActivity.class);
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Modo "+nome, Toast.LENGTH_SHORT).show();
                    intent = new Intent(MainActivity.this, PlayerCounterActivity.class);
                }


                //intent.putExtra("opcao", opcaoEscolhida);
                startActivity(intent);


            }
        });



    }
}
