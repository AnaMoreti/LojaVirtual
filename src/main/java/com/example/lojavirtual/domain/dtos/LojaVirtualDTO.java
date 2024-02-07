package com.example.lojavirtual.domain.dtos;
import com.example.lojavirtual.domain.LojaVirtual;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


public class LojaVirtualDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    protected Integer id;
    @NotNull(message = "O campo NOME é requerido.")
    protected String nome;
    @NotNull(message = "O campo TELEFONE é requerido.")
    protected String telefone;
    @NotNull(message = "O campo ENDERECO é requerido.")
    protected String endereco;
    @NotNull(message = "O campo EMAIL é requerido.")
    protected String email;

    public LojaVirtualDTO(LojaVirtual obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.telefone = obj.getTelefone();
        this.endereco = obj.getEndereco();
        this.email = obj.getEmail();

    }

    public LojaVirtualDTO() {
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

