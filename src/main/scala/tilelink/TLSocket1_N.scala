package tilelink
import chisel3._

class TLSocket1_N(N: Int)(implicit val conf: TLConfiguration) extends Module {
  val io = IO(new Bundle {
    val tl_h_i = Flipped(new TL_H2D)
    val tl_h_o = new TL_D2H

    val tl_d_o = Vec(N, new TL_H2D)
    val tl_d_i = Flipped(Vec(N, new TL_D2H))
  })

  for(i <- 0 to N-1) {
    io.tl_d_o(i) <> io.tl_h_i
  }

  io.tl_h_o <> io.tl_d_i(0)
}
