package tilelink
import chisel3.iotesters._

class TLSocket1_NUnitTester(c: TLSocket1_N) extends PeekPokeTester(c) {
  step(10)
}
