class Battle(val myTeam: Team, val teamOpponent: Team) {
    fun voina() {
        println(
            "\n=========Сводка правил=========\nХуйнёй не занимайтесь, голову мне не ебите.\n" +
                    "Каждый игрок кидает камень с цифрами, у кого больше - тот наносит первый удар\n" +
                    "Следующим ходит тот, кто проебал, далее - по очереди\n" +
                    "Чтобы посмотреть статус битвы, введите 'СТАТУС' во время своего хода\n" +
                    "Каждый ход ты можешь испытать УДАЧУ: реснуть всех своих доходяг и восполнить" +
                    " им здоровье,\nдля этого во время хода введи 'ШАНС', если выпадает '6' - Срабатывает, " +
                    "всё по маслу, но пропускаешь ход, \n" +
                    "Если '1' - твой рот ебут чурки и соответственно игра заканчивается в пользу соперника.\n" +
                    "Другие цифры - пропускаешь ход.\n" +
                    "Чтобы сдаться введи 'ЯТРУСИХОЧУСДАТЬСЯ' да-да, именно так\n" +
                    "==========================="
        )
        println("Если тебе всё ясно сынок, нажми ENTER, чтобы начать")
        winner = kubikForStart()

        while (myTeam.team.any { !it.isKilled } && teamOpponent.teamOpponent.any { !it.isKilled }) {
            nextTurn()
        }

        if (myTeam.team.any { !it.isKilled }) {
            println("\nПОБЕДА! Команда '${myTeam.nameTeam}' раскатала этих лохов!")
        } else {
            println("\nПРОИГРЫШ... Команда '${teamOpponent.nameOpponentTeam}' оказалась сильнее.")
        }
    }


    private var winner = 0


    fun kubikForStart(): Int {
        println("Бросай камень")
        readln()
        val kub1 = (1..6).random()
        println("Выпало $kub1, теперь их очередь")
        val kub2 = (1..6).random()
        println("Выпало $kub2")
        winner = when {
            kub1 > kub2 -> {
                println("Ты ходишь первым")
                1
            }

            kub2 > kub1 -> {
                println("Они начинают первыми")
                2
            }

            else -> {
                println("Ничья! Перебрасываем...")
                return kubikForStart()
            }
        }
        return winner
    }


    private fun attacked(attackers: MutableList<Warrior>, defenders: MutableList<Warrior>) {
        val attackersCopy = attackers.toList()
        for (a in attackersCopy) {
            if (a.isKilled) continue
            val target = defenders.filter { !it.isKilled }.randomOrNull()
            if (target != null) {
                println("\n$a атакует!")
                a.attack(target)
                defenders.removeIf { it.isKilled }
            }
        }
    }


    private fun nextTurn() {
        if (winner == 1) {
            println("\n--- ТВОЙ ХОД ---")
            println("|| ENTER - атака || 'ШАНС' - испытать удачу || код для сдачи: 'ЯТРУСИХОЧУСДАТЬСЯ' ||" +
                    " СТАТУС - посмотреть состояние команд ||")

            val input = readln().trim().uppercase()

            when (input) {
                "СТАТУС" -> {
                    showStatus()
                    nextTurn()
                    return
                }
                "ШАНС" -> {
                    tryLuck()
                    winner = 2
                }
                "ЯТРУСИХОЧУСДАТЬСЯ" -> {
                    println("\n🏳️ ТЫ СДАЛСЯ! Позорище! Воины бегут с поля боя, а тебя ебут чурки в рот!")
                    myTeam.team.clear()
                    return
                }
                else -> {
                    attacked(myTeam.team, teamOpponent.teamOpponent)
                    teamOpponent.teamOpponent.removeIf { it.isKilled }
                    winner = 2
                }
            }
        } else {
            println("\n--- ХОД ПРОТИВНИКА. Жми ENTER, чтобы увидеть их действия ---")
            readln()
            attacked(teamOpponent.teamOpponent, myTeam.team)
            myTeam.team.removeIf { it.isKilled }
            winner = 1
        }
    }

    private fun tryLuck(): Boolean {
        println("🎲 Испытаешь удачу? Кинь кубик, жми ENTER...")
        readln()
        val chance = (1..6).random()
        println("Выпало: $chance")

        when (chance) {
            6 -> {
                println("🍀 А ты фартовый! Все воины восстановлены и полны сил!")
                myTeam.team.forEach { warrior ->
                    if (warrior is AbstractWarrior) {
                        warrior.currentHP = warrior.maxHP
                    }
                }
                return true
            }
            1 -> {
                println("💀 ААААХАХАХАХАХХААХ. Чурки ебут тебя в рот.")
                println("Игра заканчивается.")
                myTeam.team.forEach { it.getDamage(999999) }
                return false
            }
            else -> {
                println("🤏 Не повезло братик. Ход пропущен.")
                return true
            }
        }
    }

    private fun showStatus() {
        println("\n" + "=".repeat(100))
        println("📊 ТЕКУЩИЙ СТАТУС БИТВЫ")

        println("\n🟢 ТВОЯ КОМАНДА [${myTeam.nameTeam}]:")
        myTeam.team.forEach { warrior ->
            val w = warrior as AbstractWarrior
            println("   - $w | Здоровье: ${w.currentHP}/${w.maxHP} | Оружие: ${w.weapon.weaponName} " +
                    "Патронов в магазине: ${w.weapon.horn.size}")
        }

        println("\n🔴 ВРАГИ [${teamOpponent.nameOpponentTeam}]:")
        teamOpponent.teamOpponent.forEach { warrior ->
            val w = warrior as AbstractWarrior
            println("   - $w | Здоровье: ${w.currentHP}/${w.maxHP} | Оружие: ${w.weapon.weaponName} " +
                    "Патронов в магазине: ${w.weapon.horn.size}")
        }
        println("=".repeat(50))
    }
}