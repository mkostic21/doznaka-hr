package m.kostic.doznaka;

import android.Manifest;
import android.app.DownloadManager;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.os.Environment;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import android.view.Menu;
import android.widget.Toast;

import java.io.File;
import java.io.InputStream;




public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Database database = Database.getInstance();

    //fragments
    InfoFragment infoFragment = new InfoFragment();
    VrsteFragment vrsteFragment = new VrsteFragment();
    DoznakaFragment doznakaFragment = new DoznakaFragment();
    SumaFragment sumaFragment = new SumaFragment();
//    SumaVrstaFragment sumaVrstaFragment = new SumaVrstaFragment();
//    SubSumaVrstaFragment subSumaVrstaFragment = new SubSumaVrstaFragment();

    FragmentManager fragmentManager = getSupportFragmentManager();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(""); //no title in toolbar
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.getMenu().getItem(0).setChecked(true); //highlight menu item on first launch
        fragmentManager.beginTransaction().replace(R.id.content_main, infoFragment).commit(); //first screen (fragment)

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);



        //TODO: put CSVParser in database?
        Database database = Database.getInstance(); //singleton database access point
        // csv file parsing is being done here
        InputStream stream = getResources().openRawResource(R.raw.doznaka_zpz);
        CSVParser parser = new CSVParser(stream);
        database.setTablicaTarifa(parser.Parse());



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else if(fragmentManager.getBackStackEntryCount()>0){
            fragmentManager.popBackStack();
        }
        else {
            fragmentManager.beginTransaction().replace(R.id.content_main, doznakaFragment).commit();
            NavigationView navigationView = findViewById(R.id.nav_view);
            navigationView.getMenu().getItem(2).setChecked(true);

//            super.onBackPressed(); //default
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.export) {
            XLSDataExporter xlsDataExporter = new XLSDataExporter();
            if (isExternalStorageWritable() && isStoragePermissionGranted()) {
                xlsDataExporter.export();
                saveFile(database.getDoznaka());
            }

        }

        return super.onOptionsItemSelected(item);
    }
    void saveFile(File doznaka){
        DownloadManager downloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
        if (downloadManager != null) {
            downloadManager.addCompletedDownload(doznaka.getName(), doznaka.getName(), true, "application/vnd.ms-excel", doznaka.getAbsolutePath(), doznaka.length(), true);
            Toast.makeText(this, "Datoteka Spremljena!  "+"Doznaka.xls", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Greška prilikom spremanja...", Toast.LENGTH_SHORT).show();
        }
    }
    boolean isExternalStorageWritable(){
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state);
    }
    boolean isStoragePermissionGranted(){
        if(Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                return true;
            }
            else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                return false;
            }
        }
        else {              //permission is automatically granted on sdk<23 upon installation
            return true;
        }
    }



    @SuppressWarnings({"StatementWithEmptyBody", "NullableProblems"})
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_info) {
            if(fragmentManager.getBackStackEntryCount()>0) {
                for (int i = 0; i < fragmentManager.getBackStackEntryCount(); i++) {
                    fragmentManager.popBackStack();
                }
                fragmentManager.beginTransaction().replace(R.id.content_main, infoFragment).commit();
            }
            else{
                fragmentManager.beginTransaction().replace(R.id.content_main, infoFragment).commit();
            }

        } else if (id == R.id.nav_vrste) {
            if(fragmentManager.getBackStackEntryCount()>0) {
                for (int i = 0; i < fragmentManager.getBackStackEntryCount(); i++) {
                    fragmentManager.popBackStack();
                }
                fragmentManager.beginTransaction().replace(R.id.content_main, vrsteFragment).commit();
            }
            else {
                fragmentManager.beginTransaction().replace(R.id.content_main, vrsteFragment).commit();
            }

        } else if (id == R.id.nav_doznaka) {
            if(fragmentManager.getBackStackEntryCount()>0){
                for(int i=0;i<fragmentManager.getBackStackEntryCount();i++){
                    fragmentManager.popBackStack();
                }
                fragmentManager.beginTransaction().replace(R.id.content_main, doznakaFragment).commit();
            }
            else {
                fragmentManager.beginTransaction().replace(R.id.content_main, doznakaFragment).commit();
            }

        } else if (id == R.id.nav_suma) {
            if(fragmentManager.getBackStackEntryCount()>0){
                return false;
            }
            else {
                fragmentManager.beginTransaction().replace(R.id.content_main, sumaFragment).commit();
            }

        } else if (id == R.id.nav_karta) {


        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
