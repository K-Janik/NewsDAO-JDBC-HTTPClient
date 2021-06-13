package pl.springboot2.karoljanik.newsapi.dao;

import pl.springboot2.karoljanik.newsapi.model.PersonInfo;

import java.util.List;

public interface InfoDao {

    void insertInfo(PersonInfo personInfo);

    List<PersonInfo> getAllInfos();

    void editById(int id, PersonInfo personInfo);
}
