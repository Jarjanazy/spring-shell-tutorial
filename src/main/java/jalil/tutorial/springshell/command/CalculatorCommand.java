package jalil.tutorial.springshell.command;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class CalculatorCommand {

    @ShellMethod(value = "add two integers")
    public int add(int a, int b)
    {
        return a + b;
    }


}
