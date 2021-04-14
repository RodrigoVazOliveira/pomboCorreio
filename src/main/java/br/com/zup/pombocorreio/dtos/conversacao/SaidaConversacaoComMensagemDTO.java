package br.com.zup.pombocorreio.dtos.conversacao;

import br.com.zup.pombocorreio.models.Conversacao;
import br.com.zup.pombocorreio.models.Mensagem;

import java.util.ArrayList;
import java.util.List;

public class SaidaConversacaoComMensagemDTO {

    private Long idConversacao;
    private Long idContato;
    private String nomeContato;
    private String fotoContato;
    private List<Mensagem> mensagens;

    public SaidaConversacaoComMensagemDTO() {
    }

    public SaidaConversacaoComMensagemDTO(Long idConversacao, Long idContato, String nomeContato, String fotoContato, List<Mensagem> mensagens) {
        this.idConversacao = idConversacao;
        this.idContato = idContato;
        this.nomeContato = nomeContato;
        this.fotoContato = fotoContato;
        this.mensagens = mensagens;
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

    public List<Mensagem> getMensagens() {
        return mensagens;
    }

    public void setMensagens(List<Mensagem> mensagens) {
        this.mensagens = mensagens;
    }

    public static SaidaConversacaoComMensagemDTO converterModeloParaDto(Conversacao conversacao) {
        SaidaConversacaoComMensagemDTO dto = new SaidaConversacaoComMensagemDTO();
        dto.setIdConversacao(conversacao.getId());
        dto.setNomeContato(conversacao.getContato().getPerfil().getNomeCompleto());
        dto.setIdContato(conversacao.getContato().getId());
        dto.setFotoContato(conversacao.getContato().getPerfil().getFoto());
        dto.setMensagens(conversacao.getMensagems());
        return dto;
    }

    public static Iterable<SaidaConversacaoComMensagemDTO> converterListaModeloParaListaDto(
            Iterable<Conversacao> conversacaos) {
        List<SaidaConversacaoComMensagemDTO> dtos = new ArrayList<>();

        for (Conversacao conversacao : conversacaos) {
            dtos.add(converterModeloParaDto(conversacao));
        }

        return dtos;
    }
}
