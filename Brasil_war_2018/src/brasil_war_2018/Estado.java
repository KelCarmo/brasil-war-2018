/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brasil_war_2018;

/**
 *
 * @author hprf
 */
public class Estado {
    private String nome;
    private String cor;
    private String regiao;
    private int exercito;
    private String vizinhos [];
    

    public Estado(String nome, String cor, String regiao, int exercito, String [] vizinhos) {
        this.nome = nome;
        this.cor = cor;
        this.regiao = regiao; 
        this.exercito = exercito;
        this.vizinhos = vizinhos;
    }
    
    

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setExercito(int exercito) {
        this.exercito = exercito;
    }
    
    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public void setVizinhos(String[] vizinhos) {
        this.vizinhos = vizinhos;
    }
    
    
    public String getNome() {
        return nome;
    }

    public String getCor() {
        return cor;
    }

    public int getExercito() {
        return exercito;
    }

    public String getRegiao() {
        return regiao;
    }

    public String[] getVizinhos() {
        return vizinhos;
    }

    
    
    public void renomeando(String nome, String cor, String regiao, int exercito,String[] vizinhos){
        this.setNome(nome);
        this.setCor(cor);
        this.setRegiao(regiao);
        this.setExercito(exercito);
        this.setVizinhos(vizinhos);
    }
    
}
