package bryan.travelAPP.domain;

import javax.persistence.*;

@Entity
public class Airport {
    /**
     * Un aeropuerto tiene muchos vuelos (flights)
     * - tiene muchos vuelos de salida (departureDate) origen
     * - Tiene muchos vuelos de entrada (arrivalDate) destination
     * los vuelos tiene una fecha y una hora de llegada y una fecha y una hora de salida
     */
    // en el diagrama no se ve que tiene un id, pero luego en un archivo con valores para introducir de prueba, tiene id autoincrementable
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;

    /** constructor vacio y con atributos**/
    public Airport() {
    }

    public Airport(String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    /** getters y setters **/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
