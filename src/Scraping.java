import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;


public class Scraping {

    private String year; 
    private ArrayList<String> text;

    public Scraping (String year)
    {
        this.year = year;
        this.text = new ArrayList<String>();
    }

    private void makeConnection() throws IOException {
        try {
            Document page = Jsoup.connect("https://www.rivm.nl/en/covid-19-vaccination/news").get();
            Elements element = page.select(".card-title");
            
            for(Element e:element)
            {
                this.text.add(e.text());
            }         
        } catch (IOException e) {
            System.out.println(e);
        }


    }

    public int eligiblityTest() throws IOException
    {
        this.makeConnection();
        if(this.text.size() > 0)
        {
            for(String s : this.text)
            {
                if(s.contains(year))
                {
                    return 0;
                } 
            }
            return 1;
        }
        else{
            return 2;
        }
    }
}
