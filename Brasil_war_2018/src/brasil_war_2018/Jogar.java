/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brasil_war_2018;

import java.util.ArrayList;

/**
 *
 * @author hprf
 */
public class Jogar {
    ArrayList<Jogador> jogadores;
    Mapa  mapa;
    public Jogar() {
        this.jogadores = new ArrayList<Jogador>();
    }
    
    public void adicionando_jogador_na_lista(String nome, String cor, int exercito ){
        this.jogadores.add(this.criando_jogador(nome, cor, exercito));
        
        //se passou é que já add o jogador na lista
        System.out.print("\n ");
        System.out.println("Jogador adicionado. Nome"+ nome + " e a cor "+ cor);
    }
    public Jogador criando_jogador(String nome, String cor, int exercito){
         Jogador jogador =  new Jogador(nome,cor,exercito);
         return jogador;
    }
    
    public void iniciando_o_mapa(){
        this.mapa =  new Mapa();
    }
    /**
     * Método que vai criar o jogador, escolher a cor e colocar na lista
     * @param jogadores a quantidade de jogadores que vão criar
     * @return caso o jogador seja  
     */
    public boolean iniciando_o_jogo(int jogadores){
        
        if(jogadores > 1){
            //Entrada do teclado
            String nome1 = "Joao";
            String nome2 = "Maria";
            String cor1= "VERMELHO";
            String cor2= "VERDE";
            
            // Chamando o método que cria o jogar e adiciona na lista
            this.adicionando_jogador_na_lista(nome1,cor1,1);
            this.adicionando_jogador_na_lista(nome2,cor2,2);
            // quando tiver entrada pelo teclado coloca aqui a iniciação e as perguntas
            //for(int i = 0; i< jogadores; i++){
                
            //}
            return true;
        }
        else{
            System.out.println("Não dá para jogar sozinho, colega! Ver aí uma pessoa para jogar também!");
            return false;
        }
        
    
    }
    /**
     * 
     * @param j
     * @param mapa 
     */
    public void distribuir(Jogador j,String estado,int quantidade,int limite_distribuicao){
        //implementar o exbir estados que o jogador pode distrubuir
        if(j.getCor().equals(this.mapa.retorna_estado(estado).getCor())){
            
        }
        
    }
    /**
     * Classe principal que acontece o jogo 
     */
    public void jogar (){
        this.iniciando_o_jogo(2);
        this.iniciando_o_mapa();
        this.mapa.exibir_mapa();
    }
    
    
}
