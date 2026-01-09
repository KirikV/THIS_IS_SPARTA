abstract class AbstractWeapon(
    var maxSizeHorn: Int,
    val fireType: FireType,
    var horn: Stack<Ammo> = Stack(),
    var weaponName: String
) {
    val hasBullet: Boolean
        get() = !horn.isEmpty()

    fun createBullet(bullet: Ammo): Ammo {
        horn.push(bullet)
        return bullet
    }

    fun reloading() {
        if (!hasBullet) {
            println("Перезарядка")
            if (fireType is FireType.OneShot) {
                repeat(maxSizeHorn) { createBullet(Ammo.BR) }
            } else if (fireType is FireType.BurstFire) {
                repeat(maxSizeHorn) {
                    val randomBullet = createBullet(Ammo.entries.random())
                    if (randomBullet == Ammo.BR) {
                        return@repeat
                    }
                }
            }
            println("Оружие перезаряжено, магазин полон")
        }
    }

    fun getBulletForShoot(): List<Ammo> {
        val bullets = mutableListOf<Ammo>()
        val shotsCount = when (fireType) {
            is FireType.OneShot -> 1
            is FireType.BurstFire -> 3
        }
        repeat(shotsCount) {
            val bullet = horn.pop()
            if (bullet != null)
                bullets.add(bullet)
        }
        return bullets
    }
}

