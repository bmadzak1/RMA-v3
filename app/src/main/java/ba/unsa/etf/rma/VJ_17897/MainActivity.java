package ba.unsa.etf.rma.VJ_17897;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button dugme;
    private EditText text;
    private ListView list;

    private ArrayList<String> unosi;

    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dugme = (Button)findViewById(R.id.button);
        list = (ListView)findViewById(R.id.listView);
        text = (EditText)findViewById(R.id.editText);

        unosi = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, R.layout.element_liste, unosi);

        list.setAdapter(adapter);

        dugme.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                unosi.add(0, text.getText().toString());
                adapter.notifyDataSetChanged();
                text.setText("");
            }
        });
    }
}
