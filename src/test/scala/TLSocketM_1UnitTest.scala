package tilelink
import chisel3.iotesters._

class TLSocketM_1UnitTest(c: TLSocketM_1) extends PeekPokeTester(c) {
  step(10)
}
