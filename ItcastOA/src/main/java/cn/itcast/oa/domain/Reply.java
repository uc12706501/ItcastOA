package cn.itcast.oa.domain;

/**
 * Created by lkk on 2014/11/14.
 */
public class Reply extends Article {
    private Topic topic;

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
