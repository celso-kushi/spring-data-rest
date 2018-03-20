package br.com.kushi.springdatarest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataBaseLoader implements CommandLineRunner {

	private final PessoaRepository repository;
	
	@Autowired
	public DataBaseLoader(PessoaRepository repository) {
		this.repository = repository;
	}



	@Override
	public void run(String... args) throws Exception {
		this.repository.save(new Pessoa("Frodo", "Baggins"));
	}

}
