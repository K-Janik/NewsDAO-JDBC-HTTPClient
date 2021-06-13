package pl.springboot2.karoljanik.newsapi.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import pl.springboot2.karoljanik.newsapi.model.PersonInfo;

import java.util.List;
import java.util.Optional;

@Repository("InfoDAO")
public class InfoRepository implements InfoDao {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public InfoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public PersonInfo getInfo() {
        RestTemplate restTemplate = new RestTemplate();
        PersonInfo personInfo = restTemplate.getForObject("http://numbersapi.com/random/date?json", PersonInfo.class);
        return personInfo;
    }

    @Override
    public void insertInfo(PersonInfo personInfo) {
        final String sql="INSERT INTO info VALUES (?,?)";
        jdbcTemplate.update(sql, new Object[]{
                getInfo().getNumber(),
                getInfo().getText()
        });

    }

    @Override
    public List<PersonInfo> getAllInfos() {
        final String sql = "SELECT * FROM info";
        return jdbcTemplate.query(sql,(resultSet, i) ->{
            int infoId = resultSet.getInt("id");
            String text = resultSet.getString("info");
            return new PersonInfo(infoId,text);
        } );
    }

    @Override
    public void editById(int id, PersonInfo personInfo) {
        final String sql = "UPDATE info SET info=? WHERE id=?";
        jdbcTemplate.update(sql,personInfo.getText(),id);
    }
}
