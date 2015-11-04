package com.ross.feehan.commentsdvldemoapp.Utils;

import android.content.Context;

import com.ross.feehan.commentsdvldemoapp.Data.DataImplementations.GetCommentsImpl;
import com.ross.feehan.commentsdvldemoapp.Data.SharedPreferences.CommentsSharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ross Feehan on 04/11/2015.
 * Copyright Ross Feehan
 */

@Module(injects =  {GetCommentsImpl.class},
        complete = false,
        library = true)
public class DataDIModules {

    private Context ctx;
    private GetCommentsImpl getCommentsImpl;
    private CommentsSharedPreferences commentsSP;

    //constructor
    public DataDIModules(Context ctx){
        this.ctx = ctx;
    }

    @Provides @Singleton
    public CommentsSharedPreferences provideCommentsSharedPreferences(){
        if(commentsSP == null){
            commentsSP = new CommentsSharedPreferences(ctx);
        }
        return commentsSP;
    }

    @Provides @Singleton
    public GetCommentsImpl provideGetCommentsImpl(CommentsSharedPreferences commentsSP){
        if(getCommentsImpl == null){
            getCommentsImpl = new GetCommentsImpl(commentsSP);
        }
        return getCommentsImpl;
    }
}
