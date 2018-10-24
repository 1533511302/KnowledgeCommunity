package top.maniy.mapper;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.maniy.entity.Question;

import static org.junit.Assert.*;

/**
 * @author liuzonghua
 * @Package top.maniy.mapper
 * @Description:
 * @date 2018/10/24 15:54
 */
//帮我们创建容器
@RunWith(SpringJUnit4ClassRunner.class)
//指定创建容器是使用那些配置文件
@ContextConfiguration(locations = {"classpath*:/spring/spring-*.xml"})

public class QuestionMapperTest {

    @Autowired
    private QuestionMapper questionMapper;

    @Test
    public void findQuestionByTopicId() {
        System.out.println(questionMapper.findQuestionByTopicId("1").size());
    }

    @Test
    public void findQuestionByUserId() {
        System.out.println(questionMapper.findQuestionByUserId(6).size());
    }

    @Test
    public void findQuestionLikeQuesName() {
        System.out.println(questionMapper.findQuestionLikeQuesName("lpl").size());
    }

    @Test
    public void findQuestionById() {
        System.out.println(questionMapper.findQuestionById(1));
    }

    @Test
    public void saveQuestion() {
        Question question =new Question();
        question.setTopicId("1");
        question.setUserId(6);
        question.setQuesName("uzi和厂长哪个是lpl排名");
        question.setQuesDescribe("uzi和厂长哪个是lpl排名");
        question.setPhoto("xxx.jpg");
        questionMapper.saveQuestion(question);



    }

    @Test
    public void updateQuestion() {
        Question question =new Question();
        question.setId(1);
        question.setQuesDescribe("uzi人气大减，跌落神坛");
        question.setPhoto("xxxxx.jpg");
        questionMapper.updateQuestion(question);
    }

    @Test
    public void deleteQuestion() {
        questionMapper.deleteQuestion(13);
    }
}