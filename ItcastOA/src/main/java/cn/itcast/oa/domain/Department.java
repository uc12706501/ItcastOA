package cn.itcast.oa.domain;

import javax.persistence.*;

/**
 * Created by lkk on 2014/11/7.
 */
@Entity
@Table(name = "itcastoa_department")
public class Department {
    private Long id;
    private String name;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
