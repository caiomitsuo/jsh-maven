package br.unifil.dc.sisop;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
public final class ComandosInternos {

    public static int exibirRelogio() {
        System.out.println(java.time.LocalDate.now());
        System.out.println(java.time.LocalTime.now());
        return (1);
    }
    public static int escreverListaArquivos(Optional<String> nomeDir) {
        File file = new File(nomeDir.get());
        File afile[] = file.listFiles();
        for (int i = 0; i < afile.length; i++) {
            System.out.println(afile[i].getName());
        }
        return (1);
    }
    public static int criarNovoDiretorio(String nomeDir, String nomePasta) {
        File file = new File(nomeDir + "/" + nomePasta);
        if (!file.exists()) {
            file.mkdirs();
        }
        return (1);
    }
    public static int apagarDiretorio(String nomeDir, String nomePasta) {
        File file = new File(nomeDir + "/" + nomePasta);
        if ((file.exists()) && (file.isDirectory())) {
            file.delete();
        }
        return (1);
    }
    public static int mudarDiretorioTrabalho(String nomeDir, String arg) {
        String caminho[] = (nomeDir.split("/"));
        String mdtCaminho = "";
        if(arg.equals("..")){
            for(int i=0; i<caminho.length - 1; i++){
                mdtCaminho += caminho[i] + "/";
            }
            System.setProperty("user.dir", mdtCaminho);

        } else{

            File file = new File(nomeDir + "/" + arg);
            if ((file.exists()) && (file.isDirectory())) {
                System.setProperty("user.dir", file.getAbsolutePath());
            } else if(!(file.exists()) && (file.isDirectory())){
                System.out.println("diretório não existe :(");
            }
        }

        return (1);
    }
    private ComandosInternos() {
    }
}
