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

public class RegistroAluno_PgmPrincipal {

    public static void main(String arg[]) throws IOException {
        
        RegistroLogico_Aluno[] aluno = new RegistroLogico_Aluno[3];
        RegistroAluno_LeituraGravacao m = new RegistroAluno_LeituraGravacao();
        
        int opc = 0;
        
        while (opc != 9) {
            
            opc = Integer.parseInt(JOptionPane.showInputDialog("1 - Gravar Aluno \n2 - Ler Aluno \n9 - Finaliza"));
            
            switch (opc) {
                case 1:
                    aluno = m.GravaAluno(aluno);
                    break;
                case 2:
                    m.LerAluno(aluno);
                    break;
                case 9:
                    JOptionPane.showMessageDialog(null, "FINALIZADO ");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "OPÇÃO INVÁLIDA");
            }
        }
    }

}
