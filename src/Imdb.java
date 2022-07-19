import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class Imdb {
    public static void main(String[] args) throws IOException, InterruptedException {


        // fazer uma conexão HTTP e buscar os top 50 filmes
        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        var response= client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();


        // extrair só os dados que interessam: (título, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        // exibir e manipular os dados
        for (Map<String, String> filme: listaDeFilmes) {
            System.out.println("");
            System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRating"));
            System.out.println("");

        }
    }
}
