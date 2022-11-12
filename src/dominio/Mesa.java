package dominio;

public class Mesa {

    private int numMesa;
    private String situacao;
    private int capacidade;
    private Garcom garcom;

    public Mesa() {
    }

    public Mesa(int numMesa, String situacao, int capacidade, Garcom garcom) {
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

    public Garcom getGarcom() {
        return garcom;
    }

    public void setGarcom(Garcom garcom) {
        this.garcom = garcom;
    }

}
