package ivan.cse.movie.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "seat")
public class  Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "seat_id")
    private Long id;

    @Column(name = "seat_number")
    private Long seatNumber;

    @Column(name = "seat_type")
    private Long seatType;

    @Column(name = "seat_status")
    private Long seatStatus;

    @ManyToOne
    @JoinColumn(name = "auditorium_id")
    @JsonManagedReference
    private Auditorium auditorium;

    @OneToMany(mappedBy = "seat", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<SeatBooked> bookedSeats;
}
