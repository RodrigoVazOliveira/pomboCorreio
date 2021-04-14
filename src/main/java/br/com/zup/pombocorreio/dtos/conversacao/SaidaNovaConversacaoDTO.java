package br.com.zup.pombocorreio.dtos.conversacao;

import br.com.zup.pombocorreio.models.Conversacao;

import java.util.ArrayList;
import java.util.List;

public class SaidaNovaConversacaoDTO {

    private Long idConversacao;
    private Long idContato;
    private String nomeContato;
    private String fotoContato;

    public SaidaNovaConversacaoDTO() {
    }

    public SaidaNovaConversacaoDTO(Long idConversacao, Long idContato, String nomeContato, String fotoContato) {
        this.idConversacao = idConversacao;
        this.idContato = idContato;
        this.nomeContato = nomeContato;
        this.fotoContato = fotoContato;
    }

    public Long getIdConversacao() {
        return idConversacao;
    }

    public void setIdConversacao(Long idConversacao) {
        this.idConversacao = idConversacao;
    }

    public Long getIdContato() {
        return idContato;
    }

    public void setIdContato(Long idContato) {
        this.idContato = idContato;
    }

    public String getNomeContato() {
        return nomeContato;
    }

    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
    }

    public String getFotoContato() {
        return fotoContato;
    }

    public void setFotoContato(String fotoContato) {
        this.fotoContato = fotoContato;
    }

    public static SaidaNovaConversacaoDTO converterModeloParaDto(Conversacao conversacao) {
        SaidaNovaConversacaoDTO dto = new SaidaNovaConversacaoDTO();
        dto.setIdConversacao(conversacao.getId());
        dto.setNomeContato(conversacao.getContato().getPerfil().getNomeCompleto());
        dto.setIdContato(conversacao.getContato().getId());
        dto.setFotoContato(conversacao.getContato().getPerfil().getFoto());

        return dto;
    }

    public static Iterable<SaidaNovaConversacaoDTO> converterListaModeloParaListaDto(
            Iterable<Conversacao> conversacaos) {
        List<SaidaNovaConversacaoDTO> dtos = new ArrayList<>();

        for (Conversacao conversacao : conversacaos) {
            dtos.add(converterModeloParaDto(conversacao));
        }

        return dtos;
    }
}
