package com.qk.demo;

import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;

public class TaskKill {
	
	/*private int appium_port = 4727;
	private int bootstrap_port = 5727;
	private int chromedriver_port = 6727;*/
	
	public static void adb() throws ExecuteException, IOException{
		CommandLine verify = new CommandLine("taskkill");
		verify.addArgument("/F");
		verify.addArgument("/IM");
		verify.addArgument("adb.exe");
		DefaultExecuteResultHandler taskkill = new DefaultExecuteResultHandler();
		DefaultExecutor killer = new DefaultExecutor();
		killer.setExitValue(1);
		killer.execute(verify, taskkill);
	}
		
	public static void stopnode() throws ExecuteException, IOException{
		CommandLine verify = new CommandLine("taskkill");
		verify.addArgument("/F");
		verify.addArgument("/IM");
		verify.addArgument("node.exe");
		DefaultExecuteResultHandler taskkill = new DefaultExecuteResultHandler();
		DefaultExecutor killer = new DefaultExecutor();
		killer.setExitValue(1);
		killer.execute(verify, taskkill);
	}
	
	public static void stopappium() throws ExecuteException, IOException, InterruptedException{
		Process p = Runtime.getRuntime().exec("cmd /c echo off & FOR /F \"usebackq tokens=5\" %a in (`netstat -nao ^| findstr /R /C:\""+4731+"\"`) do (FOR /F \"usebackq\" %b in (`TASKLIST /FI \"PID eq %a\" ^| findstr /I node.exe`) do taskkill /F /PID %a)");
		Thread.sleep(2000);
		p.destroy();
		/*Process bp = Runtime.getRuntime().exec("cmd /c echo off & FOR /F \"usebackq tokens=5\" %a in (`netstat -nao ^| findstr /R /C:\""+5727+"\"`) do (FOR /F \"usebackq\" %b in (`TASKLIST /FI \"PID eq %a\" ^| findstr /I node.exe`) do taskkill /F /PID %a)");
		Thread.sleep(2000);
		bp.destroy();
		Process cp = Runtime.getRuntime().exec("cmd /c echo off & FOR /F \"usebackq tokens=5\" %a in (`netstat -nao ^| findstr /R /C:\""+6727+"\"`) do (FOR /F \"usebackq\" %b in (`TASKLIST /FI \"PID eq %a\" ^| findstr /I node.exe`) do taskkill /F /PID %a)");
		Thread.sleep(2000);
		cp.destroy();*/
		/*CommandLine verify = new CommandLine("taskkill");
		verify.addArgument("/F");
		verify.addArgument("/IM");
		verify.addArgument("node.exe");
		DefaultExecuteResultHandler taskkill = new DefaultExecuteResultHandler();
		DefaultExecutor killer = new DefaultExecutor();
		killer.setExitValue(1);
		killer.execute(verify, taskkill);*/
	}
		
	public static void javaw() throws ExecuteException, IOException{
		CommandLine verify = new CommandLine("taskkill");
		verify.addArgument("/F");
		verify.addArgument("/IM");
		verify.addArgument("javaw.exe");
		DefaultExecuteResultHandler taskkill = new DefaultExecuteResultHandler();
		DefaultExecutor killer = new DefaultExecutor();
		killer.setExitValue(1);
		killer.execute(verify, taskkill);
	}
	
	public static void startappium() throws ExecuteException, IOException{
/*		CommandLine command = new CommandLine("C:/Program Files (x86)/Appium/node.exe"); // 64-bit
//		CommandLine command = new CommandLine("C:/Program Files/Appium/node.exe"); // 32-bit
		command.addArgument("C:/Program Files (x86)/Appium/node_modules/appium/bin/Appium.js", false);
//		command.addArgument("C:/Program Files/Appium/node_modules/appium/bin/Appium.js", false);
		command.addArgument("--address", false);
		command.addArgument("127.0.0.1");
		command.addArgument("--port", false);
		command.addArgument("4731");
		command.addArgument("--bootstrap-port", false); 
		command.addArgument("5731");a
		command.addArgument("--chromedriver-port", false);
		command.addArgument("6731");
		command.addArgument("--session-override", true);
		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);
		executor.execute(command, resultHandler);
//		System.setProperty("http.keepAlive", "false");
*/		
		Runtime.getRuntime().exec("appium");
		System.out.println("Start Appium");
	}
	
	public static void clearTemp() throws ExecuteException, IOException{
		CommandLine command = new CommandLine("DEL /F /S /Q %TEMP%");
		DefaultExecuteResultHandler taskkill = new DefaultExecuteResultHandler();
		DefaultExecutor killer = new DefaultExecutor();
		killer.setExitValue(1);
		killer.execute(command, taskkill);
	}
}
