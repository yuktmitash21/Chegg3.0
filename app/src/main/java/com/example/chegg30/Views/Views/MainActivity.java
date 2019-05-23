package com.example.chegg30.Views.Views;

import android.arch.lifecycle.ViewModel;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.arch.lifecycle.ViewModelProviders;
import android.widget.Toast;

import com.example.chegg30.R;
import com.example.chegg30.ViewModels.UserViewModel;

public class MainActivity extends AppCompatActivity {
    EditText usernameText;
    EditText passwordText;
    Button loginButton;
    Button registrationButton;
    UserViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameText = findViewById(R.id.usernameLogin);
        passwordText = findViewById(R.id.passwordLogin);
        loginButton = findViewById(R.id.loginbuttonlogin);
        registrationButton = findViewById(R.id.registrationButtonLogin);
        viewModel = ViewModelProviders.of(this).get(UserViewModel.class);


        registrationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameText.getText().toString();
                String password = passwordText.getText().toString();
                viewModel.registerUser(username, password);
                Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mainActivity);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameText.getText().toString();
                String password = passwordText.getText().toString();

                if (username.equals("")) {
                    Toast.makeText(getApplicationContext(), "Enter a username!", Toast.LENGTH_LONG).show();
                } else if (password.equals("")) {
                    Toast.makeText(getApplicationContext(), "Enter a password", Toast.LENGTH_LONG).show();
                } else {
                    int hashcode = viewModel.validUser(username, password);
                    if (hashcode == -1) {
                        Toast.makeText(getApplicationContext(), viewModel.errorMessage(username, password), Toast.LENGTH_LONG).show();
                    } else {
                        Intent mainScreenIntent = new Intent(getApplicationContext(), MainScreen.class);
                        mainScreenIntent.putExtra("id", hashcode);
                        startActivity(mainScreenIntent);
                    }
                }

            }
        });
    }
}
