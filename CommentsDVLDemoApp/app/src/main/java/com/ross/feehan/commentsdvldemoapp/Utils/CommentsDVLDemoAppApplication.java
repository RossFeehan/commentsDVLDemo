package com.ross.feehan.commentsdvldemoapp.Utils;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

import java.util.Arrays;
import java.util.List;

import dagger.ObjectGraph;

/**
 * Created by Ross Feehan on 04/11/2015.
 * Copyright Ross Feehan
 */
public class CommentsDVLDemoAppApplication extends Application {

    private ObjectGraph objectGraph;
    private Context ctx;

    @Override
    public void onCreate(){
        super.onCreate();

        this.ctx = this;

        objectGraph = ObjectGraph.create(getModules().toArray());
        objectGraph.inject(this);
    }

    private List<Object> getModules(){
        return Arrays.<Object>asList(new DataDIModules(ctx), new LogicDIModules());
    }

    public ObjectGraph getObjectGraph(){
        return objectGraph;
    }

    //APPLICATION LIFECYCLE METHODS
    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onLowMemory(){
        super.onLowMemory();
    }

    @Override
    public void onTerminate(){
        super.onTerminate();
    }
}
