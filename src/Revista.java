public class Revista extends Material{

    private String numeroISSN;

    public String getNumeroISSN() {
        return numeroISSN;
    }

    public void setNumero(String numero) {
        this.numeroISSN = numero;
    }

    public Revista(String titulo, String autor, String numeroISSN) {
        super(titulo, autor);
        this.numeroISSN = numeroISSN;
    }

    @Override
    public String toString() {
        return "\n————————————————————————————————————"+
                "\nMaterial: REVISTA" +
                "\nTitulo = " + super.getTitulo() +
                "\nAutor = " + super.getAutor() +
                "\nCódigo (ISSN) = " + numeroISSN+
                "\n————————————————————————————————————\n";
    }
}
