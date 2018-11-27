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
public class Jogador {
    public String nome;
    public String cor;
    public int exercito;

    public Jogador(String nome, String cor, int exercito) {
        this.nome =  nome;
        this.cor = cor;
        this.exercito = exercito;
    }
    
    
    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setExercito(int exercito) {
        this.exercito = exercito;
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
    
    
}
