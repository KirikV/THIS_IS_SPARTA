import kotlin.random.Random

fun main() {
    val c = Team()
    c.createTeam()
    c.createOpponentTeam()
val v = Battle()
    v.voina()



    /* println("Введите название первой команды")
     val team1: String = readln()
     println("Введите кооличество воинов первой команды")
     var sizet1: Int = readln()
     println("Введите название второй команды")
     val team2: String = readln()
     println("Введите кооличество воинов второй команды")
     var sizet2: Int = readln()
     war()
 */

//
//    val shot1 = Ammo.entries.random()
//    println("${shot1.bulletName} нанесён урон ${shot1.currentDamage()}")
//    val shot2 = Ammo.entries.random()
//
//    println("${shot2.bulletName} нанесён урон ${shot2.currentDamage()}")
//    val shot3 = Ammo.entries.random()
//    println("${shot3.bulletName} нанесён урон ${shot3.currentDamage()}")
//    val shotgun = Weapons.createShotgun()
//
//    println("Статус наличия пуль ${shotgun.hasBullet}")
//
//    shotgun.reloading()
//
//    println("Статус наличия пуль после перезарядки ${shotgun.hasBullet}")
//
//    while (shotgun.hasBullet) {
//        val bullet = shotgun.getBulletForShoot()
//        println("Выстрел! Урон ${bullet?.currentDamage()}")
//    }
//
//    println("Статус после стрельбы ${shotgun.hasBullet}")
//
//    val mka = Weapons.createM4A4()
//
//    println("Статус наличия пуль ${mka.hasBullet}")
//
//    mka.reloading()
//
//    println("Статус наличия пуль после перезарядки ${mka.hasBullet}")
//
//    while (mka.hasBullet) {
//        val bullet = mka.getBulletForShoot()
//        println("Выстрел! Урон ${bullet?.currentDamage()}")
//    }
//
//    println("Статус после стрельбы ${mka.hasBullet}")
//}

    /*fun war() {
println("Война началась")
    while (!win) {

    }
    println()
}*/


}

fun Int.Companion.getChance(chance: Int): Boolean {
    return Random.nextInt(100) < chance
}

