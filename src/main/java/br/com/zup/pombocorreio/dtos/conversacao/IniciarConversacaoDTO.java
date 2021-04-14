package br.com.zup.pombocorreio.dtos.conversacao;

import br.com.zup.pombocorreio.models.Conta;
import br.com.zup.pombocorreio.models.Contato;
import br.com.zup.pombocorreio.models.Conversacao;

import javax.validation.constraints.NotNull;

public class IniciarConversacaoDTO {

    @NotNull(message = "O id da conta deve ser informado!")
    private Long idConta;

    @NotNull(message = "O id do contato deve ser informado!")
    private Long idContato;

    public IniciarConversacaoDTO() {
    }

    public IniciarConversacaoDTO(Long idConta, Long idContato) {
        this.idConta = idConta;
        this.idContato = idContato;
    }

    public Long getIdConta() {
        return idConta;
    }

    public void setIdConta(Long idConta) {
        this.idConta = idConta;
    }

    public Long getIdContato() {
        return idContato;
    }

    public void setIdContato(Long idContato) {
        this.idContato = idContato;
    }

    public Conversacao converterDtoParaModelo() {
        Contato contato = new Contato();
        contato.setId(idContato);
        Conta conta = new Conta();
        conta.setId(idConta);

        Conversacao conversacao = new Conversacao(
            conta,
            contato,
            null
        );

        return conversacao;
    }
}
