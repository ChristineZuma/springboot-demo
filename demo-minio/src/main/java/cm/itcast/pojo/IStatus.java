package cm.itcast.pojo;

/**
 * <p>
 * REST API 错误码接口
 * </p>
 *
 * @author lisong
 * @date Created in 2022-12-25
 */
public interface IStatus {

    /**
     * 状态码
     *
     * @return 状态码
     */
    Integer getCode();

    /**
     * 返回信息
     *
     * @return 返回信息
     */
    String getMessage();

}