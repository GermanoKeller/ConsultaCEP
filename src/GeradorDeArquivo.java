import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeradorDeArquivo {

    public void salvaJson(List<Endereco> endereco) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter writer = new FileWriter("Endereços.json");
        writer.write(gson.toJson(endereco));
        writer.close();
    }
}
