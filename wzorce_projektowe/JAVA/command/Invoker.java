package studia.wzorce_projektowe.command;

import java.util.ArrayList;
import java.util.List;

public class Invoker {

	private List<Command> commands = new ArrayList<Command>();
	
	public void pressButton(Command command) {
		command.execute();
	}
		
	public void addingButton(Command command) {
		commands.add(command);
	}
	

}
