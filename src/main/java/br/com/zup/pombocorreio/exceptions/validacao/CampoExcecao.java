package br.com.zup.pombocorreio.exceptions.validacao;

public class CampoExcecao {
    private String campo;
    private String mensagem;

    public CampoExcecao() {
    }

    public CampoExcecao(String campo, String mensagem) {
        this.campo = campo;
        this.mensagem = mensagem;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
