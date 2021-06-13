package pl.springboot2.karoljanik.newsapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.springboot2.karoljanik.newsapi.dao.InfoDao;
import pl.springboot2.karoljanik.newsapi.model.PersonInfo;

import java.util.List;


@Service
public class InfoService {

    private InfoDao infoDao;

    @Autowired
    public InfoService(@Qualifier("InfoDAO") InfoDao infoDao) {
        this.infoDao = infoDao;
    }

    public void addInfo(PersonInfo personInfo) {
        infoDao.insertInfo(personInfo);
    }

    public List<PersonInfo> getAllInfos(){
        return infoDao.getAllInfos();
    }

    public void editInfo(int id, PersonInfo personInfo) {
        infoDao.editById(id, personInfo);
    }
}
