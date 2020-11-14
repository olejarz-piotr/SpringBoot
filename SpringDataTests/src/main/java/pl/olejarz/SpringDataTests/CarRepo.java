package pl.olejarz.SpringDataTests;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepo  extends CrudRepository<Car,Integer> {

    List<Car>findAllByColor(Color color);

}
