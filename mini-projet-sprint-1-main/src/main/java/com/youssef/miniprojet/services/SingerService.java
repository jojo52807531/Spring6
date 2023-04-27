package com.youssef.miniprojet.services;

import com.youssef.miniprojet.entities.Singer;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SingerService {
    Singer saveSinger(Singer singer);
    Singer updateSinger(Singer singer);
    void deleteSinger(Singer singer);
    void deleteSingerById(Long id);
    Singer getSinger(Long id);
    List<Singer> getAllSingers();
    Page<Singer> getAllSingerByPage(int page, int size);
}
