import java.util.Random;

public class JogoMinecraft {
    public static void main(String[] args) throws Exception{
        var gerador = new Random();
        var jogador = new JogadorMinecraft("Alex");

        while(true){
            var acoes = 1 + gerador.nextInt(3);
            switch(acoes){
                case 1:
                    jogador.minerar();
                    break;
                case 2:
                    jogador.coletarMadeira();
                    break;
                case 3:
                    jogador.construir();
                    break;
            }
            System.out.println(jogador);
            System.out.println("============");
            Thread.sleep(5000);
        }
    }
}