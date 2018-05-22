package programacion.proyecto.cristian.seller;

import android.app.ActionBar;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import static android.R.layout.simple_spinner_item;
import static programacion.proyecto.cristian.seller.R.layout.tab1;

public class Tab1 extends Fragment{

    Spinner spinner;
    TextView text;
    LinearLayout layout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tab1,container,false);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle state) {
        super.onActivityCreated(state);

        layout = (LinearLayout) getView().findViewById(R.id.linear);
        spinner = (Spinner) getView().findViewById(R.id.spin);
        String[] opciones = {"Más reciente", "Más antiguo"};
        ArrayAdapter <String> adapter = new ArrayAdapter<>(getActivity().getApplicationContext(), R.layout.spinner_item_tab1,opciones);
        spinner.setAdapter(adapter);


    }

    public void addChild(boolean right){


    }
}
