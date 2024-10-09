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
                    System.out.println("Digite o id do professor responsável por este curso: ");
                    int IdCursoProfessor = scanner.nextInt();
                    Curso curso = new Curso(IdCurso, NomeCurso, CargaHoraria, IdCursoProfessor);
                    // invocar o construtor curso
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
                    System.out.println("Digite o id do curso em que o aluno está matriculado");
                    int IdAlunoCurso = scanner.nextInt();
                    Aluno aluno = new Aluno(IdAluno, NomeAluno, DataNascimento, cpf, IdAlunoCurso); // invocar o
                                                                                                    // construtor aluno
                    alunos.add(aluno);
                    break;
                case 4:
                    System.out.println("Listagem dos professores");
                    for (Curso cursoPrint : cursos) {
                        {
                            int countAlunos = contaAlunosPorCurso(cursoPrint.IdCurso, alunos);
                            for (Professor professorPrint : professores) {
                                if (cursoPrint.IdCursoProfessor == professorPrint.IdProfessor)
                                    System.out.println("Nome: " + professorPrint.NomeProfessor + " | Departamento: "
                                            + professorPrint.Departamento + " | Curso: " + cursoPrint.NomeCurso
                                            + " | Quantidade de alunos: " + countAlunos);
                            }
                        }
                    }
                    break;
                case 5:
                    System.out.println("Listagem dos cursos");
                    for (Curso cursoPrint : cursos) {
                        Professor professorDoCurso = buscaProfessorPorId(professores, cursoPrint.IdCursoProfessor);
                        if (professorDoCurso != null) {
                            System.out.println("Curso: " + cursoPrint.NomeCurso +
                                    " | Carga Horária: " + cursoPrint.CargaHoraria +
                                    " | Professor: " + professorDoCurso.NomeProfessor);
                        } else {
                            System.out.println("Curso: " + cursoPrint.NomeCurso +
                                    " | Carga Horária: " + cursoPrint.CargaHoraria +
                                    " | Professor: Não encontrado");
                        }
                    }
                    break;

                case 6:
                    System.out.println("Listagem dos alunos");
                    for (Aluno alunoPrint : alunos) {
                        Curso cursoDoAluno = buscaCursoPorId(cursos, alunoPrint.IdAlunoCurso);
                        if (cursoDoAluno != null) {
                            System.out.println("Aluno: " + alunoPrint.NomeAluno +
                                    " | Curso: " + cursoDoAluno.NomeCurso + " | Data de nascimento: "
                                    + alunoPrint.DataNascimento + " | CPF: " + alunoPrint.cpf);
                        } else {
                            System.out.println("Aluno: " + alunoPrint.NomeAluno +
                                    " | Curso: Não encontrado");
                        }
                    }
                    break;
            }
        } while (option != 7);
    }

    static Curso buscaCursoPorId(ArrayList<Curso> cursos, int idCurso) {
        for (Curso curso : cursos) {
            if (curso.IdCurso == idCurso) {
                return curso;
            }
        }
        return null;
    }

    static Professor buscaProfessorPorId(ArrayList<Professor> professores, int idProfessor) {
        for (Professor professorPrint : professores) {
            if (professorPrint.IdProfessor == idProfessor) {
                return professorPrint;
            }
        }
        return null;
    }

    static int contaAlunosPorCurso(int idCurso, ArrayList<Aluno> alunos) {
        int count = 0;
        for (Aluno alunoPrint : alunos) {
            if (alunoPrint.IdAlunoCurso == idCurso) {
                count++;
            }
        }
        return count;
    }
}
