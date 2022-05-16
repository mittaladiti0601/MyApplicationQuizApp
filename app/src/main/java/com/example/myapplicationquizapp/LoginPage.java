package com.example.myapplicationquizapp;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import android.content.Intent;

import com.google.android.gms.auth.api.identity.SignInCredential;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import java.util.HashMap;



public class LoginPage extends AppCompatActivity {

//    private static final int RC_SIGN_IN = 101;
    public Button button;
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    ImageView googleBtn;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

//        progressDialog = new ProgressDialog(this);
        googleBtn = findViewById(R.id.google_btn);

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
//        mAuth = FirebaseAuth.getInstance();
//        mUser = mAuth.getCurrentUser();
        gsc = GoogleSignIn.getClient(this,gso);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if(acct!=null){
//            acct.getIdToken();
            navigateToVariousQuizzes();
        }
//        Intent signInIntent = gsc.getSignInIntent();
//        startActivityForResult(signInIntent,RC_SIGN_IN);


        googleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });

    }

    void signIn(){
        Intent signInIntent = gsc.getSignInIntent();
        startActivityForResult(signInIntent,1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1000){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);

            try {
                task.getResult(ApiException.class);
//                firebaseAuthWithGoogle(acct.getIdToken());

                navigateToVariousQuizzes();
            } catch (ApiException e) {
                Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
//                progressDialog.dismiss();
//                finish();
            }
        }
    }

//    private void firebaseAuthWithGoogle(String idToken) {
//        AuthCredential firebaseCredential = GoogleAuthProvider.getCredential(idToken, null);
//        mAuth.signInWithCredential(firebaseCredential)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            // Sign in success, update UI with the signed-in user's information
//                            progressDialog.dismiss();
//                            FirebaseUser user = mAuth.getCurrentUser();
//                            updateUI(user);
//                        } else {
//                            // If sign in fails, display a message to the user.
//                            progressDialog.dismiss();
//                            Toast.makeText(LoginPage.this, ""+task.getException(), Toast.LENGTH_SHORT).show();
//                            finish();
//
//                        }
//                    }
//                });
//    }

//    private void updateUI(FirebaseUser user) {
//        Intent intent = new Intent(LoginPage.this,VariousQuizzes2.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(intent);
//    }

    void navigateToVariousQuizzes() {
        finish();
        Intent intent = new Intent(LoginPage.this, VariousQuizzes2.class);
        startActivity(intent);

    }

    public void btn_login(View view) {
        startActivity(new Intent(getApplicationContext(),Login_Form.class));
    }

    public void btn_SignUp(View view) {
        startActivity(new Intent(getApplicationContext(),SignUp_Form.class));
    }
}