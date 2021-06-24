package practica3;

/**
 *
 * @author Luciano Xiquín
 */
class Asignado {
    private int id_alumno;
    private int id_curso;
    private double nota;

    public Asignado(int id_alumno, int id_curso, double nota) {
        this.id_alumno = id_alumno;
        this.id_curso = id_curso;
        this.nota = nota;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public int getId_curso() {
        return id_curso;
    }

    public double getNota() {
        return nota;
    }
    
}
