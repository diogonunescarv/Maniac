package br.ufla.gac111.s2021_2.Maniac;
import br.ufla.gac111.s2021_2.baseJogo.InterfaceUsuario;
//import br.ufla.gac111.s2021_2.baseJogo.Terminal;

public class Programa {
    public static void main(String[] args) {
        InterfaceUsuario iu = new Terminal();
        String nomeJogador = iu.obterInformacao("Digite o nome do seu personagem: \n");
        Jogo jogo = new Jogo(iu, nomeJogador);
        
        jogo.jogar();
    }

}
