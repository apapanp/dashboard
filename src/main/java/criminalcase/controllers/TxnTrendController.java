package criminalcase.controllers;

import criminalcase.model.TransactionTrend;
import criminalcase.repositories.PieRepository;
import criminalcase.repositories.TransactionTrendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by apapan on 5/15/2017 AD.
 */
@RestController
@RequestMapping("/dashboard/TxnTrendGraph")
public class TxnTrendController {
    @Autowired
    private TransactionTrendRepository repository;
    @RequestMapping(method= RequestMethod.GET)
    public ResponseEntity<Collection<TransactionTrend>> getAllTransactionTrend(){
        return new ResponseEntity<>((Collection<TransactionTrend>) repository.findAll(), HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.GET,value="/{id}")
    public ResponseEntity<TransactionTrend> getTxnTrendWithId(@PathVariable Long id)
    {
        return new ResponseEntity<>(repository.findOne(id),HttpStatus.OK);
    }
    @RequestMapping(method=RequestMethod.GET,params = {"suspiciousAccNo"})
    public ResponseEntity<Collection<TransactionTrend>> findTransactionTrendWithAccNo(@RequestParam(value="suspiciousAccNo") Integer accno){
        return new ResponseEntity<>(repository.findByAccno(accno),HttpStatus.OK);
    }
    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<?> addTxnTrend(@RequestBody TransactionTrend input){
        return new ResponseEntity<>(repository.save(input),HttpStatus.CREATED);
    }

    @RequestMapping(value = "/test", method=RequestMethod.GET,params = {"accno"})
    public String test(@RequestParam(value="accno") String accno){
        return accno;
    }

    @RequestMapping(value = "/parameters" , method=RequestMethod.GET  )
    public Map<String,String> test2(@RequestParam Map<String,String> params){
        Map<String,String> resultmap = new HashMap<>();
        resultmap = params;
        return resultmap;
    }

    @RequestMapping(value = "/parameter" , method=RequestMethod.GET  )
    public ResponseEntity<Collection<TransactionTrend>> test2222(@RequestParam Map<String,String> params){
        Map<String,String> resultmap = new HashMap<>();
        resultmap = params;
        return new ResponseEntity<>(repository.findTransactionTrendByAccnoAndYears(Integer.parseInt(resultmap.get("accno")),Integer.parseInt(resultmap.get("years"))),HttpStatus.OK);
    }



}
