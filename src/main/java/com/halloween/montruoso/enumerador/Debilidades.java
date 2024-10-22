package com.halloween.montruoso.enumerador;

public enum Debilidades {

        LUZ_SOLAR("Luz solar"),
        AGUA_BENDITA("Agua bendita"),
        AJO("Ajo"),
        PLATA("Plata"),
        FUEGO("Fuego"),
        ESTACA_AL_CORAZON("Estaca al corazon"),
        RUIDOS_FUERTES("Ruidos fuertes"),
        MAGIA("Magia"),
        HIERRO_FRIO("Hierro frío"),
        SIMBOLOS_SAGRADOS("Símbolos sagrados"),
        DECAPITACION("Decapitacion"),
        SAL("Sal"),
        AGUA_CORRIENTE("Agua corriente"),
        SANGRE_DE_VIRGEN("Sangre de virgen"),
        MIEDO("Miedo"),
        RELIGION("Religión"),
        CLAVOS("Clavos"),
        MALDICIONES("Maldiciones");
        private String nombre;

        Debilidades(String nombre) {
                this.nombre = nombre;
        }

        public String getNombre() {
                return nombre;
        }
}
