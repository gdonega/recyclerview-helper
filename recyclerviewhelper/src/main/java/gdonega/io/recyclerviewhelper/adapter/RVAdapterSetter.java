package gdonega.io.recyclerviewhelper.adapter;

import android.content.Context;
import android.view.ViewGroup;

import gdonega.io.recyclerviewhelper.RVManager;

/**
 * Created by Gustavo Donegá Queiroz(gdonega).
 */
public class RVAdapterSetter {

    private Context context;
    private RVManager manager;
    private Integer cardXmlId;
    private ViewGroup root;
    private Boolean attachToRoot;

    public RVAdapterSetter(RVManager manager) {
        context = null;
        cardXmlId = null;
        this.manager = manager;
    }

    public RVAdapterSetter setContext(Context context){
        this.context = context;
        return this;
    }

    public RVAdapterSetter setCardXmlId(int id){
        this.cardXmlId = id;
        return this;
    }

    public RVAdapterSetter setRoot(ViewGroup root){
        this.root = root;
        return this;
    }

    public RVAdapterSetter setAttachToRoot(Boolean attachToRoot){
        this.attachToRoot = attachToRoot;
        return this;
    }


    public RVManager and(){
        return manager;
    }

    public Context getContext() {
        return context;
    }

    public RVManager getManager() {
        return manager;
    }

    public Integer getCardXmlId() {
        return cardXmlId;
    }

    public ViewGroup getRoot() {
        return root;
    }

    public Boolean getAttachToRoot() {
        return attachToRoot;
    }
}
