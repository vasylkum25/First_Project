package kum.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kum.entity.Comment;
import kum.model.view.CommentView;

public interface CommentRepository extends JpaRepository<Comment, Integer>{

	@Query("SELECT new kum.model.view.CommentView(comment.id, comment.message, comment.time, comment.rate, comment.user) FROM Comment comment JOIN comment.cafe cafe WHERE cafe.id=?1")
	List<CommentView> findCommentByCafeId(Integer id);

	@Query("SELECT new kum.model.view.CommentView(comment.id, comment.message, comment.time, comment.rate, comment.user) FROM Comment comment JOIN comment.meal meal WHERE meal.id=?1")
	List<CommentView> findCommentByMealId(Integer id);

	@Query("SELECT DISTINCT c FROM Comment c WHERE c.id=?1")
	Comment findOneRequest(Integer idComment);

	@Query("SELECT new kum.model.view.CommentView(comment.id, comment.message, comment.time, comment.rate, comment.user) FROM Comment comment WHERE parentComent.id=?1")
	List<CommentView> findAllCommentsByParent(Integer id);

}
