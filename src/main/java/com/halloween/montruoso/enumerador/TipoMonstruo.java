package com.halloween.montruoso.enumerador;

public enum TipoMonstruo {

        VAMPIRO("Vampiro"),
        ZOMBIE("Zombie"),
        HOMBRE_LOBO("Hombre Lobo"),
        FANTASMA("Fantasma"),
        BRUJA("Bruja"),
        GHOUL("Espiritu macabro"),
        MOMIA("Momia"),
        DEMONIO("Demonio"),
        FRANKENSTEIN("Frankestein"),
        ESQUELETO("Esqueleto"),
        DUENDE("Duende"),
        TROLL("Troll"),
        DRAGON("Dragon");

        private String nombre;

        TipoMonstruo(String nombre){
                this.nombre = nombre;
        }
}
