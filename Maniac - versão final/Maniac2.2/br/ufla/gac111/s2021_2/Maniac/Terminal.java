package br.ufla.gac111.s2021_2.Maniac;
import br.ufla.gac111.s2021_2.baseJogo.InterfaceUsuario;
import br.ufla.gac111.s2021_2.baseJogo.EntidadeGrafica;
import java.util.Scanner;

/**
 * Escreva uma descrição da classe Terminal aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Terminal implements InterfaceUsuario
{
    private Scanner entrada;

    /**
     * Construtor para objetos da classe Terminal
     */
    public Terminal()
    {
        entrada = new Scanner(System.in);
    }
    
    /**
     * Exibe uma nova mensagem para o jogador
     * 
     * @param mensagem Mensagem a ser exibida para o usuário.
     */
    @Override
    public void exibirMensagem(String mensagem){
        System.out.println(mensagem);    
    }
    
    /**
     * Acrescenta informação à uma mensagem anterior
     * 
     * @param mensagem Informação a ser acrecentada na mensagem anterior
     */
    @Override
    public void continuarMensagem(String mensagem){
        System.out.println(mensagem);
    }
    
    /**
     * Obtém um comando do jogador. Deve ser chamado apenas na classe Analisador.
     */
    @Override
    public String obterComando(){
        return entrada.nextLine();
    }
    
    /**
     * Obtém uma informação do usuário como String. 
     * 
     * Obs.: não deve ser usado para comandos. No caso de comandos use 'obterComando'.
     * 
     * @param instrucao Mensagem de instrução para o usuário (diz qual informação está sendo solicitada)
     */
    @Override
    public String obterInformacao(String instrucao){
        System.out.println(instrucao);
        return entrada.nextLine();
    }
    
    /**
     * Informa a Interface do Usuário que o jogador mudou de ambiente.
     * 
     * @param ambiente Objeto do novo ambiente atual.
     */
    @Override
    public void ambienteAtualMudou(EntidadeGrafica ambiente){   
    }
    
    /**
     * Informa a Interface do Usuário que o jogador pegou um item (ou similar).
     * 
     * @param item Objeto do item que o usuário pegou.
     */
    @Override
    public void jogadorPegouItem(EntidadeGrafica item){
    }
    
    /**
     * Informa a Interface do Usuário que o jogador não tem mais um item (ou similar).
     * 
     * @param item Objeto do item que o usuário não tem mais.
     */
    @Override
    public void jogadorDescartouItem(EntidadeGrafica item){
    }

}
