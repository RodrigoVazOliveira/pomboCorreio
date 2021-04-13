package br.com.zup.pombocorreio.dtos.conta;

import br.com.zup.pombocorreio.enumerates.Recado;
import br.com.zup.pombocorreio.models.Conta;
import br.com.zup.pombocorreio.models.Perfil;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AtualizarContaDTO {

    private Long id;

    @NotNull(message = "O campo nomeCompleto não foi informado")
    @NotEmpty(message = "O campo nomeCompleto está vazio")
    @Size(max = 80, message = "o campo nomecompleto deve ter no máximo 80 caracteres")
    private String nomeCompleto;

    @NotNull(message = "O campo numeroTelefone não foi informado")
    @NotEmpty(message = "O campo numeroTelefone está vazio")
    @Size(max = 30, message = "O campo numeroTelefone deve ter no máximo 30 caracteres")
    private String numeroTelefone;
    private String foto;
    private Recado recado;

    @NotNull(message = "O campo senha não foi informado")
    @NotEmpty(message = "O campo senha está vazio")
    private String senha;

    public AtualizarContaDTO() {
    }

    public AtualizarContaDTO(Long id, String nomeCompleto, String numeroTelefone,
                             String foto, Recado recado, String senha) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.numeroTelefone = numeroTelefone;
        this.foto = foto;
        this.recado = recado;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Recado getRecado() {
        return recado;
    }

    public void setRecado(Recado recado) {
        this.recado = recado;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Conta converterDtoParaModelo() {
        Perfil perfil = new Perfil(
                nomeCompleto,
                numeroTelefone,
                foto,
                recado,
                true
        );
        Conta conta = new Conta(
                perfil,
                senha
        );
        conta.setId(id);
        return conta;
    }
}
