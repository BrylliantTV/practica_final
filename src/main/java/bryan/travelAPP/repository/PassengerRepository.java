package bryan.travelAPP.repository;

import bryan.travelAPP.domain.Flight;
import bryan.travelAPP.domain.Passenger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PassengerRepository extends CrudRepository<Passenger, Integer> {
    Page<Passenger> findAll(Pageable pageable);
    List<Passenger> findAll(Sort sort);
}
