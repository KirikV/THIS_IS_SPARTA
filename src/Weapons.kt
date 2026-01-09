object Weapons {
    private class Weapon(maxSizeHorn: Int, fireType: FireType, horn: Stack<Ammo> = Stack(), weaponName: String) :
        AbstractWeapon(maxSizeHorn, fireType, horn, weaponName)

    fun createGovno(): AbstractWeapon {
        val horn: Stack<Ammo> = Stack()
        return Weapon(2, FireType.OneShot, horn, weaponName = "\uD83D\uDCA9Кусок говна\uD83D\uDCA9")
    }

    fun createStappler(): AbstractWeapon {
        val horn: Stack<Ammo> = Stack()
        return Weapon(4, FireType.OneShot, horn, weaponName = "\uD83D\uDCCEСтэплер\uD83D\uDCCE")
    }

    fun createRezinoviiEldak(): AbstractWeapon {
        val horn: Stack<Ammo> = Stack()
        return Weapon(6, FireType.BurstFire(3), horn, weaponName = "\uD83C\uDF46Здоровенная елда\uD83C\uDF46")
    }

}