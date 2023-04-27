package com.youssef.miniprojet.services;

import com.youssef.miniprojet.entities.Singer;
import com.youssef.miniprojet.repos.SingerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SingerServiceImpl implements SingerService {
    @Autowired
    private SingerRepository SingerRepository;
    @Override
    public Singer saveSinger(Singer album) {
        return SingerRepository.save(album);
    }

    @Override
    public Singer updateSinger(Singer album) {
        return SingerRepository.save(album);
    }

    @Override
    public void deleteSinger(Singer album) {
        SingerRepository.delete(album);
    }

    @Override
    public void deleteSingerById(Long id) {
        SingerRepository.deleteById(id);
    }

    @Override
    public Singer getSinger(Long id) {
        return SingerRepository.findById(id).get();
    }

    @Override
    public List<Singer> getAllSingers() {
        return SingerRepository.findAll();
    }

    @Override
    public Page<Singer> getAllSingerByPage(int page, int size) {
        return SingerRepository.findAll(PageRequest.of(page, size));
    }
}
