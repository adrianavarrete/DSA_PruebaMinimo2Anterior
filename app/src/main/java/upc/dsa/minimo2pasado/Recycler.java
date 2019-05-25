package upc.dsa.minimo2pasado;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Constraints;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Recycler extends RecyclerView.Adapter<Recycler.ViewHolder> {

    List<Element> data;
    Context context;

    public Recycler(Context context) {
        this.context = context;
        this.data = new ArrayList<>();
    }

    public void addElements(List<Element> elementList){

        data.addAll(elementList);
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.city_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Element element = data.get(i);

        viewHolder.ineMunicipiView.setText(element.getIne());
        viewHolder.nomMunicipiView.setText(element.getMunicipiNom());

        Picasso.with(context).load(element.getMunicipiEscut()).into(viewHolder.escutMuncipi);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView nomMunicipiView;
        private ConstraintLayout constraintLayout;
        private TextView ineMunicipiView;
        private ImageView escutMuncipi;


        public ViewHolder(View v){
            super(v);
            constraintLayout = v.findViewById(R.id.constraintLayout);
            nomMunicipiView = v.findViewById(R.id.nomMunicipi);
            ineMunicipiView = v.findViewById(R.id.numeroIne);
            escutMuncipi = v.findViewById(R.id.escutMunicipi);



        }

    }
}
