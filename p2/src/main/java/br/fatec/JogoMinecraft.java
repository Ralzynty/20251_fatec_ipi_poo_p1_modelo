package br.fatec;

import java.util.ArrayList;
import java.util.Random;

public class JogoMinecraft{
    public static void main(String [] args) throws Exception {
        var jogadores = new ArrayList<JogadorMinecraft>();
        jogadores = JogadorMinecraftDAO.listar();
        var rand = new Random();
        
        while(true){
            if(jogadores.get(0).estaVivo())
            {
                var acao = rand.nextDouble();
                if(acao <= jogadores.get(0).getProbColetarMadeira()) jogadores.get(0).coletarMadeira();
                if(acao > jogadores.get(0).getProbColetarMadeira() && acao <= jogadores.get(0).getProbColetarMadeira()+jogadores.get(0).getProbConstruir()) jogadores.get(0).construir();
                if(acao > jogadores.get(0).getProbColetarMadeira()+jogadores.get(0).getProbConstruir()) jogadores.get(0).minerar();

		        var tomarDano = rand.nextDouble();
                if(tomarDano <= 0.25) jogadores.get(0).levarDano();
            }
            if(jogadores.get(1).estaVivo())
            {
                var acao = rand.nextDouble();
                if(acao <= jogadores.get(1).getProbColetarMadeira()) jogadores.get(1).coletarMadeira();
                if(acao > jogadores.get(1).getProbColetarMadeira() && acao <= jogadores.get(1).getProbColetarMadeira()+jogadores.get(1).getProbConstruir()) jogadores.get(1).construir();
                if(acao > jogadores.get(1).getProbColetarMadeira()+jogadores.get(1).getProbConstruir()) jogadores.get(1).minerar();

                var tomarDano = rand.nextDouble();
                if(tomarDano <= 0.25) jogadores.get(1).levarDano();
            }    

            var chanceAtaque = rand.nextDouble();
            if(jogadores.get(0).estaVivo() && jogadores.get(1).estaVivo())
            {
                if(chanceAtaque <= 0.5) jogadores.get(0).ataque(jogadores.get(1));
                else jogadores.get(1).ataque(jogadores.get(0));
            }

            System.out.println(jogadores.get(0));
            System.out.println(jogadores.get(1));
            
            if(!jogadores.get(0).estaVivo() && !jogadores.get(1).estaVivo())
            {
                System.out.println("============");
                System.out.println("GAME OVER");
            }

            System.out.println("============");
            Thread.sleep(5000);
        }
    }
}