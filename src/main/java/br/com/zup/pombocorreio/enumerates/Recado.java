package br.com.zup.pombocorreio.enumerates;

public enum Recado {
    DISPONIVEL("Disponível"),
    OCUPADO("Ocupado"),
    NA_ESCOLA("Na escola"),
    NO_CINEMA("Cinema"),
    NO_TRABALHO("No trabalho"),
    BATERIA_PRESTES_A_ACABAR("Bateria prestes a acabar"),
    NAO_POSSO_FALAR_SOMENTE_MENSAGEM("Não posso falar, somente mensagem!"),
    EM_REUNIAO("Em reunião"),
    NA_ACADEMIA("Na academia"),
    DORMINDO("Dormindo"),
    SO_CHAMADA_URGENTE("Só chamada urgente");

    private String descricao;

    Recado(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}