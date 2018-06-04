package programacion.proyecto.cristian.seller;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.View;

public class MyPagerAdapter extends FragmentStatePagerAdapter{

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;

        switch (position) {

            case 0:
                fragment = new Cliente();
                break;
            case 1:
                fragment = new Registro();
                break;
            case 2:
                fragment = new Pedido();
                break;
            case 3: fragment = new Producto();
                break;
            default:
                fragment = null;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Clientes";
            case 1:
                return "Registro";
            case 2:
                return "Pedidos";
            case 3:
                return "Catálogo";
        }
        return null;
    }
}
