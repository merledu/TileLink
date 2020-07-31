package tilelink
import chisel3._

object TL_HostAdapterMain extends App {
  implicit val tl_conf = TLConfiguration()
  iotesters.Driver.execute(args, () => new TL_HostAdapter){
    c => new TL_HostAdapterUnitTester(c)
  }
}