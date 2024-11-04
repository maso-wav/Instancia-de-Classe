package SistemaVotação;

/*
    Nome do Programa: Sistema de Votação
    Objetivo do Programa: Elaborar a gravação dos dados em “ArquivoEstatistica.txt” 
                          e fazer a leitura dos dados do arquivo para suas devidas consultas.
    Data: 17/10/2024
*/

public class CandidatoVotos{
    
    int numCandidato;
    int votos;

    CandidatoVotos(int numCandidato, int votos){
        
        this.numCandidato = numCandidato;
        this.votos = votos;
    }
}
