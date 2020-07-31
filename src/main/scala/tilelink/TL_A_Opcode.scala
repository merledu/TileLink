package tilelink
import chisel3._
object TL_A_Opcode {
  val get = 4.U
  val putFullData = 0.U
  val putPartialData = 1.U
}