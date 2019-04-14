package sg.edu.np.twq2.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    String input = "";
    int operatorIndex = -1;
    String operator = "";
    Button[] ops = new Button[4];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ops[0] = findViewById(R.id.button4);
        ops[1] = findViewById(R.id.button8);
        ops[2] = findViewById(R.id.button12);
        ops[3] = findViewById(R.id.button16);
    }

    public void onClick(View v)
    {
        Button butt = (Button)v;
        String pressed = butt.getText().toString();
        input += butt.getText();
        TextView tv = findViewById(R.id.text);
        tv.setText(input);

        switch(butt.getText().toString())
        {
            case "+":
            case "-":
            case "×":
            case "÷":
                operatorIndex = input.length()-1;
                operator = butt.getText().toString();
                disableOperators();
                break;
            case "=":
                calculateOperation();
                enableOperators();
                input = "";
                operatorIndex = 0;
                operator="";
                break;
            default:
                break;
        }
    }

    private void calculateOperation()
    {
        int i = Integer.parseInt(input.substring(0, operatorIndex));
        int j = Integer.parseInt(input.substring(operatorIndex+1, input.length()-1));
        double results = 0;

        switch(operator)
        {
            case "+":
                results = i + j;
                break;
            case "-":
                results = i-j;
                break;
            case "×":
                results = i*j;
                break;
            case "÷":
                results = (double)i/j;
                break;
        }

        input += results;
        TextView tv = findViewById(R.id.text);
        tv.setText(input);
    }

    private void disableOperators()
    {
        for(Button b:ops)
        {
            b.setEnabled(false);
        }
    }

    private void enableOperators()
    {
        for(Button b:ops)
        {
            b.setEnabled(true);
        }
    }


}
