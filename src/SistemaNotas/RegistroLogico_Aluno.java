package SistemaNotas;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author matheusoliveira
 */

public class RegistroLogico_Aluno {

    String pnome, unome;
    int pontos;

    // TRANSMISSÃO DE DADOS	 
    RegistroLogico_Aluno(){
        
        this("", "", 0);
    }

    RegistroLogico_Aluno(String pnomealuno, String unomealuno, int pontosaluno){
        
        pnome = pnomealuno;
        unome = unomealuno;
        pontos = pontosaluno;
    }

}
