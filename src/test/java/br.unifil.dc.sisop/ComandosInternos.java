package br.unifil.dc.sisop.;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.Optional;

public class ComandosInternosTest {
    @Test
    public void exibirRelogio() {
        int teste = ComandosInternos.exibirRelogio();
    }

    @Test
    public void escreverListaArquivos() {
        int teste = ComandosInternos.escreverListaArquivos();
    }

    @test
    public void criarNovoDiretorio() {
        int teste = ComandosInternos.criarNovoDiretorio();
    }

    @test
    public void apagarDiretorio() {
        int test = ComandosInternos.apagarDiretorio();
    }

    @test
    public void mudarDiretorioTrabalho() {
        int test = ComandosInternos.mudarDiretorioTrabalho()
    }
}