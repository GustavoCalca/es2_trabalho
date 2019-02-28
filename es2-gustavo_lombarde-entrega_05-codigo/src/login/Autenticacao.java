package login;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

public class Autenticacao {
    
    private String usuario, senha, horario_login;
    private String[] valor = new String[3];
    private RegistroLogin registro = new RegistroLogin();
    
    public boolean autenticar(){
        try{
            if(registro.lerArquivo("Registro de Log.txt", getUsuario(), getSenha()) == true){
                registro(Boolean.toString(true));
                return true;
            }
            else{
                registro(Boolean.toString(false));
                JOptionPane.showMessageDialog(null, "Login inválido.");
                return false;
            }
        }
        catch (Exception e){
            return false;
        }
    }
    
    public void registro(String resultado){
        SimpleDateFormat data = new SimpleDateFormat("HH:mm:ss");
        Date hora = Calendar.getInstance().getTime();
        setHorario_login(data.format(hora));
        
        this.valor[0] = getUsuario();
        this.valor[1] = getHorario_login();
        this.valor[2] = resultado;
        
        try {
            if(registro.inserirArquivo("Registro de Tentativas de Login.txt", valor) == false)
                registro.criarArquivo("Registro de Tentativas de Login.txt", valor);
        } catch (Exception e) {            
        }
    }

    //Getters & Setters
    public String getHorario_login() {
        return horario_login;
    }
    
    public String[] getValor() {
        return valor;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setValor(String[] valor) {
        this.valor = valor;
    }

    public void setHorario_login(String horario_login) {
        this.horario_login = horario_login;
    }
}
