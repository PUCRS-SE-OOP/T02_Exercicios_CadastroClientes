import java.util.regex.Pattern;
public class App{
    public static void main(String args[]) {
        CadastroClientes cc = new CadastroClientes();
        String fct = "";    //String concatenada
        String fctA = "";   //mType ~ (1)Consultar ; (2)Atualizar  ; (3)Cadastrar ; (8)Gerenciar ~
        String fctB = "";   //mRange ~ (1) Todos ; (2) Intervalo *String grande* ; (3)Específico ~
        String fctC = "";   //String intervalo mRange 00000-99999
        String fctD = "";   //field de pesquisa (tudo, cadastro, nome, (...))
        String fctX = "";   //Manipulação de string menor
        String res = "";    //Respostas do sistema


        do{
        fct = Interface.menu(cc);

        if(fct.equals("acessoGerencia"))
            Interface.acessoGerencia(cc);
        
        fctA = fct.substring(0,1); // mType
        fctB = fct.substring(3,4); //mRange
        if(fctB.equals("2")){
            fctC = fct.substring(7,18); //RANGE 00000-99999
            fctD = fct.substring(21); //FIELD
        }
        else
            fctD = fct.substring(6);
        fctX = fct.substring(3);
        

        switch(fctA){
            case "1":
                switch(fctB){
                    case "1": res = cc.getCliente("a", Interface.menuSearch(fctD), fctD); break;
                    case "2": res = cc.getCliente(fctC, Interface.menuSearch(fctD), fctD); break; // CadastroClientes.getCliente(00000;99999, searchFor) //
                    case "3": res = cc.getCliente("e", fctD); break;
                    case "4": res = cc.size(); break;
                }
            break;
            case "2":
                res = cc.getCliente(fctB, "cliente");
                if(Pattern.matches("[0-9]{5}", res)){
                   fctX = Interface.menuAtualizar(cc);
                   res = cc.set(res, fctX.substring(0,1), fctX.substring(3));
                   break;
                }else res = "\nCliente nao encontrado.";
            break;
            case "3":
                res = cc.novoCliente(fctX);
            break;    
        }

    System.out.println("\n" + res);
    }while(true);
    }
}

/*        
 System.out.println("\nfct: "+fct+
                    "\nfctA: "+fctA+
                    "\nfctB: "+fctB+
                    "\nfctC: "+fctC+
                    "\nfctD: "+fctD+
                    "\nfctX: "+fctX);
*/