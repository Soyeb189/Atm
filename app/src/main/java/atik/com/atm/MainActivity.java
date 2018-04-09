package atik.com.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editTextUserId,editTextUserPassword;
    Button buttonLogin;
    String userId = "12345";
    String userPass = "123";
    String getUserId,getUserPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUserId = findViewById(R.id.edtUserId);
        editTextUserPassword = findViewById(R.id.edtUserPassword);
        buttonLogin = findViewById(R.id.btnLogin);

       getUserId= editTextUserId.getText().toString();
       getUserPass = editTextUserPassword.getText().toString();
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    getUserId = editTextUserId.getText().toString().trim();
                    getUserPass = editTextUserPassword.getText().toString().trim();

                    if (userId.equals(getUserId) && userPass.equals(getUserPass)) {
                        Intent i = new Intent(MainActivity.this, Menu.class);
                        startActivity(i);
                    }
                    else {
                        Toast.makeText(MainActivity.this, "User Id Or Password Incorrect", Toast.LENGTH_SHORT).show();
                    }

            }
        });
    }
}
