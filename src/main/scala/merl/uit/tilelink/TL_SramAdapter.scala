package merl.uit.tilelink
import chisel3._
import chisel3.util.{Enum, log2Ceil}

class TL_SramAdapter(sramAw: Int, sramDw: Int)(implicit val conf: TLConfiguration) extends Module {
  val io = IO(new Bundle {
    // TL-UL interface
    val tl_i = Flipped(new TL_H2D())
    val tl_o = new TL_D2H()
    // SRAM interface
    val req_o = Output(Bool())
    val gnt_i = Input(Bool())
    val we_o = Output(Bool())
    val addr_o = Output(UInt(sramAw.W))
    val wdata_o = Output(UInt(sramDw.W))
    val wmask_o = Output(UInt(sramDw.W))
    val rdata_i = Input(UInt(sramDw.W))
    val rvalid_i = Input(Bool())
    val rerror_i = Input(UInt(2.W))
  })

  val sramByte = sramDw/8
  val dataBitWidth = log2Ceil(sramByte)
  val widthMult = sramDw/conf.TL_DW // 1 in our case (32/32)
  val wOffsetWidth = if (sramByte == conf.TL_DBW) 1 else dataBitWidth - log2Ceil(conf.TL_DBW) // 1 in our case

  val sram_req = new Bundle {
    val mask = Wire(UInt(conf.TL_DBW.W))      // byte mask within the TL-UL word
    val woffset = Wire(UInt(wOffsetWidth.W))  // offset of the TL-UL word within the SRAM word
  }

  val req_op = new Bundle {
    val opWrite = 0.U
    val opRead = 1.U
    val opUnkown = 2.U
  }

  val req = new Bundle {
    val op = Wire(req_op)
    val error = Wire(Bool())
  }

  val resp = new Bundle {
    val data = Wire(UInt(sramDw.W))
    val error = Wire(Bool())
  }


}
