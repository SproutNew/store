package cn.itcast.store.domain;

public class Comment {
	public final static int STAR = 0;
	public final static int DISS = 1;
	
	private String cid;
	private String pid;
	private String nickname;
	private String content;
	private String time;
	private  int star ;
	private  int diss;
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public int getDiss() {
		return diss;
	}
	public void setDiss(int diss) {
		this.diss = diss;
	}
	
	public Comment() {
		
	}
	@Override
	public String toString() {
		return "Comment [cid=" + cid + ", pid=" + pid + ", nickname=" + nickname + ", content=" + content + ", time="
				+ time + ", star=" + star + ", diss=" + diss + "]";
	}
	public Comment(String cid, String pid, String nickname, String content, String time, int star, int diss) {
		super();
		this.cid = cid;
		this.pid = pid;
		this.nickname = nickname;
		this.content = content;
		this.time = time;
		this.star = star;
		this.diss = diss;
	}
	
}
