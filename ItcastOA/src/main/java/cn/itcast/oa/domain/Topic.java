package cn.itcast.oa.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lkk on 2014/11/14.
 */
public class Topic extends Article {
    public static final int TYPE_NORMAL = 0;
    public static final int TYPE_BEST = 1;
    public static final int TYPE_TOP = 2;

    private Forum forum;//所属板块
    private Set<Reply> replies = new HashSet<Reply>();

    private int type;//类型
    private int replyCount;//回复数量
    private Reply lastReply;//最后回复
    private Date lastUpdateTime;//最后更新

    public Forum getForum() {
        return forum;
    }

    public void setForum(Forum forum) {
        this.forum = forum;
    }

    public Set<Reply> getReplies() {
        return replies;
    }

    public void setReplies(Set<Reply> replies) {
        this.replies = replies;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }

    public Reply getLastReply() {
        return lastReply;
    }

    public void setLastReply(Reply lastReply) {
        this.lastReply = lastReply;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}
