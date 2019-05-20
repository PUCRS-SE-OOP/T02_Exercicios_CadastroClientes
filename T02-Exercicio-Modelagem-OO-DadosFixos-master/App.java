public class App{
    /* Exercícios:
     1) Clientes por cidade
     2) Clientes por pais
     3) Clientes por pais e profissão
     */

    public static void main(String args[]) {
        Cadastro ap = new Cadastro();

        ap.imprimeDados("Todos os clientes",ap.getTodosClientes());
        ap.imprimeDados("Clientes homens",ap.getClientesPorSexo("Male"));
        ap.imprimeDados("Clientes mulheres",ap.getClientesPorSexo("Female"));
    }
}