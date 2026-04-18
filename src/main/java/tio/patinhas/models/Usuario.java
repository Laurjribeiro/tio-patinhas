package tio.patinhas.models;

import tio.patinhas.service.AuthenticateService;

public class Usuario {
    private Long id;

    private String nome;
    private String email;
    private String senhaHash;
    private Carteira carteira;
    private AuthenticateService autenticacaoService;

    public Usuario(String nome, String email, String senhaHash) {
        this.nome = nome;
        this.email = email;
        this.senhaHash = senhaHash;
        this.carteira = new Carteira();
        this.autenticacaoService = new AuthenticateService();
    }

    public Usuario() {
    }

    public void cadastrar() {
        // lógica de cadastro (persistência, validação, etc.)
        System.out.println("Usuário cadastrado com sucesso.");
    }

    public boolean autenticar(String email, String senha) {
        return autenticacaoService.login(email, senha);
    }

    public void recuperarSenha() {
        // lógica de recuperação de senha
        System.out.println("Instruções de recuperação enviadas.");
    }

    public Carteira getCarteira() {
        return carteira;
    }
}