package criminalcase.repositories;

import criminalcase.model.Pie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by apapan on 5/15/2017 AD.
 */
public interface PieRepository extends CrudRepository<Pie,Long> {
    List<Pie> findByName (String name);
}