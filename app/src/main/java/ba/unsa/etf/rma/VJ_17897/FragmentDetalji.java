package ba.unsa.etf.rma.VJ_17897;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentDetalji extends Fragment {

    private Muzicar muzicar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View iv = inflater.inflate(R.layout.detalji_fragment, container, false);
        if(getArguments() != null && getArguments().containsKey("muzicar")){
            muzicar = getArguments().getParcelable("muzicar");
            TextView ime = (TextView) iv.findViewById(R.id.detaljiIme);
            TextView zanr = (TextView) iv.findViewById(R.id.detaljiZanr);
            TextView www = (TextView)iv.findViewById(R.id.detaljiWeb);
            ime.setText(muzicar.getIme());
            zanr.setText(muzicar.getZanr());
            www.setText(muzicar.getWww());
        }
        return iv;
    }
}
