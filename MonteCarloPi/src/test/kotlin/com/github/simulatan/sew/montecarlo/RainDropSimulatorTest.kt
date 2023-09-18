package com.github.simulatan.sew.montecarlo

import com.github.simulatan.sew.montecarlopi.RainDropSimulator
import org.junit.Test
import kotlin.test.assertTrue

class RainDropSimulatorTest {
	@Test
	fun `test isHit inside`() {
		assertTrue(RainDropSimulator.isHit(0.5, 0.5))
		assertTrue(RainDropSimulator.isHit(0.0, 0.0))
		assertTrue(RainDropSimulator.isHit(0.0, 1.0))
		assertTrue(RainDropSimulator.isHit(1.0, 0.0))
		assertTrue(RainDropSimulator.isHit(0.5, 0.5))
	}

	@Test
	fun `test isHit outside`() {
		assertTrue(!RainDropSimulator.isHit(0.0, 1.1))
		assertTrue(!RainDropSimulator.isHit(1.1, 0.0))
		assertTrue(!RainDropSimulator.isHit(1.1, 1.1))
		assertTrue(!RainDropSimulator.isHit(-0.1, 0.0))
		assertTrue(!RainDropSimulator.isHit(0.0, -0.1))
		assertTrue(!RainDropSimulator.isHit(1.0, 1.0))
	}
}
