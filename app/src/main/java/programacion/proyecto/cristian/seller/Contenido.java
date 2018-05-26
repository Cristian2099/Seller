package programacion.proyecto.cristian.seller;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Contenido extends AppCompatActivity{

    TabLayout tabLayout;
    MyPagerAdapter myPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contenido);

        tabLayout = (TabLayout)findViewById(R.id.pestanas);
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);

        myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(myPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);
    }

}
