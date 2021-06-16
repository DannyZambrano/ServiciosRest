package com.app.persona.bci;

import com.app.persona.bci.model.Person;
import com.app.persona.bci.model.Phone;
import com.app.persona.bci.repository.IPersonaRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BciApplicationTests {

	@Autowired
	private IPersonaRepository repository;


	@Test
	public void guardaRegistroTest() {

		Person persona = new Person();

		Phone phone = new Phone();

		phone.setCityCode(1234);
		phone.setCountryCode(15);
		phone.setNumber(12265454);

		persona.setName("Danny Zambrano");
		persona.setEmail("dannyjosezambranoLugo@gmail.com");
		persona.setPassword("Cachupin123+");
		persona.setToken("asdasdasdasdasdasdasdasd");
		persona.setPhone(phone);

		repository.save(persona);

		Person validacion = new Person();

		validacion = repository.findByemail(persona.getEmail());


		Assert.assertEquals(validacion.getEmail(), "dannyjosezambranoLugo@gmail.com");

	}

	@Test
	void contextLoads() {
	}

}
