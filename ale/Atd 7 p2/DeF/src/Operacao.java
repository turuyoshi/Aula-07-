public class Operacao {
    public String tipo; 
    public String texto;

    public Operacao(String tipo, String texto) {
        this.tipo = tipo;
        this.texto = texto;
    }

    public String getTipo() {
        return tipo;
    }

    public String getTexto() {
        return texto;
    }
}
