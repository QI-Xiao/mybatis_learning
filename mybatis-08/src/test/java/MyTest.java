import com.kuang.dao.BlogMapper;
import com.kuang.pojo.Blog;
import com.kuang.utils.IdUtils;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MyTest {

    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IdUtils.getId());
        blog.setTitle("Mybatis is easy");
        blog.setAuthor("qx");
        blog.setCreateTime(new Date());
        blog.setViews(9833);
        mapper.addBlog(blog);

        blog.setId(IdUtils.getId());
        blog.setTitle("java is easy");
        mapper.addBlog(blog);

        blog.setId(IdUtils.getId());
        blog.setTitle("spring is easy");
        mapper.addBlog(blog);

        blog.setId(IdUtils.getId());
        blog.setTitle("micro service is easy");
        mapper.addBlog(blog);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void queryBlogIF(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        map.put("title", "java is easy");
        map.put("author", "qx");

        List<Blog> blogs = mapper.queryBlogIF(map);
        for(Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.close();
    }

    @Test
    public void queryBlogChoose(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        map.put("title", "java is easy");
//        map.put("author", "qx");
        map.put("views", 9833);

        List<Blog> blogs = mapper.queryBlogChoose(map);
        for(Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.close();
    }

    @Test
    public void updateBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        map.put("title", "java is easy222");
        map.put("author", "qx22");
        map.put("id", "6d042e1c91bb4f32a89059e093a1a810");
//        map.put("views", 9833);

        mapper.updateBlog(map);

        sqlSession.close();
    }

    @Test
    public void queryBlogForeach(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        ArrayList<String> ids = new ArrayList<String>();
        ids.add("6d042e1c91bb4f32a89059e093a1a810");
        ids.add("31dbafd772ae401fa2c8e9f1369a665e");
        map.put("ids", ids);

        List<Blog> blogs = mapper.queryBlogForeach(map);
        for(Blog blog : blogs){
            System.out.println(blog);
        }

        sqlSession.close();
    }
}
