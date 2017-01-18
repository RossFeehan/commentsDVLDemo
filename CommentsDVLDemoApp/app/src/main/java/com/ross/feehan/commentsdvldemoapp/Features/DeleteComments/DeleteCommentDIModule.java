package com.ross.feehan.commentsdvldemoapp.Features.DeleteComments; /*
 * Created by Ross Feehan on 18/01/2017.
 */

import com.ross.feehan.commentsdvldemoapp.Features.DisplayComments.DisplayCommentsActivity;
import com.ross.feehan.commentsdvldemoapp.Shared.SharedPreferences.CommentsSharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(injects = DisplayCommentsActivity.class, complete = false)
public class DeleteCommentDIModule {

    private DeleteCommentViewInterface view;

    //CONSTRUCTOR
    public DeleteCommentDIModule(DeleteCommentViewInterface view) {
        this.view = view;
    }

    @Provides @Singleton
    public DeleteCommentDataInterface provideDeleteCommentDataInterface(CommentsSharedPreferences commentsSP){
        return new DeleteCommentDataImpl(commentsSP);
    }

    @Provides @Singleton
    public DeleteCommentLogicInterface provideDeleteCommentLogicInterface(DeleteCommentDataInterface deleteComment){
        return new DeleteCommentLogicImpl(deleteComment, view);
    }
}