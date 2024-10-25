package com.halloween.montruoso.enumerador;

public enum Debilidades {
        LUZ_SOLAR("Luz solar"),
        AGUA_BENDITA("Agua bendita"),
        AJO("Ajo"),
        PLATA("Plata"),
        FUEGO("Fuego"),
        ESTACA_AL_CORAZON("Estaca al corazón"),
        RUIDOS_FUERTES("Ruidos fuertes"),
        MAGIA("Magia"),
        HIERRO_FRIO("Hierro frío"),
        SIMBOLOS_SAGRADOS("Símbolos sagrados"),
        DECAPITACION("Decapitación"),
        SAL("Sal"),
        AGUA_CORRIENTE("Agua corriente"),
        SANGRE_DE_VIRGEN("Sangre de virgen"),
        MIEDO("Miedo"),
        RELIGION("Religión"),
        CLAVOS("Clavos"),
        MALDICIONES("Maldiciones"),
        RITUALES_SAGRADOS("Rituales Sagrados"),
        LUZ_SAGRADA("Luz sagrada"),
        DISPARO_CABEZA("Disparos en la cabeza"),
        FUEGO_SAGRADO("Fuego sagrado"),
        AMULETOS_PROTECTORES("Amuletos protectores"),
        RAYOS("Rayos"),
        SAL_SAGRADA("Sal sagrada");

        private String nombre;

        Debilidades(String nombre) {
                this.nombre = nombre;
        }

        public String getNombre() {
                return nombre;
        }
}
