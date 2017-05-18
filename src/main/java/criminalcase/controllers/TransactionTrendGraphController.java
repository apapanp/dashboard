package criminalcase.controllers;

import criminalcase.model.TransactionTrend;
import criminalcase.model.TransactionTrendGraph;
import criminalcase.repositories.TransactionTrendGraphRepository;
import criminalcase.repositories.TransactionTrendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by apapan on 5/17/2017 AD.
 */
@RestController
@RequestMapping("/dashboard/TransactionTrendGraphs")
public class TransactionTrendGraphController {
    @Autowired
    private TransactionTrendGraphRepository repository;

    @RequestMapping(method= RequestMethod.GET)
    public ResponseEntity<Collection<TransactionTrendGraph>> getAllTransactionTrend(){
        return new ResponseEntity<>((Collection<TransactionTrendGraph>) repository.findAll(), HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.GET,value="/{id}")
    public ResponseEntity<TransactionTrendGraph> getTxnTrendWithId(@PathVariable Long id)
    {
        return new ResponseEntity<>(repository.findOne(id),HttpStatus.OK);
    }

    @RequestMapping(method=RequestMethod.GET,params = {"accNo"})
    public ResponseEntity<Collection<TransactionTrendGraph>> findTransactionTrendWithAccNo(@RequestParam(value="accNo") Integer accno){
        return new ResponseEntity<>(repository.findByAccno(accno),HttpStatus.OK);

    }

    @RequestMapping(value = "/parameter" , method=RequestMethod.GET  )
    public ResponseEntity<Collection<TransactionTrendGraph>> test2222(@RequestParam Map<String,String> params,HttpServletResponse resp){
        resp.setHeader("Access-Control-Allow-Origin", "*");
        Map<String,String> resultmap = new HashMap<>();
        resultmap = params;
        Date startdate = new Date();
        Date enddate  = new Date();
        DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
        try {
            startdate = df.parse(resultmap.get("startdate"));
            enddate = df.parse(resultmap.get("enddate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String json = "jsonResponse";
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<>(repository.findByStartDateBetweenAndAccNo(startdate,enddate,Integer.parseInt(resultmap.get("accno"))),responseHeaders,HttpStatus.CREATED);
    }
    @RequestMapping(value = "/parameters" , method=RequestMethod.GET  )
    public Map<String,String> test2(@RequestParam Map<String,String> params){
        Map<String,String> resultmap = new HashMap<>();
        resultmap = params;
        return resultmap;
    }

}
