package com.example.kalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.itis.libs.parserng.android.expressParser.MathExpression;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.calkulator);
        findViewById(R.id.clear_btn).setOnClickListener(v -> textView.setText(""));
    }

    public void onNumberClick(View view) {
        textView.append(((TextView) view).getText());
    }

    public void onDeleteClick(View view) {
        String math = textView.getText().toString();

        if (!math.isEmpty()) {
            textView.setText(math.substring(0, math.length() - 1));
        }
    }

    public void onActionClick(View view) {
        switch (view.getId()) {
            case R.id.equally:
                try {
                    String math = textView.getText().toString();
                    textView.setText(math + " = " + new MathExpression(math).solve());
                } catch (Exception e) {
                    textView.setText("");
                }
                return;
        }

        textView.append(((TextView) view).getText());
    }
}