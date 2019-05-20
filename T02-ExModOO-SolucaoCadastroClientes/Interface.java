import java.util.Scanner;

/* Returns:
 * int i = 1x - 
 */

public class Interface{
    public static void menu(){
        Scanner in = new Scanner(System.in);
        System.out.println("------------------------\n");
        System.out.println("1 - Consultar cliente");
        System.out.println("1 - Atualizar cadastro");
        System.out.println("1 - Cadastrar novo cliente");
        System.out.println("1 - Consultar cliente");
        System.out.println("9 - Fechar programa");
        short imenu = in.nextShort();

        switch(imenu){
            case 1: menu(1);
            case 9: System.exit(0);
            default: System.out.println("Opção inválida. Digite uma opção válida.");
        }
        in.close();
    }

    public static void menu(int imenu){
        if(imenu == 1){ //Tipo de consulta:
        System.out.println("------------------------\n");
        System.out.println("Consultar por:");
        System.out.println("1 - Todos cadastrados");
        System.out.println("2 - Intervalo");
        System.out.println("3 - Cliente específico");
        }
    
        if(imenu == 2){ //Tipo de consulta:
            System.out.println("------------------------\n");
            System.out.println("Consultar por:");
            System.out.println("1 - Nome");
            System.out.println("2 - Sobrenome");
            System.out.println("3 - Email");
            System.out.println("4 - Sexo");
            System.out.println("5 - Telefone");
            System.out.println("6 - CEP");
            System.out.println("7 - Cidade");
            System.out.println("8 - País");
            System.out.println("9 - Profissão");
        }
    }
}