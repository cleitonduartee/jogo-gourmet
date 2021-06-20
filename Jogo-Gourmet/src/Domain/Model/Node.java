package Domain.Model;

public class Node {
    private String prato;
    private Node esquerdo;
    private Node direito;

    public Node(String prato) {
        this.prato = prato;
    }

    public void setPrato(String prato) {
        this.prato = prato;
    }

    public void setEsquerdo(Node esquerdo) {
        this.esquerdo = esquerdo;
    }

    public void setDireito(Node direito) {
        this.direito = direito;
    }

    public String getPrato() {
        return prato;
    }

    public Node getEsquerdo() {
        return esquerdo;
    }

    public Node getDireito() {
        return direito;
    }

    public boolean eFolha(){
        return getDireito() == null && getEsquerdo() == null;
    }
}
