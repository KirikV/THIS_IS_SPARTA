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
            var validBullet = false
            while (!validBullet){
                val randomBullet = Ammo.entries.random()
            if (fireType is FireType.OneShot || (fireType is FireType.BurstFire && randomBullet != Ammo.SH)) {
                createBullet(randomBullet)
                validBullet = true
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

