package com.ait.generator;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.stereotype.Component;

import com.ait.entity.SSN_Entity;

@Component
public class SSN_Number_Generator implements IdentifierGenerator {

	Random r = new Random();
	Session session1;

	int attempt = 0;

	public int generate9DigitNumber() {
		int aNumber = (int) ((Math.random() * 900000000) + 100000000);
		return aNumber;
	}

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

		session1 = (Session) session;
		Integer id = generateRandomIndex();
		System.out.println("id "+id);
		return id;

	}

	public Integer generateRandomIndex() {
		for (int i = 0; i < 3; i++) {
			Integer a = generate9DigitNumber();

			if (session1.get(SSN_Entity.class, a) == null) {

				return a;
			} else {

			}
		}

		for (int i = 100000000; i < 999999999; i++) {
			if (session1.get(SSN_Entity.class, i) == null) {

				return i;
			}
		}
		return null;
	}

}
