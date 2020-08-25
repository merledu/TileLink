package tilelink
import org.scalatest._
import chiseltest._
import chisel3._

class TLHostAdapterTest extends FlatSpec with ChiselScalatestTester with Matchers {
  implicit val tl_conf = TLConfiguration()
  behavior of "TL-UL Host Adapter"

  it should "Pass data to the device" in {
    test(new TL_HostAdapter) { c =>
      c.io.req_i.poke(true.B)
    }
  }
}
