import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        int option = 0;
        Scanner scanner = new Scanner(System.in);
        ArrayList<Professor> professores = new ArrayList<>();
        ArrayList<Curso> cursos = new ArrayList<>();
        ArrayList<Aluno> alunos = new ArrayList<>();

        do {

            System.out.println("Escolha uma das opções a seguir: ");
            System.out.println("1 CADASTRAR PROFESSOR");
            System.out.println("2 CADASTRAR CURSO");
            System.out.println("3 CADASTRAR ALUNO");
            System.out.println("4 LISTAR PROFESSORES");
            System.out.println("5 LISTAR CURSOS");
            System.out.println("6 LISTAR ALUNOS");

            try {
                option = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Opção Inválida, escolha uma opção conforme o menu");
                scanner.nextLine();
                continue;
            }

            switch (option) { // neste switch case, vamos dar opção ao usuário de cadastrar e lista um
                              // professor, curso e aluno,
                case 1:
                    System.out.println("Digite o ID do Professor");
                    int IdProfessor = scanner.nextInt();
                    System.out.println("Digite o nome do professor");
                    String NomeProfessor = scanner.next();
                    System.out.println("Digite o departamento do professor");
                    String Departamento = scanner.next();
                    Professor professor = new Professor(IdProfessor, NomeProfessor, Departamento); // invocar o
                                                                                                   // construtor
                                                                                                   // professor
                    professores.add(professor);
                    break;
                case 2:
                    System.out.println("Digite o ID do curso");
                    int IdCurso = scanner.nextInt();
                    System.out.println("Digite o nome do curso");
                    String NomeCurso = scanner.next();
                    System.out.println("Digite a carga horária do curso");
                    int CargaHoraria = scanner.nextInt();
                    Curso curso = new Curso(IdCurso, NomeCurso, CargaHoraria); // invocar o construtor curso
                    cursos.add(curso);
                    break;
                case 3:
                    System.out.println("Digite o ID do aluno");
                    int IdAluno = scanner.nextInt();
                    System.out.println("Digite o nome do aluno");
                    String NomeAluno = scanner.next();
                    System.out.println("Digite a data de nascimento do aluno");
                    String DataNascimento = scanner.next();
                    System.out.println("Digite o cpf do aluno");
                    String cpf = scanner.next();
                    Aluno aluno = new Aluno(IdAluno, NomeAluno, DataNascimento, cpf); // invocar o construtor aluno
                    alunos.add(aluno);
                    break;
                case 4:
                    System.out.println("Listagem dos professores");
                    for (Professor professorPrint : professores) {
                        System.out.println(professorPrint.NomeProfessor);
                    }
                    break;
                case 5:
                    System.out.println("Listagem dos cursos");
                    for (Curso cursoPrint : cursos) {
                        System.out.println("Curso: " + cursoPrint.NomeCurso + "Carga Horária: "
                                + cursoPrint.CargaHoraria);
                    }
                    break;
                case 6:
                    System.out.println("Listagem dos alunos");
                    for (Aluno AlunoPrint : alunos) {
                        System.out.println(AlunoPrint.NomeAluno);
                    }
                    break;
            }
        } while (option != 7);
    }
}
