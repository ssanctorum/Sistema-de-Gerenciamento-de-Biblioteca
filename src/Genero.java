public enum Genero {
    FICCAO("Ficção"),
    TERROR("Terror"),
    ROMANCE("Romance"),
    BIOGRAFIA("Biografia"),
    FANTASIA("Fantasia"),
    DRAMA("Drama"),
    AVENTURA("Aventura"),
    AUTO_AJUDA("Auto Ajuda"),
    ACADEMICO("Acadêmico"),
    ACAO("Ação"),
    SUSPENSE("Suspense"),
    HISTORIA("História");

    private String generoFormatado;

    Genero (String generoFormatado){
        this.generoFormatado = generoFormatado;
    }

    public String getNome(){
        return generoFormatado;
    }
}
