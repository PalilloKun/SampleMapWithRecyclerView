package com.palitokun.mapwrecyclerview.CustomRecycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.palitokun.mapwrecyclerview.Pojo.Info;
import com.palitokun.mapwrecyclerview.R;

import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import java.util.ArrayList;

/**
 *Custom Adapter for Recycler data
*/

public class CustomRecycler extends RecyclerView.Adapter<CustomRecycler.ViewHolder>{

    public ArrayList<Info> data ;
    public Context contextActual;
    public ArrayList<String> list;


    public CustomRecycler(ArrayList<Info> a) {
        data=a;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View v) {
            super(v);
        }
    }

    /*
    *  Class for map layout
    * */

    public class MapViewHolder extends ViewHolder {

        MapView mapaShow;

        public MapViewHolder(View v) {
            super(v);

            this.mapaShow = (MapView) v.findViewById(R.id.mapShow);
        }
    }
    /*
    * Class for infodata layout
    * */
    public class InfoDataViewHolder extends ViewHolder {

        TextView TitleInfoTxt;
        TextView ContentInfodata;


        public InfoDataViewHolder(View v) {
            super(v);
            this.TitleInfoTxt = (TextView) v.findViewById(R.id.TitleInfoTxt);
            this.ContentInfodata = (TextView) v.findViewById(R.id.ContentInfodata);

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v;

        /*
        *   viewType = 1, is a Map
        *   viewType = 2, is a Graphic
        *   viewType = 3, is a InfoData
        *
        *   In this example, only put two layouts: Map and Info
        * */

        if(viewType == 1){
            v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.maplayaout, viewGroup, false);
            return new MapViewHolder(v);
        }else {
            v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.infodatalayout, viewGroup, false);
            return new InfoDataViewHolder(v);
        }
    }
/*
    java.lang.ClassCastException: com.palitokun.mapwrecyclerview.CustomRecycler.CustomRecycler$MapViewHolder cannot be cast to com.palitokun.mapwrecyclerview.CustomRecycler.CustomRecycler$InfoDataViewHolder
    at com.palitokun.mapwrecyclerview.CustomRecycler.CustomRecycler.onBindViewHolder(CustomRecycler.java:101)
    at com.palitokun.mapwrecyclerview.CustomRecycler.CustomRecycler.onBindViewHolder(CustomRecycler.java:22)
    */
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        //For Info data
        if (viewHolder.getItemViewType() == 3) {

            Info dat = data.get(position);
            InfoDataViewHolder Indicador = (InfoDataViewHolder) viewHolder;

            Indicador.TitleInfoTxt.setText(dat.getTitle());
            Indicador.ContentInfodata.setText(dat.getContent());
        }else{

            Info dat = data.get(position);
            MapViewHolder Indicador = (MapViewHolder) viewHolder;
            Indicador.mapaShow.setBuiltInZoomControls(true);
            Indicador.mapaShow.setMultiTouchControls(true);
            Indicador.mapaShow.setClickable(false);


            Indicador.mapaShow.getController().setZoom(14);
            Indicador.mapaShow.getController().setCenter(new GeoPoint(-25.2961407, -57.6309129));
        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        //return mDataSetTypes[position];
        return  Integer.valueOf(data.get(position).getTypeLayout());

    }
}
