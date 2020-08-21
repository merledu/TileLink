package tilelink
import chisel3._

class TLSocketM_1(M: Int)(implicit val conf:TLConfiguration) extends Module {
  val io = IO(new Bundle {
    val tl_h_i = Vec(M, Flipped(new TL_H2D))
    val tl_h_o = Vec(M, new TL_D2H)
    val tl_d_o = new TL_H2D
    val tl_d_i = Flipped(new TL_D2H)
  })
  val hRequest = Vec(M, Wire(Bool()))
  val hGrant = Vec(M, Wire(Bool()))

//  val arbReady = Wire(Bool())
//  val arbValid = Wire(Bool())
//  val arbData = Wire(new TL_H2D)


  for(i <- 0 until M) {
    hRequest(i) := io.tl_h_i(i).a_valid
  }

  //arbReady := io.tl_d_i.a_ready
}