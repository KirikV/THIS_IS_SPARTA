package dataWarriors
import AbstractWarrior

class SeniorPidor() : AbstractWarrior(
    chanceAvoidPunishment = 50,
    maxHP = 150,
    chanceHit = 50,
    weapon = Weapons.createRezinoviiEldak(),
    currentHP = 150
){
        override fun toString(): String = "|Сэйонара Помидор \uD83D\uDC14 $name|"
    val name = listOf("Илья Джигарасханян", "Алина Окошкина", "Владимир Навальный",
        "Сильвестр Андреич", "Главный по унитазам", "Ещё не придумал").random()
}