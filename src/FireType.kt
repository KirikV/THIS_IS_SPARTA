sealed class FireType {
    abstract val typeName: String

    object OneShot : FireType() {
        override val typeName = "Одиночными"
        override fun toString(): String = typeName
    }

    data class BurstFire(val burstSize: Int) : FireType() {
        override val typeName = "Очередью по $burstSize штук(и)"
        override fun toString(): String = typeName
    }
}