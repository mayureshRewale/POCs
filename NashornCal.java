package com.week2;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class NashornCal {

	public static void main(String[] args) throws FileNotFoundException, ScriptException, NoSuchMethodException {
		
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		engine.eval(new FileReader("resources/calci.js"));
		
		//calling functions
		Invocable invocable = (Invocable) engine;
		invocable.invokeFunction("add",100,10);
		invocable.invokeFunction("sub",100,10);
		invocable.invokeFunction("divi",100,10);
		invocable.invokeFunction("mul",100,10);

	}

}
