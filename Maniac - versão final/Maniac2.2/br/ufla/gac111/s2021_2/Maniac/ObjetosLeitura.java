package br.ufla.gac111.s2021_2.Maniac;

/**
 * Escreva uma descrição da classe ObjetosLeitura aqui.
 * 
 * @author Diogo Nunes Carvalho e Maria Paula Zacaroni Silva 
 * @version 1.0
 */
public class ObjetosLeitura extends Objeto
{
    private String texto;
    /**
     * Construtor para objetos da classe ObjetosUsaveis
     */
    public ObjetosLeitura(String nome, int peso, String descricao, String texto, String caminhoImagem)
    {
        super(nome, peso, descricao, caminhoImagem);
        this.texto = texto;
    }
    
    // retorna o texto presente no objeto
    public String getTexto(){
        return texto;
    }

}
