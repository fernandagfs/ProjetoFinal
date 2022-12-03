package bancodados;

import dominio.Mesa;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MesaBanco {
    private final Connection conexao;

    public MesaBanco(Connection conexao) {
        this.conexao = conexao;
    }

    public void salvarMesa(Mesa mesa) {
        try {
            String sql = "insert into Mesa ( cogigoMesa, capacidade, situacao, codigoGarcom)" +
                    "values (?,?,?,?)";
            PreparedStatement stmt = this.conexao.prepareStatement(sql);

            stmt.setInt(1, mesa.getNumMesa());
            stmt.setInt(1, mesa.getCapacidade());
            stmt.setString(1, mesa.getSituacao());
            stmt.setInt(1, mesa.getGarcom().getCodigo());

            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao gravar garcom!");
        }
    }
}





