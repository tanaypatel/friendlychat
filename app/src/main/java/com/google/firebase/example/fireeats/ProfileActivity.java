package com.google.firebase.example.fireeats;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileActivity extends AppCompatActivity {


    @BindView(R.id.email_edittext)
    EditText mEmail;

    @BindView(R.id.name_edittext)
    EditText mName;

    @BindView(R.id.photo_url_edittext)
    EditText mPhotoUrl;

    @BindView(R.id.btn_update_profile)
    Button btnUpdate;

    private FirebaseFirestore mFirestore;
    private FirebaseUser mFirebaseUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ButterKnife.bind(this);

        initFirestore();

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateUserData();
            }
        });


    }

    private void initFirestore() {
        mFirestore = FirebaseFirestore.getInstance();

        //Get reference
        mFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        mEmail.setText(mFirebaseUser.getEmail());
        mName.setText(mFirebaseUser.getDisplayName());
        if(mFirebaseUser.getPhotoUrl() != null){
            mPhotoUrl.setText(mFirebaseUser.getPhotoUrl().toString());
        }



    }

    private void updateUserData(){

        DocumentReference updatedProfile = mFirestore.collection("users").document(mFirebaseUser.getUid());

        updatedProfile.update("userEmail", mEmail.getText().toString()); //Maybe not good idea to change email
        updatedProfile.update("displayName", mName.getText().toString());
        updatedProfile.update("photoURL", mPhotoUrl.getText().toString());
        updatedProfile.update("schoolName", "School1")
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(ProfileActivity.this, "Failed to Update",
                                        Toast.LENGTH_SHORT).show();

                            }
                        }); //remove later



        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                .setDisplayName(mName.getText().toString())
                .setPhotoUri(Uri.parse(mPhotoUrl.getText().toString()))
                .build();

        mFirebaseUser.updateProfile(profileUpdates)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Log.d("ProfileActivity", "User profile updated.");
                        }
                    }
        });
    }
}
