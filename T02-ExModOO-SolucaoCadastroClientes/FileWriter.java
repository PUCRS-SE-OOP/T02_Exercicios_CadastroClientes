import java.io.IOException; 
import java.io.PrintWriter; 
import java.nio.charset.Charset; 
import java.nio.file.Files; 
import java.nio.file.Path; 
import java.nio.file.Paths; 
import java.util.Random; 

public class FileWriter{ 

    // Toda a vez que o programa for executado um arquivo novo será criado sobre o antigo 

    public static void main(String[] args){ 

        Random sorteia = new Random(); 


        // Obtem o caminho para o diretório corrente 

        String currDir = Paths.get("").toAbsolutePath().toString(); 

        // Monta o nome do arquivo 

        String nameComplete = currDir+"\\"+"numeros.dat"; 

        // Cria acesso ao "diretorio" da mídia (disco) 

        Path path = Paths.get(nameComplete); 

         

        // Usa a classe "PrintWriter" para escrever no arquivo 

        // A classe "PrintWirter" usa a variavel "path" para localizar onde escrever os dados  

        // defaultCharset retorna a codificação padrão de textos (usualmente UTF-8) 

        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path, Charset.defaultCharset()))){ 

            for(int i=0;i<100;i++){ 

                // Sorteia um numero entre 1 e 100 

                int nro = sorteia.nextInt(1000); 

                // Grava o numero no arquivo seguido de uma "," 

                writer.print(nro+","); 

            } 

            // Sorteia e grava um último numero seguido de "\n" 

            int nro = sorteia.nextInt(1000); 

            writer.print(nro+"\n"); 

        }catch (IOException x){ 

          System.err.format("Erro de E/S: %s%n", x); 

      } 

   } 

} 