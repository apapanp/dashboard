package criminalcase.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by apapan on 5/15/2017 AD.
 */
@Entity
public class TransactionTrend {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer years;
    private Double amounts;
    private Integer accno;

    public TransactionTrend(Integer years,Double amounts,Integer accno){
        this.years=years;
        this.amounts=amounts;
        this.accno = accno;
    }

    // for JPA
    public TransactionTrend() {}

    public Integer getYears(){
        return years;
    }
    public Double getAmounts(){
        return amounts;
    }
    public Integer getAccno(){
        return accno;
    }


}
