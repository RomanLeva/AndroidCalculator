package me.example.mycalc;

import me.example.mycalc.Computing.Action;
import android.view.View;

public class Buttons {
	private boolean eqlPressed = false;
	private boolean actionPressed = false;
	private int number = 0;
	Computing object = new Computing();

	public void buttonPressed(View view) {
		// вызываеться при нажатии кнопки цифры
		// если в начале был ноль или "ошибка" или было нажато действие, то
		// очищаем текстовое поле
		// проверяем если было нажато действие, значит теперь пользователь будет
		// вводить следующую цифру
		// соответственно надо очистить один раз текстовое поле
		if (MainActivity.textField.getText().toString().equals("0")
				| MainActivity.textField.getText().toString().equals("error")
				| actionPressed == true) {
			MainActivity.textField.setText("");
		}
		// если пользовались действием "равно", то вводя новую цифру
		// подразумеваеться удаление предыдущих
		// результатов
		if (eqlPressed == true) {
			object.setResult(0);
			object.setFirst_digit(0);
			object.setSecond_digit(0);
			object.setStartFirstdigit(true);
			object.setStartForMultDiv(true);
			actionPressed = false;
			eqlPressed = false;
			object.action = Action.None;
			MainActivity.textField.setText("");
		}
		// извлекаем цифру по заданному тэгу для каждой кнопки
		number = (Integer) view.getTag();
		// записываем цифру в текстовое поле подряд
		MainActivity.textField.setText(MainActivity.textField.getText()
				+ String.valueOf(number));
		// отмечаем что действие не было нажато для того что бы код вверху не
		// удалял вводимые далее цифры
		actionPressed = false;
	}

	public void actionPressed(View view) {
		// вызываеться при нажатии всех кнопок действия
		// если была "ошибка", то удаляем все предыдущие данные
		if (MainActivity.textField.getText().toString().equals("error")) {
			object.setResult(0);
			object.setFirst_digit(0);
			object.setSecond_digit(0);
			object.setStartFirstdigit(true);
			object.setStartForMultDiv(true);
			actionPressed = false;
			eqlPressed = false;
			object.action = Action.None;
			MainActivity.textField.setText("0");
		}

		try {
			actionPressed = true;
			// действие было нажато, следовательно далее если вводить цифры то
			// текстовое поле очиститься
			// автоматически
			// методы обработки кнопки и проверки ошибок отдельны от метода где
			// идут вычисления
			// например 1+1 будет 2, но результат на экран не выведеться, далее
			// если пользователь нажмет еще минус 1
			// то сначала отдельно посчитаеться и выведеться 1+1, а следущее
			// действие "будет ждать"
			switch ((Action) view.getTag()) {
			case Plus:
				object.testDigits();
				if (object.action == Action.None | eqlPressed) {
					object.action = Action.Plus;
					eqlPressed = false;
					object.setSecond_digit(0);

				}
				object.compute(object.action);
				object.action = Action.Plus;
				object.setText();
				break;
			case Min:
				object.testDigits();
				if (object.action == Action.None | eqlPressed) {
					object.action = Action.Min;
					eqlPressed = false;
					object.setSecond_digit(0);

				}
				object.compute(object.action);
				object.action = Action.Min;
				object.setText();
				break;
			case Mult:
				object.testDigits();
				if (object.action == Action.None | eqlPressed) {
					object.action = Action.Mult;
					eqlPressed = false;
					object.setSecond_digit(1);
					object.setStartForMultDiv(true);
				}
				object.compute(object.action);
				object.action = Action.Mult;
				object.setText();
				break;
			case Div:
				object.testDigits();
				if (object.action == Action.None | eqlPressed) {
					object.action = Action.Div;
					eqlPressed = false;
					object.setSecond_digit(1);
					object.setStartForMultDiv(true);
				}
				object.compute(object.action);
				object.action = Action.Div;
				object.setText();
				break;

			case Eql:
				if (!eqlPressed) {
					object.testDigits();
					object.compute(object.action);
					object.setText();
					eqlPressed = true;
				} else {
					object.compute(object.action);
					object.setText();
				}
				break;
			case Back:
				MainActivity.textField.setText(MainActivity.textField
						.getText()
						.toString()
						.substring(
								0,
								MainActivity.textField.getText().toString()
										.length() - 1));
				if (MainActivity.textField.getText().toString().equals("")) {
					throw new IndexOutOfBoundsException();
				}
				break;
			case CE:
				object.setResult(0);
				object.setFirst_digit(0);
				object.setSecond_digit(0);
				object.setStartFirstdigit(true);
				object.setStartForMultDiv(true);
				object.setStartFirstdigit(true);
				object.setStartForMultDiv(true);
				number = 0;
				object.action = Action.None;
				MainActivity.textField.setText("0");
				break;
			case Dot:
				actionPressed = false;
				if (MainActivity.textField.getText().toString().contains(".")) {
					return;
				} else {
					MainActivity.textField.setText(MainActivity.textField
							.getText() + ".");
				}
				break;
			default:
				break;
			}
			if (Double.isInfinite(object.getResult())
					| Double.isNaN(object.getResult())
					| object.getResult() > 9999999999L) {
				throw new ArithmeticException();
			}
			// проверяет не вышел ли результат вычисления за пределы текстового
			// поля, не было ли деления на ноль
		} catch (IndexOutOfBoundsException e) {
			MainActivity.textField.setText("0");
		} catch (ArithmeticException e) {
			MainActivity.textField.setText("error");
		} catch (Exception e) {
			MainActivity.textField.setText("error");
		}
	}

}
