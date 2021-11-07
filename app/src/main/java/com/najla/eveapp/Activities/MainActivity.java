package com.najla.eveapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;
import com.najla.eveapp.Fragment.Blank1Fragment;
import com.najla.eveapp.Fragment.Blank2Fragment;
import com.najla.eveapp.Fragment.Blank3Fragment;
import com.najla.eveapp.Fragment.Blank4Fragment;
import com.najla.eveapp.R;

public class MainActivity extends AppCompatActivity implements Blank1Fragment.OnFragmentInteractionListener , Blank2Fragment.OnFragmentInteractionListener , Blank3Fragment.OnFragmentInteractionListener , Blank4Fragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().add(R.id.container,new Blank1Fragment()).commit();

    }


    @Override
    public void onFragmentInteraction(int id) {
        switch (id){
            case R.id.skipfragement1 :
                getSupportFragmentManager().beginTransaction().replace(R.id.container,new Blank4Fragment()).commit();

                break;
            case R.id.next1 :
                getSupportFragmentManager().beginTransaction().replace(R.id.container,new Blank2Fragment()).commit();
                break;

            case R.id.skipfragment2 :
                getSupportFragmentManager().beginTransaction().replace(R.id.container,new Blank4Fragment()).commit();

                break;
            case R.id.next2 :
                getSupportFragmentManager().beginTransaction().replace(R.id.container,new Blank3Fragment()).commit();
                break;

            case R.id.next3 :
            getSupportFragmentManager().beginTransaction().replace(R.id.container,new Blank4Fragment()).commit();
            break;


            case R.id.log :
                startActivity(new Intent(MainActivity.this,LoginActivity.class));

                break;
            case R.id.reg :
                startActivity(new Intent(MainActivity.this,RegisterActivity.class));

                break;

            case R.id.visit :
                Intent intent = new Intent(MainActivity.this,HomeActivity.class) ;
                Bundle bundle = new Bundle();
                bundle.putString("visit","visitor");
                intent.putExtras(bundle);
                startActivity(intent);

                break;
        }
    }
}


