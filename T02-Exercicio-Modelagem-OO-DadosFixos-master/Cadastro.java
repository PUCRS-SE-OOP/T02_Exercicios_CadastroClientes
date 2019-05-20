import java.util.Arrays;

public class Cadastro{
    private final int MAX_DADOS = 10;
    private String nome[];
    private String email[];
    private String sexo[];
    private String telefone[];
    private String cep[];
    private String cidade[];
    private String pais[];
    private String profissao[];

    public void inicializa(){
        nome = new String[MAX_DADOS];
        email = new String[MAX_DADOS];
        sexo = new String[MAX_DADOS];
        telefone = new String[MAX_DADOS];
        cep  = new String[MAX_DADOS];
        cidade  = new String[MAX_DADOS];
        pais = new String[MAX_DADOS];
        profissao = new String[MAX_DADOS];

        nome[0] = "Sarina Winsbury";
        email[0] = "swinsbury0@exblog.jp";
        sexo[0] = "Female";
        telefone[0] = "(421) 5677661"; 
        cep[0]  = "692425";
        cidade[0] = "Kavalerovo";
        pais[0] = "Russia";
        profissao[0] = "Associate Professor";

        nome[1] = "Shane Stallard";
        email[1] = "sstallard1@umn.edu";
        sexo[1] = "Male";
        telefone[1] = "(397) 2431630"; 
        cep[1]  = "000000";
        cidade[1] = "Kasakh";
        pais[1] = "Armenia";
        profissao[1] = "Human Resources Manager";

        nome[2] = "Benn Linkie";
        email[2] = "blinkie2@dyndns.org";
        sexo[2] = "Male";
        telefone[2] = "(914) 9410277"; 
        cep[2] = "20350";
        cidade[2] = "Metković";
        pais[2] = "Croatia";
        profissao[2] = "Operator";

        nome[3] = "Cathy Brandli";
        email[3] = "cbrandli3@jalbum.net";
        sexo[3] = "Female";
        telefone[3] = "(448) 9414879"; 
        cep[3]  = "2825-843";
        cidade[3] = "Trafaria";
        pais[3] = "Portugal";
        profissao[3] = "Geologist IV";

        nome[4] = "Henrik Douch";
        email[4] = "hdouch4@huffingtonpost.com";
        sexo[4] = "Male";
        telefone[4] = "(159) 9695437"; 
        cep[4]  = "27000-000";
        cidade[4] = "Barra do Piraí";
        pais[4] = "Brazil";
        profissao[4] = "Occupational Therapist";

        nome[5] = "Tanitansy Van der Velden";
        email[5] = "tvan5@imageshack.us";
        sexo[5] = "Female";
        telefone[5] = "(608) 3838780"; 
        cep[5]  = "000000";
        cidade[5] = "Tsimkavichy";
        pais[5] = "Belarus";
        profissao[5] = "Associate Professor";

        nome[6] = "Helsa Andriulis";
        email[6] = "handriulis6@vkontakte.ru";
        sexo[6] = "Female";
        telefone[6] = "(282) 9285430"; 
        cep[6]  = "000000";
        cidade[6] = "Emalgolin Mongolzuxiang";
        pais[6] = "China";
        profissao[6] = "Occupational Therapist";

        nome[7] = "Karlee Sampson";
        email[7] = "ksampson7@xing.com";
        sexo[7] = "Female";
        telefone[7] = "(720) 9799255"; 
        cep[7]  = "000000";
        cidade[7] = "Danxi";
        pais[7] = "China";
        profissao[7] = "Account Executive";

        nome[8] = "Gordon Arrow";
        email[8] = "garrow8@taobao.com";
        sexo[8] = "Male";
        telefone[8] = "(246) 3936673"; 
        cep[8]  = "2621";
        cidade[8] = "Gabi";
        pais[8] = "Philippines";
        profissao[8] = "Design Engineer";
        
        nome[9] = "Carmine Stammler";
        email[9] = "cstammler9@github.io";
        sexo[9] = "Female";
        telefone[9] = "(893) 6268587"; 
        cep[9]  = "000000";
        cidade[9] = "Xingpinglu";
        pais[9] = "China";
        profissao[9] = "Associate Professor";
    }

    public void imprimeDados(String titulo,int indices[]){
        System.out.println(titulo+":");
        for(int i=0;i<indices.length;i++){
            int ind = indices[i];
            String linha = "Cliente ("+ind+"):"+
                           nome[ind]+", "+
                           email[ind]+", "+
                           sexo[ind]+", "+
                           telefone[ind]+", "+
                           cep[ind]+", "+
                           cidade[ind]+", "+
                           pais[ind]+", "+
                           profissao[ind]+".";
            System.out.println(linha);
        }
        System.out.println("----------\n");
    }

    public int[] getTodosClientes(){
        int[] resp = new int[MAX_DADOS];
        for(int i=0;i<MAX_DADOS;i++){
            resp[i] = i;
        }
        return resp;
    }

    public int[] getClientesPorSexo(String sexo){
        int[] resp = new int[MAX_DADOS];
        int pos = 0;
        for(int i=0;i<MAX_DADOS;i++){
            if (this.sexo[i].equals(sexo)){
                resp[pos] = i;
                pos++;
            }
        }
        return Arrays.copyOf(resp, pos);
    }

    public int[] getClientesPorCidade(String cidade){
        int[] resp = new int[MAX_DADOS];
        int pos = 0;
        for(int i=0;i<MAX_DADOS;i++){
            if (this.cidade[i].equals(cidade)){
                resp[pos] = i;
                pos++;
            }
        }
        return Arrays.copyOf(resp, pos);
    }

    public int[] getClientesPorPais(String pais){
        int[] resp = new int[MAX_DADOS];
        int pos = 0;
        for(int i=0;i<MAX_DADOS;i++){
            if (this.pais[i].equals(pais)){
                resp[pos] = i;
                pos++;
            }
        }
        return Arrays.copyOf(resp, pos);
    }

    public int[] getClientesPorCidadeEProfissao(String cidade, String profissao){
        int[] resp = new int[MAX_DADOS];
        int pos = 0;
        for(int i=0;i<MAX_DADOS;i++){
            if (this.cidade[i].equals(cidade) && this.profissao[i].equals(profissao)){
                resp[pos] = i;
                pos++;
            }
        }
        return Arrays.copyOf(resp, pos);
    }
}