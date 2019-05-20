import java.io.IOException; 
import java.io.PrintWriter;
import java.nio.charset.Charset; 
import java.nio.file.Files; 
import java.nio.file.Path; 
import java.nio.file.Paths;
import java.util.Scanner;

import java.util.regex.Pattern;
import java.util.ArrayList;

public class CadastroClientes{
    ArrayList<Clientes> clientes = new ArrayList<Clientes>();
    public final String pesquisaEspecifica = "e";
    public final String clienteNr = "cliente";
    public final String importAll = "tudo";
    public final String clienteNm = "nome";
    public final byte charCadastros = 4;
    public CadastroClientes(){
        carregaDados();
    }

    public void carregaDados(){
        String currDir = Paths.get("").toAbsolutePath().toString(); // Obtem o caminho para o diretório corrente 
        String nameComplete = currDir+"\\"+"Clientes.csv"; // Monta o nome do arquivo 
        Path path = Paths.get(nameComplete); // Cria acesso ao "diretorio" da mídia (disco)
        
        
        clientes.clear(); //Limpar referencias

        String cliente = "";
        String nome = "";
        String email = "";
        String sexo = "";
        String telefone = "";
        String cep = "";
        String cidade = "";
        String pais = "";
        String profissao = "";

        String info = "";
        int flag = 0;

        try (Scanner in = new Scanner(Files.newBufferedReader(path, Charset.forName("utf-8")))){ 
            in.useDelimiter("[,\n]"); // separadores: ; e nova linha 
            in.nextLine();

            while(in.hasNextLine()){
                String cadastro = in.nextLine();
                cadastro = cadastro.toUpperCase();
                flag = 0;
                info = "";

                for(int i = 0; i < cadastro.length(); i++){
                    if(cadastro.charAt(i)==',' || i == (cadastro.length()-1)){
                        switch(flag){
                            case 0: cliente = info; break;
                            case 1: nome = info; break;
                            case 2: email = info; break;
                            case 3: sexo = info; break;
                            case 4: telefone = info; break;
                            case 5: cep = info; break;
                            case 6: cidade = info; break;
                            case 7: pais = info; break;
                            case 8: profissao = info + cadastro.substring(i); break;
                        }
                        flag++;
                        info = "";
                    }else{
                        info += cadastro.charAt(i);
                    }
                }

                
              clientes.add(new Clientes(cliente, nome, email, sexo, telefone
                                        , cep, cidade, pais, profissao));
            }
            
        }catch (IOException x){ 
            System.err.format("Erro de E/S: %s%n", x); 
        }
    }

