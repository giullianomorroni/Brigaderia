package com.brigadeiro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class Sabor {

	private Integer posicao;
	private static Properties sabores;

	public Sabor(Integer posicao, Context context) {
		try {
			if (sabores == null) {
				sabores = new Properties();
				AssetManager am = context.getAssets();
				InputStream is = am.open("sabores.txt");
				BufferedReader r = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				while(r.ready()){
					String line = r.readLine();
					if (line.split("=").length < 2)
						continue;
					String chave = line.split("=")[0];
					String valor = line.split("=")[1];
					System.out.println("valor" + valor);
					sabores.put(chave,  valor);
				}
				r.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.posicao = posicao;
	}
	
	public Sabor(Integer posicao) {
		this.posicao = posicao;
	}

	public String titulo(){
		return (String) sabores.get("titulo_"+posicao);
	}

	public String descricao(){
		return (String) sabores.get("descricao_"+posicao);
	}
	
	public String valor(){
		return (String) sabores.get("valor_"+posicao);
	}

	public Drawable imagem(Resources resources){
		switch (posicao) {
		case 0: return resources.getDrawable(R.drawable.brigadeiro_banana);
		case 1: return resources.getDrawable(R.drawable.brigadeiro_cafe);
		case 2: return resources.getDrawable(R.drawable.brigadeiro_coco);
		case 3: return resources.getDrawable(R.drawable.brigadeiro_limao);
		case 4: return resources.getDrawable(R.drawable.brigadeiro_morango);
		case 5: return resources.getDrawable(R.drawable.brigadeiro_pacoca);
		case 6: return resources.getDrawable(R.drawable.brigadeiro_tradicional);
		case 7: return resources.getDrawable(R.drawable.brigadeiro_tradicional_crispy);
		default:
			return null;
		}
	}
}
