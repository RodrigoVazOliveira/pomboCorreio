package br.com.zup.pombocorreio.dtos.conta;

import br.com.zup.pombocorreio.enumerates.Recado;
import br.com.zup.pombocorreio.models.Conta;

public class SaidaCadastrarContaDTO {

    private Long id;
    private String nomeCompleto;
    private String numeroTelefone;
    private String foto;
    private Recado recado;
    private Boolean ativo;

    public SaidaCadastrarContaDTO() {
    }

    public SaidaCadastrarContaDTO(Long id, String nomeCompleto, String numeroTelefone, String foto,
                                  Recado recado, Boolean ativo) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.numeroTelefone = numeroTelefone;
        this.foto = foto;
        this.recado = recado;
        this.ativo = ativo;
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

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public static SaidaCadastrarContaDTO converterModeloParaDto(Conta conta) {
        SaidaCadastrarContaDTO dto = new SaidaCadastrarContaDTO(
            conta.getId(),
            conta.getPerfil().getNomeCompleto(),
            conta.getPerfil().getNumeroTelefone(),
            conta.getPerfil().getFoto(),
            conta.getPerfil().getRecado(),
            conta.getPerfil().getAtivo()
        );
        return dto;
    }
}