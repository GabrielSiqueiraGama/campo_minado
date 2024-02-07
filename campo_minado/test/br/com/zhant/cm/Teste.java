package br.com.zhant.cm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Teste {

	@Test
	void testIgualDois() {// sem erro
		int x = 1 + 1;
		assertEquals(2, x);
	}
	@Test
	void testIgualTres() {//Com erro
		int b = 7;
		assertEquals(3, b);
	}

}
