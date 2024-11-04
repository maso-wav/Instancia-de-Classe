package SistemaEleição;

/*
    Nome do Programa: Sistema de Eleição
    Objetivo do Programa: Criar um sistema que cadastre (votação) 5 eleitores em cada grupo de votação.
                          Gravar também o cadastro eleitoral com 10 eleitores com seu número de eleitor e nome.
                          Após os cadastramentos, processar e apurar: vencedor,2º colocado, brancos, nulos, 
                          assim como suas quantidades apuradas.
    Data: 26/10/2024
*/

public class RegistroLogico_Eleicao {
    
    int numSecao, numCandidato, numEleitor;
    
    RegistroLogico_Eleicao(){
        
        this(0,0,0);
    }
    
    RegistroLogico_Eleicao(int numeroSecao, int numeroCandidato, int numeroEleitor){
        
        numSecao = numeroSecao;
        numCandidato = numeroCandidato;
        numEleitor = numeroEleitor;
        
    }
}
