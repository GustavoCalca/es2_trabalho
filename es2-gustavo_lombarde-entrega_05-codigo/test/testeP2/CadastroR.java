package testeP2;

import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CadastroR {
    
    String[] valor = new String[6];
    
    public void valores(){
        valor[0] = "Servidor do João";
        valor[1] = "Tipo de Teste 1";
        valor[2] = "2017";
        valor[3] = "1024";
        valor[4] = "10";
        valor[5] = "Teste mal sucedido.";
    }
    
    public boolean RequisitoF(){
        cadastro.setNome_servidor("Servidor de Teste");
        cadastro.setTipo("Tipo de Teste");
        cadastro.setAno(null);
        cadastro.setCapacidade(1024);
        cadastro.setTamanho(10);
        cadastro.setAnalise("Teste mal sucedido");
        return false;
    }
    
    processo_2.Cadastro cadastro;
    processo_2.RegistroRequisito requisito;
    
    public CadastroR() {
    }
    
    @Before
    public void setUp() {
        cadastro = new processo_2.Cadastro();
        requisito = new processo_2.RegistroRequisito();
        try {
            requisito.removerArquivo("Registro de Requisitos.txt");
        } catch (IOException ex) {
        }
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void teste1(){
        assertEquals("Variavel null não aceita", cadastro.cadastrarRequisito(), RequisitoF());
    }

    @Test
    public void teste2(){
        try {
            assertFalse("Tabela inexistente no momento do teste", requisito.inserirArquivo("Registro de Requisitos.txt", valor));
        } catch (IOException ex) {
        }
    }
}
