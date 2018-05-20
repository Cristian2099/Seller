package programacion.proyecto.cristian.seller;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import static android.R.id.tabhost;

public class Contenido extends FragmentActivity {

    private TabLayout tablayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contenido);

        tablayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        tablayout.setupWithViewPager(viewPager);

        setUpViewPager(viewPager);
    }

    private void setUpViewPager(ViewPager viewPager) {

        TabViewPagerAdapter tabViewPagerAdapter = new TabViewPagerAdapter(getSupportFragmentManager());
        tabViewPagerAdapter.addFragment(new Tab1(),"Tab1");
        tabViewPagerAdapter.addFragment(new Tab2(),"Tab2");
        tabViewPagerAdapter.addFragment(new Tab3(),"Tab3");
        tabViewPagerAdapter.addFragment(new Tab4(),"tab4");
        tabViewPagerAdapter.addFragment(new Tab4(),"tab5");
        viewPager.setAdapter(tabViewPagerAdapter);
    }

}
