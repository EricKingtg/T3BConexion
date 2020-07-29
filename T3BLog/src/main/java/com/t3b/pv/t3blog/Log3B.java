package com.t3b.pv.t3blog;

import com.t3b.pv.t3blog.utils.Config;
import com.t3b.pv.t3blog.utils.Logger3B;

public class Log3B {
	public static void main(String[] args) {
		Config.loadConfig();
		Logger3B.Log(1, "log3B", "PRUEBA 1");
	}
}