package ba.unsa.etf.rma.VJ_17897;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class FragmentLista extends Fragment {

    private ArrayList<Muzicar> muzicari = new ArrayList<>();
    private OnItemClick oic;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.lista_fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        if(getArguments().containsKey("Alista")){
            muzicari = getArguments().getParcelableArrayList("Alista");
            ListView lv = (ListView)getView().findViewById(R.id.listView);
            ArrayAdapter<Muzicar> aa = new ArrayAdapter<Muzicar>(getActivity(), R.layout.element_liste, muzicari);
            lv.setAdapter(aa);

            try{
                oic = (OnItemClick)getActivity();
            }catch (ClassCastException e){
                throw new ClassCastException(getActivity().toString() + "Treba implementirati OnItemClick");
            }

            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    oic.onItemClicked(position);
                }
            });
        }
    }

    public interface OnItemClick{
        public void onItemClicked(int pos);
    }
}
