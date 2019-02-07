package edu.miracostacollege.cs134.costalattacars;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.text.NumberFormat;

import edu.miracostacollege.cs134.costalattacars.R;
import edu.miracostacollege.cs134.costalattacars.model.CarLoan;

public class MainActivity extends AppCompatActivity {

    // Let's create references to 2 edit texts and 1 radio group
    private EditText carPriceEditText;
    private EditText downPaymentEditText;
    private RadioGroup loanTermRadioGroup;

    // Let;s make a reference to our model
    private CarLoan loan;

    // Let's make formatters for currency and percentage
    NumberFormat currency = NumberFormat.getCurrencyInstance()


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Link the controller variables to the view
        carPriceEditText = findViewById(R.id.carPriceEditText);
        downPaymentEditText = findViewById(R.id.downPaymentEditText);
        loanTermRadioGroup = findViewById(R.id.loanTermRadioGroup);

        //Instantiate a new CarLoan like new Bill
        loan = new CarLoan();

    }
    public void switchToLoanSummary(View v)
    {
        // 1) Extract data from 2 edit texts and radio group char sequence like a string
        double carPrice = Double.parseDouble(carPriceEditText.getText().toString();
        double downPayment = Double.parseDouble(downPaymentEditText.getText().toString());

        int loanTerm;
        // Use a switch statement to determine radio button checked in radio group
        switch(loanTermRadioGroup.getCheckedRadioButtonId())
        {
            case R.id.threeYearsRadioButton:
                loanTerm = 3;
                break;
            case R.id.fourYearsRadioButton:
                loanTerm = 4;
                break;
            case R.id.fiveYearsRadioButton:
                loanTerm = 5;
                break;
                // }
                //going to need a default
                // default R.id.twoYearsRadioButton:


        }
        // 2) Update the model CarLoan (object:loan)
               // data to another data is content(intent)  //this(already here for PC tap)
        loan.setPrice(carPrice);
        loan.setDownPayment(downPayment);
        loan.setLoanTerm(loanTerm);

        // 3) Create a new Intent to share data between activities
        //                                   start activity, destination activity (alt ent)
        Intent loanSummaryIntent = new Intent(this, LoanSummaryActivity.class);
        // Share all the data...
        // helps to keep in order, but does not have to be
        // data is going to be called monthly payment as Key and loan.monthlyPayment is Value
        loanSummaryIntent.putExtra("Monthly Payment", currency.format(loan.monthlyPayment()));
        loanSummaryIntent.putExtra("Car Price", currency.format(loan.getPrice()));
        //one for each that we need for the textView price boxes
        //adding in currency

        // 4) Start the new activity
        startActivity(loanSummaryIntent);



    }
}
