package studia.wzorce_projektowe.command;

public class CloseGateCommand implements Command {

	private Receiver rev;

	public CloseGateCommand(Receiver rev) {
		this.rev = rev;
	}

	public void execute() {
		rev.closeGate();
	}

}
