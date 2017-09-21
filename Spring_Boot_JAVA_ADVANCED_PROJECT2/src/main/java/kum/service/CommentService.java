package kum.service;

import java.util.List;

import kum.model.request.CommentRequest;
import kum.model.view.CommentView;

public interface CommentService {

	
	List<CommentView> findCommentByCafeId( Integer id);
	
	List<CommentView> findCommentByMealId( Integer id);
	
	void saveCommentToMeal(CommentRequest commentRequest, Integer id);

	void saveCommentToCafe(CommentRequest commentRequest, Integer id);
}
