package processo_1;

import javax.swing.JOptionPane;

public class Cadastro {
    
    private String nome_representante, cpf, nome_empresa, cnpj, tel, end, email;    
    private String[] dados = new String[7];
    
    public boolean cadastrar(){
        RegistroCliente registro = new RegistroCliente();
        
        this.dados[0] = getNome_representante();
        this.dados[1] = getCpf();
        this.dados[2] = getNome_empresa();
        this.dados[3] = getCnpj();
        this.dados[4] = getTel();
        this.dados[5] = getEnd();
        this.dados[6] = getEmail();
        
        try {
            for(int i = 0; i < 7; i++) {
                if(this.dados[i].equals("")){
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
                    return false;
                }
                else{
                    if(registro.inserirArquivo("Cadastro de Clientes.txt", dados) == false)
                        registro.criarArquivo("Cadastro de Clientes.txt", dados);
                    break;
                }
            }
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no cadastro, tente novamente");
            return false;
        }
    }
    
    //Getters & Setters
    public String[] getDados() {
        return dados;
    }

    public String getNome_representante() {
        return nome_representante;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome_empresa() {
        return nome_empresa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getTel() {
        return tel;
    }

    public String getEnd() {
        return end;
    }

    public String getEmail() {
        return email;
    }

    public void setNome_representante(String nome_representante) {
        this.nome_representante = nome_representante;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome_empresa(String nome_empresa) {
        this.nome_empresa = nome_empresa;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public void setEmail(String email) {
        this.email = email;
    }   
}