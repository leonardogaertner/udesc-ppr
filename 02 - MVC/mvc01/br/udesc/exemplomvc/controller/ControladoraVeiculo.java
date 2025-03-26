package br.udesc.exemplomvc.controller;

import br.udesc.exemplomvc.model.Veiculo;
import br.udesc.exemplomvc.view.Observador;

import java.util.ArrayList;
import java.util.List;

public class ControladoraVeiculo {
    
    private Veiculo veiculoAtual = new Veiculo();
    private List<Veiculo> listaVeiculos = new ArrayList<>();
    
    public void salvarVeiculo( String modelo, String marca, int ano ){
        veiculoAtual.setModelo(modelo);
        veiculoAtual.setMarca(marca);
        veiculoAtual.setAno(ano);
        if(!listaVeiculos.contains(veiculoAtual)) {
            listaVeiculos.add(veiculoAtual);
        }
        veiculoAtual = new Veiculo();
        
        for( Observador o : listaObservadores ){
            o.salvouVeiculo();
        }
    }
    
    public void cancelar(){
        veiculoAtual = new Veiculo();
    }
    
    public void excluir(){
        listaVeiculos.remove(veiculoAtual);
        this.veiculoAtual = new Veiculo();
        
        for( Observador o : listaObservadores ){
            o.excluiuVeiculo();
        }
    }
    
    public void pesquisar(String modelo){
        for(Veiculo v : listaVeiculos) {
            if(v.getModelo().equals(modelo)) {
                veiculoAtual = v;
                for( Observador o : listaObservadores ){
                    o.achouVeiculo(modelo, v.getMarca(), v.getAno());
                }
                return;
            }
        }
        
        for( Observador o : listaObservadores ){
            o.naoAchouVeiculo();
        }
    }
    
    public List< Observador > listaObservadores = new ArrayList<>();
    
    
    public void addObservador( Observador obs ){
        listaObservadores.add( obs );
    }
    
    public void removerObservador( Observador obs ){
        listaObservadores.remove( obs );
    }
    

    
}
