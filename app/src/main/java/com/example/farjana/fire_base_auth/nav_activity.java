package com.example.farjana.fire_base_auth;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/*
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
*/
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import de.hdodenhof.circleimageview.CircleImageView;
//import id.zelory.compressor.Compressor;

public class nav_activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TabLayout my_tabs;
    private ViewPager my_pager;
    private static DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    NavigationView navigationView;
    String name, email, bitmapstr;
    Bitmap decodedByte;
    TextView nav_user_email;

    private static ImageView user_img;
    TextView nav_user;
    private static DrawerLayout drawer;

    private static CircleImageView nav_user_pic_management;
    private static CircleImageView hide1;
    private static CircleImageView hide2;
   // private static StorageReference mStorageRef;

    private static int drawableResourceId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_activity);

        databaseReference = FirebaseDatabase.getInstance().getReference("User Profile");

        my_tabs = findViewById(R.id.my_tabs);
        my_pager = findViewById(R.id.my_viewPage);

        setupViewPager(my_pager);
        my_tabs.setupWithViewPager(my_pager);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        my_pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {

                switch (position) {
                    case 0:
                        fab.show();
                        fab.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();
                            }
                        });
                        break;

                    case 1:
                        fab.hide();
                        break;


                    case 2:
                        fab.show();fab.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            Snackbar.make(view, "Replace action", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        }
                    });
                        break;

                    default:
                        fab.hide();
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View hView =  navigationView.getHeaderView(0);
        user_img = hView.findViewById(R.id.nav_userphoto);
        nav_user = hView.findViewById(R.id.nam_nav);
        nav_user_email = hView.findViewById(R.id.email_nav);

        // navigation();

       /* nav_user_pic_management = hView.findViewById(R.id.nav_user_pic_management);
        hide1 = hView.findViewById(R.id.nav_user_pic_change);
        hide2 = hView.findViewById(R.id.nav_user_pic_delete);*/

       /* user_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CropImage.activity()
                        .setAspectRatio(1, 1)
                        .setGuidelines(CropImageView.Guidelines.ON)
                        .setMinCropWindowSize(500, 500)
                        .start((Activity) view.getContext());
            }
        });*/

     /*   hide2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteUserPhoto();
            }
        });

        nav_user_pic_management.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hide1.getVisibility() == View.VISIBLE) {
                    doOutAnim(hide1);
                    doOutAnim(hide2);
                } else {
                    doInAnim(hide1);
                    doInAnim(hide2);
                }
            }
        });

        setAddListFrag();
*/
    }

    private void setAddListFrag() {
       /* adListFragment = adListFragment == null ? new AdList() : adListFragment;
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                getSupportFragmentManager().beginTransaction().replace(R.id.container_frags, new AdList())
                        .commit();
            }
        };

        if (runnable != null) {
            mHandler.post(runnable);
            toolbar.setTitle("Ad Lists");
        }*/
    }

    private void doInAnim(View v) {
       /* v.animate().cancel();
        v.animate().setListener(null);
        v.setVisibility(View.VISIBLE);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(MyAnimations.RotateRight());
        animationSet.addAnimation(MyAnimations.inFromLeftAnimation());

        v.startAnimation(animationSet);
        v.animate()
                .alpha(1f)
                .setDuration(1000).setListener(null);
  */  }

    private void doOutAnim(View v) {
       /* v.animate().cancel();
        v.animate().setListener(null);

        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(MyAnimations.RotateLeft());
        animationSet.addAnimation(MyAnimations.outToLeftAnimation());
        v.startAnimation(animationSet);
        v.animate()
                .alpha(0.0f)
                .setDuration(700).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                v.setVisibility(View.GONE);
            }
        });*/
    }

    private void deleteUserPhoto() {
       /* mStorageRef = FirebaseStorage.getInstance().getReference();
        //Storage Reference for main image
        StorageReference filepath = mStorageRef.child("profile_images").child(mAuth.getCurrentUser().getUid() + ".jpg");

        filepath.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Map map = new HashMap();
                map.put("image", "no_img");
                mDatabase = GetFirebaseInstance.GetInstance().getReference().child("User").child(mAuth.getCurrentUser().getUid());
                mDatabase.updateChildren(map);
            }
        });*/
    }

    // retriving user image in the nav header.....

    private void navigation() {

       // Retrive_crnt_user_info rcui = new Retrive_crnt_user_info();

        currentUserInfo();

       /* user_img.setImageBitmap(decodedByte);
        nav_user.setText(name);
        nav_user_email.setText(email);
*/
    }

    private void currentUserInfo() {

        databaseReference.child(firebaseAuth.getCurrentUser().getUid())
                .addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                {
                    for(DataSnapshot userDetails : dataSnapshot.getChildren()) {
                         name=  userDetails.child("name").getValue().toString();
                         email = userDetails.child("email").getValue().toString();
                         bitmapstr = userDetails.child("bitmap").getValue().toString();

                        byte[] decodedString = Base64.decode(bitmapstr, Base64.DEFAULT);
                        decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    private void setupViewPager(ViewPager my_pager) {
        ViewPagerAdapter vp = new ViewPagerAdapter(getSupportFragmentManager());
        vp.addMyFragment(new Fragment1(),"Notes");
        vp.addMyFragment(new Fragment2(),"Attendence");
        vp.addMyFragment(new Fragment3(),"CGPA");

        my_pager.setAdapter(vp);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
