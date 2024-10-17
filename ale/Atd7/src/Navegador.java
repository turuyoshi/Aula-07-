public class Navegador {
    public static void main(String[] args) {
        GerencHist historico = new GerencHist();

        historico.visitarPagina("http://google.com", "Google");
        historico.visitarPagina("http://youtube.com", "YouTube");
        historico.visitarPagina("http://github.com", "GitHub");

        System.out.println("\nPágina atual: " + historico.paginaAtual());

        historico.voltarPagina();
        System.out.println("Página atual: " + historico.paginaAtual());

        System.out.println("\nTamanho do histórico: " + historico.tamanhoHistorico());
        System.out.println("Histórico está vazio? " + historico.historicoVazio());
    }
}