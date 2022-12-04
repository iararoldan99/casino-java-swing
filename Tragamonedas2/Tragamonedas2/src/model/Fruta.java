package model;

public enum Fruta {

    PERA("pera.png"),
    BANANA("banana.png"),
    FRUTILLA("frutilla.png");

    private String archivo;

    Fruta(String archivo) {
        this.archivo = archivo;
    }

    public String getArchivo() {
        return archivo;
    }
}
