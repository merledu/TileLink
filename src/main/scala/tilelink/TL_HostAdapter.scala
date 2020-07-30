package tilelink
import chisel3._

class TL_HostAdapter(implicit val conf: TLConfiguration) extends Module {
  val io = IO(new Bundle {
    val req_i = Input(Bool())
    val gnt_o = Output(Bool())
    val addr_i = Input(UInt(conf.TL_AW.W))
    val we_i = Input(Bool())
    val wdata_i = Input(UInt(conf.TL_DW.W))
    val be_i = Input(UInt(conf.TL_DBW.W))
    val valid_o = Output(Bool())
    val rdata_o = Output(UInt(conf.TL_DW.W))
    val corr_o = Output(Bool())

    val tl_o = new TL_H2D()
    val tl_i = Flipped(new TL_D2H())
  })

  when(reset.asBool()) {
    io.tl_o.a_valid := false.B  // spec pg 11 during RESET the a_valid from master must be low
  }

}