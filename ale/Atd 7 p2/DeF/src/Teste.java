public class Teste {
    public static void main(String[] args) {
        EditorTexto editor = new EditorTexto();

        editor.inserirTexto("OLaa, ");
        System.out.println("Texto Atual: " + editor.getTextoAtual());

        editor.inserirTexto("Gatinhass!");
        System.out.println("Texto Atual: " + editor.getTextoAtual());

        editor.removerTexto(10); 
        System.out.println("Texto Atual: " + editor.getTextoAtual());

        editor.desfazer(); // Desfaz a remoção
        System.out.println("Texto Atual após desfazer: " + editor.getTextoAtual());

        editor.refazer(); // Refaz a remoção
        System.out.println("Texto Atual após refazer: " + editor.getTextoAtual());
    }
}
