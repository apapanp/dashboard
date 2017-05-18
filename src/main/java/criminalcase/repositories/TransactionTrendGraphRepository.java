package criminalcase.repositories;

import criminalcase.model.TransactionTrend;
import criminalcase.model.TransactionTrendGraph;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by apapan on 5/17/2017 AD.
 */
public interface TransactionTrendGraphRepository extends CrudRepository<TransactionTrendGraph,Long> {


    @Modifying
    @Query("select b from TransactionTrendGraph b " +
            "where b.startDate between ?1 and ?2 and b.accno = ?3")
    List<TransactionTrendGraph> findByStartDateBetweenAndAccNo(Date startDate,Date endDate,Integer amount);

    List<TransactionTrendGraph> findByAccno(Integer accno);

}



