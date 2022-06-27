package jalil.tutorial.springshell.command;

import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import org.springframework.shell.standard.ShellOption;

import java.util.logging.Logger;

import static java.lang.String.format;

@ShellComponent
public class SSHLoggingCommand {
    Logger log = Logger.getLogger(SSHLoggingCommand.class.getName());
    private boolean signedIn;
    private String password = "";

    @ShellMethod(value = "Sign in.")
    public void signIn()
    {
        this.signedIn = true;
        log.info("Signed In!");
    }
    @ShellMethod(value = "Sign out.")
    public void signOut()
    {
        this.signedIn = false;
        log.info("Signed out.");
    }

    @ShellMethod(value = "Change password.")
    public void changePass(@ShellOption String newPass)
    {
        if (newPass.equals("")) {
            log.info("Please select a non empty password.");
            return;
        }
        this.password = newPass;
        log.info(format("Changed password to 'XXXXX (masked)'", newPass));
    }

    @ShellMethod(value = "Verify password.")
    public void verifyPass(@ShellOption String pass) {
        boolean verify = (pass.equals(this.password));
        String message = "Password is incorrect.";
        if (verify) {
           message = "Password is correct.";
        }
        log.info(message);
    }

    @ShellMethodAvailability({"verify-pass"})
    public Availability verifyPassCheck() {
        return passwordSet() ?
                Availability.available() : Availability.unavailable("the password is not set. Please change the password.");
    }

    @ShellMethodAvailability({"sign-out", "change-pass"})
    public Availability signOutCheck()
    {
        return signedIn ?
                Availability.available() : Availability.unavailable("the user is not logged in. Please sign in first.");
    }

    public boolean passwordSet() {
        return !this.password.equals("");
    }
}
