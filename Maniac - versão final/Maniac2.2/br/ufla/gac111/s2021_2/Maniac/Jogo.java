package br.ufla.gac111.s2021_2.Maniac;

import java.util.Deque;
import java.util.LinkedList;
import br.ufla.gac111.s2021_2.baseJogo.InterfaceUsuario;
import br.ufla.gac111.s2021_2.baseJogo.EntidadeGrafica;

/**
 *  Essa eh a classe principal da aplicacao "World of Zull".
 *  "World of Zuul" eh um jogo de aventura muito simples, baseado em texto.
 *  Usuarios podem caminhar em um cenario. E eh tudo! Ele realmente
 *  precisa ser estendido para fazer algo interessante!
 * 
 *  Para jogar esse jogo, crie uma instancia dessa classe e chame o metodo
 *  "jogar".
 * 
 *  Essa classe principal cria e inicializa todas as outras: ela cria os
 *  ambientes, cria o analisador e comeca o jogo. Ela tambeme avalia e 
 *  executa os comandos que o analisador retorna.
 * 
 * @author  Diogo Nunes Carvalho e Maria Paula Zacaroni Silva
 * @version 1.0
 */

public class Jogo 
{
    private Analisador analisador; // pega a entrada do jogador - definido por quem joga
    private Ambiente ambienteAtual;
    private Ambiente ambienteInicio;
    private Ambiente ambienteVitoria;
    private Ambiente fora;
    private Jogador jogador;
    private Deque<Ambiente> ambientesVisitados;
    private InterfaceUsuario iu;
    private long tempoInicio;
    
    /**
     * Cria o jogo e incializa seu mapa interno.
     */
    public Jogo(InterfaceUsuario iu, String nomeJogador) {
        this.iu = iu;
        criarAmbientes();
        analisador = new Analisador(iu);
        jogador = new Jogador(nomeJogador);
        ambientesVisitados = new LinkedList<>();
        tempoInicio = System.currentTimeMillis();
    }

