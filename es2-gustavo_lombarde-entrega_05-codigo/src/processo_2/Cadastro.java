package processo_2;

import javax.swing.JOptionPane;

public class Cadastro {
    
    private String empresa, observacoes, data_visita;//visita
    private String nome_servidor, tipo, analise;//requisitos
    private int capacidade, tamanho;//requisitos
    private String[] visita = new String[3];
    private String[] requisitos = new String[6];
    private Object ano;//requisitos
    
    public boolean cadastrarVisita(){
        RegistroVisita registroV = new RegistroVisita();
        
        this.visita[0] = getEmpresa();
        this.visita[1] = getData_visita();
        this.visita[2] = getObservacoes();
        try {
            for(int i = 0; i < 3; i++) {
                if(this.visita[i].equals("")){
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
                    return false;
                }
                else{
                    if(registroV.inserirArquivo("Registro de Visitas.txt", visita) == false)
                        registroV.criarArquivo("Registro de Visitas.txt", visita);
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
    
    public boolean cadastrarRequisito(){
        RegistroRequisito registroR = new RegistroRequisito();
        
        this.requisitos[0] = getNome_servidor();
        this.requisitos[1] = getTipo();
        this.requisitos[2] = (String) getAno();
        this.requisitos[3] = Integer.toString(getCapacidade());
        this.requisitos[4] = Integer.toString(getTamanho());
        this.requisitos[5] = getAnalise();
        
        try {
            for(int i = 0; i < 6; i++) {
                if(this.requisitos[i].equals("")){
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
                    return false;
                }
                else{
                    if(registroR.inserirArquivo("Registro de Requisitos.txt", requisitos) == false)
                        registroR.criarArquivo("Registro de Requisitos.txt", requisitos);
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
    //Visita
    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getData_visita() {
        return data_visita;
    }

    public void setData_visita(String data_visita) {
        this.data_visita = data_visita;
    }

    public String[] getVisita() {
        return visita;
    }

    public void setVisita(String[] visita) {
        this.visita = visita;
    }
    
    //Requisitos
    public String getNome_servidor() {
        return nome_servidor;
    }

    public void setNome_servidor(String nome_servidor) {
        this.nome_servidor = nome_servidor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAnalise() {
        return analise;
    }

    public void setAnalise(String analise) {
        this.analise = analise;
    }

    public Object getAno() {
        return ano;
    }

    public void setAno(Object ano) {
        this.ano = ano;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public String[] getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String[] requisitos) {
        this.requisitos = requisitos;
    }
}