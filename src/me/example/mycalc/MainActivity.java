package me.example.mycalc;

import me.example.mycalc.Computing.Action;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	Button Button1, Button2, Button3, Button4, Button5, Button6, Button7,
			Button8, Button9, Button0, ButtonPlus, ButtonMin, ButtonMult,
			ButtonDiv, ButtonBck, ButtonDot, ButtonEql, ButtonCE;
	static EditText textField;
	Buttons button = new Buttons();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// создаем кнопки и присваиваем каждой свой тэг
		setContentView(R.layout.activity_main);
		Button1 = (Button) findViewById(R.id.Button1);
		Button2 = (Button) findViewById(R.id.Button2);
		Button3 = (Button) findViewById(R.id.Button3);
		Button4 = (Button) findViewById(R.id.Button4);
		Button5 = (Button) findViewById(R.id.Button5);
		Button6 = (Button) findViewById(R.id.Button6);
		Button7 = (Button) findViewById(R.id.Button7);
		Button8 = (Button) findViewById(R.id.Button8);
		Button9 = (Button) findViewById(R.id.Button9);
		Button0 = (Button) findViewById(R.id.Button0);
		ButtonPlus = (Button) findViewById(R.id.ButtonPlus);
		ButtonMin = (Button) findViewById(R.id.ButtonMin);
		ButtonMult = (Button) findViewById(R.id.ButtonMult);
		ButtonDiv = (Button) findViewById(R.id.ButtonDiv);
		ButtonEql = (Button) findViewById(R.id.ButtonEql);
		ButtonBck = (Button) findViewById(R.id.ButtonBck);
		ButtonDot = (Button) findViewById(R.id.ButtonDot);
		ButtonCE = (Button) findViewById(R.id.ButtonCE);
		textField = (EditText) findViewById(R.id.textField);
		Button1.setTag(1);
		Button2.setTag(2);
		Button3.setTag(3);
		Button4.setTag(4);
		Button5.setTag(5);
		Button6.setTag(6);
		Button7.setTag(7);
		Button8.setTag(8);
		Button9.setTag(9);
		Button0.setTag(0);
		ButtonPlus.setTag(Action.Plus);
		ButtonMin.setTag(Action.Min);
		ButtonMult.setTag(Action.Mult);
		ButtonDiv.setTag(Action.Div);
		ButtonEql.setTag(Action.Eql);
		ButtonDot.setTag(Action.Dot);
		ButtonBck.setTag(Action.Back);
		ButtonCE.setTag(Action.CE);
	}

	public void buttonPressed(View view) {
		button.buttonPressed(view);
	}

	public void actionPressed(View view) {
		button.actionPressed(view);
	}
}
