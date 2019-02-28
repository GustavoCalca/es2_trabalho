package testeP2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CadastroV {
    
    public boolean visitaT(){
        cadastro.setEmpresa("Empresa do João");
        cadastro.setData_visita("Empresa do João");
        cadastro.setObservacoes("//Sem Oservações");
        return true;
    }
    
    public boolean visitaF(){
        cadastro.setEmpresa("");
        cadastro.setData_visita("");
        cadastro.setObservacoes("");
        return false;
    }
    
    processo_2.Cadastro cadastro;
    
    public CadastroV() {
    }
    
    @Before
    public void setUp() {
        cadastro = new processo_2.Cadastro();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void teste1(){
        assertEquals("Registro realizado mesmo com data irregular", cadastro.cadastrarVisita(), visitaT());
    }

    @Test
    public void teste2(){
        assertEquals("Variáveis em branco", cadastro.cadastrarVisita(), visitaF());
    }
}
