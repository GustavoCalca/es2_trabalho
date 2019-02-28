package testePL;

import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Login {
    
    String user = "Username";
    String password = "password1";
    
    login.RegistroLogin autenticacao;
    
    public Login() {
    }
    
    @Before
    public void setUp() {
        autenticacao = new login.RegistroLogin();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void teste1(){
        try {
            assertFalse("Usuario e senha não corresnpondem", autenticacao.lerArquivo("Registro de Log.txt", user, password));
        } catch (IOException ex) {
        }
    }
    
    @Test
    public void teste2(){
        try {
            assertTrue("Usuário e Senha correspondente", autenticacao.lerArquivo("Registro de Log.txt", "joao", "123"));
        } catch (IOException ex) {
        }
    }
}
