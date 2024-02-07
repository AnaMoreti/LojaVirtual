package com.example.lojavirtual.domain.enums;
public enum ProdutoEstoque {
    PRODUTO_ESGOTADO(0), PRODUTO_ESTOQUE(1);

    private int quantidade;


    ProdutoEstoque(int quantidade) {

        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }


    public static ProdutoEstoque toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }
        for (ProdutoEstoque x : ProdutoEstoque.values()) {
            if (cod.equals(x.getQuantidade())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Quantidade Invalida");
    }
}