/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brasil_war_2018;

import java.awt.List;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author hprf
 */
public class Mapa {
    private ArrayList<Estado> estados ;
    private String nome_regiao [] = new String[5];

    public Mapa() {
        this.estados  = new ArrayList();
        this.iniciar_mapa();
        
    }
    
    public void somar_exercito(int quantidade){
        
    }
    /**
     * Retorna o objeto estado que foi procurado pelo nome 
     * @param nome nome do estado que está procurando
     * @return  o objeto estado que tem o nome
     */
    public Estado retorna_estado(String nome){
        
        for(int i = 0; i< this.estados.size(); i++){
            if(this.estados.get(i).getNome().equals(nome)){
                return this.estados.get(i); 
            }
        }
        return null;
    }
    /**
     * Método que retorna a lista de estados que tem a mesma cor
     * @param cor a cor do exercíto que domina o estado
     * @return retorna a lista de estados
     */
    public ArrayList lista_de_estados_cor(String cor){
        ArrayList<Estado> temp = new ArrayList();
        for(int i = 0; i< this.estados.size();i++ ){
            
            if(this.estados.get(i).equals(cor)){
                temp.add(this.estados.get(i));
            }
        }
        return temp;
    
    }
    /**
     * Método chama a chamada de uma função do tipo private que realiza a opera-
     * ção de preenchimento da lista estados.
     * Também faz a chamada para preencher a tabela que contém os nomes das regiões do país.
     * @param estados lista que contém todos os estados
     */
    public void iniciar_mapa(){
        this.preenchendo_regiao(this.nome_regiao);
        this.preenchendo_estados(this.estados);
        
    }
    
    public void exibir_mapa(){
        System.out.println("-----------------MAPA--------------------");
        for(int i = 0 ; i < this.nome_regiao.length ; i++){
                
            System.out.println("-->> REGIÂO: " + nome_regiao[i]);
            
                //Estado t = (Estado) this.estados.iterator();
                String estado = this.nome_regiao[i];
                for(int y = 0; y< this.estados.size();y++){
                Estado temp = (Estado) this.estados.get(y);
                
                if(estado.equals(temp.getRegiao())){
                    
                    System.out.println(temp.getNome()+" "+ temp.getCor() + " "+ temp.getExercito()  );
                }
                
            }
        }
        System.out.println("---------------------///--------------------");
        
    }
    /**
     * Método para preencher a lista que tem o nome das regiões para exbir na tela
     * ajudando nos for necessários do código
     * @param nome_regiao lista com o nome das regiões 
     */
    public void preenchendo_regiao(String [] nome_regiao ){
        
        this.nome_regiao[0]= "NORTE";
        this.nome_regiao[1]= "NORDESTE";
        this.nome_regiao[2]= "CENTRO-OESTE";
        this.nome_regiao[3]= "SUDESTE";
        this.nome_regiao[4]= "SUL";
        
    }
    /**
     * Método para escolher entre duas cores caso esteja jogando 2 jogadores.
     * @param cor1
     * @param cor2
     * @return 
     */
    public String cor_randomica(String cor1, String cor2){
        Random gerador = new Random();
        if(gerador.nextInt(100)<=49){
            return cor1;
        }
        return cor2;
    }
    /** 
     * Método  que auxilia na distribiucao randomica das cores para os estados. 
     * O método será usado quando umas das cores já preencher a quantidade de estados
     * e sobra o restante de estados sem cor para preencher com a cor que não completou a quantidade.
     * 
     * @param qtd_cor1 a quantidade de vezes que a cor 1 foi escolhida. Caso ela já completou os 12 estados ela
     * retorna o valor 2 indicando para a função que chamou que a cor 2 deve preencher o restante dos estados
     * @param qtd_cor2 caso a cor dois já preencheu todos os estados ela retorna 1 indicando que a cor 1 que deve ser usada.
     * @return a indicação da cor que deve ser usada. 1 para cor 1 e 2 para a cor2 .
     */
    private int cor_escolhida(int qtd_cor1, int qtd_cor2){
        if(qtd_cor1 == 12){
            return 2;
        }
        return 1;
            
    }
    /** 
     * Método que distribui a cor entre os estados de forma randomica entre dois jogadores,
     * ou seja, 12 estados para cada jogador
     * @param quantidade_jogadores
     * @return 
     */
    public void distruibuir_cor_dois_jogadores(int quantidade_jogadores,String cor1,String cor2){
        
        if(quantidade_jogadores == 2){
        int qtd_cor1=0,qtd_cor2=0;    
            
            for(int i =0; i<this.estados.size();i++){
                this.estados.get(i).setCor(this.cor_randomica(cor1, cor2));
                //Caso nenhuma das cores já completou 12 estados
                if(qtd_cor1 < 12 && qtd_cor2 < 12 ){
                    if(this.estados.get(i).getCor().equals(cor1)){
                        
                        qtd_cor1++;
                    }
                    else{
                        
                         qtd_cor2++;
                    }
                }
                //Caso uma das cores já completou 12 estados os estados que faltam 
                //irão receber a cor que não chegou a quantidade de 12 estados
                else{
                    if(this.cor_escolhida(qtd_cor1, qtd_cor2)==1){
                        this.estados.get(i).setCor(cor1);
                    }
                    else{
                        this.estados.get(i).setCor(cor2);
                    }
                    
                    
                }
            }
            
        }
       // return null;
    }
            
