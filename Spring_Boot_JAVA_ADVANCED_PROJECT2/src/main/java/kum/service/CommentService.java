package kum.service;

import java.util.List;

import kum.entity.Comment;
import kum.model.request.CommentRequest;
import kum.model.view.CommentView;

public interface CommentService {

	
	List<CommentView> findAllCommentByCafeId( Integer id);
	
	List<CommentView> findAllCommentByMealId( Integer id);
	
	void saveCommentToMeal(CommentRequest commentRequest, Integer id);

	void saveCommentToCafe(CommentRequest commentRequest, Integer id);
	
	List<Comment> findAll(Integer id);

	void saveCommentToCommentCafe(CommentRequest commentRequest, Integer idComment);
	
	void saveCommentToCommentMeal(CommentRequest commentRequest, Integer idComment);

	List<CommentView> findAllToCafe(Integer id);

	List<CommentView> findAllToMeal(Integer id);
}
