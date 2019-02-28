    package testeP1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Cadastro {
    
    public boolean CadastroT(){
        cadastro.setNome_representante("Chaves");
        cadastro.setCpf("12345678910");
        cadastro.setNome_empresa("Televisa");
        cadastro.setCnpj("01234567891011");
        cadastro.setTel("12987654321");
        cadastro.setEnd("Apartamento 8");
        cadastro.setEmail("chaves@chapolin.com");
        return true;
    }
    
    processo_1.Cadastro cadastro;
    
    public Cadastro() {
    }
    
    @Before
    public void setUp() {
        cadastro = new processo_1.Cadastro();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void teste1(){
        assertEquals("Sem erro", cadastro.cadastrar(), CadastroT());
    }
    
    @Test
    public void teste2(){
        assertFalse("Erro, pois não têm variáveis", cadastro.cadastrar());
    }
}
