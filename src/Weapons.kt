object Weapons {
    private class Weapon(maxSizeHorn: Int, fireType: FireType, horn: Stack<Ammo> = Stack(), weaponName: String) :
        AbstractWeapon(maxSizeHorn, fireType, horn, weaponName)

    fun createGovno(): AbstractWeapon {
        val horn: Stack<Ammo> = Stack()
        return Weapon(5, FireType.OneShot, horn, weaponName = "Кусок говна")
    }

    fun createStappler(): AbstractWeapon {
        val horn: Stack<Ammo> = Stack()
        return Weapon(9, FireType.OneShot, horn, weaponName = "Стэплер")
    }

    fun createRezinoviiEldak(): AbstractWeapon {
        val horn: Stack<Ammo> = Stack()
        return Weapon(30, FireType.BurstFire(5), horn, weaponName = "Здоровенная елда")
    }

}