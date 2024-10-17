import java.util.Stack;

public class GerencHist {
    public Stack<Pagina> historico;

    public GerencHist() {
        historico = new Stack<>();
    }

    public void visitarPagina(String url, String titulo) {
        Pagina novaPagina = new Pagina(url, titulo);
        historico.push(novaPagina);
        System.out.println("Página visitada: " + novaPagina);
        //Faz a visita de uma nova pagína 
    }

     //Verificar o tamanho do histórico
    public int tamanhoHistorico() {
        return historico.size();
    }

    //Ver a página atrual
    public Pagina paginaAtual() {
        if (!historico.isEmpty()) {
            return historico.peek();
        } else {
            System.out.println("Nenhuma página no histórico.");
            return null;
        }
    }

public Pagina voltarPagina() {
    if (historico.size() > 1) {
        historico.pop(); // Remove a página atual
        Pagina paginaAnterior = historico.peek(); // Página anterior
        System.out.println("Voltando para: " + paginaAnterior);
        return paginaAnterior;
    } else {
        System.out.println("Não há páginas anteriores.");
        return null;
    }
}

// Verifica se o histórico está vazio
public boolean historicoVazio() {
    return historico.isEmpty();
}
}
