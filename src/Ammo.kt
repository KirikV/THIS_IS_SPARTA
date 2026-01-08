enum class Ammo(
    val bulletName: String,
    val damage: Int,
    val chance: Int,
    val kcrit: Int
) {
    BR("Бронебойный", 80, 40, 2),
    SH("Шрапнель", 30, 20, 2),
    FU("Фугас", 50, 30, 4);

    fun currentDamage(): Int {
        return if (Int.getChance(this.chance)) {
            print("КРИТ!!!   ")
            this.damage * this.kcrit
        } else this.damage
    }
}