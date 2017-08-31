package tech.alvarez.withlove;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import tech.alvarez.withlove.adapters.FotosAdapter;
import tech.alvarez.withlove.model.Album;
import tech.alvarez.withlove.util.Util;

public class MainActivity extends AppCompatActivity {

    private static final Gson gson = new Gson();

    private RecyclerView fotosRecyclerView;
    private FotosAdapter fotosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configuración de la lista de fotos
        fotosRecyclerView = (RecyclerView) findViewById(R.id.fotosRecyclerView);
        fotosRecyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        fotosRecyclerView.setLayoutManager(layoutManager);

        fotosAdapter = new FotosAdapter(this);
        fotosRecyclerView.setAdapter(fotosAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();

        cargarDatos();
    }

    private void cargarDatos() {

        String json = Util.leerJSON(this);

        Album album = gson.fromJson(json, Album.class);

        fotosAdapter.setDataset(album.getFotos());
    }
}
