package br.unifil.dc.sisop;
import java.io.*;
import java.util.*;
import java.io.IOException;

public final class Jsh {
    public static String userName;
    public static String userDir;
    public static String userID;

    public static void promptTerminal() {

        while (true) {
            exibirPrompt();
            ComandoPrompt comandoEntrado = lerComando();
            executarComando(comandoEntrado);
        }
    }
    public static void exibirPrompt() {
        userName = System.getProperty("user.name");
        userDir = System.getProperty("user.dir");
        userID = getUID();
        System.out.print(userName + "#" + userID + ":" + userDir + "%");

    }

    public static ComandoPrompt lerComando() {
        Scanner input = new Scanner(System.in);
        String command = input.nextLine();
        ComandoPrompt cmd = new ComandoPrompt(command);
        return cmd;
    }
    public static void executarComando(ComandoPrompt command) {
        switch (command.getArgumentos().get(0)) {
            case ("encerrar"): {
                System.exit(0);
                break;
            }
            case ("relogio"): {
                ComandosInternos.exibirRelogio();
                break;
            }
            case ("la"): {
                ComandosInternos.escreverListaArquivos(Optional.of(userDir));
                break;
            }
            case ("cd"): {
                ComandosInternos.criarNovoDiretorio(userDir, command.getArgumentos().get(1));
                break;
            }
            case ("ad"): {
                ComandosInternos.apagarDiretorio(userDir, command.getArgumentos().get(1));
                break;
            }
            case ("mdt"): {
                ComandosInternos.mudarDiretorioTrabalho(userDir, command.getArgumentos().get(1));
                break;
            }
            default: {
                executarPrograma(command);
                break;
            }
        }
    }
    public static int executarPrograma(ComandoPrompt command) {
        File arquivo = new File(userDir);
        File[] file = arquivo.listFiles();

        if(file != null){
            for(int i=0; i<file.length; i++){
                File f = file[i];
                if(command.getNome().substring(2).equals(f.getName())){
                    executarProcesso(command.getNome());
                } else{
                    System.out.println("Comando inexistente");
                }
            }
        }
        return (1);
    }

    public static void executarProcesso(String command){
        //System.out.println("Chamei");
        try {
            ProcessBuilder p = new ProcessBuilder();
            p.command(command);
            Process process = p.start();

            int exitCode = process.waitFor();

            Scanner scanner = new Scanner(process.getInputStream());
            String result = scanner.useDelimiter("$$").next();
            System.out.println(result);

            if(exitCode != 0){
                System.out.println("Erro na execução do processo filho");
            }
        } catch (IOException e){
            e.printStackTrace();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {

        promptTerminal();
    }
    public static String getUID() {
        Runtime r = Runtime.getRuntime();
        Process p;
        try {
            String userName = System.getProperty("user.name");
            String command = "id -u " + userName;
            p = r.exec(command);

            Scanner scanner = new Scanner(p.getInputStream());
            String result = scanner.useDelimiter("$$").next();
            return result;

        } catch (IOException e) {
            throw new RuntimeException("UID not found");
        }
    }
    private Jsh() {
    }
}
