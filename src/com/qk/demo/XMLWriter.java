package com.qk.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import javax.management.loading.PrivateClassLoader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class XMLWriter {
	
	private static PrintWriter runFlagPath;
	private static PrintWriter wfFlagPath;
	private static PrintWriter errFlagPath;
	private static PrintWriter freqFlagPath;

	private static String runPath;
	private static String wfPath;
	private static String errPath;
	private static String freqPath;

	private static boolean alreadyExists;
	private static Element runone;
	private static Document startdoc;
	//	private static Element run;
	private static Element pages;

	private static BufferedReader runfile;
	private static BufferedReader wf;
	private static BufferedReader ef;
	private static String logtime;

	private static String runstatus;
	private static String wfstatus;
	private static String efstatus;

	public static void runFrequency(String ApplicationName,int value) throws Exception
	{
		
		SimpleDateFormat sd = new SimpleDateFormat("yyyy");
		SimpleDateFormat sd1 = new SimpleDateFormat("MMM");
		SimpleDateFormat sd2 = new SimpleDateFormat("dd");

		Calendar c = Calendar.getInstance();

		String username = System.getProperty("user.name");

		//Frequency Text file Creation code
		/*freqPath = "D:\\"+username+"\\" + sd.format(c.getTime()) + "\\"
				+ sd1.format(c.getTime()) + "\\" + sd2.format(c.getTime())
				+ "\\" + ApplicationName;*/
		
		freqPath = "C:\\Script_Essentials\\"+username+"\\"+ ApplicationName; // Changes in here for new framework
//		freqPath = "D:\\"+username+"\\"+ ApplicationName;

		File theDir = new File(freqPath);
		if (!theDir.exists()) 
		{
			System.out.println("creating directory: " + freqPath);
			boolean result = false;
			try {
				theDir.mkdirs();
				result = true;
				Thread.sleep(1000);
			} catch (SecurityException localSecurityException) {
			}
			if (result) {
				System.out.println("Directory Created..!!");
			}
		}

		/*		if(!theDir.exists())
		{
			freqFlagPath = new PrintWriter(freqPath+"\\"+ApplicationName+"Freq.txt", "UTF-8");
			freqFlagPath.print(0);
			freqFlagPath.close();
		}
		else
		{*/
		freqFlagPath = new PrintWriter(freqPath+"\\"+ApplicationName+".txt", "UTF-8");
		freqFlagPath.print(value);
		freqFlagPath.close();
		//		}
	}

	public static void errorFlagFile(String ApplicationName,String value) throws FileNotFoundException, UnsupportedEncodingException, InterruptedException
	{
		SimpleDateFormat sd = new SimpleDateFormat("yyyy");
		SimpleDateFormat sd1 = new SimpleDateFormat("MMM");
		SimpleDateFormat sd2 = new SimpleDateFormat("dd");
		Calendar c = Calendar.getInstance();

		String username = System.getProperty("user.name");

		//Error Text file Creation code
		/*errPath = "C:\\Logs\\XL_Jakarta\\" + sd.format(c.getTime()) + "\\"
				+ sd1.format(c.getTime()) + "\\" + sd2.format(c.getTime())
				+ "\\" + ApplicationName;*/

		/*errPath = "D:\\"+username+"\\" + sd.format(c.getTime()) + "\\"
				+ sd1.format(c.getTime()) + "\\" + sd2.format(c.getTime())
				+ "\\" + ApplicationName;*/

		errPath = "D:\\"+username+"\\"+ApplicationName;

		File theDir = new File(errPath);
		if (!theDir.exists()) {
			System.out.println("creating directory: " + errPath);
			boolean result = false;
			try {
				theDir.mkdirs();
				result = true;
				Thread.sleep(1000);
			} catch (SecurityException localSecurityException) {
			}
			if (result) {
				System.out.println("DIR's created");
			}
		}

		errFlagPath = new PrintWriter(errPath+"\\"+ApplicationName+"ErrorFlag.txt", "UTF-8");
		errFlagPath.print(value);
		errFlagPath.close();

	}

	public static void wfFlagFile(String ApplicationName,String value) throws FileNotFoundException, UnsupportedEncodingException, InterruptedException
	{
		SimpleDateFormat sd = new SimpleDateFormat("yyyy");
		SimpleDateFormat sd1 = new SimpleDateFormat("MMM");
		SimpleDateFormat sd2 = new SimpleDateFormat("dd");
		Calendar c = Calendar.getInstance();

		String username = System.getProperty("user.name");

		//WF Text file Creation code
		/*wfPath = "C:\\Logs\\XL_Jakarta\\" + sd.format(c.getTime()) + "\\"
				+ sd1.format(c.getTime()) + "\\" + sd2.format(c.getTime())
				+ "\\" + ApplicationName;*/

		/*		wfPath = "D:\\"+username+"\\" + sd.format(c.getTime()) + "\\"
				+ sd1.format(c.getTime()) + "\\" + sd2.format(c.getTime())
				+ "\\" + ApplicationName;*/

		wfPath = "D:\\"+username+"\\"+ ApplicationName;


		File theDir = new File(wfPath);
		if (!theDir.exists()) {
			System.out.println("creating directory: " + wfPath);
			boolean result = false;
			try {
				theDir.mkdirs();
				result = true;
				Thread.sleep(1000);
			} catch (SecurityException localSecurityException) {
			}
			if (result) {
				System.out.println("DIR's created");
			}
		}

		wfFlagPath = new PrintWriter(wfPath+"\\"+ApplicationName+"WfFlag.txt", "UTF-8");
		wfFlagPath.print(value);
		wfFlagPath.close();

	}

	public static void runFile(String ApplicationName,String value) throws FileNotFoundException, UnsupportedEncodingException, InterruptedException
	{
		SimpleDateFormat sd = new SimpleDateFormat("yyyy");
		SimpleDateFormat sd1 = new SimpleDateFormat("MMM");
		SimpleDateFormat sd2 = new SimpleDateFormat("dd");
		Calendar c = Calendar.getInstance();

		String username = System.getProperty("user.name");

		//WF Text file Creation code
		/*		 runPath = "C:\\Logs\\XL_Jakarta\\" + sd.format(c.getTime()) + "\\"
				+ sd1.format(c.getTime()) + "\\" + sd2.format(c.getTime())
				+ "\\" + ApplicationName;*/

		/* runPath = "D:\\"+username+"\\" + sd.format(c.getTime()) + "\\"
					+ sd1.format(c.getTime()) + "\\" + sd2.format(c.getTime())
					+ "\\" + ApplicationName;*/

		runPath = "D:\\"+username+"\\"+ ApplicationName;

		File theDir = new File(runPath);
		if (!theDir.exists()) {
			System.out.println("creating directory: " + runPath);
			boolean result = false;
			try {
				theDir.mkdirs();
				result = true;
				Thread.sleep(1000);
			} catch (SecurityException localSecurityException) {
			}
			if (result) {
				System.out.println("DIR's created");
			}
		}

		runFlagPath = new PrintWriter(runPath+"\\"+ApplicationName+"RunFlag.txt", "UTF-8");
		runFlagPath.print(value);
		runFlagPath.close();
	}

	public static void xmlWriter(String StartTime,String Clientname, String ApplicationName,int mFrequency,String pagename,double downloadtime,String errorTime,String ErrorCode, String ErrorMessage) throws ParserConfigurationException, TransformerException, SAXException, IOException, InterruptedException 
	{	

		SimpleDateFormat sd = new SimpleDateFormat("yyyy");
		SimpleDateFormat sd1 = new SimpleDateFormat("MMM");
		SimpleDateFormat mm = new SimpleDateFormat("MM");
		SimpleDateFormat sd2 = new SimpleDateFormat("dd");
		Calendar c = Calendar.getInstance();

		if(mFrequency == 10)
		{
			SimpleDateFormat ch = new SimpleDateFormat("mm");
			SimpleDateFormat hh = new SimpleDateFormat("HH");
			String hour =hh.format(c.getTime());
			String minute = ch.format(c.getTime());

			int slot = Integer.parseInt(minute) / mFrequency;

			if(slot == 0)
			{
				logtime = hour+":"+00;
			}
			else if(slot == 1)
			{
				logtime = hour+":"+10;
			}
			else if(slot == 2)
			{
				logtime = hour+":"+20;
			}
			else if(slot == 3)
			{
				logtime = hour+":"+30;
			}
			else if(slot == 4)
			{
				logtime = hour+":"+40;
			}
			else if(slot == 5)
			{
				logtime = hour+":"+50;
			}
		}


		if(mFrequency == 15)
		{
			SimpleDateFormat ch = new SimpleDateFormat("mm");
			SimpleDateFormat hh = new SimpleDateFormat("HH");
			String hour =hh.format(c.getTime());
			String minute = ch.format(c.getTime());

			int slot = Integer.parseInt(minute) / mFrequency;

			if(slot == 0)
			{
				logtime = hour+":"+00;
			}
			else if(slot == 1)
			{
				logtime = hour+":"+15;
			}
			else if(slot == 2)
			{
				logtime = hour+":"+30;
			}
			else if(slot == 3)
			{
				logtime = hour+":"+45;
			}
		}

		if(mFrequency == 30)
		{
			SimpleDateFormat ch = new SimpleDateFormat("mm");
			SimpleDateFormat hh = new SimpleDateFormat("HH");
			String hour =hh.format(c.getTime());
			String minute = ch.format(c.getTime());

			int slot = Integer.parseInt(minute) / mFrequency;

			if(slot == 0)
			{
				logtime = hour+":"+00;
			}
			else if(slot == 1)
			{
				logtime = hour+":"+30;
			}
		}

		if(mFrequency == 60 || mFrequency == 120)
		{
			SimpleDateFormat ch = new SimpleDateFormat("mm");
			SimpleDateFormat hh = new SimpleDateFormat("HH");
			String hour =hh.format(c.getTime());
			String minute = ch.format(c.getTime());

			int slot = Integer.parseInt(minute) / mFrequency;

			if(slot == 0)
			{
				logtime = hour+":"+00;
			}
		}


		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String snapshot_time = sdf.format(c.getTime());

		//XML Folder Creation code
		/*String path = "C:\\Logs\\XL_Jakarta\\" + sd.format(c.getTime()) + "\\"
				+ sd1.format(c.getTime()) + "\\" + sd2.format(c.getTime())
				+ "\\" + ApplicationName;
*/
		String path = "C:\\Logs\\" + sd.format(c.getTime()) + "\\"
				+ sd1.format(c.getTime()) + "\\" + sd2.format(c.getTime())
				+ "\\" + ApplicationName;

		File theDir = new File(path);
		if (!theDir.exists()) {
			System.out.println("creating directory: " + path);
			boolean result = false;
			try {
				theDir.mkdirs();
				result = true;
				Thread.sleep(1000);
			} catch (SecurityException localSecurityException) {
			}
			if (result) {
				System.out.println("DIR's created");
			}
		}

		String outputFile = path + "\\"+ApplicationName+".xml";
		alreadyExists = new File(outputFile).exists();

		runfile = new BufferedReader(new FileReader(runPath+"\\"+ApplicationName+"RunFlag.txt"));
		runstatus = runfile.readLine();

		wf = new BufferedReader(new FileReader(wfPath+"\\"+ApplicationName+"WfFlag.txt"));
		wfstatus = wf.readLine();

		ef = new BufferedReader(new FileReader(errPath+"\\"+ApplicationName+"ErrorFlag.txt"));
		efstatus = ef.readLine();

		if(!alreadyExists)
		{	
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			//Parent XML tags
			Document doc = docBuilder.newDocument();

			//------------------Parent Flag-----------------------------//
			Element logs = doc.createElement("LOGS");
			doc.appendChild(logs);

			Element client = doc.createElement("CLIENT_NAME");
			client.appendChild(doc.createTextNode(Clientname));
			logs.appendChild(client);

			Element script = doc.createElement("SCRIPT_NAME");
			script.appendChild(doc.createTextNode(ApplicationName));
			logs.appendChild(script);

			String frequency = String.valueOf(mFrequency);

			Element freq = doc.createElement("MONITORING_FREQUENCY");
			freq.appendChild(doc.createTextNode(frequency));
			logs.appendChild(freq);

			Element date = doc.createElement("DATE");
			date.appendChild(doc.createTextNode(sd2.format(c.getTime())+"/"+mm.format(c.getTime())+"/"+sd.format(c.getTime())));
			logs.appendChild(date);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult xmlresult = new StreamResult(new File("C:\\Logs\\" + sd.format(c.getTime()) + "\\"
					+ sd1.format(c.getTime()) + "\\" + sd2.format(c.getTime())
					+ "\\" + ApplicationName +"\\"+ ApplicationName +".xml"));
			transformer.transform(source, xmlresult);
		}

		if(runstatus.equalsIgnoreCase("true"))
		{
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			startdoc = docBuilder.parse(new File("C:\\Logs\\" + sd.format(c.getTime()) + "\\"
					+ sd1.format(c.getTime()) + "\\" + sd2.format(c.getTime())
					+ "\\" + ApplicationName +"\\"+ ApplicationName +".xml"));

			Element root = startdoc.getDocumentElement();				

			runone = startdoc.createElement("RUN");
			root.appendChild(runone);

			Element logtime = startdoc.createElement("LOG_TIME");
			logtime.appendChild(startdoc.createTextNode(XMLWriter.logtime));
			runone.appendChild(logtime);

			Element runstarttime = startdoc.createElement("START_TIME");
			runstarttime.appendChild(startdoc.createTextNode(StartTime));
			runone.appendChild(runstarttime);

			Element ISP = startdoc.createElement("ISP");
			ISP.appendChild(startdoc.createTextNode("0"));
			runone.appendChild(ISP);

			Element throughput = startdoc.createElement("THROUGHPUT");
			throughput.appendChild(startdoc.createTextNode("0"));
			runone.appendChild(throughput);

			pages = startdoc.createElement("PAGES");
			runone.appendChild(pages);

			runFlagPath = new PrintWriter(runPath+"\\"+ApplicationName+"RunFlag.txt", "UTF-8");
			runFlagPath.println("false");
			runFlagPath.close();
		}

		if(wfstatus.equalsIgnoreCase("true"))
		{
			Element page = startdoc.createElement("PAGE");
			pages.appendChild(page);

			Element pname = startdoc.createElement("PAGE_NAME");
			pname.appendChild(startdoc.createTextNode(pagename));
			page.appendChild(pname);

			String dtime = String.valueOf(downloadtime);

			Element downtime = startdoc.createElement("DOWNLOAD_TIME");
			downtime.appendChild(startdoc.createTextNode(dtime));
			page.appendChild(downtime);

			Element error = startdoc.createElement("ERROR");
			page.appendChild(error);

			wfFlagPath = new PrintWriter(wfPath+"\\"+ApplicationName+"WfFlag.txt", "UTF-8");
			wfFlagPath.println("false");
			wfFlagPath.close();
		}

		else if(efstatus.equalsIgnoreCase("true"))
		{

			Element page = startdoc.createElement("PAGE");
			pages.appendChild(page);

			Element pname = startdoc.createElement("PAGE_NAME");
			pname.appendChild(startdoc.createTextNode(pagename));
			page.appendChild(pname);

			String dtime = String.valueOf("PF"+downloadtime);

			Element downtime = startdoc.createElement("DOWNLOAD_TIME");
			downtime.appendChild(startdoc.createTextNode(dtime));
			page.appendChild(downtime);

			Element error = startdoc.createElement("ERROR");
			page.appendChild(error);

			Element actualerrortime = startdoc.createElement("ACTUAL_ERROR_TIME");
			actualerrortime.appendChild(startdoc.createTextNode(errorTime));
			error.appendChild(actualerrortime);

			Element snapshottime = startdoc.createElement("SCREEN_SHOT_TIME");
			snapshottime.appendChild(startdoc.createTextNode(snapshot_time));
			error.appendChild(snapshottime);

			Element errorcode = startdoc.createElement("ERROR_DESCRIPTION");
			errorcode.appendChild(startdoc.createTextNode(ErrorCode));
			error.appendChild(errorcode);

			Element errordesc = startdoc.createElement("ERROR_MESSAGE");
			errordesc.appendChild(startdoc.createTextNode(ErrorMessage));
			error.appendChild(errordesc);

			Element screenshotfile = startdoc.createElement("SCREEN_SHOT_FILE");
			screenshotfile.appendChild(startdoc.createTextNode(path+"\\"+pagename+"_"+errorTime+".jpg"));
			error.appendChild(screenshotfile);

			errFlagPath = new PrintWriter(errPath+"\\"+ApplicationName+"ErrorFlag.txt", "UTF-8");
			errFlagPath.println("false");
			errFlagPath.close();
		}

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(startdoc);
		StreamResult xmlresult = new StreamResult(new File("C:\\Logs\\" + sd.format(c.getTime()) + "\\"
				+ sd1.format(c.getTime()) + "\\" + sd2.format(c.getTime())
				+ "\\" + ApplicationName +"\\"+ ApplicationName +".xml"));
		transformer.transform(source, xmlresult);

	}

}
