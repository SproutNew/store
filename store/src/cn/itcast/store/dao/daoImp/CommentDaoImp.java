package cn.itcast.store.dao.daoImp;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.store.dao.CommentDao;
import cn.itcast.store.utils.JDBCUtils;
import cn.itcast.store.domain.Comment;

public  class CommentDaoImp implements CommentDao {

	@Override
	public void deleteComment(String cid) throws SQLException {
		String sql = "DELETE FROM comment WHERE cid=" + cid;
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		qr.update(sql);
	}
	
	@Override
	public void addComment(Comment comment) throws SQLException {
		String sql = "INSERT  INTO comment VALUES(?,?,?,?,?,?,?)";
		Object[] params={comment.getCid(),comment.getPid(),comment.getNickname(),comment.getContent(),comment.getTime(),comment.getStar(),comment.getDiss()};
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		qr.update(sql,params);
	}

	@Override
	public Comment getComment(String pid) throws SQLException {
		String sql = "SELECT * FROM comment WHERE pid=? ORDER BY TIME";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanHandler<Comment>(Comment.class),pid);
	}

	@Override
	public int star_diss(String cid, int star_or_diss) throws SQLException {
		String sql;
		if (star_or_diss == Comment.STAR) {
			sql = "update comment set star=star+1 where cid=" + cid;
		} else if (star_or_diss == Comment.DISS) {
			sql = "update comment set diss=diss+1 where cid=" + cid;
		} else {
			return -1;
		}
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		if (star_or_diss == Comment.STAR) {
			sql = "SELECT star FROM comment WHERE cid = " + cid;
		} else if (star_or_diss == Comment.DISS) {
			sql = "SELECT diss FROM comment WHERE cid = " + cid;
		}
		qr.update(sql);
		return 0;
	}
}
