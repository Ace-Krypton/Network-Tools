import java.io.*;
import java.net.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLScraping {
    public static void main(String[] args) {
        /* URL Connection
        * http://example.com
        * http:// -> Protocol Identifier
        * example.com -> Resource Name
        * */
        try {
            URL url = new URL("https://finance.yahoo.com/q?s=ORCL");
            URLConnection myURL = url.openConnection();
            BufferedReader input = new BufferedReader(new InputStreamReader(myURL.getInputStream()));
            String inputLine;
            //while ((inputLine = input.readLine()) != null) System.out.println(inputLine);
            String pattern = "<fin-streamer class=\"Fw(b) Fz(36px) Mb(-4px) D(ib)\" data-symbol=\"ORCL\" data-test=\"qsp-price\" data-field=\"regularMarketPrice\" data-trend=\"none\" data-pricehint=\"2\" value=\"78.25\" active=\"\">78.25</fin-streamer>";
            Pattern r = Pattern.compile(pattern);

            while ((inputLine = input.readLine()) != null) {
                if (inputLine.contains("<fin-streamer class=\"Fw(b) Fz(36px) Mb(-4px) D(ib)\" data-symbol=\"ORCL\" data-test=\"qsp-price\" data-field=\"regularMarketPrice\" data-trend=\"none\" data-pricehint=\"2\" value=\"78.25\" active=\"\">78.25</fin-streamer>")) {
                    Matcher m = r.matcher(inputLine);
                    if (m.find()) System.out.println(m.group(1));
                }
            }
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
