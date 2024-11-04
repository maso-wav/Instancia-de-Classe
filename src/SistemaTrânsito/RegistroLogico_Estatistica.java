package SistemaTrânsito;



/*
    Nome do Programa: Sistema de Trânsito
    Objetivo do Programa: Elaborar a gravação dos dados em “ArquivoEstatistica.txt” 
                          e fazer a leitura dos dados do arquivo para suas devidas consultas.
    Data: 03/10/2024
*/

public class RegistroLogico_Estatistica {
    
    String cidade;
    int codCidade, acidentes;
    
    RegistroLogico_Estatistica(){
        
        this(0,"",0);        
    }
    
    RegistroLogico_Estatistica(int codigoCidade, String nomeCidade, int qtdAcidentes){
        
        codCidade = codigoCidade;
        cidade = nomeCidade;
        acidentes = qtdAcidentes;
        
    }
    
}
