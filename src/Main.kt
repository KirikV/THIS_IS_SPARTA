import kotlin.random.Random

fun main() {
    val arena = Team()

    arena.createTeam()

    if (arena.team.isNotEmpty()) {
        arena.createOpponentTeam()

        val battle = Battle(arena, arena)
        battle.voina()
    }
}

fun Int.Companion.getChance(chance: Int): Boolean {
    return Random.nextInt(100) < chance
}

