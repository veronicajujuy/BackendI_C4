package dh.backend.service;

import dh.backend.model.Computadora;

import java.util.HashMap;

public class ComputadoraFactory {
    private static HashMap<String, Computadora> poolComputadoras = new HashMap<>();

    public static Computadora obtenerComputadora(String tipo){
        Computadora computadora = poolComputadoras.get(tipo);
        if(computadora == null){
            switch (tipo){
                case "Windows":{
                    computadora = new Computadora(tipo, 2, 128);
                    break;
                }
                case "Mac16":{
                    computadora = new Computadora(tipo, 16, 500);
                    break;
                }
                default:
                    System.out.println("No existe ese tipo de computadora");
            }
            System.out.println("Computadora creada: " + computadora);
            poolComputadoras.put(tipo, computadora);
        } else {
            System.out.println("Computadora encontrada "+ computadora);
        }
        return computadora;
    }
}
