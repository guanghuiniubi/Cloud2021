package commons.util;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class BaseEntity<T extends BaseEntity> extends Model<T> implements Serializable, Cloneable {


    @TableField(value = "create_time", exist = true)
    private String create_time;

    @TableField(value = "update_time", exist = true)
    private String update_time;

    @JsonIgnore
    @TableField(value = "create_by", exist = true)
    private String create_by;

    @JsonIgnore
    @TableField(value = "update_by", exist = true)
    private String update_by;


    @TableField(value = "deleted")
    private int deleted;


    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public void setUpdate_by(String update_by) {
        this.update_by = update_by;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public String toString() {
        return "BaseEntity(create_time=" + getCreate_time() + ", update_time=" + getUpdate_time() + ", create_by=" + getCreate_by() + ", update_by=" + getUpdate_by() + ", deleted=" + isDeleted() + ")";
    }

    /* 15 */
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof BaseEntity)) return false;
        BaseEntity<?> other = (BaseEntity) o;
        if (!other.canEqual(this)) return false;
        if (!super.equals(o)) return false;
        if (getCreate_time() != other.getCreate_time()) return false;
        if (getUpdate_time() != other.getUpdate_time()) return false;
        if (getCreate_by() != other.getCreate_by()) return false;
        if (getUpdate_by() != other.getUpdate_by()) return false;
        return isDeleted() == other.isDeleted();
    }

    protected boolean canEqual(Object other) {
        return other instanceof BaseEntity;
    }


    public String getCreate_time() {

        return this.create_time;

    }


    public String getUpdate_time() {

        return this.update_time;

    }


    public String getCreate_by() {

        return this.create_by;

    }


    public String getUpdate_by() {

        return this.update_by;

    }


    public int isDeleted() {

        return this.deleted;

    }

    public void before() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String createTime = sdf.format(date);
        this.create_time = createTime;
    }


}