    /**
     * Método que cria todos os estados e coloca na lista de estados. Com as 
     * informações de nome, cor, quantidade do exercíto e os estados vizinhos
     * @param estados lista que contém todos os estados
     */
    private void preenchendo_estados(ArrayList estados){
        // ACRE
        String vizinhos_0 [] = new String[3];
        vizinhos_0[0]="AM";
        vizinhos_0[1]="AC";
        vizinhos_0[2]="RO";
        Estado estado0 =  new Estado("AC","VERDE","NORTE",1,vizinhos_0);
        this.estados.add(estado0);
        
        // AMAZONAS 
        String vizinhos_1 [] = new String[6];
        vizinhos_1[0]="AM";
        vizinhos_1[1]="AC";
        vizinhos_1[2]="RR";
        vizinhos_1[3]="RO";
        vizinhos_1[4]="RR";
        vizinhos_1[5]="AM";
        Estado estado1 =  new Estado("AM","VERDE","NORTE",1,vizinhos_1);
        this.estados.add(estado1);
        
        
        // AMAPÁ
        String vizinhos_2 [] = new String[2];
        vizinhos_2[0]="AP";
        vizinhos_2[1]="PA";
        Estado estado2 =  new Estado("AP","AZUL","NORTE",1,vizinhos_2);
        this.estados.add(estado2);
        
        // PARÁ
        String vizinhos_3 [] = new String[7];
        vizinhos_3[0]="PA";
        vizinhos_3[1]="AP";
        vizinhos_3[2]="AM";
        vizinhos_3[3]="GO";
        vizinhos_3[4]="MT";
        vizinhos_3[5]="RR";
        vizinhos_3[6]="MA";
        Estado estado3 =  new Estado("PA","VERMELHO","NORTE",1,vizinhos_3);
        this.estados.add(estado3);
        
        // RONDÔNIA
        String vizinhos_4 [] = new String[4];
        vizinhos_4[0]="RO";
        vizinhos_4[1]="MT";
        vizinhos_4[2]="AM";
        vizinhos_4[3]="AC";
        Estado estado4 =  new Estado("RO","AZUL","NORTE",1,vizinhos_4);
        this.estados.add(estado4);
        
        // RORAIMA
        String vizinhos_5 [] = new String[3];
        vizinhos_5[0]="RR";
        vizinhos_5[1]="AM";
        vizinhos_5[2]="PA";
        Estado estado5 =  new Estado("RR","VERMELHO","NORTE",1,vizinhos_5);
        this.estados.add(estado5);
        
        // ALAGOAS
        String vizinhos_6 [] = new String[4];
        vizinhos_6[0]="AL";
        vizinhos_6[1]="PE";
        vizinhos_6[2]="BA";
        vizinhos_6[3]="SE";
        Estado estado6 =  new Estado("AL","AZUL","NORDESTE",1,vizinhos_6);
        this.estados.add(estado6);
        
        // BAHIA
        String vizinhos_7 [] = new String[8];
        vizinhos_7[0]="BA";
        vizinhos_7[1]="AL";
        vizinhos_7[2]="SE";
        vizinhos_7[3]="PE";
        vizinhos_7[4]="PI";
        vizinhos_7[5]="GO";
        vizinhos_7[6]="MG";
        vizinhos_7[7]="ES";
        Estado estado7 =  new Estado("BA","AZUL","NORDESTE",1,vizinhos_7);
        this.estados.add(estado7);
        
        // CEARÁ
        String vizinhos_8 [] = new String[5];
        vizinhos_8[0]="CE";
        vizinhos_8[1]="RN";
        vizinhos_8[2]="PB";
        vizinhos_8[3]="PE";
        vizinhos_8[4]="PI";
        Estado estado8 =  new Estado("CE","VERDE","NORDESTE",1,vizinhos_8);
        this.estados.add(estado8);
        
        // MARANHÃO
        String vizinhos_9 [] = new String[4];
        vizinhos_9[0]="MA";
        vizinhos_9[1]="PI";
        vizinhos_9[2]="GO";
        vizinhos_9[3]="PA";
        Estado estado9 =  new Estado("MA","AZUL","NORDESTE",1,vizinhos_9);
        this.estados.add(estado9);
        
        // PERNAMBUCO
        String vizinhos_10 [] = new String[6];
        vizinhos_10[0]="PE";
        vizinhos_10[1]="PB";
        vizinhos_10[2]="BA";
        vizinhos_10[3]="AL";
        vizinhos_10[4]="PI";
        vizinhos_10[5]="CE";
        Estado estado10 =  new Estado("PE","VERMELHO","NORDESTE",1,vizinhos_10);
        this.estados.add(estado10);
        
        // PARAÍBA
        String vizinhos_11 [] = new String[4];
        vizinhos_11[0]="PB";
        vizinhos_11[1]="PE";
        vizinhos_11[2]="RN";
        vizinhos_11[3]="CE";
        Estado estado11 =  new Estado("PB","VERMELHO","NORDESTE",1,vizinhos_11);
        this.estados.add(estado11);
        
        // PIAUÍ
        String vizinhos_12 [] = new String[5];
        vizinhos_12[0]="PI";
        vizinhos_12[1]="CE";
        vizinhos_12[2]="MA";
        vizinhos_12[3]="BA";
        vizinhos_12[4]="PE";
        Estado estado12 =  new Estado("PI","VERDE","NORDESTE",1,vizinhos_12);
        this.estados.add(estado12);
        
        // RIO GRANDE DE NORTE
        String vizinhos_13 [] = new String[3];
        vizinhos_13[0]="RN";
        vizinhos_13[1]="PB";
        vizinhos_13[2]="CE";
        Estado estado13 =  new Estado("RN","VERDE","NORDESTE",1,vizinhos_13);
        this.estados.add(estado13);
        
        // ESPÍRIO SANTO
        String vizinhos_14 [] = new String[4];
        vizinhos_14[0]="ES";
        vizinhos_14[1]="BA";
        vizinhos_14[2]="RJ";
        vizinhos_14[3]="MG";
        Estado estado14 =  new Estado("ES","VERMELHO","SUDESTE",1,vizinhos_14);
        this.estados.add(estado14);
        
        // MINAS GERAIS
        String vizinhos_15 [] = new String[7];
        vizinhos_15[0]="MG";
        vizinhos_15[1]="BA";
        vizinhos_15[2]="ES";
        vizinhos_15[3]="RJ";
        vizinhos_15[4]="SP";
        vizinhos_15[5]="MT";
        vizinhos_15[6]="GO";
        Estado estado15 =  new Estado("MG","AZUL","SUDESTE",1,vizinhos_15);
        this.estados.add(estado15);
        
        // RIO DE JANEIRO
        String vizinhos_16 [] = new String[4];
        vizinhos_16[0]="RJ";
        vizinhos_16[1]="SP";
        vizinhos_16[2]="MG";
        vizinhos_16[3]="ES";
        Estado estado16 =  new Estado("RJ","VERDE","SUDESTE",1,vizinhos_16);
        this.estados.add(estado16);
        
        // SÃO PAULO
        String vizinhos_17 [] = new String[5];
        vizinhos_17[0]="SP";
        vizinhos_17[1]="RJ";
        vizinhos_17[2]="MG";
        vizinhos_17[3]="PR";
        vizinhos_17[4]="MT";
        Estado estado17 =  new Estado("SP","VERMELHO","SUDESTE",1,vizinhos_17);
        this.estados.add(estado17);
        
        // GOÍAS
        String vizinhos_18 [] = new String[7];
        vizinhos_18[0]="GO";
        vizinhos_18[1]="BA";
        vizinhos_18[2]="MG";
        vizinhos_18[3]="MT";
        vizinhos_18[4]="PA";
        vizinhos_18[5]="MA";
        vizinhos_18[6]="PI";
        Estado estado18 =  new Estado("GO","AZUL","CENTRO-OESTE",1,vizinhos_18);
        this.estados.add(estado18);
        
        // MATO GROSSO
        String vizinhos_19 [] = new String[8];
        vizinhos_19[0]="MT";
        vizinhos_19[1]="GO";
        vizinhos_19[2]="SP";
        vizinhos_19[3]="PR";
        vizinhos_19[4]="MG";
        vizinhos_19[5]="RO";
        vizinhos_19[6]="AM";
        vizinhos_19[7]="PA";
        Estado estado19 =  new Estado("MT","VERMELHO","CENTRO-OESTE",1,vizinhos_19);
        this.estados.add(estado19);
        
        // PARANÁ
        String vizinhos_20 [] = new String[4];
        vizinhos_20[0]="PR";
        vizinhos_20[1]="SP";
        vizinhos_20[2]="SC";
        vizinhos_20[3]="MT";
        Estado estado20 =  new Estado("PR","VERMELHO","SUL",1,vizinhos_20);
        this.estados.add(estado20);
        
        // RIO GRANDE DO SUL
        String vizinhos_21 [] = new String[2];
        vizinhos_21[0]="RS";
        vizinhos_21[1]="SC";
        Estado estado21 =  new Estado("RS","VERDE","SUL",1,vizinhos_21);
        this.estados.add(estado21);
        
        // SANTA CATARINA
        String vizinhos_22 [] = new String[3];
        vizinhos_22[0]="SC";
        vizinhos_22[1]="RS";
        vizinhos_22[2]="PR";
        Estado estado22 =  new Estado("SC","VERMELHO","SUL",1,vizinhos_22);
        this.estados.add(estado22);
        
        // SERGIPE
        String vizinhos_23 [] = new String[3];
        vizinhos_23[0]="SE";
        vizinhos_23[1]="AL";
        vizinhos_23[2]="BA";
        Estado estado23 =  new Estado("SE","AZUL","NORDESTE",1,vizinhos_23);
        this.estados.add(estado23);
        
    }
}
