package dataWarriors
import AbstractWarrior

class Middle() : AbstractWarrior(
    chanceAvoidPunishment = 30,
    maxHP = 100,
    chanceHit = 30,
    weapon = Weapons.createStappler(),
    currentHP = 100
){
    override fun toString(): String = "|Мидл \uD83D\uDCA9 $name|"
    val name = listOf<String>("Немытый пиструн", "Вялая колбаса", "Сломанный корнишон",
        "Папа может", "Нихуя не знаю", "Необласканная бастурма").random()
}