package tio.patinhas.service;

import tio.patinhas.models.RecoveryPass;
import tio.patinhas.models.Usuario;

public class ForgotPass {
    public boolean checkToken (String token) {
        // validar se o token passado no parâmetro é para o determinado usuário...
        return true;
    }

    public void recoveryPassoword(String updatePass) {
        // atualiza senha do usuário no banco com hash...
    }
}
