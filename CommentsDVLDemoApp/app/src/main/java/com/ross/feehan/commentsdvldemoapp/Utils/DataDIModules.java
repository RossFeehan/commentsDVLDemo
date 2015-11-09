package com.ross.feehan.commentsdvldemoapp.Utils;

import android.content.Context;

import com.ross.feehan.commentsdvldemoapp.Data.DataImplementations.DeleteCommentImpl;
import com.ross.feehan.commentsdvldemoapp.Data.DataImplementations.GetCommentsImpl;
import com.ross.feehan.commentsdvldemoapp.Data.DataImplementations.PostCommentImpl;
import com.ross.feehan.commentsdvldemoapp.Data.Objects.Comment;
import com.ross.feehan.commentsdvldemoapp.Data.SharedPreferences.CommentsSharedPreferences;
import com.ross.feehan.commentsdvldemoapp.Logic.LogicImplementations.DeleteCommentsLogicImpl;
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
        PostCommentLogicImpl.class, PostCommentImpl.class, DeleteCommentsLogicImpl.class},
        complete = false,
        library = true)
public class DataDIModules {

    private Context ctx;
    private GetCommentsImpl getCommentsImpl;
    private CommentsSharedPreferences commentsSP;
    private PostCommentImpl postComment;
    private DeleteCommentImpl deleteComment;
    private Comment comment;

    //constructor
    public DataDIModules(Context ctx){
        this.ctx = ctx;
    }

    @Provides @Singleton
    public CommentsSharedPreferences provideCommentsSharedPreferences(){
        return commentsSP = new CommentsSharedPreferences(ctx);
    }

    @Provides @Singleton
    public GetCommentsImpl provideGetCommentsImpl(CommentsSharedPreferences commentsSP){
        return getCommentsImpl = new GetCommentsImpl(commentsSP);
    }

    @Provides @Singleton
    public PostCommentImpl providePostCommentImpl(CommentsSharedPreferences commentsSP){
        return postComment = new PostCommentImpl(commentsSP);
    }

    @Provides @Singleton
    public DeleteCommentImpl provideDeleteCommentImpl(CommentsSharedPreferences commentsSP){
        return deleteComment = new DeleteCommentImpl(commentsSP);
    }

    @Provides
    public Comment provideComment(){
        return comment = new Comment();
    }
}
