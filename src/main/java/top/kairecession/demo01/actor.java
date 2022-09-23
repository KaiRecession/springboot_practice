package top.kairecession.demo01;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@ApiModel("演员类")
public class actor implements Serializable {
    @ApiModelProperty("演员id")
    private int actor_id;
    @ApiModelProperty("演员姓")
    private String first_name;
    private String last_name;
    private Date last_update;
    private String woc;
    private String woc1;
    private String woc2;
    private List<Hobby> hobbs;

    public actor() {
    }

    public int getActor_id() {
        return this.actor_id;
    }

    public void setActor_id(int actor_id) {
        this.actor_id = actor_id;
    }

    public String getFirst_name() {
        return this.first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return this.last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getLast_update() {
        return this.last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }

    public String getWoc() {
        return this.woc;
    }

    public void setWoc(String woc) {
        this.woc = woc;
    }

    public String getWoc1() {
        return this.woc1;
    }

    public void setWoc1(String woc1) {
        this.woc1 = woc1;
    }

    public String getWoc2() {
        return this.woc2;
    }

    public void setWoc2(String woc2) {
        this.woc2 = woc2;
    }

    public List<Hobby> getHobbs() {
        return this.hobbs;
    }

    public void setHobbs(List<Hobby> hobbs) {
        this.hobbs = hobbs;
    }

    public String toString() {
        return "actor{actor_id=" + this.actor_id + ", first_name='" + this.first_name + "', last_name='" + this.last_name + "', last_update=" + this.last_update + ", woc='" + this.woc + "', woc1='" + this.woc1 + "', woc2='" + this.woc2 + "', hobbs=" + this.hobbs + "}";
    }
}