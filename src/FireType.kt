sealed class FireType() {
    object OneShot : FireType()

    data class BurstFire(var burstSize: Int) : FireType()
}