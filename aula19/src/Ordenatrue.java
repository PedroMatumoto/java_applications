package src;

public class Ordenatrue {
    public void ordenaNumeroDecrescentes(int vetor[]){
        int iA,iB,iT;
        for(iA=0;iA<vetor.length;iA++){
            for(iB=iA+1;iB<vetor.length;iB++){
                if(vetor[iA]<vetor[iB]){
                    iT=vetor[iA];
                    vetor[iA]=vetor[iB];
                    vetor[iB]=iT;
                }
            }
        }   
    }
    
}
