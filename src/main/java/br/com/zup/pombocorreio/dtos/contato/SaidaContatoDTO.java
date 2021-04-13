package br.com.zup.pombocorreio.dtos.contato;

import br.com.zup.pombocorreio.models.Contato;

import java.util.ArrayList;
import java.util.List;

public class SaidaContatoDTO {
    private Long id;
    private String nomeCompleto;
    private String numeroTelefone;
    private Boolean bloqueio;

    public SaidaContatoDTO() {
    }

    public SaidaContatoDTO(Long id, String nomeCompleto, String numeroTelefone, Boolean bloqueio) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.numeroTelefone = numeroTelefone;
        this.bloqueio = bloqueio;
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

    public static Iterable<SaidaContatoDTO> converterModeloparaListaDeDto(Iterable<Contato> contatos) {
        List<SaidaContatoDTO> dtos = new ArrayList<>();
        for (Contato contato : contatos) {
            SaidaContatoDTO dto = new SaidaContatoDTO(
                    contato.getId(),
                    contato.getPerfil().getNomeCompleto(),
                    contato.getPerfil().getNumeroTelefone(),
                    contato.getBloqueio()
            );
            dtos.add(dto);
        }
        return dtos;
    }
}
