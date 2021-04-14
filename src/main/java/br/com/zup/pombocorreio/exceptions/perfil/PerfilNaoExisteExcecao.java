package br.com.zup.pombocorreio.exceptions.perfil;

public class PerfilNaoExisteExcecao extends RuntimeException {
    private Integer status = 400;
    private String descricaoStatus = "BAD REQUEST";
    private String tipoDeErro = "Perfil não cadastrado!";

    public PerfilNaoExisteExcecao(String message) {
        super(message);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescricaoStatus() {
        return descricaoStatus;
    }

    public void setDescricaoStatus(String descricaoStatus) {
        this.descricaoStatus = descricaoStatus;
    }

    public String getTipoDeErro() {
        return tipoDeErro;
    }

    public void setTipoDeErro(String tipoDeErro) {
        this.tipoDeErro = tipoDeErro;
    }
}
