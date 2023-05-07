package cn.itcast.pojo;

import lombok.Data;

/**
 * @description: user
 * @author: lisong
 * @since: 2023-04-15 22:34
 **/
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
