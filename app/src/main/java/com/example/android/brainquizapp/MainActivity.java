package com.example.android.brainquizapp;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private RadioGroup mQuestion1, mQuestion2, mQuestion3, mQuestion4, mQuestion5;
    private EditText customerNameEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupView();
    }

    private void setupView() {
        final Button submitButton = (Button) findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitButtonPressed();
            }
        });

        mQuestion1 = (RadioGroup) findViewById(R.id.answer_to_question_1);
        mQuestion2 = (RadioGroup) findViewById(R.id.answer_to_question_2);
        mQuestion3 = (RadioGroup) findViewById(R.id.answer_to_question_3);
        mQuestion4 = (RadioGroup) findViewById(R.id.answer_to_question_4);
        mQuestion5 = (RadioGroup) findViewById(R.id.answer_to_question_5);




        customerNameEditText = (EditText) findViewById(R.id.answer_11);
    }

    private void submitButtonPressed() {
        int mResult = 0;
        if (mQuestion1.getCheckedRadioButtonId() == R.id.answer_1b) {
            mResult += 20;
        } else if (mQuestion1.getCheckedRadioButtonId() == -1) {
            showError();
            return;
        }

        if (mQuestion2.getCheckedRadioButtonId() == R.id.answer_2b) {
            mResult += 20;
        } else if (mQuestion2.getCheckedRadioButtonId() == -1) {
            showError();
            return;
        }

        if (mQuestion3.getCheckedRadioButtonId() == R.id.answer_3a) {
            mResult += 20;
        } else if (mQuestion3.getCheckedRadioButtonId() == -1) {
            showError();
            return;
        }

        if (mQuestion4.getCheckedRadioButtonId() == R.id.answer_4b) {
            mResult += 20;
        } else if (mQuestion4.getCheckedRadioButtonId() == -1) {
            showError();
            return;
        }

        if (mQuestion5.getCheckedRadioButtonId() == R.id.answer_5a) {
            mResult += 20;
        } else if (mQuestion5.getCheckedRadioButtonId() == -1) {
            showError();
            return;
        }


        if (customerNameEditText.getText().toString().isEmpty()) {
            showError();
            return;
        }


        displayMessage(mResult);
    }

    void displayMessage(int score) {
        String userName = customerNameEditText.getText().toString();
        String message = "Dear " + userName + ",\nYour score is: " + String.valueOf(score) + " OVER 100";
        message += "\n" + quizResultMessage(score);

        new AlertDialog.Builder(this).setMessage(message).show();
    }

    String quizResultMessage(int score) {
        if (score <= 40) {
            return getString(R.string.result_0_40);
        } else if (score > 40 && score <= 60) {
            return getString(R.string.result_50_60);
        } else if (score > 60 && score <= 90) {
            return getString(R.string.result_70_90);
        } else {
            return getString(R.string.result_90_100);
        }
    }

    void showError() {
        // Show an error message as a toast
        Toast.makeText(this, "Please select answers to all questions.", Toast.LENGTH_SHORT).show();
    }
}
