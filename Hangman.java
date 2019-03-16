/**
 * @author Peter Betz
 * 11.03.2019
 */

public class Hangman {
    public static void main(String[] args) {
        String[] words = {"Lebenswerk", "Baumhaus", "Zimmer", "Wohnung", "Werbebudget", "Englischkurs",
                "Staubsauger", "Lachnummer", "Garantie", "Glaubensfrage", "Wetteinsatz", "Farbeinspiel",
                "Warnstreik", "Konferenz", "Unterhaltung", "Hauptquartier", "Hochzeit", "Kandidat",
                "Gesundheit", "Blutzuckerwert", "Rechtsausschuss", "Ankündigung", "Maulwurf", "Experiment",
                "Forschungsstudie", "Gesundheit", "Depression", "'Doktortitel", "Ozean", "Entwarnung",
                "Intelligenz", "Gymnasium", "Nachbarschaft", "Nachwuchs", "Mondlandung", "Veranstaltung",
                "Redaktion", "Immobilienmarkt", "Datenschutz", "Hubschrauber", "Landeanflug", "Deutschland",
                "Obduktion", "Katastrophe", "Liebe", "Gewitterregen", "Sachverständiger", "Sportplatz",
                "Stromleitung", "Grenzmauer", "Gouverneur", "Bauernhof", "Rattenplage", "Phänomen",
                "Kilogramm", "Population", "Stromschlag", "Transportunternehmen", "Zoobesucher", "Vergangenheit"};
        int number = (int) (Math.random() * 60 ); // Zahl zwischen 0 und 59

        String unformattedSecretWord = words[number];
        String secretWord = "";
        int exit = 0;

        for (int i = 0; i < unformattedSecretWord.length(); i++)
            secretWord += Character.toUpperCase(unformattedSecretWord.charAt(i));

        String guessedWord = "", guessedChars = "", ergebnis = "";
        char c;
        int l = secretWord.length(), v = 12;

        for (int i = 1; i <= l; i++) guessedWord += "*";
        for (int i = 1; i < 100; i++) System.out.println();
        System.out.println(" _                                             ");
        System.out.println("| |                                            ");
        System.out.println("| |__   __ _ _ __   __ _ _ __ ___   __ _ _ __  ");
        System.out.println("| '_ \\ / _` | '_ \\ / _` | '_ ` _ \\ / _` | '_ \\ ");
        System.out.println("| | | | (_| | | | | (_| | | | | | | (_| | | | |");
        System.out.println("|_| |_|\\__,_|_| |_|\\__, |_| |_| |_|\\__,_|_| |_|");
        System.out.println("                    __/ |                      ");
        System.out.println("Text Version am    |___/   11.3.2019           ");
        System.out.println("                           von Peter Betz      ");
        System.out.printf("Errate das geheime Wort und versuche den Hangman zu retten.%n");
        System.out.println("( a - z , ä ö ü ß sind als Eingaben erlaubt )");
        System.out.printf("Gib '!' ein, wenn Du glaubst, das Wort zu kennen.%n%n");
        System.out.println();
        System.out.println(guessedWord);
        for (int i = v; i > 0; i--) {
            System.out.println();
            switch (i) {
                case 11:
                    System.out.println("  ___ ___             ");
                    break;
                case 10:
                    System.out.println("  ___|___             ");
                    break;
                case 9:
                    System.out.println("     |				  ");
                    System.out.println("  ___|___             ");
                    break;
                case 8:
                    System.out.println("     |                ");
                    System.out.println("     |				  ");
                    System.out.println("  ___|___             ");
                    break;
                case 7:
                    System.out.println("     |                ");
                    System.out.println("     |                ");
                    System.out.println("     |				  ");
                    System.out.println("  ___|___             ");
                    break;
                case 6:
                    System.out.println("     |                ");
                    System.out.println("     |                ");
                    System.out.println("     |                ");
                    System.out.println("     |				  ");
                    System.out.println("  ___|___             ");
                    break;
                case 5:
                    System.out.println("     |                ");
                    System.out.println("     |                ");
                    System.out.println("     |                ");
                    System.out.println("     |                ");
                    System.out.println("     |				  ");
                    System.out.println("  ___|___             ");
                    break;
                case 4:
                    System.out.println("     |/               ");
                    System.out.println("     |                ");
                    System.out.println("     |                ");
                    System.out.println("     |                ");
                    System.out.println("     |                ");
                    System.out.println("     |				  ");
                    System.out.println("  ___|___             ");
                    break;
                case 3:
                    System.out.println("      ___             ");
                    System.out.println("     |/               ");
                    System.out.println("     |                ");
                    System.out.println("     |                ");
                    System.out.println("     |                ");
                    System.out.println("     |                ");
                    System.out.println("     |				  ");
                    System.out.println("  ___|___             ");
                    break;
                case 2:
                    System.out.println("      _______         ");
                    System.out.println("     |/               ");
                    System.out.println("     |                ");
                    System.out.println("     |                ");
                    System.out.println("     |                ");
                    System.out.println("     |                ");
                    System.out.println("     |				  ");
                    System.out.println("  ___|___             ");
                    break;
                case 1:
                    System.out.println("      _______         ");
                    System.out.println("     |/      |        ");
                    System.out.println("     |                ");
                    System.out.println("     |                ");
                    System.out.println("     |                ");
                    System.out.println("     |                ");
                    System.out.println("     |				  ");
                    System.out.println("  ___|___             ");
                    break;
            }
            System.out.println();
            System.out.printf("Du hast noch %d Versuche!%n%n", i);
            char unformattedChar = new java.util.Scanner(System.in).next().charAt(0);
            c = Character.toUpperCase(unformattedChar);
            if (c == '!') {
                System.out.println("Wie lautet das geheime Wort?");
                String unformattedErgebnis = new java.util.Scanner(System.in).next();
                for (int j = 0; j < unformattedErgebnis.length(); j++) {
                    ergebnis += Character.toUpperCase(unformattedErgebnis.charAt(j));
                }
                if (ergebnis.equals(secretWord)) {
                    System.out.println();
                    System.out.println("*********************");
                    System.out.println("* Du hast gewonnen! *");
                    System.out.println("*********************");
                    exit = 1;
                    break;
                } else {
                    System.out.println();
                    System.out.println("Leider falsch! Ein Versuch weniger.");
                    i--;
                }
            }
            for (int j = 0; j < l; j++) {
                char d = secretWord.charAt(j);
                char e = guessedWord.charAt(j);
                if (c == d) {
                    guessedChars += d;
                } else if (e != '*') {
                    guessedChars += e;
                } else {
                    guessedChars += "*";
                }
            }
            guessedWord = guessedChars;
            guessedChars = "";
            System.out.println();
            System.out.println(guessedWord);
            if (guessedWord.equals(secretWord)) {
                System.out.println();
                System.out.println("*********************");
                System.out.println("* Du hast gewonnen! *");
                System.out.println("*********************");
                exit = 1;
                break;
            }
        }
        if (exit == 0) {
            System.out.println("      _______         ");
            System.out.println("     |/      |        ");
            System.out.println("     |      (_)       ");
            System.out.println("     |      \\|/       ");
            System.out.println("     |       |        ");
            System.out.println("     |      / \\       ");
            System.out.println("     |				  ");
            System.out.println("  ___|___             ");
            System.out.println();
            System.out.println("Das war wohl nichts...");
            System.out.println();
            System.out.println("Das gesuchte Wort war: " + secretWord);
        }
    }
}

