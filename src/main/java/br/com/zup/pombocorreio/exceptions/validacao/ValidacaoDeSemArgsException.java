package br.com.zup.pombocorreio.exceptions.validacao;

public class ValidacaoDeSemArgsException {
    private String tipoDeErro;
    private Integer codigoStatus;
    private String descricaoStatus;
    private String mensagem;

    public ValidacaoDeSemArgsException() {
    }

    public ValidacaoDeSemArgsException(String tipoDeErro, Integer codigoStatus, String descricaoStatus, String mensagem) {
        this.tipoDeErro = tipoDeErro;
        this.codigoStatus = codigoStatus;
        this.descricaoStatus = descricaoStatus;
        this.mensagem = mensagem;
    }

    public String getTipoDeErro() {
        return tipoDeErro;
    }

    public void setTipoDeErro(String tipoDeErro) {
        this.tipoDeErro = tipoDeErro;
    }

    public Integer getCodigoStatus() {
        return codigoStatus;
    }

    public void setCodigoStatus(Integer codigoStatus) {
        this.codigoStatus = codigoStatus;
    }

    public String getDescricaoStatus() {
        return descricaoStatus;
    }

    public void setDescricaoStatus(String descricaoStatus) {
        this.descricaoStatus = descricaoStatus;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
