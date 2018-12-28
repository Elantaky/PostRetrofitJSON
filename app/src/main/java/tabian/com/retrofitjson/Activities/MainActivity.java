package tabian.com.retrofitjson.Activities;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tabian.com.retrofitjson.APIPackage.SignInRetrofitClient;
import tabian.com.retrofitjson.APIPackage.SignUpRetrofitClient;
import tabian.com.retrofitjson.R;
import tabian.com.retrofitjson.model.UserSignIn;
import tabian.com.retrofitjson.model.UserSignInResponse;
import tabian.com.retrofitjson.model.UserSignUp;
import tabian.com.retrofitjson.model.UserSignUpResponse;


public class MainActivity extends AppCompatActivity {
    private AlertDialog signInDialog;
    private View signinLayout;
    EditText emailEditTextSi;
    Button btnSignIn;
    EditText passwordEditTextSi;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSignIn = findViewById(R.id.btnSingIn);
        Button btnSignUp = findViewById(R.id.btnSignUp);
        final EditText etEmail = findViewById(R.id.input_email);
        final EditText etPassword = findViewById(R.id.input_password);
        final EditText etFirstName = findViewById(R.id.input_firstName);
        final EditText etPhoneNo = findViewById(R.id.input_phoneNo);
        final EditText etLastName = findViewById(R.id.input_lastName);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                String firstName = etFirstName.getText().toString();
                String phoneNo = etPhoneNo.getText().toString();
                String lastName = etLastName.getText().toString();

                Call<UserSignUpResponse> call = SignUpRetrofitClient.getInstance().getAPI().signUp(email, password, firstName, phoneNo, lastName);
                call.enqueue(new Callback<UserSignUpResponse>() {
                    @Override
                    public void onResponse(Call<UserSignUpResponse> call, Response<UserSignUpResponse> response) {
                        UserSignUpResponse userSignUp = response.body();
                        Log.v("WWW", "onResponse: Status Response: " + response.isSuccessful());
                        Log.v("WWW", "onResponse: Server Response: " + response.body());
                        Toast.makeText(MainActivity.this, userSignUp.getSuccess()+"and your id code is : "+userSignUp.getAid(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<UserSignUpResponse> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                signInDialog = getSignInDialog();
                signInDialog.show();

            }
        });
    }

    private AlertDialog getSignInDialog() {

        signinLayout = LayoutInflater.from(this).inflate(R.layout.sign_in_layout, null);
        emailEditTextSi = signinLayout.findViewById(R.id.email_editText_si);
        passwordEditTextSi = signinLayout.findViewById(R.id.password_editText_si);
        return new AlertDialog.Builder(this)
                .setView(signinLayout)
                .setTitle("Sign in")
                .setMessage("enter correct data")
                .setPositiveButton("Sign in", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (TextUtils.isEmpty(emailEditTextSi.getText().toString()) ||
                                !Patterns.EMAIL_ADDRESS.matcher(emailEditTextSi.getText().toString()).matches()) {
                            dialog.dismiss();
                            Toast.makeText(MainActivity.this, "invalid email", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        if (TextUtils.isEmpty(passwordEditTextSi.getText().toString()) || passwordEditTextSi.getText().toString().length() < 6) {
                            dialog.dismiss();
                            Toast.makeText(MainActivity.this, "invalid password", Toast.LENGTH_SHORT).show();
                            return;
                        } else {
                            //////////////////////////////////////////////////////
                            Call<UserSignInResponse> call = SignInRetrofitClient.getInstance().getAPI().signIn(emailEditTextSi.getText().toString(),passwordEditTextSi.getText().toString()
                                    );

                            call.enqueue(new Callback<UserSignInResponse>() {
                                @Override
                                public void onResponse(Call<UserSignInResponse> call, Response<UserSignInResponse> response) {
                                    UserSignInResponse userSignInResponse = response.body();
                                    Toast.makeText(MainActivity.this, "welcome "+userSignInResponse.getFirstName(), Toast.LENGTH_SHORT).show();
                                    if ("dd".equals(userSignInResponse.getFirstName())) {
                                        Toast.makeText(MainActivity.this, "dd", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(MainActivity.this, "not dd", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                @Override
                                public void onFailure(Call<UserSignInResponse> call, Throwable t) {

                                }
                            });

                            //////////////////////////////////////////////////////

                        }
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();
                    }
                })
                .create();
    }
}


