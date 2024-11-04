package SistemaVotação;

/*
    Nome do Programa: Sistema de Votação
    Objetivo do Programa: Elaborar a gravação dos dados em “ArquivoEstatistica.txt” 
                          e fazer a leitura dos dados do arquivo para suas devidas consultas.
    Data: 17/10/2024
*/

import java.io.*;
import javax.swing.*;
import java.util.Random;

public class RegistroVotacao_ClasseMetodos {           
    
    public RegistroLogico_Votacao[] CadastraVotos(RegistroLogico_Votacao[] votos) throws IOException{
        
        int i;
        Random gerador = new Random();
        
        for(i = 0; i < 200; i++){
            
            votos[i] = new RegistroLogico_Votacao();
            
            votos[i].numSecao = gerador.nextInt(10) + 1;
            votos[i].numCandidato = gerador.nextInt(300) + 1;
        }                
        
        return votos;
    }
    
    public RegistroLogico_Votacao[] ClassificaSecao(RegistroLogico_Votacao[] votos) throws IOException{
        
        int i, j;
        RegistroLogico_Votacao[] aux = new RegistroLogico_Votacao[200];
        
        for(i = 0; i < 200; i++){
            for(j = 0; j < 199; j++){
                
                if(votos[j].numSecao > votos[j + 1].numSecao){
                    
                    aux[j] = votos[j];
                    votos[j] = votos[j + 1];
                    votos[j + 1] = aux[j];                                        
                }                
            }            
        }                
        
        return votos;
    }
    
    public RegistroLogico_Votacao[] GravaVotos(RegistroLogico_Votacao[] votos) throws IOException{
        
        int i;
        String fileName = "Votação 2024.txt";
        BufferedWriter gravar = new BufferedWriter(new FileWriter(fileName));
        
        for(i = 0; i < 200; i++){                       
            
            gravar.write(Integer.toString(votos[i].numSecao));
            gravar.newLine();
            
            gravar.write(Integer.toString(votos[i].numCandidato));
            gravar.newLine();
            
        }                
        
        gravar.close();
        return votos;
    }
    
    public void LerEleitoresSecao(RegistroLogico_Votacao[] votos) throws IOException{
        
        int i, eleitores[] = new int[200];
        
        String fileName = "Votação 2024.txt";
        BufferedReader ler = new BufferedReader(new FileReader(fileName));
                
        for(i = 0; i < 200; i++){
            
            votos[i] = new RegistroLogico_Votacao();
            
            votos[i].numSecao = Integer.parseInt(ler.readLine());
            votos[i].numCandidato = Integer.parseInt(ler.readLine());
        }        
        
        for(i = 0; i < 200; i++){
                
           eleitores[votos[i].numSecao] = (eleitores[votos[i].numSecao] + 1);             
                
        }                       
               
        for(i = 1; i < 11; i++){
            
            JOptionPane.showMessageDialog(null, "A SEÇÃO Nº " + i + " TEVE " + eleitores[i] + " ELEITORES.");
        }
        
        ler.close();
    }
    
    public void LerMaiorMenor(RegistroLogico_Votacao[] votos) throws IOException{
        
        int i, j, eleitores[] = new int[200], auxiliar[] = new int[200];
        RegistroLogico_Votacao[] aux = new RegistroLogico_Votacao[200];
        
        String fileName = "Votação 2024.txt";
        BufferedReader ler = new BufferedReader(new FileReader(fileName));
        
        for(i = 0; i < 200; i++){
            
            votos[i] = new RegistroLogico_Votacao();
            
            votos[i].numSecao = Integer.parseInt(ler.readLine());
            votos[i].numCandidato = Integer.parseInt(ler.readLine());
        }   
        
        for(i = 0; i < 200; i++){
                
           eleitores[votos[i].numSecao] = (eleitores[votos[i].numSecao] + 1);      
                
        }
        
        for(i = 0; i < 200; i++){
            for(j = 0; j < 199; j++){
                if(eleitores[votos[j].numSecao] > eleitores[votos[j + 1].numSecao])
                {
                    
                    aux[j] = votos[j];
                    auxiliar[j] = eleitores[votos[j].numSecao];
                    
                    votos[j] = votos[j + 1];
                    eleitores[votos[j].numSecao] = eleitores[votos[j + 1].numSecao];
                    
                    votos[j + 1] = aux[j];
                    eleitores[votos[j + 1].numSecao] = auxiliar[j];
                }   
            }           
        }        
        
        
        JOptionPane.showMessageDialog(null, "A SEÇÃO " + votos[199].numSecao + " TEVE O MAIOR NÚMERO DE ELEITORES: " + eleitores[votos[199].numSecao] + " \nA SEÇÃO " + votos[0].numSecao + " TEVE O MENOR NÚMERO DE ELEITORES: " + eleitores[votos[0].numSecao] + "." );
        
        ler.close();
    }
    
    public void VotoCandidato(RegistroLogico_Votacao[] votos) throws IOException {
    
        int i = 0, j, votosCandidato[] = new int[301]; 
        
        String fileName = "Votação 2024.txt";
        BufferedReader ler = new BufferedReader(new FileReader(fileName));                      

        for(j = 0; j < 200; j++){
            
            votos[j] = new RegistroLogico_Votacao();
            
            votos[j].numSecao = Integer.parseInt(ler.readLine());
            votos[j].numCandidato = Integer.parseInt(ler.readLine());
            
            votosCandidato[votos[j].numCandidato]++;
            
        }
        
        for (j = 0; j < 200; j++){
            if((votosCandidato[j] > 0) && (votosCandidato[j] < 2))
            {    
                
                System.out.println("O CANDIDATO " + j + " RECEBEU " + votosCandidato[j] + " VOTO.");
            }
            else if(votosCandidato[j] > 1)
                {    
                    
                    System.out.println("O CANDIDATO " + j + " RECEBEU " + votosCandidato[j] + " VOTOS.");
                }
        }

        ler.close();
    }

    
    public void MaisVotados(RegistroLogico_Votacao[] votos) throws IOException{               
        
        int i, j, votosCandidato[] = new int [301];        
        CandidatoVotos[] candidatos = new CandidatoVotos[301]; // Criação do array auxiliar para armazenar candidatos e votos
        
        String fileName = "Votação 2024.txt";        
        BufferedReader ler = new BufferedReader(new FileReader(fileName));                
        
        for(i = 0; i < 200; i++){
            
            votos[i] = new RegistroLogico_Votacao();
            
            votos[i].numSecao = Integer.parseInt(ler.readLine());
            votos[i].numCandidato = Integer.parseInt(ler.readLine());
            
            votosCandidato[votos[i].numCandidato]++;            
        }                                              
                        
        for (i = 0; i < 200; i++){
            
            candidatos[i] = new CandidatoVotos(i, votosCandidato[i]);
        }
        
        for (i = 0; i < 200; i++){
            for (j = 0; j < 199; j++){
                if (candidatos[j].votos < candidatos[j + 1].votos){
                                        
                    CandidatoVotos temp = candidatos[j];
                    candidatos[j] = candidatos[j + 1];
                    candidatos[j + 1] = temp;
                }
            }
        }
        
        for(i = 0; i < 10; i++){
            if (candidatos[i].votos > 0) 
            {
                
                System.out.println("O " + (i + 1) + "° CANDIDATO MAIS VOTADO FOI O CANDIDATO " + 
                                candidatos[i].numCandidato + " COM " + candidatos[i].votos + " VOTOS.");
            }
        }                                        
        ler.close();
    }
}