    /**
     * Cria todos os ambientes e liga as saidas deles
     */
    private void criarAmbientes()
    {
        Ambiente cozinha, cantina, salaDeRemedios, jardim, sotao1, escritorio, sotao2, salaDeEstar, sotao3, corredor1, corredor2, corredor3, ala1, ala2, ala3, ala4, quartoAla3;
        ObjetosUsaveis lanternaVerde = new ObjetosUsaveis("LanternaVerde", 90, "Use a lanterna para iluminar seu caminho. Utilize para entrar em locais com pouca luz...", "Imagens/LanternaAzul.jpg");
        ObjetosUsaveis lanternaVermelha = new ObjetosUsaveis("LanternaVermelha", 90, "Use a lanterna para iluminar seu caminho. Utilize para entrar em locais escuros...", "Imagens/LanternaVermelha.jpg");
        ObjetosUsaveis lanternaAmarela = new ObjetosUsaveis("LanternaAmarela", 90, "Use a lanterna para iluminar seu caminho. Utilize para entrar em locais completamente escuros...", "Imagens/LanternaAmarela.jpg");
        ObjetosUsaveis canivete = new ObjetosUsaveis("Canivete",75, "Use o canivete para se proteger!", "Imagens/Canivete.jpg");
        ObjetosDesbloqueaveis bauComChaves = new ObjetosDesbloqueaveis("bauComChaves", 60, "Desbloqueie com uma palvra para conseguir descobrir o que tem dentro!", "Alzheimer","Imagens/BauFechado.jpg");
        ObjetosUsaveis chave = new ObjetosUsaveis("Chave",5, "Guarde a chave, ela pode ser útil em algum momento!", "Imagens/Chave.jpg");
        ObjetosLeitura livroFamilia = new ObjetosLeitura("LivroFamilia", 200, "Neste livro estão presentes histórias sobre a família Thompson!", "A família Thompson era muito respeitada no ano de 1890, e conseguiram conquistar muitas riquezas por conta de seu esforço para construir o PRIMEIRO hospital psiquiátrico da cidade de Barbacena e um dos primeiros do Brasil. \nPara isso, muitas histórias sugiram de que eles tinham feito pacto, ou que roubaram, ou até mesmo que vieram fugidos de outra cidade. Mas a real história é que eles trabalharam muito para conquistar suas riquezas e ao final da vida, a bisavó do Senhor Thompson sofreu da doença do esquecimento (nome dado naquela época, para o que conhecemos hoje como Alzheimer). \nPor isso, senhor Thompson resolveu construir um ambiente 'seguro' para sua bisavó, onde tivessem padres e exorcistas para tentarem salvá-la. \nCom o tempo, outros tipos de doenças (na época, eram conhecidas como maldição) foram 'tratados' lá e o ambiente foi crescendo cada vez mais, até o dia em que resolveram fechar por conta das atrocidades que os doentes sofriam!!", "Imagens/LivroAntigoAberto.jpg");
        ObjetosLeitura cartaoPostal1 = new ObjetosLeitura("CartaoPostal1", 5, "Cartão Postal enviado pelo avô do Sr. Thompson (marido de sua avó que estava internada)", "Olá meu amor, \nespero que se lembre de mim com o mesmo carinho que eu me lembro de quando visitamos este lugar pela primeira vez! \nFique bem logo, amo você!", "Imagens/CartaoPostal.jpg");
        ObjetosLeitura cartaoPostal2 = new ObjetosLeitura("CartaoPostal2", 5, "Cartão Postal enviado pelo filho do Sr. Thompson (neto de sua avó que estava internada, ele não sabia das condições de sua avó)", "Bom dia vovó, \na senhora disse que estaria na primeira fileira no meu primeiro concerto de música, espero que você e o vovô não tenham se esquecido. Aguardo vocês lá! \nCom amor, do seu neto.", "Imagens/CartaoPostal2.jpg");
        
        // cria os ambientes com as imagens
        fora = new Ambiente("Imagens/PortaTrancada1.jpg", "na entrada do manicômio! Ela costumava ser mais apresentável, porém, com o tempo, começaram a ter histórias perturbadoras sobre tal construção e colocaram uma fechadura na esperança de não deixar o que estava la dentro sair.");
        cozinha= new Ambiente("Imagens/Cozinha1.jpg","na cozinha do manicômio!", canivete);
        cantina = new Ambiente("Imagens/Cantina1.jpg","na cantina do manicômio!");
        salaDeRemedios = new Ambiente("Imagens/SalaDeRemedio.jpg","na sala de remédios. \nDesça as escadas caso queira ir ao sótão.", lanternaVermelha);
        sotao1 = new Ambiente ("Imagens/Sotao.jpg","no sótão da sala de remédios. \nSuba as escadas para voltar à sala de remédios.", cartaoPostal1);
        jardim = new Ambiente("Imagens/Jardim1.jpg","no jardim do manicômio. \nCostumava ser o lugar mais bonito de todo ambiente, aqui todos se sentiam livres!", cartaoPostal2);
        corredor1 = new Ambiente ("Imagens/Corredor1.png","no corredor que da acesso ao escritório e a sala de recriação!");
        escritorio = new Ambiente ("Imagens/ADM1.jpg","no escritório do manicômio! \nAqui é onde ficavam todos os arquivos dos doentes. \nDesça as escadas caso queira ir ao sótão.", livroFamilia);
        sotao2 = new Ambiente ("Imagens/Sotao.jpg","no sótão do escritório. \nTodos os arquivos antigos foram arquivados aqui! \nSuba as escada para voltar ao escritório.");
        salaDeEstar = new Ambiente ("Imagens/SalaDeEstar1.png","na sala de recriação. \nEra onde os doentes costumavam passar a maior parte do tempo. \nAqui eles podiam pintar, contar histórias, ler, desenhar, jogar jogos, entre outras atividades que ajudavam a manter eles conectados uns com os outros.  \nDesça as escadas caso queira ir ao sótão.", lanternaVerde);
        sotao3 = new Ambiente ("Imagens/Sotao.jpg","no sótão da sala de recriação. \nAqui é onde eles guardavam todo o material usado. \nSuba as escadas para voltar à sala de recriação.", chave);
        corredor2 = new Ambiente ("Imagens/Corredor2.jpg","no corredor que da acesso às alas Verde e Amarela dos quartos. \nCuidado ao entrar em uma porta!");
        corredor3 = new Ambiente ("Imagens/Corredor4.jpeg","no corredor que da acesso às alas Vermelha e Roxa dos quartos. \nCuidado ao entrar em uma porta!");
        ala1 = new Ambiente ("Imagens/QuartoALA1.jpg","na ala Verde (ALA1) da construção. \nEssa foi a primeira ala construída no casarão. \nCom o tempo ela foi se expandindo e ficavam os internados por um curto tempo pré-determinado! \nTipo de medicaçao: fraca, 2 vezes ao dia.");
        ala2 = new Ambiente ("Imagens/QuartoALA2.jpg","na ala Amarela (ALA2) da construção. \nNessa área ficavam os internados por um longo tempo pré-estabelecido! \nEles ficavam em quartos coletivos de, no máximo, 4 pessoas. \nTipo de medicaçao: fraca, 3 vezes ao dia.");
        ala3 = new Ambiente ("Imagens/QuartoALA3.jpg","na ala Vermelha (ALA3) da construção. \nNessa área ficavam os internados por tempo indeterminado, ou seja, os que precisavam que presença médica a todo momento!  \nEles ficavam em quartos coletivos de, no máximo, 2 pessoas. \nTipo de medicaçao: forte, 4 vezes ao dia. Além da intervenção médica.");
        ala4 = new Ambiente ("Imagens/QuartoALA4.jpg","na ala Roxa (ALA4) da construção. \nAqui era a área mais pesada do hospital, nela ficavam os internados com maiores pertubações que não eram conhecidas na época! \nEles ficavam em quartos individuais.", lanternaAmarela);
        quartoAla3 = new Ambiente ("Imagens/BauFechado.jpg", "no quarto da Ala 3", bauComChaves);
        ambienteVitoria = new Ambiente("Imagens/BauAberto.jpg", "Você conheceu a história da sua família, portanto chegou ao seu objetivo final. \n PARABÉNS, VOCÊ VENCEU!!!");
        ambienteInicio = new Ambiente("Imagens/TelaAbertura.png", "Você está prestes a iniciar a melhor aventura de sua vida!");
        
        // inicializa as saidas dos ambientes
        // ambiente: entrada do manicômio
        fora.ajustarSaida("leste", jardim);
        fora.ajustarSaida("sul", salaDeRemedios);
        
        // ambiente: cozinha
        cozinha.ajustarSaida("sul", cantina);

        // ambiente: cantina
        cantina.ajustarSaida("norte", cozinha);
        cantina.ajustarSaida("oeste", jardim);

        // ambiente: sala de remédios
        salaDeRemedios.ajustarSaida("norte", jardim);
        salaDeRemedios.ajustarSaida("oeste", fora);
        salaDeRemedios.ajustarSaidaBloqueada("descer", sotao1, "LanternaAmarela");
        
        // ambiente: sótão sala de remédios
        sotao1.ajustarSaida("subir", salaDeRemedios);
        
        // ambiente: jardim
        jardim.ajustarSaida("norte", corredor1);
        jardim.ajustarSaida("leste", cantina);
        jardim.ajustarSaida("sul", salaDeRemedios);
        jardim.ajustarSaida("oeste", fora);
        
        // ambiente: corredor1
        corredor1.ajustarSaida("norte", corredor2);
        corredor1.ajustarSaida("sul", jardim);
        corredor1.ajustarSaida("leste", salaDeEstar);
        corredor1.ajustarSaida("oeste", escritorio);
        
        // ambiente: escritório
        escritorio.ajustarSaida("leste", corredor1);
        escritorio.ajustarSaidaBloqueada("descer", sotao2, "LanternaVerde");
        
        // ambiente: sotao escritório
        sotao2.ajustarSaida("subir", escritorio);
        
        // ambiente: sala de estar
        salaDeEstar.ajustarSaida("leste", corredor1);
        salaDeEstar.ajustarSaidaBloqueada("descer", sotao3, "LanternaVermelha");
        
        // ambiente: sotao sala de estar
        sotao3.ajustarSaida("subir", salaDeEstar);
        
        // ambiente: corredor 2
        corredor2.ajustarSaida("sul", corredor1);
        corredor2.ajustarSaida("leste", ala2);
        corredor2.ajustarSaida("oeste", ala1);
        corredor2.ajustarSaida("norte", corredor3);
        
        // ambiente: corredor 3
        corredor3.ajustarSaida("sul", corredor2);
        corredor3.ajustarSaida("leste", ala4);
        corredor3.ajustarSaida("oeste", ala3);
        
        // ambiente: ala1
        ala1.ajustarSaida("leste", corredor2);
        
        // ambiente: ala2
        ala2.ajustarSaida("oeste", corredor2);
        
        // ambiente: ala3
        ala3.ajustarSaida("leste", corredor3);
        ala3.ajustarSaidaBloqueada("subir", quartoAla3, "Chave");
        
        // ambiente: ala4
        ala4.ajustarSaida("oeste", corredor3);
        
        // ambiente: quartoAla3
        quartoAla3.ajustarSaida("descer", ala3);
        //quartoAla3.ajustarSaidaBloqueada("norte", ambienteVitoria, "bauComChaves");
        
        ambienteAtual = ambienteInicio; // o jogo comeca do lado de fora
        iu.ambienteAtualMudou(ambienteAtual);
    }

