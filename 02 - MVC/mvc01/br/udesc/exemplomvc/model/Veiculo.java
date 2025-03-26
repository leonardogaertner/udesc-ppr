package br.udesc.exemplomvc.model;

public class Veiculo{
    private String modelo;
    private String marca;
    private int ano;

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAno() {
        return ano;
    }

     public void setAno(int ano) {
        this.ano = ano;
    }
     
     @Override
    public String toString() {
    	return this.modelo;
    }


}
