package br.fatec;
import java.sql.*;
import java.util.*;

public class JogadorMinecraftDAO {
    public static ArrayList<JogadorMinecraft> listar() throws Exception{
        var jogadores = new ArrayList<JogadorMinecraft>();
        var sql = "SELECT * FROM tb_personagens";

        try(
            var conexao = ConnectionFactory.obterConexao();
            var ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        ){
            while(rs.next()){
                var codigo = rs.getInt("codigo");
                var nome = rs.getString("nome");
                var probConstruir = rs.getFloat("prob_construir");
                var probColetarMadeira = rs.getFloat("prob_coletar_madeira");
                var probMinerar = rs.getFloat("prob_minerar");
                var vitorias = rs.getInt("vitorias");
                var derrotas = rs.getInt("derrotas");
                var jogador = new JogadorMinecraft(codigo, nome, probConstruir, probColetarMadeira, probMinerar, vitorias, derrotas);
                jogadores.add(jogador);
            }
            return jogadores;
        }
    }
    public void atualizar(JogadorMinecraft jogador) throws Exception{
        var sql = "UPDATE tb_personagens SET vitorias = ?, derrotas = ?, prob_construir = ?, prob_coletar_madeira = ?, prob_minerar = ? WHERE codigo = ?";

        try(
            var conexao = ConnectionFactory.obterConexao();
            var ps = conexao.prepareStatement(sql);
        ){
            ps.setInt(1, jogador.getVitorias());
            ps.setInt(2, jogador.getDerrotas());
            ps.setFloat(3, jogador.getProbConstruir());
            ps.setFloat(4, jogador.getProbColetarMadeira());
            ps.setFloat(5, jogador.getProbMinerar());
            ps.setInt(6, jogador.getCodigo());
            ps.execute();
        }
    }
}