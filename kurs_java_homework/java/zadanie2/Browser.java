package zadanie2;

public class Browser {
	public static void main(String[] args) {
		String text = "ERNEST HEMINGWAY STARY CZŁOWIEK I MORZE Był starym człowiekiem, który łowił ryby w Golfstromie pływając samotnie łodzią i oto już od osiemdziesięciu czterech dni nie schwytał ani jednej. Przez pierwsze czterdzieści dni pływał z nim pewien chłopiec. Ale po czterdziestu jałowych dniach rodzice oświadczyli mu, że stary jest teraz bezwzględnie i ostatecznie salao, co jest najgorszą formą określenia „pechowy” i chłopiec na ich rozkaz popłynął inną łodzią, która w pierwszym tygodniu złowiła trzy dobre ryby. Smuciło go to, że stary co dzień wraca z pustą łodzią, więc zawsze przychodził i pomagał mu odnosić zwoje linek albo osęk i harpun i żagiel owinięty dokoła masztu. Żagiel był wylatany workami od mąki, a zwinięty wyglądał jak sztandar nieodmiennej klęski. Stary był suchy i chudy, na karku miał głębokie bruzdy. Brunatne plamy po niezłośliwym raku skóry, występującym wskutek odblasku słońca na morzach tropikalnych, widniały na jego policzkach. Plamy te biegły po obu stronach twarzy, a ręce miał poorane głębokimi szramami od wyciągania linką ciężkich ryb. Ale żadna z tych szram nie była świeża. Były one tak stare jak erozje na bezrybnej pustyni. Wszystko w nim było stare prócz oczu, które miały tę samą barwę co morze i były wesołe i niezłomne. - Santiago - powiedział do niego chłopiec, kiedy wspinali się na stromy brzeg od miejsca, gdzie stała łódź wciągnięta na piasek. - Mógłbym znów z tobą popłynąć";
		System.out.println(countWord(text, "stary"));
		System.out.println(countWord(text, "morze"));
		System.out.println("Liczba wszystkich wyrazow: " + countAllWords(text));
		System.out.println(countLastLetters(text, "ec"));
}

	public static int countWord(String text, String word) {
		int count = 0;
		for (String item : text.split(" ")) {
			if(word.equalsIgnoreCase(item)) {
				count++;
			}
		}
		return count;
	}
	
	public static int countAllWords(String text) {
		String [] tekst = text.split(" ");
		int length = tekst.length;
		return length;
	}
	
	public static int countLastLetters(String text, String letters) {
		int count = 0;
		for (String item : text.split(" ")) {
			if(item.endsWith(letters)) {
				count++;
			}
		}
		return count;
	}
}
