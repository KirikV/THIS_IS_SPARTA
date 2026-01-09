package dataWarriors
import AbstractWarrior

class Middle() : AbstractWarrior(
    chanceAvoidPunishment = 10,
    maxHP = 150,
    chanceHit = 30,
    weapon = Weapons.createStappler(),
    currentHP = 150,
    name = listOf("'Немытый пиструн'", "'Вялая колбаса'", "'Сломанный корнишон'",
"'Папа может'", "'Нихуя не знаю'", "'Необласканная бастурма'").random()
){
    override fun toString(): String = "|Мидл \uD83E\uDEB5 $name|"
}