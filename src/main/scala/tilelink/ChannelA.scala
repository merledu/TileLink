package tilelink
import chisel3._

class ChannelA(implicit val conf: TLConfiguration) extends Bundle {
  val a_valid = Output(Bool())
  val a_opcode = Output(UInt(3.W))
  val a_param = Output(UInt(3.W))
  val a_size = Output(UInt(conf.TL_SZW.W))
  val a_source = Output(UInt(conf.TL_AIW.W))
  val a_address = Output(UInt(conf.TL_AW.W))
  val a_mask = Output(UInt(conf.TL_DBW.W))
  val a_data = Output(UInt(conf.TL_DW.W))
  val d_ready = Output(Bool())
}