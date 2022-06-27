package jalil.tutorial.springshell.command;

import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import javax.validation.constraints.Size;
import java.util.logging.Logger;

import static java.lang.String.format;

@ShellComponent
public class SSHCommand {
    Logger log = Logger.getLogger(SSHCommand.class.getName());

    @ShellMethod(value = "Connect to remote server.")
    public void ssh(@ShellOption(value = "--server-name", defaultValue = "localhost") String serverName)
    {
        log.info(format("Logged to machine '%s'", serverName));
    }

    @ShellMethod(value = "Add keys.")
    public void sshAdd(@ShellOption(value = "--k", arity = 2) String[] keys)
    {
        log.info(format("Adding keys '%s' '%s'", keys[0], keys[1]));
    }

    @ShellMethod(value = "Sign in.")
    public void sshLogin(@ShellOption(value = "--r") boolean rememberMe)
    {
        log.info(format("remember me option is '%s'", rememberMe));
    }

    @ShellMethod(value = "SSH agent.")
    public void sshAgent(
            @ShellOption(value = "--a")
            @Size(min = 2, max = 10) String agent)
    {
        log.info(format("adding agent '%s'", agent));
    }
}