    /**
     *  Rotina principal do jogo. Fica em loop ate terminar o jogo.
     */
    public void jogar() 
    {            
        imprimirBoasVindas();

        // Entra no loop de comando principal. Aqui nos repetidamente lemos
        // comandos e os executamos ate o jogo terminar.
                
        boolean terminado = false;
        while (! terminado) {
            Comando comando = analisador.pegarComando();
            terminado = processarComando(comando);
        }
        iu.exibirMensagem("Obrigado por jogar. Até mais!");
    }

    /**
     * Imprime a mensagem de abertura para o jogador.
     */
    private void imprimirBoasVindas()
    {   
        iu.exibirMensagem("");
        iu.continuarMensagem("Bem-vindo ao Maniac!");
        iu.continuarMensagem(jogador.getNome() + ", você está em um manicômio abandonado da cidade de Barbacena!");
        iu.continuarMensagem("\nDigite 'ajuda' se você precisar de ajuda e 'jogar' para começar o jogo.");
        iu.continuarMensagem("");
        
    }

    /**
     * Dado um comando, processa-o (ou seja, executa-o)
     * @param comando O Comando a ser processado.
     * @return true se o comando finaliza o jogo.
     */
    private boolean processarComando(Comando comando) 
    {
        boolean querSair = false;

        if(comando.ehDesconhecido()) {
            iu.continuarMensagem("Eu não entendi o que você disse...");
            return false;
        }

        String palavraDeComando = comando.getPalavraDeComando();
        if (palavraDeComando.equals("ajuda")) {
            imprimirAjuda();
        }
        else if (palavraDeComando.equals("jogar")) {
            comecarJogo();
        }
        else if (palavraDeComando.equals("ir")) {
            irParaAmbiente(comando);
        }
        else if (palavraDeComando.equals("observar")){
            observar();
        }
        else if (palavraDeComando.equals("pegar")){
            pegar(comando);
        }
        else if (palavraDeComando.equals("usar")) {
            usar(comando);
        }
        else if (palavraDeComando.equals("sair")) {
            querSair = sair(comando);
        }
        else if (palavraDeComando.equals("voltar")){
            voltar();
        }
        else if (palavraDeComando.equals("largar")){
            largar(comando);
        }
        else if (palavraDeComando.equals("ler")){
            ler(comando);
        }
        else if (palavraDeComando.equals("abrir")){
           querSair = abrir(comando); 
        }
        
        return querSair;
    }

