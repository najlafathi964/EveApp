package com.najla.eveapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.app.ExpandableListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.najla.eveapp.Fragment.ChatFragment;
import com.najla.eveapp.Fragment.ConsulativeFragment;
import com.najla.eveapp.Fragment.ProfileFragment;
import com.najla.eveapp.Models.ArticleFragment_;
import com.najla.eveapp.Models.InstitutionsFragment;
import com.najla.eveapp.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeActivity extends AppCompatActivity implements ProfileFragment.OnFragmentInteractionListener {
  String user ;
  Bundle bundle ;
  TextView title ;
  CircleImageView userhome ;
    FirebaseAuth mAuth;
    FirebaseUser currentUser ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.homeToolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        userhome = findViewById(R.id.home_userImage);
        title = findViewById(R.id.title_home);
        try {
            mAuth = FirebaseAuth.getInstance();
            currentUser = mAuth.getCurrentUser();
            Glide.with(this).load(currentUser.getPhotoUrl()).into(userhome);
        } catch (Exception e ){
            Glide.with(this).load(this.getResources().getIdentifier("userphoto","drawable",this.getPackageName())).into(userhome);
            e.printStackTrace();
        }
        userhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentUser == null ){
                    startActivity(new Intent(HomeActivity.this , LoginActivity.class));
                    finish();
                }else {
                title.setText(R.string.profile);
                getSupportFragmentManager().beginTransaction().replace(R.id.container,
                        new ProfileFragment()).commit();
            }
            }
        });

        try {
            bundle = getIntent().getExtras();
            user = bundle.getString("visit");
        }catch (Exception e){
            e.printStackTrace();
        }
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch (item.getItemId()) {
                    case R.id.nav_home:
                            selectedFragment = new ArticleFragment_();
                        title.setText(R.string.cons);

                        break;
                    case R.id.nav_instit:
                        selectedFragment = new InstitutionsFragment();
                        title.setText(R.string.cons);

                        break;
                    case R.id.nav_Massages:
                        if(currentUser == null){
                            startActivity(new Intent(HomeActivity.this , LoginActivity.class));
                            finish();
                        }else {
                            selectedFragment = new ChatFragment();
                            title.setText(R.string.massg);
                        }

                        break;
                    case R.id.nav_cons:
                        if(currentUser == null ){
                            startActivity(new Intent(HomeActivity.this , LoginActivity.class));
                            finish();
                        }else {
                            selectedFragment = new ConsulativeFragment();
                            title.setText(R.string.cons);
                        }
                        break;
                }

                try {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,
                            selectedFragment).commit();
                }catch (Exception e){
                    e.printStackTrace();
                }

                return true;            }
        });

        //I added this if statement to keep the selected fragment when rotating the device
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container,
                    new ConsulativeFragment()).commit();
        }

}


    @Override
    public void onFragmentInteraction(int id) {
        switch (id) {
            case R.id.logout:
                mAuth.signOut();
                Intent loginActivity = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(loginActivity);
                finish();

                break;
        }
    }
}
