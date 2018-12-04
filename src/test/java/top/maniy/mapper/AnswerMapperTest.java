package top.maniy.mapper;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.maniy.entity.Answer;

import static org.junit.Assert.*;

/**
 * @author liuzonghua
 * @Package top.maniy.mapper
 * @Description:
 * @date 2018/10/29 11:00
 */
//帮我们创建容器
@RunWith(SpringJUnit4ClassRunner.class)
//指定创建容器是使用那些配置文件
@ContextConfiguration(locations = {"classpath*:/spring/spring-*.xml"})
public class AnswerMapperTest {

    @Autowired
    private AnswerMapper answerMapper;
    @Test
    public void findAnswerByQuesId() {
        System.out.println(answerMapper.findAnswerByQuesId(1).size());
    }

    @Test
    public void findAnswerByUserId() {
    }

    @Test
    public void findAnswerById() {
    }

    @Test
    public void saveAnswer() {
        Answer answer =new Answer();
        answer.setUserId(1);
        answer.setQuesId(1);
        answer.setPhoto("xxx.jpg");
        answer.setAnswerContent("  有一个学长，警校毕业以后工作。女朋友劈腿了，他失魂落魄的出门，眼前正好跑过一个男人，紧接着是女人追着哭求“抓小偷”。\n" +
                "                学长二话不说，追上去一招擒拿，把小偷摁在地上。中年妇女拿回了钱包，路过的行人迅速围观。\n" +
                "                学长说，报警吧。\n" +
                "                妇女说，东西拿回来了就行，那多麻烦，放他走吧。\n" +
                "                路人说，小伙子不要多管闲事，以后他记恨你嘞。\n" +
                "                被摁在地上的男人眉目沉郁，隐藏着凶悍的暴戾。\n" +
                "                学长腾出一只手来打电话，妇女拿着钱包偷偷溜走，围观者三三两两的散开。");
        answerMapper.saveAnswer(answer);
    }

    @Test
    public void updateAnswer() {
    }

    @Test
    public void deleteAnswer() {
    }
}