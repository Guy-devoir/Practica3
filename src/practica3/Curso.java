package practica3;

/**
 * @author Luciano Xiquín
 */
public class Curso {
    private int id_curso;
    private int codigo;
    private String nombre;

    public Curso(int id_curso, int codigo, String nombre) {
        this.id_curso = id_curso;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_curso() {
        return id_curso;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }
    
    
}
