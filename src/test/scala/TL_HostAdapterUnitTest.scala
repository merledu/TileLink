package tilelink
import chisel3.iotesters._

class TL_HostAdapterUnitTester(c: TL_HostAdapter) extends PeekPokeTester(c) {
  step(10)
}