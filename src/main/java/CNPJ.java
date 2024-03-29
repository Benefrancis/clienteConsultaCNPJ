import com.google.gson.Gson;
import model.Empresa;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * @author <a href="https://github.com/Benefrancis">Benefrancis do Nascimento</a>
 * <br />
 * Fonte da API: https://brasilapi.com.br/docs#tag/CNPJ/paths/~1cnpj~1v1~1{cnpj}/get
 * @see <a href="https://github.com/SavioAndres/BrasilAPI-Java">BrasilAPI-Java</a>
 * @see <a href="https://github.com/Benefrancis/clienteConsultaCNPJ.git">Projeto no Github</a>
 */
public class CNPJ {


    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {


        /// CNPJ aleatórios que encontrei na internet
        String cnpj = "46830089000114"; // ""11164743000113"; // "43901921000138";  // "40526763000195"; //"63002141000163"; //"26989715005414"; //"11319526000155";  // "19131243000197";

        var uri = new URI( "https://brasilapi.com.br/api/cnpj/v1/" + cnpj );

        var cliente = HttpClient.newHttpClient();

        var request = HttpRequest.newBuilder( uri ).GET().build();

        HttpResponse<String> response = cliente.send( request, HttpResponse.BodyHandlers.ofString() );

        if (response.statusCode() != 200) {
            throw new RuntimeException( "HTTP error code : " + response.statusCode() );
        }

        //Será que tem Suporte ao HTTP 2?
        System.out.println( response.version() );

        //Olha o JSON
        System.out.println( response.body() );

        //Colocando num Objeto Imutável:
        Empresa empresa = new Gson().fromJson( response.body(), Empresa.class );

        System.out.println( empresa );


    }
}
