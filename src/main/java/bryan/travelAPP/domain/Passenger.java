package bryan.travelAPP.domain;

import javax.persistence.*;

@Entity
public class Passenger {
    /**
     * un pasajero tiene un asiento(seat) y muchos pasajeros están en un vuelo (flight)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String idNumber;
    private String name;
    private int age;
    private String email;
    private String gender;

    /** Relacion uno a uno con asiento{Seat}*/
    @OneToOne(mappedBy = "Passenger")
    private Seat seat;

    /** Relacion muchos a uno de vuelo{Flight} a pasajero{Passenger}*/
    @ManyToOne
    private Flight flight;

    /** constructor vacio y con atributos**/
    public Passenger() {
    }

    public Passenger(Integer id, String idNumber, String name, int age, String email, String gender) {
        this.id = id;
        this.idNumber = idNumber;
        this.name = name;
        this.age = age;
        this.email = email;
        this.gender = gender;
    }

    /** getters y setters **/
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
