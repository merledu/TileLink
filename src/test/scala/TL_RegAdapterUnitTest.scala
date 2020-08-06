package tilelink
import chisel3.iotesters._

class TL_RegAdapterUnitTester(c: TL_RegAdapter) extends PeekPokeTester(c) {
  step(10)
}