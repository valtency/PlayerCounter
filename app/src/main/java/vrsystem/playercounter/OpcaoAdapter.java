package vrsystem.playercounter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;


public class OpcaoAdapter extends ArrayAdapter<Opcao> {


    Context contexto;

    public OpcaoAdapter(Context context, List<Opcao> opcoes) {

        super(context, 0, opcoes);
        contexto = context;

    }

    private class OpcoesHolder {
        TextView nomePartida, descricaoPartida;
        LinearLayout cartao;

        public OpcoesHolder(View view){
            nomePartida = view.findViewById(R.id.tvNomePartida);
            descricaoPartida = view.findViewById(R.id.tvDescricaoPartida);
            cartao = view.findViewById(R.id.cartao);
        }
    }


    @Override

    public View getView(int position, View convertView, ViewGroup parent) {

        View itemView = convertView;
        OpcoesHolder holder;

        if (itemView == null) {
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.item_lista_opcoes, parent, false);
        }

        if (itemView.getTag() == null) {
            holder = new OpcoesHolder(itemView);
            itemView.setTag(holder);
        }else{
            holder = (OpcoesHolder) itemView.getTag();
        }

        Opcao opcao = getItem(position);
        holder.nomePartida.setText(opcao.getNomePartida());
        holder.descricaoPartida.setText(opcao.getDescricaoPartida());
        if(position % 3 == 0)
            holder.cartao.setBackgroundColor(contexto.getResources().getColor(R.color.azul));
        if(position % 3 == 1)
            holder.cartao.setBackgroundColor(contexto.getResources().getColor(R.color.vermelho));
        if(position % 3 == 2)
            holder.cartao.setBackgroundColor(contexto.getResources().getColor(R.color.verde));

        return itemView;

    }

}