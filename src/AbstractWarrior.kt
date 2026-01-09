abstract class AbstractWarrior(
    override var chanceAvoidPunishment: Int,
    val maxHP: Int,
    var chanceHit: Int,
    var weapon: AbstractWeapon,
    var currentHP: Int,
    override var name: String
) : Warrior {
    override var isKilled: Boolean = false
        get() = currentHP <= 0


    override fun attack(opponent: Warrior) {
        if (!weapon.hasBullet) {
            println("--- В магазине пусто. Тратит ход на перезарядку! ---")
            weapon.reloading()
            return
        }

        val ammoForShoot = weapon.getBulletForShoot()
        println(
            "$name открывает огонь ${weapon.fireType.typeName} из ${weapon.weaponName}" +
                    " по ${opponent.name}!")
        for (ammo in ammoForShoot) {
            if (opponent.isKilled) {
                println("...прекращение огня! ${opponent.name} уже готов 💀")
                break
            }
            if (Int.getChance(chanceHit) && !Int.getChance(opponent.chanceAvoidPunishment)) {
                val damage = ammo.currentDamage()
                println("🎯 Попадание патроном ${ammo.bulletName}!")
                println("${opponent.name} принимает $damage урона в очко")
                opponent.getDamage(damage)

            } else {
                println("В молоко! Промах! Лох!")
            }
        }
        println("🔋 В магазине '${weapon.weaponName}' осталось: ${weapon.horn.size}")
    }

    override fun getDamage(damage: Int) {
        currentHP -= damage
        if (currentHP < 0) currentHP = 0
        if (isKilled) {
            println("💀💀💀 $name Сдох! 💀💀💀")
        }
    }
}
