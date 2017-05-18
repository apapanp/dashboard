package criminalcase.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by apapan on 5/17/2017 AD.
 */
@Entity
public class TransactionTrendGraph {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date startDate;
    private Double amounts;
    private Integer accno;

    public TransactionTrendGraph(Date startDate, Double amounts,Integer accno){
       this.startDate=startDate;

       this.accno=accno;
       this.amounts=amounts;
    }

    public TransactionTrendGraph() {}



    public Date getStartDate(){
        return startDate;
    }
    public Double getAmounts() {return amounts;}
    public Integer getAccno() { return accno;}

}
