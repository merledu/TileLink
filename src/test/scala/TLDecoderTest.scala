package tilelink
import org.scalatest._
import chiseltest._
import chisel3._

class TLDecoderTest extends FlatSpec with ChiselScalatestTester with Matchers {
  behavior of "TL Decoder"
  implicit val conf = TLConfiguration()
  val addrMap = AddressMap()
  it should "just run" in {
    test(new TL_Decoder(4, addrMap)) {c =>
      c.io.addr_i.poke("h40010000".U)
      c.io.dev_sel.expect(TL_Peripherals.deviceMap("gpio"))
    }
  }
}
