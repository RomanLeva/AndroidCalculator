package me.example.mycalc;

public class Computing {

	public Computing() {
		this.first_digit = 0;
		this.second_digit = 0;
		this.result = 0;
		this.startFirstdigit = true;
		this.startForMultDiv = true;
		this.action = Action.None;
	}

	private double first_digit, second_digit, result;
	private boolean startFirstdigit;
	private boolean startForMultDiv;

	enum Action {
		Plus, Min, Mult, Div, Eql, Back, Dot, CE, None
	};

	Action action;

	public void compute(Action action) {
		switch (action) {
		case Plus:
			result = first_digit + second_digit;
			first_digit = result;
			startForMultDiv = false;
			break;
		case Min:
			result = first_digit - second_digit;
			first_digit = result;
			startForMultDiv = false;
			break;
		case Mult:
			// проверяет если действие было первый раз, а во второй переменной
			// еще ничего нет (ноль)
			// то исключает умножение на ноль
			if (startForMultDiv == true) {
				result = first_digit;
			} else
				result = first_digit * second_digit;
			first_digit = result;
			startForMultDiv = false;
			break;
		case Div:
			// проверяет если действие было первый раз, а во второй переменной
			// еще ничего нет (ноль)
			// то исключает деление на ноль
			if (startForMultDiv == true) {
				result = first_digit;
			} else
				result = first_digit / second_digit;
			first_digit = result;
			startForMultDiv = false;
			break;
		case None:
			break;
		default:
			break;
		}
	}

	public void setText() {
		// выводит результат по возможности округляя нули после запятой
		if (result % 1 == 0) {
			long l = (long) result;
			MainActivity.textField.setText(String.valueOf(l));
		} else
			MainActivity.textField.setText(String.valueOf(result));
	}

	public void testDigits() {
		// записывает сначала в первую, потом только во вторую переменную, что
		// бы каждый раз к результату
		// который все время после вычисления будет "уходить" в первую
		// переменную
		// можно было применить следующее действие и цифру взятые из второй
		if (startFirstdigit) {
			first_digit = Double.parseDouble(MainActivity.textField.getText()
					.toString());
			startFirstdigit = false;
		} else
			second_digit = Double.parseDouble(MainActivity.textField.getText()
					.toString());
	}

	public double getFirst_digit() {
		return first_digit;
	}

	public void setFirst_digit(double first_digit) {
		this.first_digit = first_digit;
	}

	public double getSecond_digit() {
		return second_digit;
	}

	public void setSecond_digit(double second_digit) {
		this.second_digit = second_digit;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

	public boolean isStartFirstdigit() {
		return startFirstdigit;
	}

	public void setStartFirstdigit(boolean startFirstdigit) {
		this.startFirstdigit = startFirstdigit;
	}

	public boolean isStartForMultDiv() {
		return startForMultDiv;
	}

	public void setStartForMultDiv(boolean startForMultDiv) {
		this.startForMultDiv = startForMultDiv;
	}
}
