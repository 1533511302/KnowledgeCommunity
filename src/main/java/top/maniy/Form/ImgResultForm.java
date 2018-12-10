package top.maniy.Form;

/**
 * @author liuzonghua
 * @Package top.maniy.Form
 * @Description:
 * @date 2018/12/10 15:33
 */
public class ImgResultForm {

    private int error;//错误代码

    private String[] data;//存放数据

    public ImgResultForm(int error, String[] data) {
        this.error = error;
        this.data = data;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }
}
