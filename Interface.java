import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Scanner;

public class Interface{

    public static String menu(CadastroClientes cc){
        Scanner in = new Scanner(System.in);
        String search = "";
        String mRange = "";
        byte mType = 0;

        System.out.println("\n------------------------");
        System.out.println("     Menu principal     \n");
        System.out.println("Deseja pesquisar por:"+
                            "\n1 - Consultar clientes;"+
                            "\n2 - Atualizar cadastro;"+
                            "\n3 - Cadastrar novo cliente;"+
                            "\n"+
                            "\n8 - Gerenciar programa;"+
                            "\n9 - Fechar programa.");
        mType = in.nextByte();

        switch(mType){
            case 1: return "" + mType + ", " + menuRange(cc);
            case 2: return "" + mType + ", " + menuFind(cc);
            case 3: String novoCadastro = menuCadastro();
                    if(novoCadastro != "0"){
                        return "" + mType + ", " + novoCadastro;
                    }else menu(cc);
            case 8: return "acessoGerencia";
            case 9: if(menuSure("Sair do programa sem salvar os cadastros fara com que os mesmos sejam perdidos."
                                +" Voce tem certeza que deseja sair?") == true){
                        System.exit(0);
                    }else{
                        System.out.println("Chame a gerencia para salvar os novos cadastros."
                        +" Voce sera redirecionado para o menu principal.");
                        menu(cc);   
                    }
            default: System.out.println("Err1>1: Opcao invalida. Digite uma opcao valida.");
        }
    return "" + mType + mRange + search;
    }

    public static String menuRange(CadastroClientes cc){
        Scanner in = new Scanner(System.in);
        String mRange = "";
        
        //Range de consulta:
        System.out.println("\n------------------------\n");
        System.out.println("Deseja pesquisar por:"+
                            "\n1 - Em todos os cadastros;"+
                            "\n2 - Em intervalo;"+
                            "\n3 - Um cliente especifico;"+
                            "\n4 - Quantidade de cadastros ativos;");
            mRange = in.next();
            switch(mRange){
                case "1": return mRange + ", " + findFor(cc);
                case "2": return mRange + ", " + menuRangeBetween(cc);
                case "3": return mRange + ", " + menuFind(cc);
                case "4": return mRange + " Cadastros.";
                default: System.out.println("Err1>2: Opcao invalida. Digite uma opcao valida.");
            }
    return "Error: menuRange can not find target,";
    }

        public static String menuRangeBetween(CadastroClientes cc){
            Scanner in = new Scanner(System.in);
            System.out.println("\n------------------------\n");
            System.out.println("Consultar do ID:");
            int c = Integer.parseInt(cc.size());
            int a = in.nextInt();
            if(a < 1 || a > c-1){
                System.out.println("Valor invalido.");
                return menu(cc);
            }
            System.out.println("Ate o ID:");
            int b = in.nextInt();
            if(b < 1 || b > c-1){
                System.out.println("Valor invalido.");
                return menu(cc);
            }

            String returnA = "" + a;
            String returnB = "" + b;

            for(byte i = 4; i >= returnA.length();)
                returnA = "0" + returnA;
            for(byte i = 4; i >= returnB.length();)
                returnB = "0" + returnB;
            
        return "(" + returnA + ";" + returnB + ")" +", "+ findFor(cc);
        }
        
        public static String menuFind(CadastroClientes cc){
            Scanner in = new Scanner(System.in);
            System.out.println("\n------------------------\n");
            System.out.println("Digite o ID ou nome completo do cliente:");
            String cliente = in.nextLine();
            cliente = cliente.toUpperCase();
            if(Character.isDigit(cliente.charAt(0)))
                for(byte i = 4; i >= cliente.length();)
                    cliente = "0" + cliente;
            
            return cliente;
        }

        public static String findFor(CadastroClientes cc){
            Scanner in = new Scanner(System.in);
 
            System.out.println("\n------------------------\n");
            System.out.println("Deseja pesquisar por:");
            String line =       "\n0 - Cliente;"+
                                "\n1 - Nome;"+
                                "\n2 - Sobrenome;"+
                                "\n3 - Email;"+
                                "\n4 - Genero;"+
                                "\n5 - Telefone;"+
                                "\n6 - CEP;"+
                                "\n7 - Cidade;"+
                                "\n8 - Pais;"+
                                "\n9 - Profissao;"+
                                "\n10 - Cadastro completo.";
            System.out.println(line);
            byte search = in.nextByte();
            line = line.toLowerCase();
                switch(search){
                    case 0: return line.substring(5, 12);
                    case 1: return line.substring(18, 22);
                    case 2: return line.substring(28, 37);
                    case 3: return line.substring(43, 48);
                    case 4: return line.substring(54, 60);
                    case 5: return line.substring(66, 74);
                    case 6: return line.substring(80, 83);
                    case 7: return line.substring(89, 95);
                    case 8: return line.substring(101, 105);
                    case 9: return line.substring(111, 120);
                    case 10: return line = "tudo";
                    default: return menu(cc);
                }
        }

