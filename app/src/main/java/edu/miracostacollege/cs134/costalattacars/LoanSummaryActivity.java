package edu.miracostacollege.cs134.costalattacars;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoanSummaryActivity extends AppCompatActivity {

    // public double calculateBorrowedAmount() { return calculateBorrowedAmount; }

   // public double calculateInterestAmount { return }

   // public double

    private TextView monthlyPaymentTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_summary);

        monthlyPaymentTextView = findViewById(R.id.monthlyPaymentTextView);


        // 1) Receive the intent (from MainActivity)

        Intent intent = getIntent();

        //2) Populate all the text views  the information below is for 1st text box
        monthlyPaymentTextView.setText(intent.getStringExtra("MonthlyPayment"));
         //make sure you add to all these for what is needed
        //finish and close the return data entry button (making method below)
    }
    //have to set up onClick button back to activity of new layout loan summary
    public void closeActivity(View v){
        this. finish();
    }
}
