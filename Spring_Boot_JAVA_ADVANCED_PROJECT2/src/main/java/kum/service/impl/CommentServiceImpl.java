package kum.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kum.entity.Cafe;
import kum.entity.Comment;
import kum.model.request.CommentRequest;
import kum.model.view.CommentView;
import kum.repository.CafeRepository;
import kum.repository.CommentRepository;
import kum.repository.MealRepository;
import kum.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	private final CommentRepository commentRepository;
	
	private final CafeRepository cafeRepository;
	
	private final MealRepository mealRepository;
	
	@Autowired
	public CommentServiceImpl(CommentRepository commentRepository, CafeRepository cafeRepository, MealRepository mealRepository) {
		this.commentRepository=commentRepository;
		this.cafeRepository=cafeRepository;
		this.mealRepository = mealRepository;
	}

	@Override
	public List<CommentView> findAllCommentByCafeId(Integer id) {
		return commentRepository.findCommentByCafeId(id);
	}

	@Override
	public List<CommentView> findAllCommentByMealId(Integer id) {
		return commentRepository.findCommentByMealId(id);
	}

	@Override
	public void saveCommentToCafe(CommentRequest commentRequest, Integer id) {
		Comment comment = new Comment();
		if(!commentRequest.getMessage().isEmpty()){
		comment.setMessage(commentRequest.getMessage());
		comment.setTime(LocalDateTime.now());
		comment.setRate(new BigDecimal(commentRequest.getRate()));
		comment.setUser(commentRequest.getUser());
		comment.setCafe(cafeRepository.findOne(id));
		commentRepository.save(comment);
		updadeCafeRate(id);}
		else{
			comment.setUser(commentRequest.getUser());
			comment.setRate(new BigDecimal(commentRequest.getRate()));
			comment.setCafe(cafeRepository.findOne(id));
			commentRepository.save(comment);
			updadeCafeRate(id);
			}
	}
	
	private void updadeCafeRate(Integer id){
		BigDecimal rate = BigDecimal.ZERO;
		int count = 0;
		for(CommentView commentView : findAllCommentByCafeId(id)){
			if(commentView.getRate()!=null){
				rate = rate.add(commentView.getRate());
				count++;
			}
		}
		Cafe cafe = cafeRepository.findOne(id);
		cafe.setRate(rate.divide(new BigDecimal(count), RoundingMode.HALF_DOWN));
		cafeRepository.save(cafe);
	}

	@Override
	public void saveCommentToMeal(CommentRequest commentRequest, Integer id) {
		Comment comment = new Comment();
		comment.setMessage(commentRequest.getMessage());
		comment.setTime(LocalDateTime.now());
		comment.setUser(commentRequest.getUser());
		comment.setMeal(mealRepository.findOneReqeust(id));
		commentRepository.save(comment);
	}

	@Override
	public List<Comment> findAll(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveCommentToCommentCafe(CommentRequest commentRequest, Integer idComment) {
		Comment comment = new Comment();
 		comment.setParentComent(commentRepository.findOneRequest(idComment)); 
 		comment.setMessage(commentRequest.getMessage());
		comment.setUser(commentRequest.getUser());
		comment.setTime(LocalDateTime.now());
 		commentRepository.save(comment);

	}

	@Override
	@Transactional(readOnly=true)
	public List<CommentView> findAllToCafe(Integer id) {
		List<CommentView> list = findAllCommentByCafeId(id);
		 		loadChildComments(list);
		 		return list;
		
	}

	private void loadChildComments(List<CommentView> commentViews) {
		 		for (CommentView commentView : commentViews) {
		 			List<CommentView> commentViews2 = commentRepository.findAllCommentsByParent(commentView.getId());
		 			loadChildComments(commentViews2);
		 			commentView.setChildComment(commentViews2); 
		 		}	
	}

	@Override
	public void saveCommentToCommentMeal(CommentRequest commentRequest, Integer idComment) {
		Comment comment = new Comment();
 		comment.setParentComent(commentRepository.findOneRequest(idComment)); 
 		comment.setMessage(commentRequest.getMessage());
		comment.setUser(commentRequest.getUser());
		comment.setTime(LocalDateTime.now());
 		commentRepository.save(comment);
	}

	@Override
	public List<CommentView> findAllToMeal(Integer id) {
		List<CommentView> list = findAllCommentByMealId(id);
 		loadChildComments(list);
 		return list;

	}
}