package aula11.lab.ex1;

import javax.print.attribute.standard.Media;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dialogo extends JDialog implements ActionListener {
    JLabel lb;
    JTextField tf;
    JButton bt;
    int tam;
    int vet[];
    double media;
    double desvpad;
    double variancia;
    double mediana;
    double coef_assi;
    double coef_var;
    double moda;



    public Dialogo(JFrame fr) {
        super(fr, true);
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        lb = new JLabel("Selecione uma opção no menu!");
        cp.add(lb);
        tf = new JTextField(10);
        cp.add(tf);
        bt = new JButton("OK");
        cp.add(bt);
        bt.addActionListener(this);

        //menu vetor
        JMenu vetor = new JMenu("Opções");
        vetor.setMnemonic('O');
        vetor.addSeparator();
        JMenuItem dimensiona = new JMenuItem("Dimensiona");
        dimensiona.setMnemonic('X');
        dimensiona.addActionListener(this);
        JMenuItem digita = new JMenuItem("Digita");
        digita.setMnemonic('I');
        digita.addActionListener(this);
        JMenuItem apresenta = new JMenuItem("Apresenta");
        apresenta.setMnemonic('A');
        apresenta.addActionListener(this);
        //menu Probest
        JMenu probest = new JMenu("Probest");
        JMenuItem media = new JMenuItem("Média");
        media.setMnemonic('X');
        media.addActionListener(this);
        JMenuItem desvpad = new JMenuItem("Desvio padrão");
        desvpad.setMnemonic('I');
        desvpad.addActionListener(this);
        JMenuItem variancia = new JMenuItem("Variancia");
        variancia.setMnemonic('A');
        variancia.addActionListener(this);
        JMenuItem mediana = new JMenuItem("Mediana");
        mediana.setMnemonic('A');
        mediana.addActionListener(this);
        JMenuItem coef_assi = new JMenuItem("Coeficiente de assimetria");
        coef_assi.setMnemonic('A');
        coef_assi.addActionListener(this);
        JMenuItem coef_var = new JMenuItem("Coeficiente de variação");
        coef_var.setMnemonic('A');
        coef_var.addActionListener(this);
        probest.add(media);
        probest.add(desvpad);
        probest.add(variancia);
        probest.add(mediana);
        probest.add(coef_assi);
        probest.add(coef_var);

        //menu CDI
        JMenu CDI = new JMenu("CDI");
        JMenuItem funcao = new JMenuItem("Função");
        funcao.setMnemonic('X');
        funcao.addActionListener(this);
        JMenuItem derivada = new JMenuItem("Derivada");
        derivada.setMnemonic('I');
        derivada.addActionListener(this);

        //menu algesd
        JMenu algesd = new JMenu("ALGESD");
        JMenu ordenacao = new JMenu("Ordenação");
        ordenacao.setMnemonic('X');
        ordenacao.addActionListener(this);
        JMenu busca = new JMenu("Busca");
        busca.setMnemonic('I');
        busca.addActionListener(this);
        //submenu ordenação
        JMenuItem trocas = new JMenuItem("Trocas");
        trocas.setMnemonic('A');
        trocas.addActionListener(this);
        JMenuItem selecao= new JMenuItem("Seleção");
        selecao.setMnemonic('A');
        selecao.addActionListener(this);
        JMenuItem insercao = new JMenuItem("Inserção");
        insercao.setMnemonic('A');
        insercao.addActionListener(this);
        JMenuItem quick = new JMenuItem("Quick");
        quick.setMnemonic('A');
        quick.addActionListener(this);
        JMenuItem merge = new JMenuItem("Merge");
        merge.setMnemonic('A');
        merge.addActionListener(this);
        //submenu busca
        JMenuItem lineariterativa = new JMenuItem("Linear Iterativa");
        lineariterativa.setMnemonic('A');
        lineariterativa.addActionListener(this);
        JMenuItem linearrecursiva = new JMenuItem("Linear Recursiva");
        linearrecursiva.setMnemonic('A');
        linearrecursiva.addActionListener(this);
        JMenuItem binariaiterativa = new JMenuItem("Binária Iterativa");
        binariaiterativa.setMnemonic('A');
        binariaiterativa.addActionListener(this);
        JMenuItem binariarecursiva = new JMenuItem("Binária Recursiva");
        binariarecursiva.setMnemonic('A');
        binariarecursiva.addActionListener(this);
        algesd.add(ordenacao);
        algesd.add(busca);

        busca.add(lineariterativa);
        busca.add(linearrecursiva);
        busca.add(binariaiterativa);
        busca.add(binariarecursiva);

        ordenacao.add(trocas);
        ordenacao.add(selecao);
        ordenacao.add(insercao);
        ordenacao.add(quick);
        ordenacao.add(merge);

        JMenuBar barra = new JMenuBar();
        CDI.add(funcao);
        CDI.add(derivada);
        setJMenuBar(barra);
        barra.add(vetor);
        barra.add(probest);
        barra.add(CDI);
        barra.add(algesd);
        vetor.add(dimensiona);
        vetor.add(digita);
        vetor.add(apresenta);
        setSize(300, 300);
        setLocationRelativeTo(null);
        setTitle("Vetor");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bt.setVisible(false);
        tf.setVisible(false);
        setVisible(true);
        
        if (fr.isVisible() == false)
            System.exit(0);

    }

    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Trocas")){
            Trocas(vet);
            String s = "";
            for (int i = 0; i < vet.length; i++) {
                s += vet[i] + " ";
            }
            lb.setText("Vetor: " + s);
        }
        if(e.getActionCommand().equals("Seleção")){
            selectionSort(vet);
            String s = "";
            for (int i = 0; i < vet.length; i++) {
                s += vet[i] + " ";
            }
            lb.setText("Vetor: " + s);
        }
        if(e.getActionCommand().equals("Inserção")){
            Insertion_Sort(vet);
            String s = "";
            for (int i = 0; i < vet.length; i++) {
                s += vet[i] + " ";
            }
            lb.setText("Vetor: " + s);
        }
        if(e.getActionCommand().equals("Quick")){
            quicksort(vet);
            String s = "";
            for (int i = 0; i < vet.length; i++) {
                s += vet[i] + " ";
            }
            lb.setText("Vetor: " + s);
        }
        if(e.getActionCommand().equals("Merge")){
            mergeSort(vet, 0, vet.length - 1);
            String s = "";
            for (int i = 0; i < vet.length; i++) {
                s += vet[i] + " ";
            }
            lb.setText("Vetor: " + s);
        }

        if(e.getActionCommand().equals("Linear Iterativa")){
            int x = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor a ser buscado: "));
            int i;
            for (i = 0; i < vet.length; i++) {
                if(vet[i] == x){
                    break;
                }
            }
            if(i == vet.length){
                lb.setText("Valor não encontrado");
            }else{
                lb.setText("Valor encontrado na posição: " + i);
            }
        }
        
        if(e.getActionCommand().equals("Linear Recursiva")){
            int x = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor a ser buscado: "));
            int i = 0;
            int pos = buscaLinearRecursiva(vet, x, i);
            if(pos == -1){
                lb.setText("Valor não encontrado");
            }else{
                lb.setText("Valor encontrado na posição: " + pos);
            }
        }
        if(e.getActionCommand().equals("Binária Iterativa")){
            int opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a busca a ser utilizada: \n1 - Trocas \n2 - Selection \n3 - Insertion \n4 - Quick\n5 - Merge"));
            switch (opcao) {
                case 1:
                Trocas(vet);
                    break;
                case 2:
                selectionSort(vet);
                    break;
                
                case 3:
                Insertion_Sort(vet);
                    break;
                case 4:
                quicksort(vet);
                    
                    break;
                case 5:
                mergeSort(vet, 0, vet.length - 1);
                    break;
                default:
                    break;
            }
            int x = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor a ser buscado: "));
            int i = 0;
            int f = vet.length - 1;
            int pos = buscaBinariaIterativa(vet, x, i, f);
            if(pos == -1){
                lb.setText("Valor não encontrado");
            }else{
                lb.setText("Valor encontrado na posição: " + pos);
            }
        }

        if(e.getActionCommand().equals("Binária Recursiva")){
            int opcao = Integer.parseInt(JOptionPane.showInputDialog(
                    "Digite a busca a ser utilizada: \n1 - Trocas \n2 - Selection \n3 - Insertion \n4 - Quick\n5 - Merge"));
            switch (opcao) {
                case 1:
                    Trocas(vet);
                    break;
                case 2:
                    selectionSort(vet);
                    break;

                case 3:
                    Insertion_Sort(vet);
                    break;
                case 4:
                    quicksort(vet);

                    break;
                case 5:
                    mergeSort(vet, 0, vet.length - 1);
                    break;
                default:
                    break;
            }
            int x = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor a ser buscado: "));
            int i = 0;
            int f = vet.length - 1;
            int pos = buscaBinariaRecursiva(vet, x, i, f);
            if(pos == -1){
                lb.setText("Valor não encontrado");
            }else{
                lb.setText("Valor encontrado na posição: " + pos);
            }
        }

        if(e.getActionCommand().equals("Função")){

        }
        if(e.getActionCommand().equals("Derivada")){

        }
        if(e.getActionCommand().equals("Média")){
            media = 0;
            for (int i = 0; i < vet.length; i++) {
                media += vet[i];
            }
            media = media/vet.length;
            lb.setText("Média: "+media);
        }
        if(e.getActionCommand().equals("Desvio padrão")){
            media=0;
            desvpad=0;
            for (int i = 0; i < vet.length; i++) {
                media += vet[i];
            }
            media = media/vet.length;
            double desvpad = 0;
            for (int i = 0; i < vet.length; i++) {
                desvpad += Math.pow(vet[i]-media, 2);
            }
            desvpad = Math.sqrt(desvpad/vet.length);
            lb.setText("Desvio padrão: "+desvpad);
        }
        if(e.getActionCommand().equals("Variancia")){
            media =0;
            for (int i = 0; i < vet.length; i++) {
                media += vet[i];
            }
            media = media/vet.length;
            variancia = 0;
            for (int i = 0; i < vet.length; i++) {
                variancia += Math.pow(vet[i]-media, 2);
            }
            variancia = variancia/vet.length;
            lb.setText("Variância: "+variancia);
        }
        if(e.getActionCommand().equals("Mediana")){
            int aux;
            mediana=0;
            for (int i = 0; i < vet.length; i++) {
                for (int j = 0; j < vet.length; j++) {
                    if(vet[i]<vet[j]){
                        aux = vet[i];
                        vet[i] = vet[j];
                        vet[j] = aux;
                    }
                }
            }
            if(vet.length%2==0){
                mediana = (vet[vet.length/2]+vet[(vet.length/2)-1])/2;
            }else{
                mediana = vet[vet.length/2];
            }
            lb.setText("Mediana: "+mediana);
        }
        if(e.getActionCommand().equals("Coeficiente de assimetria")){

            double primeiroquartil;
            double terceiroquartil;
            double coef_assi;
            int aux;
            mediana=0;
            for (int i = 0; i < vet.length; i++) {
                for (int j = 0; j < vet.length; j++) {
                    if(vet[i]<vet[j]){
                        aux = vet[i];
                        vet[i] = vet[j];
                        vet[j] = aux;
                    }
                }
            }
            if(vet.length%2==0){
                mediana = (vet[vet.length/2]+vet[(vet.length/2)-1])/2;
            }else{
                mediana = vet[vet.length/2];
            }
            primeiroquartil = vet[vet.length/4];
            terceiroquartil = vet[(vet.length/4)*3];
            coef_assi = (terceiroquartil+primeiroquartil-(2*mediana))/(terceiroquartil-primeiroquartil);
            lb.setText("Coeficiente de assimetria de Pearson: "+coef_assi);

        }
        if (e.getActionCommand().equals("Coeficiente de variação")) {
            for (int i = 0; i < vet.length; i++) {
                media += vet[i];
            }
            media = media / vet.length;

            double desvpad = 0;
            for (int i = 0; i < vet.length; i++) {
                desvpad += Math.pow(vet[i] - media, 2);
            }
            desvpad = Math.sqrt(desvpad / vet.length);
            double cov = (desvpad/media);
            lb.setText("Coeficiente de variação: "+cov);
        }

        if (e.getActionCommand().equals("Dimensiona")) {
            tf.setVisible(true);
            bt.setVisible(true);
            tam = Integer.parseInt(JOptionPane.showInputDialog("Digite o tamanho do vetor: "));
            vet = new int[tam];
            tf.setVisible(false);
            bt.setVisible(false);
            lb.setText("Vetor dimensionado!");
        }
        if (e.getActionCommand().equals("Digita")) {
            tf.setVisible(true);
            bt.setVisible(true);
            for (int i = 0; i < vet.length; i++) {
                vet[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor da posição " + i + ": "));
            }
            tf.setVisible(false);
            bt.setVisible(false);
            lb.setText("Vetor preenchido!");
        }
        if (e.getActionCommand().equals("Apresenta")) {
            tf.setVisible(false);
            bt.setVisible(false);
            String s = "";
            for (int i = 0; i < vet.length; i++) {
                s += vet[i] + " ";
            }
            lb.setText("Vetor: "+s);
        }
        if (e.getSource() == bt) {
            dispose();
        }

    }

    public int buscaLinearRecursiva(int[] vetor, int valor, int posicao) {
        if (posicao >= vetor.length) {
            return -1;
        } else if (vetor[posicao] == valor) {
            return posicao;
        } else {
            return buscaLinearRecursiva(vetor, valor, posicao + 1);
        }
    }

    public int buscaBinariaIterativa(int[] vetor, int valor, int posicao, int fim){
        int meio;
        while (posicao <= fim) {
            meio = (posicao + fim) / 2;
            if (vetor[meio] == valor) {
                return meio;
            } else if (vetor[meio] < valor) {
                posicao = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return -1;
    }

    public void Insertion_Sort(int []vetor){
        int aux;
        for (int i = 1; i < vet.length; i++) {
            aux = vet[i];
            for (int j = i - 1; j >= 0 && vet[j] > aux; j--) {
                vet[j + 1] = vet[j];
                vet[j] = aux;
            }
        }
    }

    public void Trocas(int [] vetor){
        int aux;
        for (int i = 0; i < vet.length; i++) {
            for (int j = 0; j < vet.length; j++) {
                if (vet[i] < vet[j]) {
                    aux = vet[i];
                    vet[i] = vet[j];
                    vet[j] = aux;
                }
            }
        }
    }
    public int buscaBinariaRecursiva(int[] vetor, int valor, int inicio, int fim) {
        if (inicio > fim) {
            return -1;
        } else {
            int meio = (inicio + fim) / 2;
            if (vetor[meio] == valor) {
                return meio;
            } else if (vetor[meio] < valor) {
                return buscaBinariaRecursiva(vetor, valor, meio + 1, fim);
            } else {
                return buscaBinariaRecursiva(vetor, valor, inicio, meio - 1);
            }
        }
    }



    public static void quicksort(int[] vetor) {
        quicksort(vetor, 0, vetor.length - 1);
    }

    private static void quicksort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int indicePivo = particionar(vetor, inicio, fim);
            quicksort(vetor, inicio, indicePivo - 1);
            quicksort(vetor, indicePivo + 1, fim);
        }
    }

    private static int particionar(int[] vetor, int inicio, int fim) {
        int pivo = vetor[fim];
        int i = inicio - 1;
        for (int j = inicio; j < fim; j++) {
            if (vetor[j] <= pivo) {
                i++;
                trocar(vetor, i, j);
            }
        }
        trocar(vetor, i + 1, fim);
        return i + 1;
    }

    private static void trocar(int[] vetor, int i, int j) {
        int temp = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = temp;
    }

    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);

            merge(array, left, middle, right);
        }
    }

    public static void merge(int[] array, int left, int middle, int right) {
        int[] pivo = new int[array.length];

        for (int i = left; i <= right; i++) {
            pivo[i] = array[i];
        }

        int pivoLeft = left;
        int pivoRight = middle + 1;
        int atual = left;

        while (pivoLeft <= middle && pivoRight <= right) {
            if (pivo[pivoLeft] <= pivo[pivoRight]) {
                array[atual] = pivo[pivoLeft];
                pivoLeft++;
            } else {
                array[atual] = pivo[pivoRight];
                pivoRight++;
            }
            atual++;
        }

        int restante = middle - pivoLeft;
        for (int i = 0; i <= restante; i++) {
            array[atual + i] = pivo[pivoLeft + i];
        }
    }
     
    public static void selectionSort(int[] array) {
        int tam = array.length;
        for (int i = 0; i < tam - 1; i++) {
            int pivo = i;
            for (int j = i + 1; j < tam; j++)
                if (array[j] < array[pivo])
                    pivo = j;
            int aux = array[pivo];
            array[pivo] = array[i];
            array[i] = aux;
        }

    }
    

}
