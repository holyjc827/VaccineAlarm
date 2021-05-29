import java.util.Scanner;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException{

        Scanner scanner = new Scanner(System.in);
        System.out.println("What year are you born?");
        String year = scanner.nextLine();

        Scraping scraping = new Scraping(year);
        switch(scraping.eligiblityTest()){
            case 0:
                System.out.println("Please register!!");
                break;
            case 1:
                System.out.println("You are not yet eligible!!");
                break;
            case 2:
                System.out.println("[ERROR] Scraping.java::eligibilityTest() >> Something went wrong during the web scraping.");
                break;
        }
    }
}