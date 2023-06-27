package br.ufla.gac111.s2021_2.Maniac;


/**
 * Escreva uma descrição da classe ObjetosDesbloqueaveis aqui.
 * 
 * @author Diogo Nunes Carvalho e Maria Paula Zacaroni Silva 
 * @version 1.0
 */
public class ObjetosDesbloqueaveis extends Objeto
{
    private String palavra;
    /**
     * Construtor para objetos da classe ObjetosUsaveis
     */
    public ObjetosDesbloqueaveis(String nome, int peso, String descricao, String palavra, String caminhoImagem)
    {
        super(nome, peso, descricao, caminhoImagem);
        this.palavra = palavra;
    }
    
    // retorna o texto presente no objeto
    public String getPalavra(){
        return palavra;
    }
    
    public Boolean ehDesbloqueavel(){
        return true;
    }

}
