package tilelink
import chisel3._
import chisel3.util.Cat

/**
  TL-UL adapter for the register interface used by peripherals
 */

class TL_RegAdapter(regAw: Int = 8, regDw: Int = 32)(regBw: Int = regDw/8)(implicit val conf: TLConfiguration) extends Module {
  val io = IO(new Bundle {
    // TL-UL interface
    val tl_i = Flipped(new TL_H2D())
    val tl_o = new TL_D2H()

    // Register interface
    val re_o = Output(Bool())
    val we_o = Output(Bool())
    val addr_o = Output(UInt(regAw.W))
    val wdata_o = Output(UInt(regDw.W))
    val be_o = Output(UInt(regBw.W))
    val rdata_i = Input(UInt(regDw.W))
    val error_i = Input(Bool())
  })

  val a_ack = Wire(Bool())
  val d_ack = Wire(Bool())

  val rdata = Wire(UInt(regDw.W))
  val error = Wire(Bool())
  val err_internal = Wire(Bool())
  val addr_align_err = Wire(Bool())
  val tl_err = Wire(Bool())

  val reqId = Wire(UInt(conf.TL_AIW.W))
  val reqSz = Wire(UInt(conf.TL_SZW.W))
  val rd_req = Wire(Bool())
  val wr_req = Wire(Bool())

  a_ack := io.tl_i.a_valid && io.tl_o.a_ready
  d_ack := io.tl_o.d_valid && io.tl_i.d_ready

  // Request signals coming from Host
  wr_req := a_ack && ((io.tl_i.a_opcode === TL_A_Opcode.putFullData) || (io.tl_i.a_opcode === TL_A_Opcode.putPartialData))
  rd_req := a_ack && (io.tl_i.a_opcode === TL_A_Opcode.get)

  io.we_o := wr_req && !err_internal
  io.re_o := rd_req && !err_internal
  io.addr_o := Cat(io.tl_i.a_address(regAw-1, 2), 0.U(2.W)) // word aligned address
  io.wdata_o := io.tl_i.a_data
  io.be_o := io.tl_i.a_mask
}