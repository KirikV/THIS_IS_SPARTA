package dataWarriors
import AbstractWarrior

class Manager() : AbstractWarrior(
    chanceAvoidPunishment = 10,
    maxHP = 70,
    chanceHit = 20,
    weapon = Weapons.createGovno(),
    currentHP = 70
){
    override fun toString(): String = "|Манагер \uD83D\uDCBC $name|"
    val name = listOf<String>("Пупа Луповна", "Лупа Пупович", "Сильвестр Всталоне",
        "Арнольд Шварцниггер", "Адольф Лунглер", "Использованный презерватив").random()
}