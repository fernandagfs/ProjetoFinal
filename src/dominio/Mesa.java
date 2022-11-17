package dominio;

public class Mesa {

    private int numMesa;
    private String situacao;
    private int capacidade;
    private Pessoa garcom;

    public Mesa() {
    }

    public Mesa(int numMesa, String situacao, int capacidade, Pessoa garcom) {
        this.numMesa = numMesa;
        this.situacao = situacao;
        this.capacidade = capacidade;
        this.garcom = garcom;
    }

    public int getNumMesa() {
        return numMesa;
    }

    public void setNumMesa(int numMesa) {
        this.numMesa = numMesa;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public Pessoa getGarcom() {
        return garcom;
    }

    public void setGarcom(Pessoa garcom) {
        this.garcom = garcom;
    }

    @Override
    public String toString() {
        return "Mesa: " +
                "numMesa= " + numMesa +
                ", situacao= '" + situacao + '\'' +
                ", capacidade= " + capacidade +
                ", Nome Garçom= " + getGarcom().getNome() +
                ", Código Garcom= " + getGarcom().getCodigo();
    }
}
