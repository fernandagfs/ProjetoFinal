package bancodados;

import dominio.Garcom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GarcomBanco {

    private final Connection conexao;

    public GarcomBanco(Connection conexao) {
        this.conexao = conexao;
    }

    public void salvar(Garcom garcom) {
        try {
            String sql = "insert into Garcom (codigoGarcom, nome, CPF, dataNascimento, email, telefone, sexo, salarioFixo) " +
                    "values (?,?,?,?,?,?,?,?)";

            PreparedStatement stmt = this.conexao.prepareStatement(sql);

            stmt.setInt(1, garcom.getCodigo());
            stmt.setString(2, garcom.getNome());
            stmt.setString(3, garcom.getCPF());
            stmt.setString(4, garcom.getDataNascimento());
            stmt.setString(5, garcom.getEmail());
            stmt.setString(6, garcom.getTelefone());
            stmt.setString(7, garcom.getSexo());
            stmt.setDouble(8, garcom.getSalarioFixo());

            stmt.execute();
            stmt.close();
        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao gravar garcom!");
        }
    }

    public void remover(int codigo) {

    }

    public Garcom buscarPorEmail(String email) {
        try {
            String sql = "select * from Garcom where email = ?";
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                int codigoGarcom = rs.getInt("codigoGarcom");
                String nome = rs.getString("nome");
                String cpf = rs.getString("CPF");
                String sexo = rs.getString("sexo");
                String telefone = rs.getString("telefone");
                double salario = rs.getDouble("salarioFixo");
                String dataNascimento = rs.getString("dataNascimento");

                Garcom garcom = new Garcom(codigoGarcom, nome, cpf, dataNascimento, email, sexo, salario, telefone);

                return garcom;
            }


        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao buscar garcom por email!");
        }

        return null;
    }

    public Garcom buscarPorCodigo(int codigoGarcom) {
        try {
            String sql = "select * from Garcom where codigoGarcom = ?";
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            stmt.setInt(1, codigoGarcom);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                String nome = rs.getString("nome");
                String cpf = rs.getString("CPF");
                String emailResultado = rs.getString("email");
                String sexo = rs.getString("sexo");
                String telefone = rs.getString("telefone");
                double salario = rs.getDouble("salarioFixo");
                String dataNascimento = rs.getString("dataNascimento");

                Garcom garcom = new Garcom(codigoGarcom, nome, cpf, dataNascimento, emailResultado, sexo, salario, telefone);

                return garcom;
            }


        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao buscar garcom por código!");
        }

        return null;
    }
    public void deletarGarcom (int codigoGarcom) {
        try {
            String sql = "delete from Garcom where codigoGarcom = ?";
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            stmt.setInt(1, codigoGarcom);

            stmt.execute();
            stmt.close();



        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao buscar garcom por código!");
        }
    }


}
