import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    private static void printMenu() {
        String[] opcoes = {"1- Apresentar pauta",
                "2- Introduzir classificações na pauta",
                "3- Pesquisar classificação de aluno",
                "4- Ordenar a pauta alfabeticamente",
                "5- Ordenar a pauta por classificação (decrescente)",
                "6- Sair",
        };

        System.out.println();
        System.out.println("----------------------MENU------------------------");

        for (String opcao : opcoes){
            System.out.println(opcao);
        }

        System.out.println("--------------------------------------------------");
        System.out.println();
        System.out.print("Introduza a sua opção : ");
    }

    private static void printPauta() {
        System.out.println();
        System.out.println("Aluno | Classificação");
        System.out.println("---------------------");

        if(Dados.nomes != null) {
            for(int i=0; i<Dados.nomes.length; i++) {
                System.out.println(Dados.nomes[i] + " | " + Dados.classificacoes[i]);
            }
        }
    }

    private static void introduzAlunos() {
        Scanner scanner = new Scanner(System.in);

        Dados.nomes = null;
        Dados.classificacoes = null;

        System.out.println("Introduza o número de alunos da turma: ");
        Dados.numAlunos = Integer.parseInt(scanner.nextLine());
        Dados.nomes = new String[Dados.numAlunos];
        Dados.classificacoes = new int[Dados.numAlunos];

        for(int i = 0; i<Dados.numAlunos; i++) {
            System.out.println("Introduza o nome do aluno: ");
            String nome = scanner.nextLine();
            Dados.insereNome(i,nome);

            System.out.println("Introduza a classificação do aluno " + nome + ":");
            Dados.insereClassificacao(i,Integer.parseInt(scanner.nextLine()));
        }
    }

    private static void pesquisaClassificacao() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduza o nome do aluno a pesquisar:");
        String nome = scanner.nextLine();
        int classificacao = -1;

        for(int i = 0; i< Dados.nomes.length; i++) {
            if(Dados.nomes[i].equalsIgnoreCase(nome)){
                classificacao = Dados.classificacoes[i];
            }
        }

        if(classificacao == -1) {
            System.out.println("Aluno não encontrado na pauta.");
        }
        else {
            System.out.println("Classificação do aluno " + nome + ": " + classificacao);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int escolha = 1;
        while (escolha != 6) {
            printMenu();
            try {
                escolha = scanner.nextInt();
                switch (escolha) {
                    case 1: printPauta(); break;
                    case 2: introduzAlunos(); break;
                    case 3: pesquisaClassificacao(); break;
                    case 4: Dados.ordenaPorNome(Dados.numAlunos,Dados.nomes,Dados.classificacoes); break;
                    case 5: Dados.ordenaPorClassificacao(Dados.numAlunos,Dados.classificacoes,Dados.nomes); break;
                    case 6: exit(0);
                    default: System.out.println("Por favor, introduza um valor entre 1 e 6");
                }
            } catch (Exception ex) {
                System.out.println("Por favor, introduza um valor entre 1 e 6");
                scanner.next();
            }
        }
    }
}