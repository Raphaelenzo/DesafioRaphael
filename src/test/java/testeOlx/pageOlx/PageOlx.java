package testeOlx.pageOlx;

import org.junit.Assert;
import org.openqa.selenium.By;

import java.awt.*;

import static testeOlx.core.BasePage.*;
import static testeOlx.core.DriverFactory.getNavegador;

public class PageOlx {


    public static void acessarOlx() {
        abrirLink("https://www.olx.com.br/");
        aguardarElementoVisivel(By.xpath("//div//header//div//a//span[.='Entrar']"), 15);
    }

    /*##### CLIQUE #####*/

    public static void clicarBuscar() {
        aguardarElementoClicavel(By.xpath("//*//div//header/a[.='Buscar']"), 10);
        clicar(By.xpath("//*//div//header/a[.='Buscar']"), 10);
    }

    public static void clicarplanoProfissional() {
        clicar(By.xpath("//div//header//div//a//span[.='Plano Profissional']"), 10);
    }

    public static void clicarMeusAnuncios() {
        clicar(By.xpath("//div//header//div//a//span[.='Meus Anúncios']"), 10);
    }

    public static void clicarChat() {
        clicar(By.xpath("//div//header//div//a//span[.='Chat']"), 10);
    }

    public static void clicarEntrarPgInicial() {
        clicar(By.xpath("//div//header//div//a//span[.='Entrar']"), 10);
    }

    public static void clicarRetornoBusca() {
        clicar(By.xpath("//*[@id='ad-list']/li[1]/a//div[1]/img"), 10);
    }

    public static void clicarSairLogoff() {
        mouseOver(By.xpath("//div//header//div//a//span//div[.!='']"), 10);
        clicar(By.xpath("/*//header//ul//li//a[.='Sair']"), 10);
        aguardarElementoVisivel(By.xpath("//div//header//div//a//span[.='Entrar']"), 5);
    }

    public static void clicarEstado(String estado) {
        clicar(By.xpath("//*[@id='content']//div[2]/div[1]/div[2]/div//a[.='".concat(estado).concat("']")), 10);
    }

    public static void clicarEntrarLogar() {
        clicar(By.xpath("//button[@type= 'text'][.='Entrar']"), 10);
    }

    public static void clicarFavoritar() {
        clicar(By.xpath("//*[@id='content']//div/button[1][.='Favoritar']"), 10);
    }

    public static void clicarMenuFavoritos() {
        mouseOver(By.xpath("//div//header//div//a//span//div[.!='']"), 10);
        clicar(By.xpath("/*//header//ul//li//a[.='Favoritos']"), 10);
        aguardarElementoVisivel(By.xpath("//*//div/button/span[1]"), 5);
    }

    public static void clicarDesFavoritar() {
        clicar(By.xpath("//*//div[3]/a/div[3]/span/img"), 10);
    }

    /*##### VERIFICAÇÕES #####*/

    public static void verificarEstado(String expectedMsg) {
        aguardarElementoVisivel(By.xpath("//*[@id='content']//div[2]/div[3]//h1"), 10);
        String msg = obterTexto(By.xpath("//*[@id='content']//div[2]/div[3]//h1"));
        Assert.assertTrue(msg.contains(expectedMsg));
    }

    public static void verificarPalavraChave(String expectedMsg) {

        aguardarElementoVisivel(By.xpath("//*[@id='content']//div[2]/div[3]//h1"), 10);
        String msg = obterTexto(By.xpath("//*[@id='content']//div[2]/div[3]//h1"));
        Assert.assertTrue(msg.contains(expectedMsg));
    }

    public static void verificarElemantodeBusca(String expectedMsg) {

        aguardarElementoVisivel(By.xpath("//*[@id='content']//div[6]/h1"), 10);
        String msg = obterTexto(By.xpath("//*[@id='content']//div[6]/h1"));
        Assert.assertTrue(msg.contains(expectedMsg));
    }


    public static void verificarFavorito(String expectedMsg) {
        aguardarElementoVisivel(By.xpath("//*//div[3]/a/div[2]/div[1]"), 10);
        String msg = obterTexto(By.xpath("//*//div[3]/a/div[2]/div[1]"));
        Assert.assertTrue(msg.contains(expectedMsg));
    }

    public static void verificarUsuarioLogado(String expectedMsg) {
        aguardarElementoVisivel(By.xpath("//div//header//div//a//span//div/span[.!='']"), 10);
        String msg = obterTexto(By.xpath("//div//header//div//a//span//div/span[.!='']"));
        Assert.assertTrue(msg.contains(expectedMsg));
    }

    public static void verificarMensagemErroLogin(String expectedMsg) {
        aguardarElementoVisivel(By.xpath("//*[@id]//div[3]/div/div/span"), 10);
        String msg = obterTexto(By.xpath("//*[@id]//div[3]/div/div/span"));
        Assert.assertTrue(msg.contains(expectedMsg));
    }

    public static void escreverCampoEmail(String email) {
        escrever(By.xpath("//input[@type= 'email']"), email);
    }

    /*##### ESCREVER #####*/

    public static void escreverCampoSenha(String senha) {
        escrever(By.xpath("//input[@type= 'text']"), senha);
    }

    public static void escreverCampoBusca(String palavrachave) {

    }

    /*#### ABAS NAVEGADOR #####*/

    public void alternarAbas(String index) {
        alternaAbas(index, 2);
    }

    public void Screenshot() {
        tirarScreenshot(getNavegador(), "target\\Screenshot_Evidencias\\" + horaArquivo() + "evidencia.png");
    }

    public void fecharAbaSelecionada() throws AWTException {
        fecharAba();
    }


}