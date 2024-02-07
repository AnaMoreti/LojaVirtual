package com.example.lojavirtual.domain.enums;

public enum Status {
    ABERTO(0,"Aguardando Pagamento"), ANDAMENTO(1, "ENVIADO"), FINALIZADO(2, "ENTREGUE");

    private Integer codigo;
    private String descricao;

    private Status(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;

    }

    public static Status toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }
        for (Status x : Status.values()) {
            if (cod.equals(x.getCodigo())){
                return x;
            }
        }
        throw new IllegalArgumentException("Status Invalido");
    }
}
