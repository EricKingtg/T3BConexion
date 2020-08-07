package com.org.t3b.log;

import com.org.t3b.log.utils.Config;
import com.org.t3b.log.utils.Logger3B;

public class Log3B {
	public static void main(String[] args) {
		Config.loadConfig();
		Logger3B.Log(1, "log3B", "PRUEBA 1");
	}
}