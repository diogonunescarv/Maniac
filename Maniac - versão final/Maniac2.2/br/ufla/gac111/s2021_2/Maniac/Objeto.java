package br.ufla.gac111.s2021_2.Maniac;
import br.ufla.gac111.s2021_2.baseJogo.EntidadeGrafica;

/**
 * Define um objeto com nome, peso e uma descrição (explicação de como devemos utilizar tal objeto).
 * 
 * @author Maria Paula Zacaroni Sivla 
 * @version 1.0
 */
public class Objeto extends EntidadeGrafica
{
    private String nome;
    private int peso;
    private String descricao;

    /**
     * Construtor para objetos da classe Objeto
     */
    public Objeto(String nome, int peso, String descricao, String caminhoImagem){
        super(caminhoImagem);
        this.nome = nome;
        this.peso = peso; // em gramas
        this.descricao = descricao;
    }

    public String getNome(){
        return nome;
    }
    
    public String getDescricao(){
        return descricao;
    }
    
    public int getPeso(){
        return peso;
    }
    
    public String getTexto(){
        return null;
    }
    
    public Boolean ehCarregavel(){
        return false;
    }
    
    public Boolean ehDesbloqueavel(){
        return false;
    }
    
    public String getPalavra(){
        return null;
    }
}
