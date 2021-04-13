package br.com.zup.pombocorreio.dtos.contato;

import br.com.zup.pombocorreio.models.Contato;
import br.com.zup.pombocorreio.models.Perfil;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CadastrarContatoDTO {
    @NotNull(message = "O campo nomeCompleto não foi informado")
    @NotEmpty(message = "O campo nomeCompleto está vazio")
    @Size(max = 80, message = "o campo nomecompleto deve ter no máximo 80 caracteres")
    private String nomeCompleto;

    @NotNull(message = "O campo numeroTelefone não foi informado")
    @NotEmpty(message = "O campo numeroTelefone está vazio")
    @Size(max = 30, message = "O campo numeroTelefone deve ter no máximo 30 caracteres")
    private String numeroTelefone;
    private Boolean bloqueio;

    @NotNull(message = "O campo idConta não foi informado")
    @NotEmpty(message = "O campo idConta está vazio")
    private Long idConta;

    public CadastrarContatoDTO() {
    }

    public CadastrarContatoDTO(String nomeCompleto, String numeroTelefone, Boolean bloqueio, Long idConta) {
        this.nomeCompleto = nomeCompleto;
        this.numeroTelefone = numeroTelefone;
        this.bloqueio = bloqueio;
        this.idConta = idConta;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public Boolean getBloqueio() {
        return bloqueio;
    }

    public void setBloqueio(Boolean bloqueio) {
        this.bloqueio = bloqueio;
    }

    public Long getIdConta() {
        return idConta;
    }

    public void setIdConta(Long idConta) {
        this.idConta = idConta;
    }

    public Contato converterDtoParaModelo() {
        Perfil perfil = new Perfil(
          nomeCompleto,
          numeroTelefone,
                null,
                null,
                true
        );
        Contato contato = new Contato(
                perfil,
                false
        );
        return contato;
    }
}
