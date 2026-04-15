package tio.patinhas.models;

import java.util.Date;
import java.util.UUID;

public class Usuario {
    private Long id;
    private String hashPassword;

    public String name;
    public String email;
    public Date createDate;
    public Date updateDate;

    public Usuario(Long id, String hashPassword, String name, String email, Date dataCadastro, Date dataAtualizada) {
        this.id = id;
        this.hashPassword = hashPassword;
        this.name = name;
        this.email = email;
        this.createDate = dataCadastro;
        this.updateDate = dataAtualizada;
    }

    // criar realms para o usuário para criação do token
    public String generateToken() {
        return UUID.randomUUID().toString();
    }

    public Usuario() {
    }

    public String getName() {
        return name;
    }
}