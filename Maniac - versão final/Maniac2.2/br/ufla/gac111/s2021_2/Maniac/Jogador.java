package br.ufla.gac111.s2021_2.Maniac;

import java.util.ArrayList;
/**
 * Define o jogador com nome e uma mochila que vai ser onde ele irá carregar os objetos encontrados no decorrer do jogo.
 * 
 * @author Maria Paula Zacaroni Silva 
 * @version 1.0
 */
public class Jogador
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private String nome;
    private ArrayList<Objeto>mochila;
    private static int limitePeso = 250;

    /**
     * Construtor para objetos da classe Jogador
     */
    public Jogador(String nome)
    {
        this.nome = nome;
        mochila = new ArrayList<>();
    }
    
    /**
     * Retorna o nome do jogador
     */
    public String getNome(){
        return nome;
    }
    
    /**
     * Se caso houver espaço, adiciona um objeto a mochila do jogador
     */
    public boolean adcionarObjeto(Objeto objeto){
        int soma = pesoAtual() + objeto.getPeso();
        
        if (soma <= limitePeso){
            mochila.add(objeto);
            return true;
        } else{
            return false;
        }
    }
    
    /**
     * Remove um objeto da mochila do jogador
     */
    public Objeto removerObjeto(String nomeObjeto){
        Objeto aux = null;
        for (Objeto objeto : mochila){
            if (objeto.getNome().equals(nomeObjeto)){
                aux = objeto; 
            }
        } 
        
        if (aux != null){
            mochila.remove(aux);
        }
        
        return aux;
    } 
    
    /**
     * Enumera os objetos presentes na mochila do jogador
     */
    public String itensMochila(){
        String itens = "Itens na mochila: ";
        for (int i = 0; i < mochila.size(); i++){
            itens += mochila.get(i).getNome() + " ";
        }
        return itens;
    }
    
    /**
     * Verifica a existencia ou não de objetos da mochila do jogador
     */
    public boolean existeItem(String nomeObjeto){
        for (Objeto objeto : mochila){
            if (objeto.getNome().equals(nomeObjeto)){
                return true;
            } 
        } 
        
        return false;
    }
    
    /**
     * Calcula o peso atual da mochila do jogador
     */
    public int pesoAtual(){
        int peso = 0;
        
        for (Objeto o : mochila){
            peso += o.getPeso();
        }
        
        return peso;
    }
}
