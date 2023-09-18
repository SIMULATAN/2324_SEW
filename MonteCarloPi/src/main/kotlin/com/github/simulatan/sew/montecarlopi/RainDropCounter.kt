package com.github.simulatan.sew.montecarlopi

object RainDropCounter {
	var total: Int = 0
		private set
	var hits: Int = 0
		private set

	fun add(total: Int, hits: Int) {
		synchronized(this) {
			this.total += total
			this.hits += hits
		}
	}

	fun reset() {
		synchronized(this) {
			total = 0
			hits = 0
		}
	}
}
