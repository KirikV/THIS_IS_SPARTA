    open class Stack<T> {
        private val list = mutableListOf<T>()

        fun push(item: T) {
            list.add(item)
        }

        fun pop(): T? = if (list.isNotEmpty()) {
            list.removeAt(list.size - 1)
        } else {
            null
        }

        fun isEmpty(): Boolean =
            list.isEmpty()
    }

