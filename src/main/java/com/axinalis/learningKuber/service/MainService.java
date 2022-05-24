package com.axinalis.learningKuber.service;

import com.axinalis.learningKuber.dao.MainRepository;
import com.axinalis.learningKuber.entity.NumberEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class MainService {

    private MainRepository repository;

    public MainService(@Autowired MainRepository repository) {
        this.repository = repository;
    }

    public String getPrimesAsString(Long value){
        repository.save(new NumberEntity(null, value));
        List<Integer> primes = new LinkedList<>();
        for(int i = 2; i <= value; i++){
            if(value % i == 0){
                primes.add(i);
                value /= i--;
            }
        }
        StringBuilder builder = new StringBuilder();
        int lastIndex = primes.size() - 1;
        for(int i = 0; i < lastIndex; i++){
            builder.append(primes.get(i)).append(", ");
        }
        builder.append(primes.get(lastIndex));
        return builder.toString();
    }

    public String getHistoryAsString(){
        StringBuilder builder = new StringBuilder();
        List<NumberEntity> requests = repository.findAll();

        int lastIndex = requests.size() - 1;
        for(int i = 0; i < lastIndex; i++){
            builder.append(requests.get(i).getValue()).append(", ");
        }
        builder.append(requests.get(lastIndex).getValue());
        return builder.toString();
    }

}
