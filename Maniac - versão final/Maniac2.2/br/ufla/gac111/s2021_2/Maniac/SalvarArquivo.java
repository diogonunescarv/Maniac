package br.ufla.gac111.s2021_2.Maniac;

import java.io.File;
import java.io.FileWriter;

/**
 * Classe utilizada para a realização da criação e escrita de um arquivo .txt que apresenta informações importantes.
 * 
 * @Diogo Nunes Carvalho e Maria Paula Zacaroni Silva
 * @1.0
 */
public class SalvarArquivo
{

    /**
     * Escreve o tempo que os jogadores levaram para completar ou não o jogo em um arquivo .txt
     */
    public static void salvamentoArquivo(String nome, long tempoJogado, String complemento)
    {
        //transformação do tempo jogado
        tempoJogado = tempoJogado/1000; 
        int minutos = (int) tempoJogado/60; 
        int segundos = (int) tempoJogado%60; 
        
        File arquivo = new File("desempenhoJogadores.txt");
        try {
            // Verifica se o arquivo existe
            if (!arquivo.exists()) {
                // Cria um arquivo (vazio)
                arquivo.createNewFile();
                
                // Cria um objeto da classe escritora de arquivo
                FileWriter arq = new FileWriter(arquivo);
                
                // Escreve no arquivo
                arq.write(nome + " jogou por " + minutos + " min e " + segundos + " segundos " + complemento + "\n");
                arq.close();
            }
            else {
                // Cria um objeto da classe escritora de arquivo
                // O construtor recebe também como argumento se o conteúdo será acrescentado ao invés de ser substituído (append)
                FileWriter arq = new FileWriter(arquivo, true);
                
                // Escreve no arquivo
                arq.write(nome + " jogou por " + minutos + " min e " + segundos + " segundos " + complemento + "\n");
                arq.close();
            }
        } catch (Exception e) {}
        
    }

}
