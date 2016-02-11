package huruhum.coctelera;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;


public class Detalle extends AppCompatActivity {

    private TextView lblDetailTitle;
    private TextView lblDetailSubtitle;
    private ImageView imgDetail;
    private TextView lblDetailDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        //getActionBar().setDisplayHomeAsUpEnabled(true);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        lblDetailTitle = (TextView) findViewById(R.id.lblDetailTitle);
        lblDetailSubtitle = (TextView) findViewById(R.id.lblDetailSubtitle);
        imgDetail = (ImageView) findViewById(R.id.imgDetail);
        lblDetailDescripcion = (TextView) findViewById(R.id.lblDetailText);

        mostrarDatos();
    }


    private void mostrarDatos() {

        Formato formato = (Formato) getIntent().getExtras().getSerializable("elemento");

        lblDetailTitle.setText(formato.getTitulo());
        lblDetailSubtitle.setText(formato.getSubtitulo());
        imgDetail.setImageResource(formato.getImagen());
        lblDetailDescripcion.setText(formato.getDescripcion());

    }

}
