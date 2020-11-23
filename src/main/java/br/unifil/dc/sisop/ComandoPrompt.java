package br.unifil.dc.sisop;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public class ComandoPrompt {
    
    public ComandoPrompt(String command) {
        //ESCREVA AQUI SEU CODIGO PARA ESTRUTURAR O COMANDO RECEBIDO DO PROMPT.
        nome = command;
        argumentos = (command.split(" "));
    }
    public String getNome() { 

        return nome;
    }
    public List<String> getArgumentos() {

        return Collections.unmodifiableList(Arrays.asList(argumentos));
    }
    
    private final String nome;
    private final String[] argumentos;
}
