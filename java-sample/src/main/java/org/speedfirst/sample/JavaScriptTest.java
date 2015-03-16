package org.speedfirst.sample;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created by jiankuan on 8/22/14.
 */
public class JavaScriptTest {
    public static void main(String[] args) throws ScriptException {
        // create a script engine manager
        ScriptEngineManager factory = new ScriptEngineManager();
        // create a JavaScript engine
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        // evaluate JavaScript code from String
        engine.put("varkey", "var value");
        engine.eval("print('Hello World ' + varkey)");
    }
}
