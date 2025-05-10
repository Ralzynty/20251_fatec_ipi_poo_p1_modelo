import java.util.Random;

public class JogoMinecraft {
    public static void main(String[] args) throws Exception{
        var gerador = new Random();
        var jogador1 = new JogadorMinecraft("Alex");
        var jogador2 = new JogadorMinecraft("Steve Construtor");

        while(jogador1.estaVivo() || jogador2.estaVivo()){
            if (jogador1.estaVivo()){
                var acoes1 = 1 + gerador.nextInt(3);
                switch(acoes1){
                    case 1:
                        jogador1.minerar();
                        break;
                    case 2:
                        jogador1.coletarMadeira();
                        break;
                    case 3:
                        jogador1.construir();
                        break;
                }
            }

            if (jogador1.estaVivo() && gerador.nextInt(4) == 0){
            jogador1.levarDano();
            }

            if (jogador1.estaVivo()){
                System.out.println(jogador1);
            } else{
                System.out.println("Alex morreu!");
            }

            if (jogador2.estaVivo()){
                var acoes2 = 1 + gerador.nextInt(10);
                switch(acoes2){
                    case 1,2,3,4,5,6:
                        jogador2.construir();
                        break;
                    case 7,8,9:
                        jogador2.coletarMadeira();
                        break;
                    case 10:
                        jogador2.minerar();
                        break;
                }
            }

            if (jogador2.estaVivo() && gerador.nextInt(4) == 0){
                jogador2.levarDano();
            }

            if (jogador2.estaVivo()){
                System.out.println(jogador2);
            } else{
                System.out.println("Steve Construtor morreu!");
            }

            if (jogador1.estaVivo() == false && jogador2.estaVivo() == false){
                System.out.println("============");
                System.out.println("GAME OVER");
            }

            System.out.println("============");
            Thread.sleep(5000);
        }
    }
}