import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.AnaliseSemestral;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="https://github.com/Benefrancis">Benefrancis do Nascimento</a>
 * <br />
 * Fonte da API: https://apidadosabertos.saude.gov.br/sisagua/controle-semestral?limit=100&offset=1
 *
 * @see <a href="https://github.com/Benefrancis/clienteConsultaCNPJ.git">Projeto no Github</a>
 */
public class SisAgua {

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        var ano = 2023;
        var municipio = 353440; //Osasco
        getSisAguaControleSemestral(ano, municipio);
    }

    private static void getSisAguaControleSemestral(int ano, int municipio) throws URISyntaxException, IOException, InterruptedException {
        var cliente = HttpClient.newHttpClient();
        URI uri;
        if (ano > 0 && municipio > 0) {
            uri = new URI(String.format("https://apidadosabertos.saude.gov.br/sisagua/controle-semestral?limit=100&offset=1&ano_referencia=%s&codigo_municipio=%s", ano, municipio));
        } else {
            uri = new URI("https://apidadosabertos.saude.gov.br/sisagua/controle-semestral?limit=100&offset=1");
        }

        var request = HttpRequest.newBuilder(uri).GET().build();

        HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException("HTTP error code : " + response.statusCode());
        }

        //Será que tem Suporte ao HTTP 2?
        System.out.println(response.version());

        //Olha o JSON
        System.out.println(response.body());

        // Deserialization
        Gson gson = new Gson();
        var mapType = new TypeToken<Map<String, List<AnaliseSemestral>>>() {
        };

        var analises = new Gson().fromJson(response.body(), mapType);

        for (AnaliseSemestral a : analises.get("parametros")) {
            System.out.println(a);
        }
    }
}
