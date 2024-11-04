package SistemaTrânsito;



/*
    Nome do Programa: Sistema de Trânsito
    Objetivo do Programa: Elaborar a gravação dos dados em “ArquivoEstatistica.txt” 
                          e fazer a leitura dos dados do arquivo para suas devidas consultas.
    Data: 10/10/2024
*/

import java.io.*;
import javax.swing.*;

public class RegistroEstatistica_PgmPrincipal {
 
    public static void main (String args[]) throws IOException{
        
        RegistroLogico_Estatistica[] estatistica = new RegistroLogico_Estatistica[10];
        RegistroEstatistica_ClasseMetodos n = new RegistroEstatistica_ClasseMetodos();
        
        int opc = 0;
        
        while(opc != 9){
            
            opc = Integer.parseInt(JOptionPane.showInputDialog("ESTATÍSTICAS DE ACIDENTES DE 2020 \n1 - Cadastro Estatística \n2 - Consulta por quantidade de acidentes \n3 - Consulta por estatísticas de acidentes \n4 - Acidentes acima da média das 10 cidades \n9 - Fim"));
            
            switch(opc){
                
                case 1:
                    
                    estatistica = n.GravaDados(estatistica);
                    break;
                
                case 2:
                    
                    n.LerAcidentes(estatistica);
                    break;
                    
                case 3: 
                    
                    n.LerMaiorMenor(estatistica);
                    break;
                    
                case 4:
                
                    n.AcimaMedia(estatistica);
                    break;
                    
                case 9:
                    
                    JOptionPane.showMessageDialog(null, "PROGRAMA FINALIZADO");
                    break;
                
                default:
                    
                    JOptionPane.showMessageDialog(null,"OPÇÃO INVÁLIDA");
            }
            
        }
    }
    
}
