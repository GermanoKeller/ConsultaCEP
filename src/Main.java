
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

void main() throws IOException, InterruptedException {
    System.out.println("=========== Consulta de Cep =============");
    Scanner scanner = new Scanner(System.in);
    ConsultaCep consulta = new ConsultaCep();
    GeradorDeArquivo gerador = new GeradorDeArquivo();
    List<Endereco> enderecos = new ArrayList<>();

    while (true) {
        System.out.println("Insira o cep que voce deseja consultar:");
        String cep = scanner.nextLine();

        if (cep.equalsIgnoreCase("sair")) {
            System.out.println("Programa finalizando...");
            break;
        }

        try {
            enderecos.add(consulta.buscaEndereco(cep));
            System.out.println(consulta.buscaEndereco(cep));

        }catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("Tente novamente.");
        }
        gerador.salvaJson(enderecos);
    }
}