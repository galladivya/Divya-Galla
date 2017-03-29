package com.example.bhaghyalakshmi.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
class Owner
{
   public  String ownerid;

    public void setOwnerid(String w)
    {ownerid = w;}

    public String getOwnerid()
    {return ownerid;}
}
public class MainActivity extends AppCompatActivity {
    Button b1;
    EditText ed1;

    TextView tx1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.button);
        ed1 = (EditText) findViewById(R.id.userid);


        tx1 = (TextView) findViewById(R.id.layout);
        tx1.setVisibility(View.GONE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ed1.getText().toString().equals("galladivya")) {
                    Toast.makeText(getApplicationContext(),
                            "Redirecting...", Toast.LENGTH_SHORT).show();
                    Firebase ref = new Firebase(Config.FIREBASE_URL);

                    Owner owner = new Owner();
                    owner.setOwnerid(ed1.getText().toString().equals("galladivya"));

                    Firebase newRef = ref.child("Owner").push();
                    newRef.setValue(owner);
                }
                tx1.setVisibility(View.VISIBLE);
                tx1.setBackgroundColor(Color.RED);
                finish();


            }
        });


        new Firebase(Config.FIREBASE_URL).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    //Getting the data from snapshot
                    Owner owner = postSnapshot.getValue(Owner.class);

                    //Adding it to a string
                    String string = "Id: " + owner.getownerid()  + "\n\n";

                    //Displaying it on textview
                    layoutowner.setOwnerid(string);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });
    }
}