package com.example.cadastro;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.cadastro.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity{
    private ActivityMainBinding amb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        amb = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(amb.getRoot());
        Formulario pessoaCadastrada = new Formulario();


        amb.nomeCompleto.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String nome = charSequence.toString();
                pessoaCadastrada.setNomeCompleto(nome);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        amb.telefone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String telefone = charSequence.toString();
                pessoaCadastrada.setTelefone(telefone);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        amb.email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String email = charSequence.toString();
                pessoaCadastrada.setEmail(email);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        amb.ingressar.setOnClickListener((view -> pessoaCadastrada.setIngressarListEmail(amb.ingressar.isChecked())));

        if(amb.sexoMasculino.isChecked())
            pessoaCadastrada.setSexo("masculino");
        amb.sexoMasculino.setOnClickListener((view -> pessoaCadastrada.setSexo("masculino")));
        amb.sexoFeminino.setOnClickListener((view -> pessoaCadastrada.setSexo("feminino")));

        amb.cidade.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String cidade = charSequence.toString();
                pessoaCadastrada.setCidade(cidade);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        amb.estados.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                pessoaCadastrada.setEstado(Estados.values()[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        amb.limparBt.setOnClickListener(view -> {
            amb.nomeCompleto.setText("");
            amb.telefone.setText("");
            amb.email.setText("");
            amb.cidade.setText("");
            amb.ingressar.toggle();
        });

        amb.salvarBt.setOnClickListener(view -> {
            String pessoa  = pessoaCadastrada.toString();
            Toast.makeText(this, pessoa, Toast.LENGTH_SHORT).show();
        });




    }
}

