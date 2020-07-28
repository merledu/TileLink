package tilelink
import chisel3.util._

case class TLConfiguration() {
  val TL_AW = 32                  // AW -> the default width of address bus
  val TL_DW = 32                  // DW -> the default width of data bus
  val TL_AIW = 4                  // AIW -> Address source identifier bus width
  val TL_DIW = 1                  // DIW -> Sink bits width
  val TL_DBW = (TL_DW >> 3)       // Number of data bytes generated (DW/8)
  val TL_SZW = log2Ceil(TL_DBW)   // The size width of operation in power of 2 represented in bytes
}