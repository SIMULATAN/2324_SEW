package com.github.simulatan.sew.montecarlopi

import java.util.concurrent.ThreadLocalRandom
import kotlin.math.pow
import kotlin.math.sqrt

class RainDropSimulator(private val rainDropCount: Long) : Runnable {
	override fun run() {
		val random = ThreadLocalRandom.current()
		var totalDrops = 0
		var hits = 0
		for (i in 0..<rainDropCount) {
			totalDrops++
			val x = random.nextDouble(1.0)
			val y = random.nextDouble(1.0)
			if (isHit(x, y)) {
				hits++
			}
		}
		RainDropCounter.add(totalDrops, hits)
	}

	companion object {
		internal fun isHit(x: Double, y: Double) =
			if (x < 0 || y < 0) false else sqrt((x `^` 2) + (y `^` 2)) <= 1

		private infix fun Double.`^`(exponent: Int) = this.pow(exponent.toDouble())
	}
}
