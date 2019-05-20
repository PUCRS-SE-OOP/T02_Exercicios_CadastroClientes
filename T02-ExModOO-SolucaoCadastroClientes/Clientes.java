public class Clientes{
    private String nome;
    private String email;
    private String sexo;
    private String telefone;
    private String cep;
    private String cidade;
    private String pais;
    private String profissao;

    public Clientes(String nome, String email, String sexo, String telefone,
                    String cep, String cidade, String pais, String profissao){
        this.nome = nome;
        this.email = email;
        this.sexo = sexo;
        this.telefone = telefone;
        this.cep = cep;
        this.cidade = cidade;
        this.pais = pais;
        this.profissao = profissao;
    }

    public void set(String field, String info){
        switch(field){
            case "nome": nome = info;
            case "email": email = info;
            case "sexo": sexo = info;
            case "telefone": telefone = info;
            case "cep": cep = info;
            case "cidade": cidade = info;
            case "pais": pais = info;
            case "profissao": profissao = info;      
        }
    }

    public String get(String field){
        switch(field){
            case "nome":return nome;
            case "email":return email;
            case "sexo":return sexo;
            case "telefone":return telefone;
            case "cep":return cep;
            case "cidade":return cidade;
            case "pais":return pais;
            case "profissao":return profissao;
            default: return "none";         
        }
    }
}