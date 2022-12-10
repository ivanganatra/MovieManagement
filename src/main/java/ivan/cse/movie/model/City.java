package ivan.cse.movie.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "city_id")
    private Long id;

    @Column(name = "name")
    private String name;

    public City(){

    }
    public City(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Theatre> theatre;

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

    public Set<Theatre> getTheatre() {
        return theatre;
    }

    public void setTheatre(Set<Theatre> theatre) {
        this.theatre = theatre;
    }
}
