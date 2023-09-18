package com.github.simulatan.sew.montecarlopi

import kotlin.system.measureNanoTime

fun main() {
	print("Please enter the number of rain drops to simulate: ")
	val rainDropCount = readln().toLongOrNull()
		?: return println("Invalid input. Please enter a number.")
	if (rainDropCount < 1) {
		return println("Invalid input. Please enter a positive number.")
	}

	print("Please enter the number of threads to use: ")
	val threadCount = readln().toIntOrNull()
		?: return println("Invalid input. Please enter a number.")
	if (threadCount < 1) {
		return println("Invalid input. Please enter a positive number.")
	}

	println("====================")
	println("Performing sequential calculation with $rainDropCount rain drops.")

	val rainDropCountPerThread = rainDropCount / threadCount
	val remainder = rainDropCount % threadCount

	val threads = Array(threadCount) {
		val dropCount = rainDropCountPerThread + if (it == threadCount - 1) remainder else 0
		Thread(RainDropSimulator(dropCount))
	}

	val time = measureNanoTime {
		threads.forEach(Thread::start)
		threads.forEach(Thread::join)
	}

	println("Result: ${RainDropCounter.hits.toDouble() / RainDropCounter.total * 4}")
	println("Time: $time ns")
	println("${RainDropCounter.hits} hits out of ${RainDropCounter.total} rain drops")
	println("====================")
}
