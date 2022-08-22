package aula05_proxyPattern.mesa;

import org.junit.jupiter.api.Test;

public class UsuarioTest {

    @Test
    public void usuarioFree(){
        Usuario free = new Usuario("123", "Free");
        Baixar baixar = new ServicoBaixarProxy();

        baixar.baixarMusica(free.getId(), free.getTipo());
    }

    @Test
    public void usuarioPremium(){
        Usuario premium = new Usuario("321", "Premium");
        Baixar baixar = new ServicoBaixarProxy();

        baixar.baixarMusica(premium.getId(), premium.getTipo());
    }
}
