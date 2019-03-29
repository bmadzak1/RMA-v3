package ba.unsa.etf.rma.VJ_17897;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Detalji extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalji);

        TextView imetv = (TextView)findViewById(R.id.detaljiIme);
        TextView prezimetv = (TextView)findViewById(R.id.detaljiPrezime);
        TextView zanrtv = (TextView)findViewById(R.id.detaljiZanr);
        TextView webtv = (TextView)findViewById(R.id.detaljiWeb);
        TextView biotv = (TextView)findViewById(R.id.detaljiBio);

        imetv.setText(getIntent().getStringExtra("imeAutora"));
        prezimetv.setText(getIntent().getStringExtra("prezimeAutora"));
        zanrtv.setText(getIntent().getStringExtra("zanr"));
        webtv.setText(getIntent().getStringExtra("webStranica"));
        biotv.setText(getIntent().getStringExtra("biografija"));
    }

    public void onClick(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(getIntent().getStringExtra("webStranica")));
        startActivity(i);
    }
}
