package ru.touchin.pic_loaders_benchmark.utils

object Timer {

    private var average: Double = 0.0
    private var count: Long = 0

    private val times = mutableMapOf<String, Long>()

    var onTimerChangeListener: (Long, Double) -> Unit = { _, _ -> }

    fun resetTimer() {
        average = 0.0
        count = 0
        times.clear()
    }

    fun startTimer(key: String) {
        times += key to System.currentTimeMillis()
    }

    fun stopTimer(key: String) {
        times[key]?.let {
            average = (average + (System.currentTimeMillis() - it)) / 2
            count++
            onTimerChangeListener.invoke(count, average)
        }
        times -= key
    }

}
