package sg.edu.np.mad.madasgcacheflash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;


import java.util.Random;

public class Signup extends AppCompatActivity {

    String title = "Main Activity 2";
    /*
    private String GLOBAL_PREF = "MyPrefs";
    private String MY_USERNAME = "MyUserName";
    private String MY_PASSWORD = "MyPassword";
    SharedPreferences sharedPreferences;
     */

    private MyDBHandler myDBHandler;
    private EditText etUsername;
    private EditText etPassword;
    private EditText etOTP;
    private Button otpButton;
    private Button createButton;
    private Button cancelButton;
    private int generatedOTP;
    private CountDownTimer myCountDown;
    private Toast otpToast; // Toast variable for OTP countdown

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        myDBHandler = new MyDBHandler(this, null);
    }

    private void generateAndDisplayOTP() {
        generatedOTP = generateOTP();
        Toast.makeText(Signup.this, "Generated OTP: " + generatedOTP, Toast.LENGTH_LONG).show();
    }

    private void createUser() {
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();
        String userOTP = etOTP.getText().toString();

        User dbData = myDBHandler.findUser(username);
        if (!username.isEmpty() && !password.isEmpty())
        {
            if (dbData != null) {
                Toast.makeText(Signup.this, "Username Already Exists!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (userOTP.isEmpty()) {
                Toast.makeText(Signup.this, "Enter a number!", Toast.LENGTH_SHORT).show();
                return;
            }

            int num = Integer.parseInt(userOTP);
            if (num != generatedOTP) {
                Toast.makeText(Signup.this, "Wrong OTP!", Toast.LENGTH_SHORT).show();
                return;
            }
            // Add the user to the database if the OTP is correct
            User dbUserData = new User(username, password);
            myDBHandler.addUser(dbUserData);

            Toast.makeText(Signup.this, "Account Created Successfully!", Toast.LENGTH_SHORT).show();

            // Move back to the previous activity (MainActivity)
            Intent intent = new Intent(Signup.this, Login.class);
            startActivity(intent);
        }

        else{
            Toast.makeText(Signup.this, "Please fill in both!", Toast.LENGTH_SHORT).show();
        }
    }

    private int generateOTP() {
        Random random = new Random();
        return random.nextInt(900000) + 100000; // Generate a random 6-digit OTP
    }

    private void startCountdown() {
        myCountDown = new CountDownTimer(20000, 1000) {
            @Override
            public void onTick(long l) {
                if (otpToast != null) {
                    otpToast.cancel(); // Cancel the previous toast message
                }
                otpToast = Toast.makeText(getApplicationContext(), "Your OTP will expire in: " + l / 1000 + " secs", Toast.LENGTH_SHORT);
                otpToast.show();
            }

            @Override
            public void onFinish() {
                Log.v(title, "Countdown Finished!");
                if (otpToast != null) {
                    otpToast.cancel();
                }
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(title, "Starting Acc Creation");

        etUsername = findViewById(R.id.editTextText3);
        etPassword = findViewById(R.id.editTextText4);
        etOTP = findViewById(R.id.editTextText6);

        otpButton = findViewById(R.id.button4);
        createButton = findViewById(R.id.button3);
        cancelButton = findViewById(R.id.button2);

        otpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateAndDisplayOTP();

                etOTP.setText("");
                startCountdown();
                myCountDown.start();
            }
        });

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
                if (otpToast != null) {
                    otpToast.cancel();
                }
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Signup.this, Login.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (myCountDown != null) {
            myCountDown.cancel();
        }
        if (otpToast != null) {
            otpToast.cancel();
        }
    }
}
