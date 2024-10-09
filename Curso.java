public class Curso {
    int IdCurso;
    String NomeCurso;
    int CargaHoraria;
    int IdCursoProfessor;


    public Curso(
        int IdCurso,
        String NomeCurso,
        int CargaHoraria,
        int IdCursoProfessor
    ){
        this.IdCurso = IdCurso;
        this.NomeCurso = NomeCurso;
        this.CargaHoraria = CargaHoraria;
        this.IdCursoProfessor = IdCursoProfessor;
    }

}
