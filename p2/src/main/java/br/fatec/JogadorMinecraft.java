package br.fatec;
import java.util.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class JogadorMinecraft {
    private int codigo;
    private String nome;
    private int vida;
    private int blocosColetados;
    private List<String> inventario;

    private float probConstruir;
    private float probColetarMadeira;
    private float probMinerar;
    private int vitorias;
    private int derrotas;

    public JogadorMinecraft(int codigo, String nome, float probConstruir, float probColetarMadeira, float probMinerar, int vitorias, int derrotas) {
        this.codigo = codigo;
        this.nome = nome;
        this.probConstruir = probConstruir;
        this.probColetarMadeira = probColetarMadeira;
        this.probMinerar = probMinerar;
        this.vitorias = vitorias;
        this.derrotas = derrotas;
        this.vida = 10;
        this.blocosColetados = 0;
        this.inventario = new ArrayList<>();
    }

    public void minerar() {
        System.out.println(nome + " está minerando...");
        blocosColetados++;
        inventario.add("Pedra");
    }

    public void coletarMadeira() {
        System.out.println(nome + " coletou madeira.");
        inventario.add("Madeira");
    }

    public void construir() {
        if (inventario.size() >= 2) {
            System.out.println(nome + " construiu algo com seus recursos!");
            inventario.remove(0);
            inventario.remove(0);
        } else {
            System.out.println(nome + " não tem blocos suficientes para construir.");
        }
    }

    public void levarDano() {
        vida--;
        System.out.println(nome + " levou dano! Vida atual: " + vida);
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public void ataque(JogadorMinecraft inimigo){
        System.out.print(nome + " atacou! ");
        inimigo.levarDano();
    }

    @Override
    public String toString() {
        return String.format(
            "%s - Vida: %d, Blocos: %d, Vitórias: %d, Derrotas: %d, Inventário: %s",
            nome, vida, blocosColetados, vitorias, derrotas, inventario
        );
    }
}
