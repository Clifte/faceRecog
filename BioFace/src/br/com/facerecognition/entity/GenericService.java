package br.com.facerecognition.entity;
import javax.ejb.Local;

@Local
public interface GenericService {
    public <T> T createOrUpdate(T obj);
    public <T> void remove(T obj);
    public <T> T find(Object obj);
} 