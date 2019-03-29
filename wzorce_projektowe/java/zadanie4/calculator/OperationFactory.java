package zadanie4.calculator;

public class OperationFactory {

	public Operation getOperation(Action action) {
		switch(action) {
			case Sum:
				return ((a,b) -> a+b);
			case Odds:
				return ((a,b) -> a-b);
			case Product:
				return ((a,b) -> a*b);
			case Quotient:
				return ((a,b) -> a/b);
		}
		return null;
	}
}

