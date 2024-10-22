package com.halloween.montruoso.enumerador;

public enum Poderes {

    VUELO("Volar"),
    INVISIBILIDAD("Invisibilidad"),
    SUPER_FUERZA("Superfuerza"),
    HIPNOSIS("Hipnosis"),
    CAMBIO_DE_FORMA("Cambio de forma"),
    INMORTALIDAD("Inmortalidad"),
    ALIENTO_DE_FUEGO("Aliento de fuego"),
    TELETRANSPORTACION("Teletransportacion"),
    REGENERACION("Regeneracion"),
    MAGIA("Magia"),
    VISION_NOCTURNA("Vision nocturna"),
    ESCUPITAZO_ACIDO("Escupitazo acido"),
    TOQUE_VENENOSO("Toque venenoso"),
    CONTROL_MENTAL("Control mental"),
        CREACION_DE_ILLUSIONES("Creación de ilusiones"),
        CONTROL_DEL_CLIMA("Control del clima"),
        TELEQUINESIA("Telequinesia"),
        PREDICCION("Predicción"),
        CAMUFLAJE("Camuflaje");

    private String nombre;

    Poderes(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
