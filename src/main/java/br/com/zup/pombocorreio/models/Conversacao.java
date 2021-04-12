package br.com.zup.pombocorreio.models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "conversacoes")
public class Conversacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Conta conta;

    @ManyToOne
    private Contato contato;

    @ManyToMany
    private List<Mensagem> mensagems;

    public Conversacao() {
    }

    public Conversacao(Conta conta, Contato contato, List<Mensagem> mensagems) {
        this.conta = conta;
        this.contato = contato;
        this.mensagems = mensagems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public List<Mensagem> getMensagems() {
        return mensagems;
    }

    public void setMensagems(List<Mensagem> mensagems) {
        this.mensagems = mensagems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conversacao that = (Conversacao) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
