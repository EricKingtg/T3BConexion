
import com.t3b.pv.t3blog.utils.Config;
import com.t3b.pv.t3blog.utils.Logger3B;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */















public class Log3B
{
  public static void main(String[] args) {
    Config.loadConfig();
    Logger3B.Log(1, "log3B", "PRUEBA 1");
  }
}
