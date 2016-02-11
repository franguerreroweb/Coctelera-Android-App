package huruhum.coctelera;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ListView lista;


    private Formato[] datos = new Formato[]{
                new Formato("Mojito", "Ron, Lima, Hierbabuena, Soda", R.drawable.m01, R.drawable.i01, "Ingredientes: 4 cl de ron blanco cubano, 3 cl de zumo de lima, 6 ramitas de hierbabuena, 2 cucharillas de azúcar, soda. \n\nMachacar las ramas de menta con azúcar y jugo de lima. Añadir un poco de soda y llenar el vaso con hielo molido. Echar ron y llenarlo con soda de nuevo. Decorar con hojas de menta y una rodaja de limón."),
                new Formato("Blue Hawaii", "Ron, Curaçao, Zumo de Naranja, Zumo de Piña", R.drawable.m05, R.drawable.i05, "Ingredientes: 6 cl de ron blanco, 3 cl de Curaçao azul, 3 cl de zumo de naranja 6 cl de zumo de piña. \n\nLleve todos los ingredientes a una coctelera y agite bien durante unos segundos. Vierta la mezcla en una copa y decórela con una tajada triangular de piña."),
                new Formato("Margarita", "Tequila, Cointreau, Lima", R.drawable.m03, R.drawable.i03, "Ingredientes: 3.5 cl de tequila, 2 cl de Cointreau, 1.5 cl de jugo de lima recién exprimido. \n\nEchar todos los ingredientes en una coctelera con hielo, agitarlo bien y colarlo en un vaso de coctel bordeado con sal."),
                new Formato("Daiquiri", "Ron, Lima, Jarabe de Frutas", R.drawable.m04, R.drawable.i04, "Ingredientes: 4.5 cl de ron blanco, 2.5 cl de jugo de lima, 1.5 cl de jarabe de frutas (fresa, plátano, piña, etc.) \n\nLicuar todos los ingredientes junto con hielo, agitar y colar en un vaso de coctel."),
                new Formato("Cosmopolitan", "Vodka, Cointreau, Lima, Zumo de Arándanos", R.drawable.m02, R.drawable.i02, "Ingredientes: 4 cl de vodka, 1.5 cl de Cointreau, 1.5 cl de jugo de lima, 3 cl de zumo de arándanos. \n\nAgitar todos los elementos con hielo en una coctelera. Servir en un vaso largo de coctel. Decorar con una rodaja de lima."),
                new Formato("Caipirinha", "Limón o Lima, Cachaça, Azucar Moreno", R.drawable.m06, R.drawable.i06, "Ingredientes: 1 limón/lima cortado en trozos, Cachaça, azucar moreno o blanco. \n\nCortar el limón o la lima en trozos, y machacarlos un poco para sacarles el jugo. Añadir unas cucharadas de azucar, y el hielo sin picar. Agregar Cachaça. Remover un poco, poner una pajita, y dejar algunos trozos de lima dentro."),
                new Formato("White Russian", "Licor de Café, Vodka, Nata", R.drawable.m07, R.drawable.i07, "Ingredientes: 2 cl de licor de café, 5 cl de vodka, 3 cl de nata o leche. \n\nLlenar el vaso de hielo, a continuación echar el licor de café, el vodka y finalmente la nata."),
                new Formato("Long Island Ice Tea", "Tequila, Vodka, Ron, Triple Seco, Ginebra, Limón, Sirope de Almibar, Cola", R.drawable.m08, R.drawable.i08, "Ingredientes: 1.5 cl de tequila, 1.5 cl de vodka, 1.5 cl de ron blanco, 1.5 cl de tripe seco, 1.5 cl de ginebra, 2.5 cl de zumo de limón, 3.0 cl de sirope de almíbar y 1 toque de Cola. \n\nAñadir todos los ingredientes en un vaso largo lleno de hielo, remover y decorar con corteza de limón."),
                new Formato("Coco Loco", "Ron, Vodka, Tequila, Crema de Coco, Zumo de Limón", R.drawable.m01, R.drawable.i01, "Ingredientes: 2 cl de ron blanco, 2 cl de vodka, 2 cl de tequila, 4 cl de crema de coco, 2 cl de zumo de limón. \n\nAñadimos todos los ingredientes, incluyendo hielo picado. Agitamos fuertemente hasta que el hielo se escarche y se mezclen bien todos los líquidos, formando una ligera emulsión con algo de espuma."),
                new Formato("Blue Ocean's", "Ginebra, Ron de Coco, Blue Curaçao, Zumo de Piña", R.drawable.m05, R.drawable.i05, "Ingredientes: 1 cl de ginebra, 2 cl de ron de coco, 2 cl de blue curaçao, 5 cl de zumo de piña.\n\nColocar en la coctelera el hielo, añadir la ginebra, añadir el blue curaçao, añadir el ron de coco, añadir el zumo de piña, batir y servir en una copa."),
                new Formato("Mai Tai", "Ron, Curaçao, sirope de Orgeat", R.drawable.m03, R.drawable.i03, "Ingredientes: 4 cl de ron blanco, 2 cl de ron oscuro añejo, 1.5 cl Curaçao naranja o Cointreau, 1.5 cl de sirope de Orgeat (almendras), 1 cl de jugo de lima y granadina. \n\nAgitar en un vaso largo, y decorar con una porción de piña, hojas de menta o piel de lima. Servir con pajita."),
                new Formato("Manhattan", "Whisky de Centeno, Vermut Rojo", R.drawable.m04, R.drawable.i04, "Ingredientes: 5 cl de whisky de centeno, 2 cl de vermut rojo, 1 toque de amargo de Angostura. \n\nEchar todos los ingredientes en un mezclador con hielos y remover bien. Colarlo en un vaso de coctel enfriado y decorarlo con cereza para coctel."),
                new Formato("Bahama Mama", "Ron, Ron de Coco, Granadina, Zumo de Naranja, Zumo de Piña", R.drawable.m02, R.drawable.i02, "Ingredientes: 1.5 cl de ron, 1.5 cl de ron de coco, 1.5 cl de granadina, 3 cl de zumo de naranja, 3 cl de zumo de piña.\n\nAgite en la coctelera con hielo picado todos los ingredientes. Vierta en un vaso alto y adorne con una rodaja de piña y una cereza."),
                new Formato("Zombie", "Ron, Ron Blanco, Brandy de Albaricoque, Brandy de Cereza, Zumo de Naranja, Lima", R.drawable.m06, R.drawable.i06, "Ingredientes: 3 cl de ron, 3 cl de ron blanco, 1.5 cl de brandy de albaricoque, 1.5 cl de brandy de cereza, 6 cl de zumo de naranja, 1.5 cl de lima. \n\nMezclar en la coctelera el hielo, el ron, el brandy y los zumos y agitar bien. Llenar el vaso de hielo y colar la mezcla. Decorar con una pajita y fruta natural."),
                new Formato("Hurricane", "Ron, Ron Blanco, Zumo de Maracuyá, Lima, Granadina", R.drawable.m07, R.drawable.i07, "Ingredientes: 2 cl de ron, 2 cl de ron blanco, 4 cl de zumo de maracuyá, 1 cl de lima, 1 cl de granadina. \n\nEn una coctelera con hielo, mezclamos todos los ingredientes, agitando bien hasta que se escarche. Luego servimos en una copa tipo Hurricane."),
                new Formato("Harvey Wallbanger", "Vodka, Galliano, Zumo Naranja", R.drawable.m08, R.drawable.i08, "Ingredientes: 4.5 cl de vodka, 1.5 cl Galliano, 9 cl de zumo de naranja. \n\nEchar vodka y zumo de naranja en un vaso largo lleno de hielo. Remover suavemente y boyar el Galliano en la superficie. Decorar con rodajas de naranja y cereza."),
                new Formato("Piña Colada", "Ron Blanco, Ron de Coco, Zumo de Piña", R.drawable.m01, R.drawable.i01, "Ingredientes: 3 cl de ron blanco, 3 cl de ron de coco, 9 cl de zumo de piña. \n\nMezclar todos los ingredientes con hielo en una licuadora, echar en una copa grande o en un vaso tipo Hurricane, y servir con pajita. Se suele adornar con una rodaja de piña y con una cereza de coctel."),
                new Formato("Sex on The Beach", "Vodka, Aguardiente de Melocotón, Zumo de Arándanos, Zumo de Naranja", R.drawable.m02, R.drawable.i02, "Ingredientes: 4 cl de vodka, 2 cl de aguardiente de melocotón, 4 cl de zumo de arándanos, 4 cl de zumo de naranja. \n\nVerter todos los ingredientes en un vaso largo lleno de hielo. Decorar con una rodaja de naranja."),
                new Formato("Tequila Sunrise", "Tequila, Zumo de Naranja, Granadina", R.drawable.m03, R.drawable.i03, "Ingredientes: 4.5 cl de tequila, 9 cl de zumo de naranja, 1.5 cl de granadina. \n\nEchar tequila y zumo de naranja directamente en un vaso largo con hielos y rociar un poco de granadina sin remover para crear un efecto cromático. Decorar con una rodaja de naranja y una cereza.")

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Adaptador adaptador = new Adaptador(this, datos);

        lista = (ListView) findViewById(R.id.LstCocteles);
        lista.setAdapter(adaptador);



        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                Intent intent = new Intent(MainActivity.this, Detalle.class); //creamos el Intent
                Bundle bundle = new Bundle(); //Creamos el bundle para pasar la información

                bundle.putSerializable("elemento", (Formato)a.getItemAtPosition(position));

                intent.putExtras(bundle); //añadimos la información al intent
                startActivity(intent); //Iniciamos la nueva actividad

            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.about) {
            Intent intent = new Intent(MainActivity.this, About.class); //creamos el Intent
            startActivity(intent); //Iniciamos la nueva actividad
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    class Adaptador extends ArrayAdapter<Formato> {
        public Adaptador(Context context, Formato[] datos) {
            super(context, R.layout.formato_item, datos);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater .inflate(R.layout.formato_item, null);

            TextView lblTitulo = (TextView) item.findViewById(R.id.lblTitulo);
            lblTitulo.setText(datos[position].getTitulo());

            TextView lblSubtitulo = (TextView) item.findViewById(R.id.lblSubtitulo);
            lblSubtitulo.setText(datos[position].getSubtitulo());

            ImageView imgThumb = (ImageView) item.findViewById(R.id.imgThumb);
            imgThumb.setImageResource(datos[position].getMiniatura());

            return item;
        }
    }



}