    // Implementacoes dos comandos do usuario

    /**
     * Printe informacoes de ajuda.
     * Aqui nos imprimimos algo bobo e enigmatico e a lista de 
     * palavras de comando
     */
    private void imprimirAjuda() 
    {
        iu.exibirMensagem("Você está em busca do seu passado!");
        iu.continuarMensagem("Você está procurando a história da família Thompson, sua família.");
        iu.continuarMensagem("\nEla foi a fundadora do primeiro hospital psiquiátrico na cidade de Barbacena e um dos primeiros no estado de Minas Gerais.");
        iu.continuarMensagem("\nMuitas histórias são criadas pelos moradores mais antigos da cidade sobre a família Thompson. Por isso, você busca descobrir a verdade.");
        iu.continuarMensagem("\nPor conta disso, você decidiu descobrir por si só qual é a verdadeira história e para isso você precisa enfrentar os desafios presentes dentro da construção.");
        iu.continuarMensagem("");
        iu.continuarMensagem("\nSuas palavras de comando são: ");
        iu.continuarMensagem(analisador.getPalavrasComando());
    }

    /** 
     * Tenta ir em uma direcao. Se existe uma saida entra no 
     * novo ambiente, caso contrario imprime mensagem de erro.
     */
    private void irParaAmbiente(Comando comando) 
    {
        if(!comando.temSegundaPalavra()) {
            // se nao ha segunda palavra, nao sabemos pra onde ir...
            iu.continuarMensagem("Ir pra onde?");
            return;
        }

        String direcao = comando.getSegundaPalavra();
        
        // Tenta sair do ambiente atual
        Ambiente proximoAmbiente = ambienteAtual.getSaida(direcao);
    
        if (proximoAmbiente == null) {
            iu.continuarMensagem("Não há passagem!");
        }
        else {
            ambientesVisitados.addFirst(ambienteAtual);
            
            ambienteAtual = proximoAmbiente;
            iu.ambienteAtualMudou(ambienteAtual);
            
            exibirAmbienteAtual();
        }
    }
    
