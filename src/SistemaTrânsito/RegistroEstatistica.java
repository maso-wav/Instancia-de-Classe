package SistemaTrânsito;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*
    Nome do Programa: Sistema de Trânsito
    Objetivo do Programa: Elaborar a gravação dos dados em “ArquivoEstatistica.txt” 
                          e fazer a leitura dos dados do arquivo para suas devidas consultas.
    Data: 03/10/2024
*/

/**
 *
 * @author matheusoliveira
 */

import javax.swing.JOptionPane;

public class RegistroEstatistica {
   
    public static void main (String args [ ]){
        
        RegistroLogico_Estatistica[] estatistica = new RegistroLogico_Estatistica[10];
        RegistroLogico_Estatistica[] aux = new RegistroLogico_Estatistica[10];
        int i, j, soma = 0, cta = 0;
        double media = 0;
        
        
        for(i = 0; i < 10; i++){
            
            estatistica[i] = new RegistroLogico_Estatistica();            
            estatistica[i].codCidade = Integer.parseInt(JOptionPane.showInputDialog("INSIRA O CÓDIGO DA CIDADE"));
            estatistica[i].cidade = JOptionPane.showInputDialog("INSIRA O NOME DA CIDADE");
            estatistica[i].acidentes = Integer.parseInt(JOptionPane.showInputDialog("INSIRA A QUANTIDADE DE ACIDENTES NA CIDADE " + estatistica[i].cidade));                                     
            
        }
        
        for(i = 0; i < 10; i++){
            for(j = 0; j < 9; j++){
                
                if(estatistica[j].acidentes > estatistica[j + 1].acidentes){
                    
                    aux[j] = estatistica[j];
                    estatistica[j] = estatistica[j + 1];
                    estatistica[j + 1] = aux[i];
                }                
            }                                           
        }
        
        JOptionPane.showMessageDialog(null, "O MAIOR NÚMERO DE ACIDENTES É: " + estatistica[9].acidentes + " ACIDENTES, REGISTRADO NA CIDADE " + estatistica[9].cidade + " \nE O MENOR NÚMERO É: " + estatistica[0].acidentes +  " ACIDENTES, REGISTRADO NA CIDADE " + estatistica[0].cidade + ".");
        
        for(i = 0; i < 10; i++){
            
            if(estatistica[i].acidentes > 100 && estatistica[i].acidentes < 500)
            {
                
                JOptionPane.showMessageDialog(null, "A CIDADE " + estatistica[i].cidade + " CÓD.: " + estatistica[i].codCidade + " REGISTROU " + estatistica[i].acidentes + " ACIDENTES.");
            }
            
            soma = (soma + estatistica[i].acidentes);
            media = (soma / (i + 1));
            
            if(estatistica[i].acidentes > media)
            {
                
                JOptionPane.showMessageDialog(null,  "A CIDADE " + estatistica[i].cidade + " CÓD.: " + estatistica[i].codCidade + " ESTÁ COM A QUANTIDADE DE ACIDENTES ACIMA DA MÉDIA: " + estatistica[i].acidentes + ".");
            }
        }
    }
    
}
