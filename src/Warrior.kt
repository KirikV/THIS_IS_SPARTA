interface Warrior {
    var isKilled: Boolean;
    var chanceAvoidPunishment: Int
    val name: String
    fun attack(opponent: Warrior)
    fun getDamage(damage: Int)
}