    /**
     * O metódo "comecarJogo", realizar a inicialização do "primeiro ambiente jogavel", após o comando "jogar" ter sido digitado pelo jogador
     */
    private void comecarJogo(){
        ambienteAtual = fora; // o jogo comeca do lado de fora
        iu.ambienteAtualMudou(ambienteAtual);
        exibirAmbienteAtual();
    }
    
    /**
     * Se "observar" for digitado, uma descrição sobre o ambiente, os objetos presentes no mesmo e na mochila do jogador serão retornados. 
     */
    private void observar(){
        exibirAmbienteAtual();
        iu.continuarMensagem(jogador.itensMochila());
    }
    
    private void pegar(Comando comando){
        String aux = comando.getSegundaPalavra();
        if(comando.temSegundaPalavra()){
            if (ambienteAtual.consultarObjeto(aux)){
                if(ambienteAtual.ehPegavel(aux)){
                    Objeto referencia = ambienteAtual.removerItem(aux);
                    if (jogador.adcionarObjeto(referencia)){
                        iu.jogadorPegouItem(referencia);
                        iu.exibirMensagem("Você pegou o objeto " + aux);
                    } else{
                        iu.exibirMensagem("Mochila cheia!! Você não pode pegar o(a) " + aux + ", largue objetos para abrir espaço.");
                    }
                }
                else{
                    iu.exibirMensagem("Não é possível pegar este objeto!");
                }
            }
            else{
                iu.exibirMensagem("Objeto inexistente!");
            }
        }
        else{
            iu.continuarMensagem("Pegar o que?");
        }
    }
    
    private void ler (Comando comando){
        String aux = comando.getSegundaPalavra();
        if(comando.temSegundaPalavra()){
            if (ambienteAtual.consultarObjeto(aux) ){
                String texto = ambienteAtual.lerObjeto(aux);
                if(texto != null){
                    iu.exibirMensagem(texto);
                }
                else{
                    iu.exibirMensagem("Não há texto para ler neste objeto!");
                }
            }
            else{
                iu.exibirMensagem("Objeto inexistente!");
            }
        }
        else{
            iu.continuarMensagem("Ler o que?");
        }
    }
    
