package criminalcase.repositories;

/**
 * Created by apapan on 5/15/2017 AD.
 */

import criminalcase.model.TransactionTrend;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.stream.Stream;

public interface TransactionTrendRepository extends CrudRepository<TransactionTrend,Long> {
    List<TransactionTrend> findByYears(Integer years);
    List<TransactionTrend> findByAccno(Integer accno);
    List<TransactionTrend> findTransactionTrendByAccnoAndYears(Integer accno,Integer years);
}
