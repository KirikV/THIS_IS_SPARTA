class Battle {
    fun voina() {
        println(
            "\n=========Сводка правил=========\nХуйнёй не занимайтесь, голову мне не ебите.\n" +
                    "Каждый игрок кидает камень с цифрами, у кого больше - тот наносит первый удар\n" +
                    "Следующим ходит тот, кто проебал, далее - по очереди\n" +
                    "Чтобы посмотреть статус битвы, введите 'СТАТУС' во время своего хода\n" +
                    "Каждый ход ты можешь испытать УДАЧУ: реснуть всех своих доходяг и восполнить" +
                    " им здоровье,\nдля этого во время хода введи 'ШАНС', если выпадает '6' - Срабатывает, " +
                    "всё по маслу,\n" +
                    "Если '1' - твой рот ебут чурки и соответственно игра заканчивается в пользу соперника.\n" +
                    "Другие цифры - пропускаешь ход.\n" +
                    "Чтобы сдаться введи 'ASDOFKDOPAFJMDPMOSA' да-да, именно так\n" +
                    "==========================="
        )
        println("Если тебе всё ясно сынок, нажми ENTER, чтобы начать")
        kubikForStart()
        firstHit(i = Team(), v = Team())
        firstHit(i = Team(), v = Team())
        firstHit(i = Team(), v = Team())

    }

    fun firstHit(i: Team, v: Team) {
        if (winner == 1) {
            for (i in i.team) {
                for (v in v.teamOpponent) {
                    println(i.attack(v))
                }
            }
        } else if (winner == 2) {
            for (v in v.teamOpponent) {
                for (i in i.team) {
                    println(i.attack(v))
                }
            }
        }
    }


        fun kubikForStart(): Int {
            println("Бросай камень")
            readln()
            var winner = 0
            val kub1 = (1..6).random()
            println("Выпало $kub1, теперь их очередь")
            val kub2 = (1..6).random()
            println("Выпало $kub2")
            if (kub1 > kub2) {
                winner = 1
                println("Ты ходишь первым")
            } else if (kub2 > kub1) {
                winner = 2
                println("Они начинают первыми")
            } else {
                println("Надо перебросить")
                kubikForStart()
            }
            return winner
        }

        private val winner = kubikForStart()

        fun oneWin(tima: Team) {
            if (tima.team.size > tima.teamOpponent.size) {
                println("Так и быть, ты победил сынок. С тебя лайк и подписка.")
            } else println("Ты проебал, сынок. Попробуй ещё раз")
        }

    }