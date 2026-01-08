import dataWarriors.Manager
import dataWarriors.Middle
import dataWarriors.SeniorPidor

class Team {
    var nameTeam: String = "Безымянная"
    var team: MutableList<Warrior> = mutableListOf()

    fun createTeam() {
        println("Введите название команды")
        nameTeam = readln()
        println("Введите количество воинов в команде")
        val tsize = readln().toIntOrNull() ?: 0
        if (tsize > 0) {
            repeat(tsize) {
                println(
                    "Нажмите ENTER, чтобы бросить октаэдр\n" +
                            "1-3 --- \uD83D\uDCBCМанагер\uD83D\uDCBC ---\n4-6 --- " +
                            "\uD83D\uDCA9Мидл\uD83D\uDCA9 ---\n7-8 --- \uD83D\uDC14Сэйонара " +
                            "Помидор\uD83D\uDC14 ---"
                )
                readln()
                val kubik = (1..8).random()
                println("Вам выпало $kubik")
                when (kubik) {
                    1, 2, 3 -> team.add(Manager())
                    4, 5, 6 -> team.add(Middle())
                    else -> team.add(SeniorPidor())
                }
            }
            println(
                "\n⚔\uFE0F⚔\uFE0F⚔\uFE0F⚔\uFE0F⚔\uFE0FДобро пожаловать на войну, сынок." +
                        "⚔\uFE0F⚔\uFE0F⚔\uFE0F⚔\uFE0F⚔\uFE0F\n" +
                        "Команда '$nameTeam', сегодня мы проверим ваши яйца на прочность.\uD83E\uDD5A\uD83E\uDD5A\n" +
                        "\nТвоя команда:\n ${team.joinToString("\n ")} "
            )
        } else {
            println("Долбоёб это не цифра больше 0. Иди на хуй")
            return
        }
    }

    val nameOpponentTeam = listOf("Тобi Пезда", "Доставай Вазелин", "Страпонессы").random()
    val teamOpponent: MutableList<Warrior> = mutableListOf()
    fun createOpponentTeam() {
        repeat(team.size) {
            val randomWarrior = when ((1..3).random()) {
                1 -> Manager()
                2 -> SeniorPidor()
                else -> Middle()
            }
            teamOpponent.add(randomWarrior)
        }
        println("\n\nЗнакомься, твои противники из команды |$nameOpponentTeam|\n" +
                "Их сосатав\n ${teamOpponent.joinToString("\n ")} "
        )
    }

}


