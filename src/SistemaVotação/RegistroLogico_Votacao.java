package SistemaVotação;

/*
    Nome do Programa: Sistema de Votação
    Objetivo do Programa: Elaborar a gravação dos dados em “ArquivoEstatistica.txt” 
                          e fazer a leitura dos dados do arquivo para suas devidas consultas.
    Data: 17/10/2024
*/

public class RegistroLogico_Votacao {
    
    int numSecao, numCandidato;
    
    RegistroLogico_Votacao(){
        
        this(0,0);
        
    }
    
    RegistroLogico_Votacao(int numeroSecao, int numeroCandidato){
        
        numSecao = numeroSecao;
        numCandidato = numeroCandidato;
    }
    
}
