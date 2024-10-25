package com.halloween.montruoso.enumerador;

public enum Poderes {
    VUELO("Volar"),
    INVISIBILIDAD("Invisibilidad"),
    SUPER_FUERZA("Superfuerza"),
    HIPNOSIS("Hipnosis"),
    CAMBIO_DE_FORMA("Cambio de forma"),
    INMORTALIDAD("Inmortalidad"),
    ALIENTO_DE_FUEGO("Aliento de fuego"),
    TELETRANSPORTACION("Teletransportación"),
    REGENERACION("Regeneración"),
    MAGIA("Magia"),
    VISION_NOCTURNA("Visión nocturna"),
    ESCUPITAZO_ACIDO("Escupitazo ácido"),
    TOQUE_VENENOSO("Toque venenoso"),
    CONTROL_MENTAL("Control mental"),
    CREACION_DE_ILUSIONES("Creación de ilusiones"),
    CONTROL_DEL_CLIMA("Control del clima"),
    TELEQUINESIA("Telequinesia"),
    PREDICCION("Predicción"),
    CAMUFLAJE("Camuflaje"),
    MORDIDA_INFECTADA("Mordida Infectada"),
    RESILIENCIA("Resiliencia"),
    CONTROL_DE_ALMAS("Control de almas"),
    MANIPULACION_DE_SOMBRAS("Manipulacion de sombras"),
    MANIPULACION_DE_TEMPERATURA("Manipulación de temperatura"),
    FUEGO_INFERNAL("Fuego infernal"),
    AGILIDAD("Agilidad"),
    APARICIONES("Apariciones"),
    CONTROL_DE_VIENTO("Control de viento"),
    HECHICERIAS("Hechicerias"),
    CONJUROS("Conjuros"),
    MAESTRIA_CON_EL_ARMAMENTO("Maestria con el armamento"),
    RESURRECCION("Resurrección");

    private String nombre;

    Poderes(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
