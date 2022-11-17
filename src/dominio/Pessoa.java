package dominio;

public class Pessoa {
    private int codigo;
    private String nome;
    private String CPF;
    private String dataNascimento;
    private String email;
    private String sexo;
    private double salario;

    protected Pessoa(int codigo, String nome, String CPF, String dataNascimento, String email, String sexo, double salario) {
        this.codigo = codigo;
        this.nome = nome;
        this.CPF = CPF;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.sexo = sexo;
        this.salario = salario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Garcom: " +
                "Codigo= " + codigo +
                ", Nome= '" + nome + '\'' +
                ", CPF= '" + CPF + '\'' +
                ", Data de Nascimento= '" + dataNascimento + '\'' +
                ", e-mail= '" + email + '\'' +
                ", Sexo= '" + sexo + '\'' +
                ", Salario= " + salario ;
    }
}

