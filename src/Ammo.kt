enum class Ammo(
    val bulletName: String,
    val damage: Int,
    val chance: Int,
    val kcrit: Int
) {
    BR("Бронебойными", 50, 90, 2),
    SH("Шрапнелью", 30, 80, 2),
    FU("Фугасом", 30, 60, 3);

    fun currentDamage(): Int {
        return if (Int.getChance(this.chance)) {
            print("КРИТ!!!   ")
            this.damage * this.kcrit
        } else this.damage
    }
}