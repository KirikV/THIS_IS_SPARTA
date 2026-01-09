package dataWarriors
import AbstractWarrior

class Manager() : AbstractWarrior(
    chanceAvoidPunishment = 5,
    maxHP = 100,
    chanceHit = 20,
    weapon = Weapons.createGovno(),
    currentHP = 100,
    name = listOf<String>("'Пупа Луповна'", "'Лупа Пупович'", "'Сильвестр Всталоне'",
        "'Арнольд Шварцниггер'", "'Адольф Лунглер'", "'Использованный презерватив'").random()
){
    override fun toString(): String = "|Манагер \uD83D\uDCBC $name|"

}