package com.ross.feehan.commentsdvldemoapp.Features.PostComments; /*
 * Created by Ross Feehan on 18/01/2017.
 */

import com.ross.feehan.commentsdvldemoapp.Shared.SharedPreferences.CommentsSharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(injects = PostCommentActivity.class, complete = false)
public class PostCommentDIModule {

    private PostCommentViewInterface view;

    //CONSTRUCTOR
    public PostCommentDIModule(PostCommentViewInterface view) {
        this.view = view;
    }

    @Provides @Singleton
    public PostCommentDataInterface providePostCommentDataInterface(CommentsSharedPreferences commentsSP){
        return new PostCommentDataImpl(commentsSP);
    }

    @Provides @Singleton
    public PostCommentLogicInterface providePostCommentsLogicInterface(PostCommentDataInterface postCommentData){
        return new PostCommentLogicImpl(postCommentData, view);
    }
}
