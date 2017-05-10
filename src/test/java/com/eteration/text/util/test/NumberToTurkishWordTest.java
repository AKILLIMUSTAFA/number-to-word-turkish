package com.eteration.text.util.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.eteration.text.util.NumberToTurkishWord;

public class NumberToTurkishWordTest {

	@Test
	public void testConvertNumberToWords() {

	

		assertEquals("yedi yüz altmış beş bin dört yüz otuz iki", NumberToTurkishWord.convertNumberToWords(765432));
		assertEquals("yetmiş altı bin beş yüz kırk üç", NumberToTurkishWord.convertNumberToWords(76543));
		assertEquals("yedi bin altı yüz elli dört", NumberToTurkishWord.convertNumberToWords(7654));
		assertEquals("yedi yüz altmış beş", NumberToTurkishWord.convertNumberToWords(765));
		assertEquals("yetmiş altı", NumberToTurkishWord.convertNumberToWords(76));
		assertEquals("on yedi", NumberToTurkishWord.convertNumberToWords(17));
		assertEquals("yedi", NumberToTurkishWord.convertNumberToWords(7));

	}

}
