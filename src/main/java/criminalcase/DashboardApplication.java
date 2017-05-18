package criminalcase;

import com.github.javafaker.Faker;
import criminalcase.model.Pie;
import criminalcase.model.TransactionTrend;
import criminalcase.model.TransactionTrendGraph;
import criminalcase.repositories.PieRepository;
import criminalcase.repositories.TransactionTrendGraphRepository;
import criminalcase.repositories.TransactionTrendRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class DashboardApplication {

	private final Faker faker = new Faker();
	public static void main(String[] args) {
		SpringApplication.run(DashboardApplication.class, args);
	}

	@Bean
	public CommandLineRunner initializeDb(PieRepository repository){
		return (args) -> {
			repository.deleteAll();
			//Insert some random pies
			for(int i = 0; i < 20; i++) {
				repository.save(new Pie(faker.lorem().word(), faker.lorem().sentence()));
			}
		};
	}

	@Bean
	public CommandLineRunner initializeDbs(TransactionTrendRepository repository){
		return (args) -> {
			repository.deleteAll();
			//Insert some random pies
			for(int i = 0; i < 20; i++) {
				repository.save(new TransactionTrend(2010+i,10000.00+(i*10),123456+i));
			}
		};
	}

	@Bean
	public CommandLineRunner initializeDbsss(TransactionTrendGraphRepository repository){
		return (args) -> {

			//Insert some random pies
			for(int i = 0; i < 50; i++) {
				DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
				String j = String.valueOf(i+1);
				Date startDate = df.parse(j+"/10/2016");
				repository.save(new TransactionTrendGraph(startDate,10000.00+(i*100),123475));
			}
		};
	}
}
