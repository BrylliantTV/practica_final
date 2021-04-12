package bryan.travelAPP.repository;

import bryan.travelAPP.domain.Seat;
import org.springframework.data.repository.CrudRepository;

public interface SeatRepository extends CrudRepository<Seat, Long> {
}
