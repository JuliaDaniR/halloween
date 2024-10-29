-- Crear tabla principal de monstruos
CREATE TABLE IF NOT EXISTS monstruos (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    tipo ENUM('VAMPIRO', 'ZOMBIE', 'HOMBRE_LOBO', 'FANTASMA', 'BRUJA', 'GHOUL', 'MOMIA', 'DEMONIO', 'FRANKENSTEIN', 'ESQUELETO', 'DUENDE', 'TROLL', 'DRAGON') NOT NULL,
    nivel_de_terror INT,
    descripcion TEXT,
    imagen_url TEXT,
    nivel_de_peligro ENUM('BAJO', 'MEDIO', 'ALTO', 'EXTREMO') NOT NULL,
    historia TEXT,
    apariencia TEXT,
    sonido TEXT
);

-- Crear tabla para la relación muchos a muchos de poderes
CREATE TABLE IF NOT EXISTS monstruo_poderes (
    monstruo_id BIGINT,
    poderes ENUM('VUELO', 'INVISIBILIDAD', 'SUPER_FUERZA', 'HIPNOSIS', 'CAMBIO_DE_FORMA', 'INMORTALIDAD', 'ALIENTO_DE_FUEGO', 'TELETRANSPORTACION', 'REGENERACION', 'MAGIA', 'VISION_NOCTURNA', 'ESCUPITAZO_ACIDO', 'TOQUE_VENENOSO', 'CONTROL_MENTAL', 'CREACION_DE_ILUSIONES', 'CONTROL_DEL_CLIMA', 'TELEQUINESIA', 'PREDICCION', 'CAMUFLAJE', 'MORDIDA_INFECTADA', 'RESILIENCIA', 'CONTROL_DE_ALMAS', 'MANIPULACION_DE_SOMBRAS', 'MANIPULACION_DE_TEMPERATURA', 'FUEGO_INFERNAL', 'AGILIDAD', 'APARICIONES', 'CONTROL_DE_VIENTO', 'HECHICERIAS', 'CONJUROS', 'MAESTRIA_CON_EL_ARMAMENTO', 'RESURRECCION') NOT NULL,
    PRIMARY KEY (monstruo_id, poderes),
    FOREIGN KEY (monstruo_id) REFERENCES monstruos(id) ON DELETE CASCADE
);

-- Crear tabla para la relación muchos a muchos de debilidades
CREATE TABLE IF NOT EXISTS monstruo_debilidades (
    monstruo_id BIGINT,
    debilidades ENUM('LUZ_SOLAR', 'AGUA_BENDITA', 'AJO', 'PLATA', 'FUEGO', 'ESTACA_AL_CORAZON', 'RUIDOS_FUERTES', 'MAGIA', 'HIERRO_FRIO', 'SIMBOLOS_SAGRADOS', 'DECAPITACION', 'SAL', 'AGUA_CORRIENTE', 'SANGRE_DE_VIRGEN', 'MIEDO', 'RELIGION', 'CLAVOS', 'MALDICIONES', 'RITUALES_SAGRADOS', 'LUZ_SAGRADA', 'DISPARO_CABEZA', 'FUEGO_SAGRADO', 'AMULETOS_PROTECTORES', 'RAYOS', 'SAL_SAGRADA') NOT NULL,
    PRIMARY KEY (monstruo_id, debilidades),
    FOREIGN KEY (monstruo_id) REFERENCES monstruos(id) ON DELETE CASCADE
);

-- Crear tabla para habilidades especiales
CREATE TABLE IF NOT EXISTS monstruo_habilidades_especiales (
    monstruo_id BIGINT,
    habilidades_especiales VARCHAR(255) NOT NULL,
    PRIMARY KEY (monstruo_id, habilidades_especiales),
    FOREIGN KEY (monstruo_id) REFERENCES monstruos(id) ON DELETE CASCADE
);