    public static String menuCadastro(){
        Scanner in = new Scanner(System.in);
        String dl = ",";

        System.out.println("\n------------------------\n");
        System.out.println("Tenha certeza de ter todas as informacoes necessarias antes de continuar.");
        System.out.println("Voce vai precisar de:"+
                            "\nNome completo;"+
                            "\nGenero;"+
                            "\nTelefone;"+
                            "\nCEP;"+
                            "\nCidade;"+
                            "\nPais;"+
                            "\nProfissao.\n");
        if(menuSure("Voce possui todas as informacoes e deseja continuar?") == true){

        System.out.println("\nDigite o nome completo do cliente: ");
        String nome = in.nextLine();
        System.out.println("Digite o email do cliente: ");
        String email = in.nextLine();
        System.out.println("Digite o genero do cliente: ");
        String sexo = in.nextLine();
        System.out.println("Digite o telefone do cliente: ");
        String telefone = in.nextLine();
        System.out.println("Digite o cep do cliente: ");
        String cep = in.nextLine();
        System.out.println("Digite a cidade do cliente: ");
        String cidade = in.nextLine();
        System.out.println("Digite o pais do cliente: ");
        String pais = in.nextLine();
        System.out.println("Digite a profissao do cliente: ");
        String profissao = in.nextLine();
        
        return nome+dl+email+dl+sexo+dl+telefone+dl+cep+dl+cidade+dl+pais+dl+profissao;    
        }
    return "0";    
    }

    public static String menuAtualizar(CadastroClientes cc){
        Scanner in = new Scanner(System.in);

        System.out.println("\n------------------------\n");
        System.out.println("Deseja atualizar qual campo?" +
                            "\n1 - Email;" +
                            "\n2 - Genero;" +
                            "\n3 - Telefone;" +
                            "\n4 - CEP;" +
                            "\n5 - Cidade;" +
                            "\n6 - Pais;" +
                            "\n7 - Profissao;" +
                            "\n8 - Voltar;");
        
        String i = "";
        int j = 0;

        do{
            i = in.next();
            if(Pattern.matches("[0-9]", i))
                j = Integer.parseInt(i);
            if(j == 8) menu(cc);
            if(j < 1 || j > 7);System.out.println("Err1>3: Opcao invalida. Digite novamente.");
        }while(j < 1 || j > 7);

            System.out.println("Digite a nova informacao do campo: ");
            String info = in.next();

        return "" + i + ", " + info.toUpperCase();
    }

    public static boolean menuSure(String txt){
        Scanner in = new Scanner(System.in);
        System.out.println(txt);
        System.out.println("1 - Sim");
        System.out.println("2 - Nao");
        String i = "";

        while(true){
        i = in.next();
            if(i.equals("1"))
                return true;
            else if(i.equals("2"))
                return false;
            else
        System.out.println("Err1>4: Opcao invalida. Digite novamente.");
        }
    }

    public static String menuSearch(String txt){
        if(txt.equals("tudo"))
            return "";
        Scanner in = new Scanner(System.in);
        System.out.println("\nDigite o termo de pesquisa: ");
        String line = in.nextLine();
        line = line.toUpperCase();    
    return line;
    }
    
    
    public static String acessoGerencia(CadastroClientes cc){
        Scanner in = new Scanner(System.in);
        System.out.println("------------------------\n");
        System.out.println("Informe a senha ou digite sair.");
        String pw = "";
        while(true){
            pw = in.nextLine();
            pw = pw.toUpperCase();
            if(pw.equals("0000")){
                return menuGerencia(cc);
            }else if(pw.equals("SAIR")){
                menu(cc);
            }
        System.out.println("Senha errada, tente novamente ou digite sair.");
        }
    }

    public static String menuGerencia(CadastroClientes cc){
        Scanner in = new Scanner(System.in);
        String menu = "";
        
        
        System.out.println("\n------------------------\n"+
                            "\n1 - Salvar arquivo de cadastros;"+
                            "\n2 - Carregar arquivo de cadastro;"+
                            "\n"+
                            "\n8 - Voltar ao menu principal;"+
                            "\n9 - Fechar programa.");
            menu = in.nextLine();     
            switch(menu){
                case "1": if(menuSure("Tem certeza que deseja salvar os cadastros?")){
                                cc.salvarDados(); return "Cadastros salvos.";
                            }else   
                                menuGerencia(cc);
                break;
                case "2": if(menuSure("Carregar os arquivos fara com que cadastros não salvos sejam descartados. Voce tem certeza que deseja carregar os arquivos?")){
                                cc.carregaDados(); return "Cadastros carregados.";
                            }else
                                menuGerencia(cc);
                break;
                case "8": return menu(cc);
                case "9": System.exit(0);
                default: System.out.println("Err1>5: Opcao invalida. Digite uma opcao valida.");
            }
    return menu(cc);
    }
}