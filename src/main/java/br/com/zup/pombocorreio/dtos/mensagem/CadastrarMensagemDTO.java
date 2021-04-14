package br.com.zup.pombocorreio.dtos.mensagem;

import br.com.zup.pombocorreio.models.Mensagem;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CadastrarMensagemDTO {

    @NotNull(message = "O campo mensagem deve ser informaddo")
    @NotEmpty(message = "A mensagem está vazia")
    private String mensagem;

    public CadastrarMensagemDTO() {
    }

    public CadastrarMensagemDTO(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Mensagem converterDtoParaModelo() {
        Mensagem modelo = new Mensagem();
        modelo.setMensagem(this.mensagem);
        return modelo;
    }
}
