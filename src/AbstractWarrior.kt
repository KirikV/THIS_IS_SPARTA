abstract class AbstractWarrior(
    override var chanceAvoidPunishment: Int,
    val maxHP: Int,
    var chanceHit: Int,
    var weapon: AbstractWeapon,
    var currentHP: Int
) : Warrior {
    override var isKilled: Boolean = false
        get() = currentHP <= 0


    override fun attack(opponent: Warrior) {
        if (!weapon.hasBullet) {
            weapon.getBulletForShoot()
            //пропустить ход
            return
        }


        val ammoForShoot = weapon.getBulletForShoot()
        for (ammo in ammoForShoot) {
            if (Int.getChance(chanceHit) && !Int.getChance(opponent.chanceAvoidPunishment)) {
                val damage = ammo.currentDamage()
                opponent.getDamage(damage)
            } else {
                println("Промах")
            }
        }


    }

    override fun getDamage(damage: Int) {
        currentHP -= damage
            .coerceAtLeast(0)
        if (isKilled) println("Сдох")
    }
}

