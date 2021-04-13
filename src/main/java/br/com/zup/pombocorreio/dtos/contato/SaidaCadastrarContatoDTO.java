package br.com.zup.pombocorreio.dtos.contato;

import br.com.zup.pombocorreio.models.Contato;

public class SaidaCadastrarContatoDTO {

    private Long id;
    private String nomeCompleto;
    private String numeroTelefone;
    private Boolean bloqueio;
    private Long idConta;

    public SaidaCadastrarContatoDTO() {
    }

    public SaidaCadastrarContatoDTO(Long id, String nomeCompleto, String numeroTelefone,
                                    Boolean bloqueio, Long idConta) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.numeroTelefone = numeroTelefone;
        this.bloqueio = bloqueio;
        this.idConta = idConta;
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

    public static SaidaCadastrarContatoDTO converterModeloParaDto(Contato contato, Long idConta) {
        SaidaCadastrarContatoDTO dto = new SaidaCadastrarContatoDTO(
                contato.getId(),
                contato.getPerfil().getNomeCompleto(),
                contato.getPerfil().getNumeroTelefone(),
                contato.getBloqueio(),
                idConta
        );

        return dto;
    }
}