    public void usar(Comando comando){
        String aux = comando.getSegundaPalavra();
        if(comando.temSegundaPalavra()){
            if (jogador.existeItem(aux)){
                if(ambienteAtual.usarItem(aux)){
                    iu.exibirMensagem("Você utilizou o objeto " + aux + " com sucesso!!" );
                    iu.jogadorDescartouItem(jogador.removerObjeto(aux));
                }
                else{
                    iu.exibirMensagem("Este objeto não desbloqueia essa passagem, procure melhor ;)");                    
                }
            }
            else{
                iu.exibirMensagem("Objeto inexistente na mochila!!");
            }
        }
        else{
            iu.continuarMensagem("Usar o que?");
        }
    }
    
    private boolean abrir (Comando comando){
        String aux = comando.getSegundaPalavra();
        if(comando.temSegundaPalavra()){
            if (ambienteAtual.consultarObjeto(aux) ){
                String palavraDesbloqueio = ambienteAtual.palavraDesbloqueio(aux);
                if (ambienteAtual.ehDesbloqueavel(aux)){
                    String palavra = iu.obterInformacao("Digite a palavra encontrada no decorrer do jogo para desbloquear o Baú: \n");
                    if(palavra.equals(palavraDesbloqueio)){
                        ambienteAtual = ambienteVitoria;
                        iu.ambienteAtualMudou(ambienteAtual);
                        salvarArquivo("e completou o Jogo!!!");
                        return true;   
                    }
                    else{
                        iu.exibirMensagem("Palavra incorreta!! \n Procure melhor ;)");
                    }
                }
                else{
                    iu.exibirMensagem("Não é possível abrir esse tipo de objeto!");
                }
            }
        }
        else{
            iu.continuarMensagem("Abrir o que?");
        }
        return false;
    }
    
    /**
     * Se "voltar" for digitado, e o jogador tiver visitado outros ambientes anteriormente, ele poderá retornar para os mesmos sem a necessidade da utilização do comando "ir" com seu complemento de direção 
     */
    private void voltar (){
        if (!ambientesVisitados.isEmpty()){
            ambienteAtual = ambientesVisitados.removeFirst();
            iu.ambienteAtualMudou(ambienteAtual);
            exibirAmbienteAtual();
        } else {
            iu.exibirMensagem("Você não visitou outros ambientes anteriormente!!!");
        }
    }
    
    /** 
     * Se caso "largar" for digitado, é verificado se existe uma segunda palavra
     * logo após isso, se caso existir uma segunda palavras, o método irá comparar a palavra digitada pelo usuario com os itens presentes na mochila do jogador. Se caso o item estiver presente na mesma, ele será largado no ambienteAtual do jogador
     */
    private void largar(Comando comando){
        String aux = comando.getSegundaPalavra();
        if(comando.temSegundaPalavra()){
            if (jogador.existeItem(aux)){
                Objeto referencia = jogador.removerObjeto(aux);
                ambienteAtual.adicionarObjeto(referencia);
                iu.jogadorDescartouItem(referencia);
                iu.exibirMensagem("Você largou o objeto " + aux + " com sucesso!!" );
            }
            else{
                iu.exibirMensagem("Objeto inexistente na mochila!!");
            }
        }
        else{
            iu.continuarMensagem("Largar o que?");
        }
    }
    
    /** 
     * "Sair" foi digitado. Verifica o resto do comando pra ver
     * se nos queremos realmente sair do jogo.
     * @return true, se este comando sai do jogo, false, caso contrario
     */
    private boolean sair(Comando comando) 
    {
        if(comando.temSegundaPalavra()) {
            iu.continuarMensagem("Sair o que?");
            return false;
        }
        else {
            salvarArquivo("e não completou o Jogo!!!");
            return true;  // sinaliza que nos queremos sair
        }
    }
    
    /** 
     * Método para deixar o programa coeso, não deixa existir duplicação de código
     */
    private void exibirAmbienteAtual(){
        iu.exibirMensagem(ambienteAtual.getDescricaoLonga());
    }
    
    /** 
     * Método para que seja realizado o salvamento do progresso dos jogadores ao finalizar a jogatina
     */
    private void salvarArquivo(String comentario){
        long tempoJogado = System.currentTimeMillis() - tempoInicio;
        String nome = jogador.getNome();
        
        SalvarArquivo.salvamentoArquivo(nome, tempoJogado, comentario);
    }
}