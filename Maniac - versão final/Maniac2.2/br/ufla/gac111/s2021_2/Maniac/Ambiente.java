package br.ufla.gac111.s2021_2.Maniac;
import br.ufla.gac111.s2021_2.baseJogo.EntidadeGrafica;
import java.util.HashMap;

/**
 * Classe Ambiente - um ambiente em um jogo adventure.
 *
 * Esta classe eh parte da aplicacao "World of Zuul".
 * "World of Zuul" eh um jogo de aventura muito simples, baseado em texto.  
 *
 * Um "Ambiente" representa uma localizacao no cenario do jogo. Ele eh
 * conectado aos outros ambientes atraves de saidas. As saidas sao
 * nomeadas como norte, sul, leste e oeste. Para cada direcao, o ambiente
 * guarda uma referencia para o ambiente vizinho, ou null se nao ha
 * saida naquela direcao.
 * 
 * @author  Michael Kölling and David J. Barnes (traduzido por Julio Cesar Alves)
 * @version 2011.07.31 (2016.02.01)
 */

public class Ambiente extends EntidadeGrafica
{
    private String descricao;
    private String direcaoBloq;
    private String itemDesbloq;
    private HashMap<String, Ambiente> saidas;
    private HashMap<String, Objeto> objetosAmbiente;
    
    /**
     * Cria um ambiente com a "descricao" passada. Inicialmente, ele
     * nao tem saidas. "descricao" eh algo como "uma cozinha" ou
     * "
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "um jardim aberto".
     * @param descricao A descricao do ambiente.
     */
    public Ambiente(String caminho, String descricao) 
    {
        super(caminho);
        this.descricao = descricao;
        direcaoBloq = "";
        itemDesbloq = "";
        saidas = new HashMap<>();
        objetosAmbiente = new HashMap<>();
    }
    
    public Ambiente(String caminho, String descricao, Objeto objeto1){
        this(caminho, descricao);
        objetosAmbiente.put(objeto1.getNome(),objeto1);
    }
    
    /**
     * Consulta a existencia de um determinado objeto em um ambiente
     */
    public boolean consultarObjeto(String nomeObjeto){
        if (objetosAmbiente.get(nomeObjeto) != null){
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Remove o objeto de um ambiente
     */
    public Objeto removerItem(String nomeObjeto){
        Objeto aux;
        
        if (consultarObjeto(nomeObjeto)){ 
            aux = objetosAmbiente.remove(nomeObjeto);
            return aux;
        }
        
        return null;
    } 
    
    // Adiciona o objeto no ambiente
    public void adicionarObjeto(Objeto novoObjeto){
        objetosAmbiente.put(novoObjeto.getNome(), novoObjeto);
    }
    
    /**
     * Retorna o texto presente em um objeto que é possível realizar este tipo de leitura
     */
    public String lerObjeto (String nomeObjeto){
        if (consultarObjeto(nomeObjeto)){ 
            return objetosAmbiente.get(nomeObjeto).getTexto();
        }
        return null;
    }
    
    /**
     * Verifica se um objeto é pegavel ou não
     */
    public Boolean ehPegavel(String nomeObjeto){
        return objetosAmbiente.get(nomeObjeto).ehCarregavel();
    }
    
    /**
     * Verifica se um objeto é desbloqueavel ou não
     */
    public Boolean ehDesbloqueavel(String nomeObjeto){
        return objetosAmbiente.get(nomeObjeto).ehDesbloqueavel();
    }
    
    /**
     * Retorna um ambiente de acordo com a direção passada por parâmetro
     */
    public Ambiente getSaida(String direcao){
        if (direcao.equals(direcaoBloq)){
            return null;    
        } else {
            return saidas.get(direcao);
        }
    }
    
    /**
     * Define ambiente para uma dada direção
     */
    public void ajustarSaida(String direcao, Ambiente saida){
        if (saida != null){
            saidas.put(direcao, saida);
        }
    }
    
    /**
     * Enumera as possiveis saidas de um determinado ambiente
     */
    public String getSaidasPossiveis(){
        String retorno = "";
        for(String direcao : saidas.keySet()){
            retorno += direcao + " ";
        }
        return retorno;
    }
    
    /**
     * @return A descricao do ambiente.
     */
    public String getDescricao()
    {
        return descricao;
    }
    
    /**
     * Cria um ambiente para o local, ou seja, retorna uma descrição para o ambiente atual
     */
    public String getDescricaoLonga(){
        String descricaoLonga = "\n" + "Você está " + getDescricao() + "\n\n" + "Objetos no ambiente: " + "\n";
        String descricaoSaidas = "Saídas: " + getSaidasPossiveis() + "\n";
        if (objetosAmbiente.isEmpty()){
            descricaoLonga += "Não há nada aqui" + "\n\n" + descricaoSaidas;
            return descricaoLonga;
        }
        else{
            return descricaoLonga += getDescricaoObjetos() + "\n" + descricaoSaidas ; 
        }
    }
    
    /**
     * Retorna os objetos e suas respectivas descrições
     */
    public String getDescricaoObjetos(){
        String descricao = "";
        for (String s : objetosAmbiente.keySet()){
            descricao += objetosAmbiente.get(s).getNome() + "\n" + "Descrição do(a) " + s + ": "+ objetosAmbiente.get(s).getDescricao() + "\n";
        }
        return descricao;
    }
    
    
    public void ajustarSaidaBloqueada(String direcao, Ambiente ambiente, String nomeItem){
        ajustarSaida(direcao, ambiente);
        direcaoBloq = direcao;
        itemDesbloq = nomeItem;
    }
    
    /**
     * Verifica se o item utilizado desbloqueia a passagem desejada
     */
    public boolean usarItem(String objeto){
        if (objeto.equals(itemDesbloq)){
            direcaoBloq = "";
            return true;
        }else {
            return false;
        }
    }
    
    @Override
    public String getNome(){
        return descricao;
    }
    
    /**
     * Verifica a palavra de desbloqueio de um determinado objeto
     */
    public String palavraDesbloqueio(String nomeObjeto){
        if (consultarObjeto(nomeObjeto)){ 
            return objetosAmbiente.get(nomeObjeto).getPalavra();
        }
        return null;        
    }
    
}
