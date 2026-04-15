package tio.patinhas.service;

import tio.patinhas.models.Usuario;

public class AuthenticateService {
    public boolean checkCredentials(String email, String senha) {
        // busca usuário no banco
        return true;
    }

    public Usuario login(String email, String senha) {
        if (checkCredentials(email, senha)) {
            return new Usuario(); // retornará o usuário autenticado
        }

        throw new RuntimeException("Invalid Credentials");
    }

    public void Logout(Usuario usuario) {
        // invalidar a sessão/token criado no login, salvo em cookies...
    }
}
