package aula5.lab;

import javax.swing.JOptionPane;

public class ex24 {
    public static void main(String[] args) {

        double candi=0;
    
        double v1=0,v2=0,v3=0,v4=0,total=0;
        do{
            String candidato = JOptionPane.showInputDialog("Voto:");
            candi = Double.parseDouble(candidato);
            
            if(candi==1) {v1++;total++;};
            if(candi==2) {v2++;total++;};
            if(candi==3) {v3++;total++;};
            if(candi==4) {v4++;total++;};

        }
        while(candi!=-1);
        System.out.println((v1/total)*100 +" "+(v2/total)*100+" "+(v3/total)*100+" "+ (v4 / total)*100);
               
    }
    
}
