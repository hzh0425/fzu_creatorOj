package com.moxi.judgerGateway.pythonUtil;

import org.python.core.PyFunction;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/25 19:37
 */
public class test {
    public static void main(String[] args) {
        PythonInterpreter interpreter=new PythonInterpreter();
        interpreter.execfile("D:/.temp/test.py");
        PyFunction pyFunction=interpreter.get("add",PyFunction.class);
        int a=5,b=10;
        PyObject pyObject=pyFunction.__call__(new PyInteger(a), new PyInteger(b));
        System.out.println("get object is:"+pyObject);
    }
}
