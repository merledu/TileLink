package tilelink
import chisel3._

class TL_Decoder(N: Int, addrMap: AddressMap)(implicit val conf: TLConfiguration) extends Module {
  val io = IO(new Bundle {
    val addr_i = Input(UInt(32.W))
    val dev_sel = Output(UInt(N.W))
  })

  val gpio_mask = Wire(UInt(32.W))
  gpio_mask := addrMap.ADDR_MASK_GPIO
  when((io.addr_i & ~gpio_mask) === addrMap.ADDR_SPACE_GPIO) {
    io.dev_sel := TL_Peripherals.deviceMap("gpio")
  } .otherwise {
    io.dev_sel := 1.U
  }

}
