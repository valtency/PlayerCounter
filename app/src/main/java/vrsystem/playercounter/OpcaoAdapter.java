package vrsystem.playercounter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


public class OpcaoAdapter extends ArrayAdapter<Opcao> {



    public OpcaoAdapter(Context context, List<Opcao> opcoes) {

        super(context, 0, opcoes);

    }

    private class OpcoesHolder {
        TextView nome,curso;

        public OpcoesHolder(View view){
            nome = view.findViewById(R.id.tv_nome);
            curso = view.findViewById(R.id.tv_curso);
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
        holder.nome.setText(opcao.getNomePartida());
        holder.curso.setText(opcao.getDescricaoPartida());

        return itemView;

    }

}