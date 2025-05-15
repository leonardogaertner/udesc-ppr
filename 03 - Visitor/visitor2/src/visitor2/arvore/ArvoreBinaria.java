package visitor2.arvore;

import visitor2.visitor.ArvoreVisitor;

public class ArvoreBinaria {

    private Noh raiz;
    private int quantidadeDeElementos;

    public ArvoreBinaria(String chaveRaiz) {
        raiz = new Noh(chaveRaiz);
        quantidadeDeElementos = 0;
    }

    public int getQuantidadeDeElementos() {
		return quantidadeDeElementos;
	}
    
    public void inserir(String chave) {
        inserir(chave, raiz);
    }

    private void inserir(String chave, Noh no) {
        if (no.getChave() == chave) {
            return;
        }
        if (chave.compareTo(no.getChave()) > 0) {
            if (no.getDireito() == null) {
                no.setDireito(new Noh(chave));
                quantidadeDeElementos++;
                return;
            }
            inserir(chave, no.getDireito());
        } else {
            if (no.getEsquerdo() == null) {
                no.setEsquerdo(new Noh(chave));
                quantidadeDeElementos++;
                return;
            }
            inserir(chave, no.getEsquerdo());
        }
    }

    public void accept(ArvoreVisitor visitor) throws Exception {
    	raiz.accept(visitor);
    }
    
 }
