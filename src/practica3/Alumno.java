package practica3;

/**
 *
 * @author Luciano Xiquín
 */
public class Alumno {
    //id del alumno
    private int id_alumno;
    private String raw_id;
    //Carnet
    private int carnet;
    private String raw_carnet;
    private String nombre;
    
    private String raw_gender;
    //El boolean genero no representá el género pero sí si el genero es aceptado por el programa.
    private boolean genero;
    //Split para las graficas no para el constructor.
    private int[] birthday;
    private String raw_birthday;
    private boolean removeElement;
    //nota a asignar, poner cero cuando se cargue
    private double nota;

    public Alumno() {

    }

    public Alumno(String raw_id, String raw_carnet, String nombre, String raw_gender, String raw_birthday, double nota, boolean removeElement) {
        this.raw_id = raw_id;
        this.raw_carnet = raw_carnet;
        this.nombre = nombre;
        this.raw_gender = raw_gender;
        this.raw_birthday = raw_birthday;
        this.nota = nota;
        this.removeElement = removeElement;
    }

    //Dividir el cumpleaños, espcialmente util para obtener el año de nacido
    public void splitBirthday() {
        String[] aux = raw_birthday.split("/", 3);
        birthday[0] = Integer.valueOf(aux[0]);
        birthday[1] = Integer.valueOf(aux[1]);
        birthday[2] = Integer.valueOf(aux[2]);
    }
    //comprobar que es un valor valido
    public void setGenero() {
        if ((raw_gender.equals("M")) || (raw_gender.equals("F"))) {
            genero = true;
            removeElement = false;
        } else {
            genero = false;
            removeElement = true;
        }
    }

    public void convertId() {
        try {
           id_alumno = Integer.valueOf(raw_id);
        } catch (Exception e) {
            removeElement = false;
        }

    }

    
    //Este es importante para eliminar
    public boolean isRemoveElement() {
        return removeElement;
    }
    

    //Metodos usuales de getters y setters
    public int getId_alumno() {
        return id_alumno;
    }

    public String getRaw_id() {
        return raw_id;
    }

    public int getCarnet() {
        return carnet;
    }

    public String getRaw_carnet() {
        return raw_carnet;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRaw_gender() {
        return raw_gender;
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

    public void setRaw_id(String raw_id) {
        this.raw_id = raw_id;
    }

    public void setRaw_carnet(String raw_carnet) {
        this.raw_carnet = raw_carnet;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRaw_gender(String raw_gender) {
        this.raw_gender = raw_gender;
    }

    public void setRaw_birthday(String raw_birthday) {
        this.raw_birthday = raw_birthday;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    
}
