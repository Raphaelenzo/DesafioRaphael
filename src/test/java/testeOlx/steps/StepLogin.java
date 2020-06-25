package testeOlx.steps;

import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import testeOlx.pageOlx.PageOlx;

import java.awt.*;

import static testeOlx.core.BasePage.pause;
import static testeOlx.core.DriverFactory.getNavegador;

public class StepLogin extends PageOlx {

    @Quando("usuario acessa o site da olx")
    public void usuario_acessa_o_site_da_olx() {
        acessarOlx();
    }

    @Quando("clica no botão entrar")
    public void clica_no_botão_entrar() {
        clicarEntrarPgInicial();
    }

    @Quando("preenche o campo email (.*)")
    public void preenche_o_campo_email(String email) {
        escreverCampoEmail(email);
    }

    @Quando("preenche o campo senha (.*)")
    public void preenche_o_campo_senha(String senha) {
        escreverCampoSenha(senha);
    }

    @Quando("clica em entrar para logar")
    public void clica_em_entrar_para_logar() {
        clicarEntrarLogar();
    }

    @Então("verifica se o login foi rejeitado com uma mensagem de alerta (.*)")
    public void verifica_se_o_login_foi_rejeitado_com_uma_mensagem_de_alerta(String mensagem) {
        verificarMensagemErroLogin(mensagem);
    }

    @Então("verifica se o login foi realizado verificando usuario logado (.*)")
    public void verifica_se_o_login_foi_realizado_verificando_usuario_logado(String userLogado) {
        verificarUsuarioLogado(userLogado);
    }

    @Então("realiza o logoff")
    public void realiza_o_logoff() {
        clicarSairLogoff();
    }

    @Quando("clica no botão Buscar")
    public void clica_no_botão_Buscar() {
        pause(5000);
        clicarBuscar();
    }

    @Quando("selecionar o estado (.*)")
    public void selecionar_o_estado(String estado) {
        pause(2000);
        clicarEstado(estado);
    }

    @Quando("Validadar se o estado selecionado (.*)")
    public void validadar_se_o_estado_selecionado(String estado) {
        verificarEstado(estado);
    }

    @Quando("Para realizar a busca no estado selecionado (.*) preencho o campo buscar com a palavra chave (.*)")
    public void para_realizar_a_busca_no_estado_selecionado_preencho_o_campo_buscar_com_a_palavra_chave(String arg1, String agr2) {
        getNavegador().get("https://".concat(arg1).concat(".olx.com.br/?q=".concat(agr2)));

       // clicar(By.xpath("//span[.='".concat(campo).concat("']//..//..//div[@class='CMAutoSearchMethod grid_3']//a[.='select']")), 5);
    }

    @Quando("verificar se a busca retornou o esperado (.*)")
    public void verificar_se_a_busca_retornou_o_esperado(String palavrachave) {
        pause(5000);
        verificarPalavraChave(palavrachave);
    }


    @Quando("clicar no primeiro item do retono da busca")
    public void clicar_no_primeiro_item_do_retono_da_busca() {
        clicarRetornoBusca();
    }


    @Quando("validar o item e guardar um print(.*)")
    public void validar_o_item_e_guardar_um_print(String palavrachave) {
        pause(1000);
        alternarAbas("0");
        pause(1000);
        alternarAbas("1");
        pause(1000);
        verificarElemantodeBusca(palavrachave);
        pause(1000);
        Screenshot();
    }


    @Quando("marcar o item como favorito")
    public void marcar_o_item_como_favorito() {
        clicarFavoritar();
    }

    @Quando("fechar a aba aberta")
    public void fechar_a_aba_aberta() throws AWTException {
        alternarAbas("0");
        pause(500);
        alternarAbas("1");
        pause(500);
        fecharAbaSelecionada();
        alternarAbas("0");
    }

    @Então("verifica se o item foi adcionado aos favoritos (.*)")
    public void verifica_se_o_item_foi_adcionado_aos_favoritos(String palavrachave) {
        clicarMenuFavoritos();
        pause(2000);

        verificarFavorito(palavrachave);

    }

    @Quando("clica no botão favoritos")
    public void clica_no_botão_favoritos() {
        clicarMenuFavoritos();
    }

    @Quando("excluir o item favoritos")
    public void excluir_o_item_favoritos() {
        clicarDesFavoritar();
    }


}
