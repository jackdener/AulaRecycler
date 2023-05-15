package com.example.aularecycler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class TelaCadastro extends AppCompatActivity {
    static ArrayList listaProdutos;
    EditText nome, categoria, preco;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);
        getSupportActionBar().hide();
        nome = findViewById(R.id.novoNome);
        categoria = findViewById(R.id.novoCat);
        preco = findViewById(R.id.novoPreco);
    }
    public void cadastra(View v){
        if(validaCampos()){
            efetivaCadastro();
        }
        else{
            Toast.makeText(this, "Preencha todos os campos corretamente!", Toast.LENGTH_SHORT).show();
        }
    }
    public void efetivaCadastro(){
        String n = nome.getText().toString();
        String c = categoria.getText().toString();
        float p = Float.parseFloat(preco.getText().toString());
        Produto produto = new Produto(n, c, p);
        listaProdutos.add(produto);
        super.onBackPressed();
    }
    public boolean validaCampos(){
        if(nome.getText().toString().isEmpty()||categoria.getText().toString().isEmpty()||preco.getText().toString().isEmpty()){
            return false;
        }
        return true;
    }
}