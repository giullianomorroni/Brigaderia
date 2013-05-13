package com.brigadeiro;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class BrigadeiroView extends Fragment {

	/**
	 * The fragment argument representing the section number for this
	 * fragment.
	 */
	public static final String ARG_SECTION_NUMBER = "section_number";

	public BrigadeiroView() {
		super();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_main_dummy, container, false);

		Object posicao = this.getArguments().get(BrigadeiroView.ARG_SECTION_NUMBER);
		
		TextView titulo = (TextView) rootView.findViewById(R.id.titulo);
		titulo.setText("Bem Vindo");
		
		TextView descricao = (TextView) rootView.findViewById(R.id.descricao);
		descricao.setText("Escolha um sabor");

		TextView valor = (TextView) rootView.findViewById(R.id.valor);
		descricao.setText("R$");
		
		ImageView fotoPrincipal = (ImageView) rootView.findViewById(R.id.imagem_principal);
		fotoPrincipal.setImageDrawable(getResources().getDrawable(R.drawable.empresa));

		if (posicao != null) {
			Sabor sabor = new Sabor((Integer) posicao);
			titulo.setText(sabor.titulo());
			descricao.setText(sabor.descricao());
			valor.setText(sabor.valor());
			fotoPrincipal.setImageDrawable(sabor.imagem(getResources()));	
		}

		return rootView;
	}

}
