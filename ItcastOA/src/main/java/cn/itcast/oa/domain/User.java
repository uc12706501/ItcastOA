package cn.itcast.oa.domain;

import javax.persistence.*;

/**
 * Created by lkk on 2014/11/5.
 */
@Entity
@Table(name = "itcastoa_user")
public class User {
    private long id;

    private String name;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
