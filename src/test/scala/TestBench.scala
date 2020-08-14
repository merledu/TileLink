package tilelink
import chisel3._

object TL_HostAdapterMain extends App {
  implicit val tl_conf = TLConfiguration()
  iotesters.Driver.execute(args, () => new TL_HostAdapter){
    c => new TL_HostAdapterUnitTester(c)
  }
}

object TL_RegAdapterMain extends App {
  implicit val tl_conf = TLConfiguration()
  iotesters.Driver.execute(args, () => new TL_RegAdapter()()){
    c => new TL_RegAdapterUnitTester(c)
  }
}

object TLSocket1_NMain extends App {
  implicit val tl_conf = TLConfiguration()
  iotesters.Driver.execute(args, () => new TLSocket1_N(4)) {
    c => new TLSocket1_NUnitTester(c)
  }
}