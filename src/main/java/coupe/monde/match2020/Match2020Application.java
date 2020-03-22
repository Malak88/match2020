package coupe.monde.match2020;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Match2020Application /*implements CommandLineRunner*/{

	//@Autowired
	//private JoueurRepository m;
	public static void main(String[] args) {
		SpringApplication.run(Match2020Application.class, args);
	}

	/*@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		m.save(new Joueur(null,"malek","bendalla",null));
		m.save(new Joueur(null,"Criestiano","Ronaldo",null));
		m.findAll().forEach(j->{
			System.out.println(j.toString());
					} );
	}*/

}
