package commons.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import commons.util.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "payment")
public class Payment extends BaseEntity<Payment> implements Serializable {
    @TableId(value = "id")
    private long id;
    @TableField(value = "serial")
    private String serial;//交易序列号
}
