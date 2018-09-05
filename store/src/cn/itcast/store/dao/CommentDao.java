package cn.itcast.store.dao;

import java.sql.SQLException;
import java.util.List;

import cn.itcast.store.domain.Comment;

public interface CommentDao {

	void deleteComment(String cid)throws SQLException;

	void addComment(Comment comment)throws SQLException;

	Comment getComment(String pid)throws SQLException;

	int star_diss(String cid, int star_or_diss)throws SQLException;

}
