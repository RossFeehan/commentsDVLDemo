package com.ross.feehan.commentsdvldemoapp.Utils;

import android.content.Context;

import com.ross.feehan.commentsdvldemoapp.Data.DataImplementations.GetCommentsImpl;
import com.ross.feehan.commentsdvldemoapp.Data.DataImplementations.PostCommentImpl;
import com.ross.feehan.commentsdvldemoapp.Data.Objects.Comment;
import com.ross.feehan.commentsdvldemoapp.Data.SharedPreferences.CommentsSharedPreferences;
import com.ross.feehan.commentsdvldemoapp.Logic.LogicImplementations.GetCommentsLogicImpl;
import com.ross.feehan.commentsdvldemoapp.Logic.LogicImplementations.PostCommentLogicImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ross Feehan on 04/11/2015.
 * Copyright Ross Feehan
 */

@Module(injects =  {CommentsDVLDemoAppApplication.class, GetCommentsImpl.class, GetCommentsLogicImpl.class,
        PostCommentLogicImpl.class, PostCommentImpl.class},
        complete = false,
        library = true)
public class DataDIModules {

    private Context ctx;
    private GetCommentsImpl getCommentsImpl;
    private CommentsSharedPreferences commentsSP;
    private PostCommentImpl postComment;
    private Comment comment;

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

    @Provides @Singleton
    public PostCommentImpl providePostCommentImpl(CommentsSharedPreferences commentsSP){
        if(postComment == null){
            postComment = new PostCommentImpl(commentsSP);
        }
        return postComment;
    }

    @Provides
    public Comment provideComment(){
        comment = new Comment();
        return comment;
    }
}
