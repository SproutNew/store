package cn.itcast.store.service;

import java.sql.SQLException;

import cn.itcast.store.domain.Comment;

public interface CommentService {
	
	void deleteComment(String cid)throws SQLException;

	void addComment(Comment comment)throws SQLException;

	Comment getComment(String pid)throws SQLException;

	int star_diss(String cid, int star_or_diss)throws SQLException;
}
