public class Livro extends Material{

    private Genero genero;

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Livro(String titulo, String autor, Genero genero) {
        super(titulo, autor);
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "\n————————————————————————————————————"+
                "\nMaterial: LIVRO" +
                "\nTitulo = " + super.getTitulo() +
                "\nAutor = " + super.getAutor() +
                "\nGênero = " + genero.getNome()+
                "\n————————————————————————————————————\n";
    }
}
