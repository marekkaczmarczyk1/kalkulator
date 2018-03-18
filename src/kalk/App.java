package kalk;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

	public static String calculate(String input) {
		Double result = null;
		Integer result2 = null;
		try {
			result = (Double) getScriptEngine().eval(input);
		} catch (Exception e) {

		}

		try {
			result2 = (Integer) getScriptEngine().eval(input);
		} catch (Exception e) {

		}
		
		if(result2 != null) {
			return result2.toString();
		}
		
		if(result != null) {
			return result.toString();
		}
		
		return "b??dne r?wnaie";
		
	}

	private static ScriptEngine getScriptEngine() {
		ScriptEngineManager manager = new ScriptEngineManager();
		return manager.getEngineByName("JavaScript");
	}

	public static void main(String[] args) {
		BufferedReader br = null;

		try {

			br = new BufferedReader(new InputStreamReader(System.in));

			while (true) {

				System.out.print("Enter something : ");
				String input = br.readLine();
				System.out.println(input);
				// Object result;

				// Integer i = result.intValue();

				// int test = Integer.parseInt(input);

				if ("q".equals(input)) {
					System.out.println("Exit!");
					System.exit(0);
				}

				System.out.println("input : " + calculate(input));
				System.out.println("-----------\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}