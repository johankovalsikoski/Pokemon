package johan.kovalsikoski.core.extensions

fun Boolean?.ifTrue(function: () -> Unit) {
    if (this.notNull() && this == true) {
        function()
    }
}