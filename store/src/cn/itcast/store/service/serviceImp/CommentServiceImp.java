package cn.itcast.store.service.serviceImp;

import java.sql.SQLException;

import cn.itcast.store.dao.daoImp.CommentDaoImp;
import cn.itcast.store.domain.Comment;
import cn.itcast.store.dao.CommentDao;
import cn.itcast.store.service.CommentService;

public class CommentServiceImp implements CommentService{

	CommentDao CommentDao=new CommentDaoImp();
	
	@Override
	public void deleteComment(String cid) throws SQLException {
		CommentDao.deleteComment(cid);
	}

	@Override
	public void addComment(Comment comment) throws SQLException {
		CommentDao.addComment(comment);
	}

	@Override
	public Comment getComment(String pid) throws SQLException {
		return CommentDao.getComment(pid);
	}

	@Override
	public int star_diss(String cid, int star_or_diss) throws SQLException {
		return CommentDao.star_diss(cid, star_or_diss);
	}
}
