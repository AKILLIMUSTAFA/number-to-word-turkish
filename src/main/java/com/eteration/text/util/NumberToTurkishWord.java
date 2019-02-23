package com.eteration.text.util;

public class NumberToTurkishWord {

	public static void main(String[] args) {
		System.out.println(convertNumberToWords(765432));
		System.out.println(convertNumberToWords(76543));
		System.out.println(convertNumberToWords(7654));
		System.out.println(convertNumberToWords(765));
		System.out.println(convertNumberToWords(76));
		System.out.println(convertNumberToWords(17));
		System.out.println(convertNumberToWords(7));
	}

	private static final String[] lowNames = { "sıfır", "bir", "iki", "üç", "dört", "beş", "altı", "yedi", "sekiz",
			"dokuz"};

	private static final String[] lowNamesForOneHundred = { "", "", "iki ", "üç ", "dört ", "beş ", "altı ", "yedi ", "sekiz ",
			"dokuz "};

	private static final String[] tensNames = {	"on", "yirmi", "otuz", "kırk", "elli", "altmış", "yetmiş", "seksen",
			"doksan" };

	private static final String[] bigNames = { "bin", "milyon", "milyar" };


	public static String convertNumberToWords(int n) {
		if (n < 0) {
			return "eksi " + convertNumberToWords(-n);
		}
		if (n <= 999) {
			return convert999(n);
		}
		String s = null;
		int t = 0;
		while (n > 0) {
			if (n % 1000 != 0) {
				String s2 = convert999(n % 1000);
				if (t > 0) {
					if(t - 1 == 0 && s2.equals(lowNames[1])){
						s2 = bigNames[t - 1];
					}
					else{
						s2 = s2 + " " + bigNames[t - 1];
					}
				}
				if (s == null) {
					s = s2;
				} else {
					s = s2 + " " + s;
				}
			}
			n /= 1000;
			t++;
		}
		return s;
	}

	private static String convert999(int n) {
		String s1 = lowNamesForOneHundred[n / 100] + "yüz";
		String s2 = convert99(n % 100);
		if (n <= 99) {
			return s2;
		} else if (n % 100 == 0) {
			return s1;
		} else {
			return s1 + " " + s2;
		}
	}

	private static String convert99(int n) {
		if (n < 10) {
			return lowNames[n];
		}
		String s = tensNames[n / 10 - 1];
		if (n % 10 == 0) {
			return s;
		}
		return s + " " + lowNames[n % 10];
	}
}
