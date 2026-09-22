package com.example.app_data_mujer

data class QuizQuestion(
    val category: String,
    val question: String,
    val options: List<String>,
    val correctOptionIndex: Int
)

val EasyQuestionsList = listOf(
    QuizQuestion("Matemáticas", "¿En qué área destacó Sophie Germain?", listOf("Medicina", "Matemáticas", "Astronomía", "Biología"), 1),
    QuizQuestion("Matemáticas", "¿Qué científica es conocida por los “primos de Sophie Germain”?", listOf("Emmy Noether", "Sophie Germain", "Maryam Mirzakhani", "Ada Lovelace"), 1),
    QuizQuestion("Matemáticas", "¿Qué científica ganó la Medalla Fields en Matemáticas?", listOf("Maryam Mirzakhani", "Marie Curie", "Grace Hopper", "Caroline Herschel"), 0),
    QuizQuestion("Astronomía", "¿Qué científica descubrió ocho cometas?", listOf("Maria Mitchell", "Caroline Herschel", "Nancy Grace Roman", "Henrietta Leavitt"), 1),
    QuizQuestion("Astronomía", "¿Quién descubrió la relación entre el período y la luminosidad de las estrellas Cefeidas?", listOf("Annie Jump Cannon", "Henrietta Swan Leavitt", "Caroline Herschel", "Maria Mitchell"), 1),
    QuizQuestion("Astronomía", "¿Qué astrónoma creó el sistema de clasificación estelar OBAFGKM?", listOf("Nancy Grace Roman", "Maria Mitchell", "Annie Jump Cannon", "Caroline Herschel"), 2),
    QuizQuestion("Astronomía", "¿Quién es conocida como la “madre del telescopio espacial Hubble”?", listOf("Nancy Grace Roman", "Rosalind Franklin", "Donna Strickland", "Ada Lovelace"), 0),
    QuizQuestion("Computación", "¿Qué científica es considerada una pionera de la programación?", listOf("Marie Curie", "Ada Lovelace", "Patricia Bath", "Barbara McClintock"), 1),
    QuizQuestion("Computación", "¿Para qué máquina escribió Ada Lovelace un algoritmo?", listOf("La máquina analítica", "El telescopio Hubble", "El microscopio electrónico", "La computadora ENIAC"), 0),
    QuizQuestion("Computación", "¿Qué científica desarrolló uno de los primeros compiladores?", listOf("Grace Murray Hopper", "Jude Milhon", "Evelyn Berezin", "Lynn Conway"), 0),
    QuizQuestion("Computación", "¿Con qué lenguaje de programación se relaciona especialmente Grace Hopper?", listOf("Kotlin", "COBOL", "Python", "Java"), 1),
    QuizQuestion("Computación", "¿Qué científica creó un sistema temprano de procesamiento de textos llamado Data Secretary?", listOf("Ada Lovelace", "Evelyn Berezin", "Hedy Lamarr", "Lynn Conway"), 1),
    QuizQuestion("Ingeniería", "¿Qué científica inventó el Kevlar?", listOf("Stephanie Kwolek", "Rosalind Franklin", "Marie Curie", "Irène Joliot-Curie"), 0),
    QuizQuestion("Física", "¿Qué científica trabajó junto a Pierre Curie y estudió la radiactividad?", listOf("Lise Meitner", "Marie Curie", "Ada Yonath", "Rosalyn Yalow"), 1),
    QuizQuestion("Física", "¿Qué científica fue hija de Marie y Pierre Curie?", listOf("Irène Joliot-Curie", "Rosalind Franklin", "Margarita Salas", "Lise Meitner"), 0),
    QuizQuestion("Física", "¿Qué descubrieron Irène Joliot-Curie y Frédéric Joliot-Curie?", listOf("La penicilina", "La radiactividad artificial", "El ADN", "Los agujeros negros"), 1),
    QuizQuestion("Química", "¿Qué científica ayudó a documentar e ilustrar los experimentos de Antoine Lavoisier?", listOf("Marie-Anne Paulze-Lavoisier", "Marie Curie", "Stephanie Kwolek", "Ada Yonath"), 0),
    QuizQuestion("Ingeniería", "¿Qué ingeniera solucionó un problema de los motores Rolls-Royce Merlin durante la Segunda Guerra Mundial?", listOf("Emily Warren Roebling", "Edith Clarke", "Beatrice Shilling", "Elisa Leonida Zamfirescu"), 2),
    QuizQuestion("Astronomía", "¿Qué científica fue cantante antes de dedicarse a la astronomía?", listOf("Caroline Herschel", "Maria Mitchell", "Nancy Grace Roman", "Annie Jump Cannon"), 0),
    QuizQuestion("Astronomía", "¿Qué científica descubrió el cometa conocido como “Miss Mitchell's Comet”?", listOf("Caroline Herschel", "Maria Mitchell", "Henrietta Leavitt", "Annie Jump Cannon"), 1)
)
