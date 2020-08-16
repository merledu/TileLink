package tilelink
import chisel3.iotesters._

class TL_ErrRespUnitTester(c: TL_ErrResp) extends PeekPokeTester(c) {
  step(10)
}
