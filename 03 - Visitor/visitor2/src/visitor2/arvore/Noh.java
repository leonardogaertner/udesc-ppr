package visitor2.arvore;

import visitor2.visitor.ArvoreVisitor;

public class Noh {

    private String chave;
    private Noh esquerdo, direito;

    public Noh(String chave) {
        this.chave = chave;
        esquerdo = null;
        direito = null;
    }

    public String toString() {
        return getChave();
    }

    public String getChave() {
        return chave;
    }

    public Noh getEsquerdo() {
        return esquerdo;
    }

    public void setEsquerdo(Noh esquerdo) {
        this.esquerdo = esquerdo;
    }

    public Noh getDireito() {
        return direito;
    }

    public void setDireito(Noh direito) {
        this.direito = direito;
    }

    public void accept(ArvoreVisitor visitor) throws Exception {
    	visitor.visit(this);
    }
}
