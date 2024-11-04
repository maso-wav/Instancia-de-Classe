package SistemaNotas;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author matheusoliveira
 */

import java.io.*;
import javax.swing.*;

public class RegistroAluno {

    public static void main(String[] args) {
        
        RegistroLogico_Aluno[] aluno = new RegistroLogico_Aluno[3];
        int i;
        
        for (i = 0; i < 3; i++){
            
            aluno[i] = new RegistroLogico_Aluno();
        }

        for (i = 0; i < 3; i++){
            
            aluno[i].pnome = JOptionPane.showInputDialog("Entre o nome do aluno:");
            aluno[i].unome = JOptionPane.showInputDialog("Entre o sobrenome do aluno:");
            aluno[i].pontos = Integer.parseInt(JOptionPane.showInputDialog("Pontos Graduação do aluno:"));
        }

        for (i = 0; i < 3; i++){
            
            System.out.println(aluno[i].pnome + " " + aluno[i].unome + " Pontos: " + aluno[i].pontos);
        }

        System.exit(0);
    } // fim do método	
} // fim da classe

