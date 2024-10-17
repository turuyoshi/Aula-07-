public class EditorTexto {
    private StringBuilder textoAtual;
    public Operacao[] pilhaDesfazer;
    public Operacao[] pilhaRefazer;
    private int topoDesfazer; // Indica o topo da pilha de desfazer
    private int topoRefazer;  // Indica o topo da pilha de refazer

    public EditorTexto() {
        textoAtual = new StringBuilder();
        pilhaDesfazer = new Operacao[100]; 
        pilhaRefazer = new Operacao[100];
        topoDesfazer = -1;
        topoRefazer = -1;0
        //99
    }

  
    public void inserirTexto(String texto) {
        textoAtual.append(texto);
        topoDesfazer++;
        pilhaDesfazer[topoDesfazer] = new Operacao("insercao", texto);
        topoRefazer = -1; // Limpa a pilha de refazer
    }

    
    public void removerTexto(int n) {
        if (n > textoAtual.length()) {
            n = textoAtual.length();
        }
        String textoRemovido = textoAtual.substring(textoAtual.length() - n);
        textoAtual.delete(textoAtual.length() - n, textoAtual.length());
        topoDesfazer++;
        pilhaDesfazer[topoDesfazer] = new Operacao("remocao", textoRemovido);
        topoRefazer = -1; 
    }

    public void desfazer() {
        if (topoDesfazer >= 0) {
            Operacao ultimaOperacao = pilhaDesfazer[topoDesfazer];
            topoDesfazer--;
            if (ultimaOperacao.tipo.equals("insercao")) {
                int tamanho = ultimaOperacao.texto.length();
                textoAtual.delete(textoAtual.length() - tamanho, textoAtual.length());
            } else if (ultimaOperacao.tipo.equals("remocao")) {
                textoAtual.append(ultimaOperacao.texto);
            }
            topoRefazer++;
            pilhaRefazer[topoRefazer] = ultimaOperacao;
        } else {
            System.out.println("Nada para desfazer!");
        }
    }

    public void refazer() {
        if (topoRefazer >= 0) {
            Operacao ultimaOperacaoDesfeita = pilhaRefazer[topoRefazer];
            topoRefazer--;
            if (ultimaOperacaoDesfeita.tipo.equals("insercao")) {
                textoAtual.append(ultimaOperacaoDesfeita.texto);
            } else if (ultimaOperacaoDesfeita.tipo.equals("remocao")) {
                int tamanho = ultimaOperacaoDesfeita.texto.length();
                textoAtual.delete(textoAtual.length() - tamanho, textoAtual.length());
            }
            topoDesfazer++;
            pilhaDesfazer[topoDesfazer] = ultimaOperacaoDesfeita;
        } else {
            System.out.println("Nada para refazer!");
        }
    }

    public String getTextoAtual() {
        return textoAtual.toString();
    }
}
