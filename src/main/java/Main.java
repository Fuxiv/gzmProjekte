import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.SECONDS;

public class Main {
    public static void main(String[] args) throws URISyntaxException {

//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(new URI("https://sdip.transportgzm.pl/main?command=planner&action=sd&id=11779"))
//                .header("command", "planner")
//                .header("action", "pt")
//                .header("next", "5")
//                .header("id", "354603284")
//                .timeout(Duration.of(10, SECONDS))
//                .version(HttpClient.Version.HTTP_2)
//                .GET()
//                .build();
//        System.out.println(request);
//
//        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
//                .thenApply(HttpResponse::body)
//                .thenAccept(System.out::print)
//                .join();

        Document doc;

        try {
            doc = Jsoup.connect("https://sdip.transportgzm.pl/main?command=planner&action=sd&id=11779").get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Elements divs = doc.select(".rows > div");
        Elements time = doc.select(".rows > div > .time");
        Elements line = doc.select(".rows > div > .line");
        Elements destination = doc.select(".rows > div > .destination");
        List<BusStop> busStopList = new ArrayList<>();

        for (int i = 0; i < divs.size(); i++) {
            busStopList.add(new BusStop(time.get(i).text(), line.get(i).text(), destination.get(i).text()));
        }
        System.out.println(divs.size());
        for (BusStop busStop : busStopList){
            System.out.println(busStop.toString());
        }


    }
}
