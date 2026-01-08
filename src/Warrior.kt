interface Warrior {
    var isKilled: Boolean;
    var chanceAvoidPunishment: Int

    fun attack(opponent: Warrior)
    fun getDamage(damage: Int)
}