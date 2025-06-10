import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaDivisa {

    public Divisa buscaDivisa(String monedaInicial, String monedaFinal, Double valorAConvertir) {
        var key = "5f18c49a5dd514ee2637bf3d";
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" + key + "/pair/" + monedaInicial + "/" + monedaFinal + "/" + valorAConvertir);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Divisa.class);
        } catch (Exception e) {
            throw new RuntimeException("No se pudo realizar la conversión.");
        }
    }
}