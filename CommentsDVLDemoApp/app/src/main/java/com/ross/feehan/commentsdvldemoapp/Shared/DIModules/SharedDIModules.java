package com.ross.feehan.commentsdvldemoapp.Shared.DIModules;

import android.content.Context;

import com.ross.feehan.commentsdvldemoapp.Features.PostComments.PostCommentActivity;
import com.ross.feehan.commentsdvldemoapp.DataTypes.Comment;
import com.ross.feehan.commentsdvldemoapp.Shared.CommentsDVLDemoAppApplication;
import com.ross.feehan.commentsdvldemoapp.Shared.SharedPreferences.CommentsSharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ross Feehan on 04/11/2015.
 * Copyright Ross Feehan
 */

@Module(injects =  CommentsDVLDemoAppApplication.class, complete = false, library = true)
public class SharedDIModules {

    private Context ctx;

    //CONSTRUCTOR
    public SharedDIModules(Context ctx){
        this.ctx = ctx;
    }

    @Provides @Singleton
    public CommentsSharedPreferences provideCommentsSharedPreferences(){
        return new CommentsSharedPreferences(ctx);
    }
}
