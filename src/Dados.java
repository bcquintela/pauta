public class Dados {

    static int numAlunos;
    static String[] nomes;
    static int[] classificacoes;

    static void insereNome(int i, String nome) {
        nomes[i] = nome;
    }

    static void insereClassificacao(int i, int classificacao) {
        classificacoes[i] = classificacao;
    }

    static void ordenaPorNome(int n, String[] nomes, int[] classificacoes) {
        for(int i = 0; i<n; i++) {
            for (int j = i+1; j<n; j++) {
                if(nomes[i].compareTo(nomes[j])>0) {
                    //troca elementos do array de nomes
                    String tempNome = nomes[i];
                    nomes[i] = nomes[j];
                    nomes[j] = tempNome;

                    //troca elementos do array de classificações
                    int tempClassificacao = classificacoes[i];
                    classificacoes[i] = classificacoes[j];
                    classificacoes[j] = tempClassificacao;
                }
            }
        }
    }

    static void ordenaPorClassificacao(int n, int[] classificacoes, String[] nomes) {
        for(int i = 0; i<n; i++) {
            for (int j = i+1; j<n; j++) {
                if(classificacoes[i] < classificacoes[j]) {
                    //troca elementos do array de classificacoes
                    int tempClassificacao = classificacoes[i];
                    classificacoes[i] = classificacoes[j];
                    classificacoes[j] = tempClassificacao;

                    //troca elementos do array de nomes
                    String tempNome = nomes[i];
                    nomes[i] = nomes[j];
                    nomes[j] = tempNome;
                }
            }
        }
    }
}
