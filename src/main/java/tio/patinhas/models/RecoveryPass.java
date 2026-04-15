package tio.patinhas.models;

import java.util.Date;
import java.util.UUID;

public class RecoveryPass {
    private Long id;
    private String token;
    public Date expiracao;

    public RecoveryPass(Long id, String token, Date expiracao) {
        this.id = id;
        this.token = token;
        this.expiracao = expiracao;
    }

    public RecoveryPass() {
    }

    public boolean checkExpirationToken() {
        return new Date().before(expiracao);
    }

    public String getToken() {
        return token;
    }

    public Date getExpiracao() {
        return expiracao;
    }
}
