package cn.itcast.oa.domain;

import javax.persistence.*;


/**
 * Created by lkk on 2014/11/6.
 */
@Entity
@Table(name = "itcastoa_role")
public class Role {
    long id;

    String name;

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

    @Column
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    String description;

}