    public void salvarDados(){
        String currDir = Paths.get("").toAbsolutePath().toString(); 
        String nameComplete = currDir+"\\"+"Clientes.csv"; 
        Path path = Paths.get(nameComplete);

        String print = "id,name,email,gender,phone,postalCode,city,country,Job";

        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path, Charset.forName("utf-8")))){ 
        
        writer.print(print+"\n");
            
            for(int i = 0; i < clientes.size(); i++)
                writer.print(clientes.get(i).print() + "\n");
        
        }catch (IOException x){ 
        System.err.format("Erro de E/S: %s%n", x);
        } 
    }
    
    public String getCliente(String searchFor){
    return getCliente("a", searchFor, "");        
    }
    
    public String getCliente(String index, String searchFor){
    return getCliente(index, searchFor, "");
    }

    public String getCliente(String index, String searchFor, String field){
        String returnString = "O(s) cliente(s) abaixo correspondem aos parametros: ";
      
        if(field.equals(clienteNr)){
            for(; charCadastros >= searchFor.length();)
                searchFor = "0" + searchFor;
        index = pesquisaEspecifica;
        }

        if(index.equals("a")){
            for(int i = 0; i < clientes.size(); i++){
                for(int j = 0; j < 10; j++){
                    if(clientes.get(i).getField(j).equals(searchFor))
                        returnString += "\n" + clientes.get(i).getField(clienteNr);
                }
                if(field.equals(importAll))
                    returnString += "\n" + clientes.get(i).toString() + "\n";
            }
        }else if(index.equals(pesquisaEspecifica)){    
            for(int i = 0; i < clientes.size(); i++)
                if(clientes.get(i).getField(clienteNr).equals(searchFor) ||
                    clientes.get(i).getField(clienteNm).equals(searchFor))
                    return clientes.get(i).toString();
        }else if(Pattern.matches("[0-9]{5}[;][0-9]{5}", index)){
            String a = index.substring(0, 5);
            String b = index.substring(6, 11);
            int i = 0;
            int j = 0;
            for(; i < clientes.size(); i++)
                if(clientes.get(i).getField(clienteNr).equals(a))
                    break;
            for(; j < clientes.size(); j++)
                if(clientes.get(j).getField(clienteNr).equals(b))
                    break;
            if(j < i){
                int x = i;  i = j;  j = x;
            }
            for(; i <= j; i++){
                for(int k = 0; k < 10; k++){
                    System.out.println("k: " + k);
                    if(clientes.get(i).getField(k).equals(searchFor))
                        returnString += "\n" + clientes.get(i).getField(field);
                }
                if(field.equals(importAll))
                        returnString += "\n" + clientes.get(i).toString() + "\n";
            }
        }else
            for(int i = 0; i < clientes.size(); i++)
                if(clientes.get(i).getField(clienteNr).equals(index) || 
                    clientes.get(i).getField(clienteNm).equals(index) )
                    return clientes.get(i).getField(searchFor);
                    
        if(returnString.equals("O(s) cliente(s) abaixo correspondem aos parametros: "))
            return "Nao foi encontrado nenhum cliente com esses parametros.";
    return returnString;  
    }

    public String novoCliente(String cadastro){
        
        String cliente = "" + (clientes.size() + 1);
        for(; charCadastros >= cliente.length();)
            cliente = "0" + cliente;
        
        cadastro = cliente + "," + cadastro;

        String nome = "";
        String email = "";
        String sexo = "";
        String telefone = "";
        String cep = "";
        String cidade = "";
        String pais = "";
        String profissao = "";

            
        cadastro = cadastro.toUpperCase();
        
        String info = "";
        int flag = 0;

        for(int i = 0; i < cadastro.length(); i++){
          if(cadastro.charAt(i)==',' || i == (cadastro.length()-1)){
                switch(flag){
                    case 0: cliente = info; break;
                    case 1: nome = info; break;
                    case 2: email = info; break;
                    case 3: sexo = info; break;
                    case 4: telefone = info; break;
                    case 5: cep = info; break;
                    case 6: cidade = info; break;
                    case 7: pais = info; break;
                    case 8: profissao = info + cadastro.substring(i); break;
                }
                flag++;
                info = "";
            }else{
                info += cadastro.charAt(i);
            }
        }
        System.out.println(cadastro);
    clientes.add(new Clientes(cliente, nome, email, sexo, telefone, cep, cidade, pais, profissao));                           
    return "Cliente cadastrado:\n" + getCliente(pesquisaEspecifica, cliente);
    }

    public String set(String cliente, String field, String info){
        int i = 0;
        if(Pattern.matches("[0-9]{5}", cliente)){
            for(; i < clientes.size(); i++)
                if(clientes.get(i).getField(clienteNr).equals(cliente)){
                    clientes.get(i).set(field, info);
                    return "Cliente atualizado: \n" + clientes.get(i).toString();
                }
        }else{
            for(; i < clientes.size(); i++)
                if(clientes.get(i).getField(clienteNm).equals(cliente)){
                    clientes.get(i).set(field, info);
                    return "Cliente atualizado: \n" + clientes.get(i).toString();
                }
        }
    return "Nao foi possivel atualizar o cadastro.";
    }

    public String size(){
        return "" + clientes.size();
    }
}