package tech.alvarez.withlove.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import tech.alvarez.withlove.R;
import tech.alvarez.withlove.model.Foto;

public class FotosAdapter extends RecyclerView.Adapter<FotosAdapter.ViewHolder> {

    private List<Foto> dataset;
    private Context context;

    public FotosAdapter(Context context) {
        this.context = context;
        this.dataset = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_foto, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Foto f = dataset.get(position);
        holder.nombreTextView.setText(f.getNombre());

        // TODO: Usar Glide para descargar la imagen y colocarla en el fotoImageView
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView fotoImageView;
        private TextView nombreTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            fotoImageView = (ImageView) itemView.findViewById(R.id.fotoImageView);
            nombreTextView = (TextView) itemView.findViewById(R.id.nombreTextView);
        }
    }


    public void setDataset(List<Foto> fotos) {
        if (fotos != null) {
            dataset.addAll(fotos);
        }
        notifyDataSetChanged();
    }

}
