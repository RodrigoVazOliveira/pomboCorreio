package br.com.zup.pombocorreio.models;

import br.com.zup.pombocorreio.enumerates.Recado;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "perfis")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 80, nullable = false)
    private String nomeCompleto;

    @Column(length = 30, nullable = false, unique = true)
    private String numeroTelefone;
    private String foto;
    private Recado recado;
    private Boolean ativo;

    public Perfil() {
    }

    public Perfil(String nomeCompleto, String numeroTelefone, String foto, Recado recado, Boolean ativo) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Perfil perfil = (Perfil) o;
        return Objects.equals(id, perfil.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
