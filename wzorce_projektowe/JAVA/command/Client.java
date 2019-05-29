package studia.wzorce_projektowe.command;

public class Client {

	public static void main(String[] args) {
		
		//tworzenie poleceń
		Receiver rev = new Receiver();
		Command openGate = new OpenGateCommand(rev);
		Command closeGate = new CloseGateCommand(rev);
		
		//wywołanie invokera i dodanie poleceń
		Invoker button = new Invoker();
		button.addingButton(openGate);
		button.addingButton(closeGate);
		
		//otworzenie bramy
		button.pressButton(openGate);

		//zamknięcie bramy
		button.pressButton(closeGate);
	}
}
