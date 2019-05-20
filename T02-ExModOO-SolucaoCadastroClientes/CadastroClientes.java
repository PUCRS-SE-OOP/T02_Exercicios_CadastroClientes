import java.io.IOException; 
import java.nio.charset.Charset; 
import java.nio.file.Files; 
import java.nio.file.Path; 
import java.nio.file.Paths;
import java.util.Scanner;

import java.util.ArrayList;

public class CadastroClientes{
    ArrayList<Clientes> clientes = new ArrayList<Clientes>();

    public CadastroClientes(){
        
    }

    public int carregaDados(CadastroClientes cc){
        String currDir = Paths.get("").toAbsolutePath().toString(); // Obtem o caminho para o diretório corrente 
        String nameComplete = currDir+"\\"+"Clientes.csv"; // Monta o nome do arquivo 
        Path path = Paths.get(nameComplete); // Cria acesso ao "diretorio" da mídia (disco)
        
        
        clientes.clear(); //Limpar referencias
        int cadastros = 0; //Novos clientes cadastrados
        
        try (Scanner in = new Scanner(Files.newBufferedReader(path, Charset.forName("utf-8")))){ 
            in.useDelimiter("[,\n]"); // separadores: ; e nova linha 
            in.nextLine();

            while(in.hasNext()){
                cadastros = Integer.parseInt(in.next());
                clientes.add(new Clientes(in.next(), in.next(), in.next(), in.next(),
                                          in.next(), in.next(), in.next(), in.next()));
            }
            
        }catch (IOException x){ 
            System.err.format("Erro de E/S: %s%n", x); 
        }
        
        return cadastros;
    }


}