package SistemaVotação;

/*
    Nome do Programa: Sistema de Votação
    Objetivo do Programa: Elaborar a gravação dos dados em “ArquivoEstatistica.txt” 
                          e fazer a leitura dos dados do arquivo para suas devidas consultas.
    Data: 17/10/2024
*/

import javax.swing.*;
import java.io.*;

public class RegistroVotacao_PgmPrincipal {
    
    public static void main (String args[]) throws IOException{
        
        RegistroLogico_Votacao[] votacao = new RegistroLogico_Votacao[200];
        RegistroVotacao_ClasseMetodos n = new RegistroVotacao_ClasseMetodos();
        
        int opc = 0;
        
        while(opc != 9){
            
            opc = Integer.parseInt(JOptionPane.showInputDialog("ELEIÇÕES 2024 \n1 - Carregar Seção/Número Eleitor"
                    + "\n2 - Classificar por Seção \n3 - Gravar Registros \n4 - Mostrar Indicadores \n9 - Finalizar"));
            
            switch(opc){
                
                case 1:
                    
                    votacao = n.CadastraVotos(votacao);
                    JOptionPane.showMessageDialog(null, "VOTOS CADASTRADOS COM SUCESSO!");                    
                    break;
                    
                case 2:
                    
                    n.ClassificaSecao(votacao);
                    JOptionPane.showMessageDialog(null, "SEÇÕES CLASSIFICADAS COM SUCESSO!");                    
                    break;
                    
                case 3:
                    
                    n.GravaVotos(votacao);
                    JOptionPane.showMessageDialog(null, "VOTOS GRAVADOS COM SUCESSO!");                    
                    break;
                    
                case 4:                   
                    
                    while(opc != 10){
                        
                        opc = Integer.parseInt(JOptionPane.showInputDialog("ESTATÍSTICAS DE VOTAÇÃO 2024 \n1 - Quantidade Eleitores por Seção"
                                + "\n2 - Seção com Maior e Menor Número de Eleitores \n3 - Quantidade de Votos por Candidato"
                                + "\n4 – 10 Primeiros Colocados \n10 - Finaliza Consulta"));
                        
                        switch(opc){
                            
                            case 1:
                                
                                n.LerEleitoresSecao(votacao);
                                break;
                            
                            case 2:
                                
                                n.LerMaiorMenor(votacao);
                                break;
                            
                            case 3: 
                                
                                n.VotoCandidato(votacao);
                                break;
                                
                            case 4: 
                                                                                                
                                n.MaisVotados(votacao);
                                break;
                                
                            case 10:
                                                                
                                break;
                                
                            default:
                                
                                JOptionPane.showMessageDialog(null, "OPÇÃO INVÁLIDA!");                                
                        }                                                
                    }
                    break;
                
                case 9:
                    
                    JOptionPane.showMessageDialog(null, "PROGRAMA FINALIZADO!");
                    break;
                    
                default:
                    
                    JOptionPane.showMessageDialog(null, "OPÇÃO INVÁLIDA!");
            }
        }        
    }       
}
