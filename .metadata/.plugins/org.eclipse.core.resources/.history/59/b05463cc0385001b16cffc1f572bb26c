package hu.bme.mit.yakindu.analysis.workhere;

import java.util.ArrayList;

import org.yakindu.sct.model.sgraph.Statechart;

public class Task4_5 {
	private ArrayList<String> lines = new ArrayList<String>();
	
	public Task4_5 add() {
		lines.add("public class RunStatechart {");
		mainFunc();
		lines.add("");	
		
		printFunc();		
		lines.add("");
		
		lines.add("");
		lines.add("}"); //closing } for class
		return this;
	}
	
	private void mainFunc() {		
		lines.add("    public static void main(String[] args) throws IOException {");
		lines.add("        ExampleStatemachine s = new ExampleStatemachine();");
		lines.add("        s.setTimer(new TimerService());");
		lines.add("        RuntimeService.getInstance().registerStatemachine(s, 200);");
		lines.add("        s.init();");
		lines.add("        s.enter();");
		lines.add("        s.runCycle();");
		lines.add("        while(true) {\n" + 
				"			BufferedReader reader =\n" + 
				"	                   new BufferedReader(new InputStreamReader(System.in));\n" + 
				"	        String name = reader.readLine();\n" + 
				"			print(s);\n" + 
				"			if(name.equals(\"start\")) {\n" + 
				"				s.raiseStart();\n" + 
				"				s.runCycle();\n" + 
				"			}\n" + 
				"			if(name.equals(\"black\")) {\n" + 
				"				s.raiseBlack();\n" + 
				"				s.runCycle();\n" + 
				"			}\n" + 
				"			if(name.equals(\"white\")) {\n" + 
				"				s.raiseWhite();\n" + 
				"				s.runCycle();\n" + 
				"			}\n" + 
				"			if(name.equals(\"exit\")) {\n" + 
				"				System.exit(0);\n" + 
				"			}\n" + 
				"		}");
		lines.add("    }");
	}
	
	private void printFunc() {
		lines.add("    public static void print(IExampleStatemachine s) {");

		lines.add("			System.out.println(\"W = \" + s.getSCInterface().getWhiteTime());");
		lines.add("			System.out.println(\"B = \" + s.getSCInterface().getBlackTime());");
		
		lines.add("    }");
	}
	
	public void print() {
		for (String l: lines)
			System.out.println(l);
	}
}
