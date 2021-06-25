package practica3;

/**
 *
 * @author Luciano Xiquín
 */
public class Almacenamiento {
    Alumno[] arregloAlumno;
    Curso[] arregloCurso;

    public Almacenamiento(Alumno[] arregloAlumno,Curso[] arregloCurso ) {
        this.arregloAlumno = arregloAlumno;
        this.arregloCurso = arregloCurso;
    }
    
    public void bondTogether(Asignado[] asignacion){   
    }

    public Alumno[] getArregloAlumno() {
        return arregloAlumno;
    }

    public Curso[] getArregloCurso() {
        return arregloCurso;
    }
    
}
