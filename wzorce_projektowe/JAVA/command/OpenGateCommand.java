package studia.wzorce_projektowe.command;

public class OpenGateCommand implements Command {

	private Receiver rev;

	public OpenGateCommand(Receiver rev) {
		this.rev = rev;
	}

	public void execute() {
		rev.openGate();
	}

}
