package SistemaTrânsito;



/*
    Nome do Programa: Sistema de Trânsito
    Objetivo do Programa: Elaborar a gravação dos dados em “ArquivoEstatistica.txt” 
                          e fazer a leitura dos dados do arquivo para suas devidas consultas.
    Data: 10/10/2024
*/

import java.io.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class RegistroEstatistica_ClasseMetodos {   

    static DecimalFormat df = new DecimalFormat("###,###,###");    
    
    public RegistroLogico_Estatistica[] GravaDados(RegistroLogico_Estatistica[] estatistica) throws IOException{
        
        int i; 
        String fileName = "ArquivoEstatístico.txt";
        BufferedWriter gravar = new BufferedWriter(new FileWriter(fileName));
        
        for(i = 0; i < 10; i++){
            
            estatistica[i] = new RegistroLogico_Estatistica();
            
            estatistica[i].codCidade = Integer.parseInt(JOptionPane.showInputDialog("INSIRA O CÓDIGO DA CIDADE"));
                gravar.write(Integer.toString(estatistica[i].codCidade)); 
                gravar.newLine();
                
            estatistica[i].cidade = JOptionPane.showInputDialog("INSIRA O NOME DA CIDADE");
                gravar.write(estatistica[i].cidade);
                gravar.newLine();
            
            estatistica[i].acidentes = Integer.parseInt(JOptionPane.showInputDialog("INSIRA A QUANTIDADE DE ACIDENTES NA CIDADE DE " + estatistica[i].cidade));
                gravar.write(Integer.toString(estatistica[i].acidentes));
                gravar.newLine();
        }
        
        JOptionPane.showMessageDialog(null, "GRAVAÇÃO CONCLUÍDA COM SUCESSO!");
        
        gravar.close();
        return estatistica;
    }
    
    public void LerAcidentes(RegistroLogico_Estatistica[] estatistica) throws IOException{
        
        int i;
        String fileName = "ArquivoEstatístico.txt";
        BufferedReader ler = new BufferedReader(new FileReader(fileName));        
        
        for(i = 0; i < 10; i++){
            
            estatistica[i] = new RegistroLogico_Estatistica();
            
            estatistica[i].codCidade = Integer.parseInt(ler.readLine());
            estatistica[i].cidade = ler.readLine();
            estatistica[i].acidentes = Integer.parseInt(ler.readLine());
        }
        
        for(i = 0; i < 10; i++){                      
            
            if(estatistica[i].acidentes > 100 && estatistica[i].acidentes < 500)
            {
                
                JOptionPane.showMessageDialog(null, "A CIDADE DE " + estatistica[i].cidade + ", CÓD.: " + estatistica[i].codCidade + " REGISTROU " + df.format(estatistica[i].acidentes) + " ACIDENTES.");
            }           
        }                      
        
        ler.close();
    }
    
    public void LerMaiorMenor(RegistroLogico_Estatistica[] estatistica) throws IOException{
        
        int i, j;       
        String fileName = "ArquivoEstatístico.txt";
        RegistroLogico_Estatistica[] aux = new RegistroLogico_Estatistica[10];
        BufferedReader ler = new BufferedReader(new FileReader(fileName));
        
        for(i = 0; i < 10; i++){
            
            estatistica[i] = new RegistroLogico_Estatistica();
            
            estatistica[i].codCidade = Integer.parseInt(ler.readLine());
            estatistica[i].cidade = ler.readLine();
            estatistica[i].acidentes = Integer.parseInt(ler.readLine());
        }
        
        for(i = 0; i < 10; i++){
            for(j = 0; j < 9; j++){
                
                if(estatistica[j].acidentes > estatistica[j + 1].acidentes){
                    
                    aux[j] = estatistica[j];
                    estatistica[j] = estatistica[j + 1];
                    estatistica[j + 1] = aux[j]; 
                                        
                }                
            }                                           
        }
        
        JOptionPane.showMessageDialog(null, "O MAIOR NÚMERO DE ACIDENTES É: " + df.format(estatistica[9].acidentes) + " ACIDENTES, REGISTRADO NA CIDADE DE " + estatistica[9].cidade + " \nE O MENOR NÚMERO É: " + df.format(estatistica[0].acidentes) +  " ACIDENTES, REGISTRADO NA CIDADE DE " + estatistica[0].cidade + ".");
        
        ler.close();
    }
    
    public void AcimaMedia(RegistroLogico_Estatistica[] estatistica) throws IOException{
        
        int i, soma = 0;
        double media, somaMedia; /* somaMedia está fazendo uma conversão implícita para calcular a média
                                  com os valores decimais */                                    
        String fileName = "ArquivoEstatístico.txt";
        BufferedReader ler = new BufferedReader(new FileReader(fileName));
        
        for(i = 0; i < 10; i++){
            
            estatistica[i] = new RegistroLogico_Estatistica();
            
            estatistica[i].codCidade = Integer.parseInt(ler.readLine());
            estatistica[i].cidade = ler.readLine();
            estatistica[i].acidentes = Integer.parseInt(ler.readLine());
        }
        
        for(i = 0; i < 10; i++){
                                   
            soma = (soma + estatistica[i].acidentes);
            somaMedia = soma;
            media = (somaMedia / 10);                        
            
            if(estatistica[i].acidentes > media)
            {
                
                JOptionPane.showMessageDialog(null,  "A CIDADE DE " + estatistica[i].cidade + ", CÓD.: " + estatistica[i].codCidade + " ESTÁ COM A QUANTIDADE DE ACIDENTES ACIMA DA MÉDIA: " + df.format(estatistica[i].acidentes) + ".");
            }
        }
        
        ler.close();
    }
}
