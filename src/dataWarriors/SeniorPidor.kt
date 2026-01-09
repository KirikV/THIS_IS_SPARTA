package dataWarriors

import AbstractWarrior
import kotlin.collections.listOf

class SeniorPidor() : AbstractWarrior(
    chanceAvoidPunishment = 15,
    maxHP = 200,
    chanceHit = 50,
    weapon = Weapons.createRezinoviiEldak(),
    currentHP = 200,
    name = listOf(
        "'Илья Джигарасханян'", "'Алина Окошкина'", "'Владимир Навальный'",
        "'Сильвестр Андреич'", "'Главный по унитазам'", "'Ещё не придумал'"
    ).random()
) {
    override fun toString(): String = "|Сэйонара Помидор \uD83D\uDC14 $name|"
}