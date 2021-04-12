package bryan.travelAPP.domain;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Airline {
    /**
     * Una aerolinea tiene muchos vuelos (flights)
     */
    // en el diagrama no se ve que tiene un id, pero luego en un archivo con valores para introducir de prueba, tiene id autoincrementable
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    /** Relacion uno a muchos de aerolinea{Airline} a vuelo{Flight}*/
    @OneToMany()
    @JoinColumn(name = "Flight_id")
    private Set<Flight> flightSet = new HashSet<>();

    /** constructor vacio  y con sus atributos**/
    public Airline() {
    }

    public Airline(String name) {
        this.name = name;
    }

    public Airline(String name, Set<Flight> flightSet) {
        this.id = id;
        this.name = name;
        this.flightSet = flightSet;
    }

    /** getters y setters **/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Airline{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", flightSet=" + flightSet +
                '}';
    }
}
