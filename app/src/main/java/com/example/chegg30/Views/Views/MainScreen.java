package com.example.chegg30.Views.Views;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.chegg30.Entity.User;
import com.example.chegg30.R;
import com.example.chegg30.ViewModels.QuestionViewModel;
import com.example.chegg30.ViewModels.UserViewModel;

public class MainScreen extends AppCompatActivity {
    RecyclerView recyclerView;
    EditText questionField;
    ImageButton imageButton;
    UserViewModel userViewModel;
    QuestionViewModel questionViewModel;
    QuestionAdapter questionAdapter;

    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        recyclerView = findViewById(R.id.recyclerView);
        questionField = findViewById(R.id.askQuestionField);
        imageButton = findViewById(R.id.sendingImageButton);

        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        questionViewModel = ViewModelProviders.of(this).get(QuestionViewModel.class);

        int id = getIntent().getIntExtra("id", 0);
        user = userViewModel.findUserbyId(id);

        Toast.makeText(getApplicationContext(), user.getUsername(), Toast.LENGTH_LONG).show();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        questionAdapter = new QuestionAdapter();
        recyclerView.setAdapter(questionAdapter);



        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = questionField.getText().toString();
                if (!text.equals("")) {
                    questionViewModel.addQuestion(text, user);
                    questionAdapter = new QuestionAdapter();
                    recyclerView.setAdapter(questionAdapter);
                    questionField.setText("");
                } else {
                    Toast.makeText(getApplicationContext(), "Enter a question!", Toast.LENGTH_LONG).show();
                }


            }
        });



    }
}
