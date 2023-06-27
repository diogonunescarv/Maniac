package br.ufla.gac111.s2021_2.Maniac;

/**
 * Escreva uma descrição da classe ObjetosUsaveis aqui.
 * 
 * @author Diogo Nunes Carvalho e Maria Paula Zacaroni Silva 
 * @version 1.0
 */
public class ObjetosUsaveis extends Objeto
{
    /**
     * Construtor para objetos da classe ObjetosUsaveis
     */
    public ObjetosUsaveis(String nome, int peso, String descricao, String caminhoImagem)
    {
        super(nome, peso, descricao, caminhoImagem);
    }
    
    public Boolean ehCarregavel(){
        return true;
    }

}
