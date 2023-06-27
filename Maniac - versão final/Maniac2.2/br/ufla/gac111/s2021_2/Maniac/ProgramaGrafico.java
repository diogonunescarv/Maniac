package br.ufla.gac111.s2021_2.Maniac;
import br.ufla.gac111.s2021_2.baseJogo.Tela;
import br.ufla.gac111.s2021_2.baseJogo.InterfaceUsuario;

public class ProgramaGrafico {
    public static void main(String[] args) {
        InterfaceUsuario iu = new Tela("Maniac");
        String nomeJogador = iu.obterInformacao("Digite o nome do seu personagem: \n");
        Jogo jogo = new Jogo(iu, nomeJogador);
        
        jogo.jogar();
    }

}
