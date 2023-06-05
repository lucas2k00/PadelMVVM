package com.lucasbelgrano.padelmvvmkt.data.model

class GolpesProvider {
    companion object {
        private var currentIndex = 0;
        fun next(): GolpesModel {
            if (currentIndex == golpes.size){
                return golpes[currentIndex]
            }
            return golpes[currentIndex++]
        }

        private val golpes = listOf(
            GolpesModel(
                name = "Derecha",
                description = "Es el golpe básico en el pádel. Se realiza con la mano dominante en el lado derecho del cuerpo (para jugadores diestros) y consiste en golpear la pelota de frente, generando velocidad y control.",
                url = ""
            ),
            GolpesModel(
                name = "Revés",
                description = "Similar al golpe de derecha, pero se realiza con la mano no dominante en el lado izquierdo del cuerpo (para jugadores diestros). Se utiliza cuando la pelota viene hacia el lado contrario del jugador y se necesita golpearla hacia atrás.",
                url = ""
            ),
            GolpesModel(
                name = "Volea de derecha",
                description = "Se realiza cuando la pelota se encuentra a media altura o cerca de la red. El jugador golpea la pelota antes de que toque el suelo, generando una respuesta rápida y precisa.",
                url = ""
            ),
            GolpesModel(
                name = "Volea de revés",
                description = "Similar a la volea de derecha, pero se realiza con la mano no dominante en el lado izquierdo del cuerpo (para jugadores diestros). También se utiliza cuando la pelota se encuentra a media altura o cerca de la red.",
                url = ""
            ),
            GolpesModel(
                name = "Bandeja",
                description = "Es un golpe defensivo que se utiliza para enviar la pelota hacia el lado contrario de la pista, con una trayectoria alta y profunda. Se utiliza cuando el jugador se encuentra cerca de la red y necesita ganar tiempo para reubicarse.",
                url = ""
            ),
            GolpesModel(
                name = "Smash",
                description = "Es un golpe ofensivo que se realiza cuando la pelota se encuentra en el aire, cerca de la red. Se trata de un golpe potente y descendente, similar a una volea pero con mayor fuerza, con el objetivo de enviar la pelota con velocidad y hacia el suelo.",
                url = ""
            ),
            GolpesModel(
                name = "Vibora",
                description = "Es un golpe que se realiza cerca de la red y con la pala en posición invertida. La pelota se golpea de abajo hacia arriba, generando un efecto liftado y con una trayectoria curva, dificultando la respuesta del oponente.",
                url = ""
            ),
            GolpesModel(
                name = "Remate",
                description = "Similar al smash, se trata de un golpe potente y descendente, pero se realiza cuando la pelota está más lejos de la red. Se busca enviar la pelota con velocidad y fuerza hacia el suelo, aprovechando la potencia del brazo.",
                url = ""
            )
        )
    }
}