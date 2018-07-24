package com.my.sample.mongo;

import com.mongodb.client.result.UpdateResult;
import com.my.sample.dao.repository.ArticleRepository;
import com.my.sample.entity.document.Article;
import com.my.sample.entity.document.Auth;
import com.my.sample.entity.document.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.query.Update.update;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExampleMongoApplicationTests {

    @Resource
    ArticleRepository articleRepository;

    @Resource
    MongoTemplate mongoTemplate;

    @Test
    public void contextLoads() {
    }

    @Test
    public void mongo() {
        Article article = new Article();
        article.setSn("1827364");
        article.setTitle("编码随笔");
        article.setContent("NoSQL stores have taken the storage world by storm. It is a vast domain with a plethora of solutions, terms, and patterns (to make things worse, even the term itself has multiple meanings). While some of the principles are common, you must be familiar with MongoDB to some degree. The best way to get acquainted is to read the documentation and follow the examples. It usually does not take more then 5-10 minutes to go through them and, especially if you are coming from an RDMBS-only background, these exercises can be an eye opener.");
        article.setModifyTime(new Date());
        article.setCreateTime(new Date());
        article.setPrice(0.01d);
        Auth auth = new Auth();
        auth.setName("shiyongbiao");
        auth.setSex(1);
        auth.setBirthDay(LocalDate.of(1988, 9, 4));
        article.setAuth(auth);
        List<Comment> comments = new ArrayList<>();

        Comment comment = new Comment();
        comment.setUserId("1001");
        comment.setContent("写得啥玩意");
        comment.setCreateTime(new Date());
        comment.setModifyTime(new Date());

        comments.add(comment);
        article.setComments(comments);
        articleRepository.insert(article);
    }

    @Test
    public void queryDoc() {
        Article a = articleRepository.findOneBySn("1827364");
        System.out.println(a);
    }

    @Test
    public void updateDoc() {
        UpdateResult r = mongoTemplate.updateFirst(query(where("sn").is("1827364")), update("price", 0.02d), Article.class);
        long count = r.getModifiedCount();
        System.out.println("更新数量：" + count);
    }

    @Test
    public void updateSubDoc() {
        UpdateResult r = mongoTemplate.updateFirst(query(where("sn").is("1827364")), update("auth.name", "shiyongbiao"), Article.class);
        long count = r.getModifiedCount();
        System.out.println("更新数量：" + count);
    }

}
