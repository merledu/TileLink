package tilelink
import chisel3.iotesters._

class ArbiterUnitTester(c:Arbiter) extends PeekPokeTester(c) {
  step(10)
}
