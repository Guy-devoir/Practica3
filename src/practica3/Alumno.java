package practica3;

/**
 *
 * @author Luciano Xiquín
 */
public class Alumno {
    //id del alumno
    private int id_alumno;    
    //Carnet
    private int carnet;    
    private String nombre;        
    //El boolean genero no representá el género pero sí si el genero es aceptado por el programa.
    private boolean genero;
    //Split para las graficas no para el constructor.
    private int[] birthday = new int[3];
    private String raw_birthday;    
    //nota a asignar, poner cero cuando se cargue
    private double nota;
    
    
    public Alumno() {

    }

    public Alumno(int id_alumno, int carnet, String nombre, boolean genero, String raw_birthday, double nota) {
        this.id_alumno = id_alumno;
        this.carnet = carnet;
        this.nombre = nombre;
        this.genero = genero;
        this.raw_birthday = raw_birthday;
        this.nota = nota;
    }

    //Dividir el cumpleaños, espcialmente util para obtener el año de nacido
    public void splitBirthday() {
        String[] aux = raw_birthday.split("/");
        birthday[0] = Integer.valueOf(aux[0]);
        birthday[1] = Integer.valueOf(aux[1]);
        birthday[2] = Integer.valueOf(aux[2]);
    }
   
    //Metodos usuales de getters y setters
    public int getId_alumno() {
        return id_alumno;
    }

    public int getCarnet() {
        return carnet;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isGenero() {
        return genero;
    }

    public int[] getBirthday() {
        return birthday;
    }

    public String getRaw_birthday() {
        return raw_birthday;
    }

    public double getNota() {
        return nota;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRaw_birthday(String raw_birthday) {
        this.raw_birthday = raw_birthday;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public int getAge() {
        splitBirthday();
        int edad = 2021 - birthday[2];
        return edad;
    }
}
