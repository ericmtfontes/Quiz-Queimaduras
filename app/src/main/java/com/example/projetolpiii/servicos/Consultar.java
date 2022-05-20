package com.example.projetolpiii.servicos;

import android.os.AsyncTask;

import com.example.projetolpiii.entidades.Pergunta;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Consultar extends AsyncTask<Void, Void, ArrayList<Pergunta>> {

    private Integer id_pergunta;

    public Consultar(Integer id_pergunta) {
        this.id_pergunta = id_pergunta;
    }

    @Override
    protected ArrayList<Pergunta> doInBackground(Void... voids) {

        String dados = "";
        try {
            String url = "https://api-queimaduras.herokuapp.com/consultar-pergunta/" + this.id_pergunta;
            dados = getJson(url);
        }catch (Exception e) {
            e.printStackTrace();
        }
        Type tipoLista = new TypeToken<ArrayList<Pergunta>>() {}.getType();
        return new Gson().fromJson(dados, tipoLista);
    }

    public String getJson(String url) {
        HttpURLConnection conexao = null;
        try {
            URL u = new URL(url);
            conexao = (HttpURLConnection) u.openConnection();
            conexao.setRequestMethod("GET");
            conexao.connect();
            int status = conexao.getResponseCode();

            switch (status) {
                case 200:
                case 201:
                    BufferedReader br = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    String linha;
                    while ((linha = br.readLine()) != null) {
                        sb.append(linha+"\n");
                    }
                    br.close();
                    return sb.toString();
            }

        } catch (MalformedURLException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conexao != null) {
                try {
                    conexao.disconnect();
                } catch (Exception ex) {
                    Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }
}