package com.youssef.miniprojet.controllers;

import com.youssef.miniprojet.entities.Singer;
import com.youssef.miniprojet.services.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class SingerController {
    @Autowired
    SingerService singerService;

    @RequestMapping("showCreate")
    public String showCreate() {
        return "createSinger";
    }

    @RequestMapping("/saveSinger")
    public String saveAlbum(
            @ModelAttribute("Singer") Singer singer,
            @RequestParam("Birthdate") String date,
            ModelMap modelMap
            ) throws ParseException {
        // Convert the date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date creationDate = dateFormat.parse(String.valueOf(date));
        singer.setBirthdate(creationDate);

        Singer savesinger = singerService.saveSinger(singer);
        String msg = "Singer saved with ID: " + savesinger.getSingerId();
        modelMap.addAttribute("msg", msg);
        return "redirect:/singerList";
    }

    @RequestMapping("/singerList")
    public String albumsList(
            ModelMap modelMap,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "2") int size
    ) {
        Page<Singer> singers = singerService.getAllSingerByPage(page, size);
        modelMap.addAttribute("singers", singers);
        modelMap.addAttribute("pages", new int[singers.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        return "listSinger";
    }

    @RequestMapping("/deleteSinger")
    public String deleteAlbum(
            @RequestParam("SingerId") Long SingerId,
            ModelMap modelMap,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "2") int size
    ) {
        singerService.deleteSingerById(SingerId);
        Page<Singer> singers = singerService.getAllSingerByPage(page, size);
        modelMap.addAttribute("singers", singers);
        modelMap.addAttribute("pages", new int[singers.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "listSinger";
    }

    @RequestMapping("/showUpdate")
    public String showUpdate(
            @RequestParam("SingerId") Long SingerId,
            ModelMap modelMap
    ) {
        Singer singer = singerService.getSinger(SingerId);
        modelMap.addAttribute("singer", singer);
        return "updateSinger";
    }

    @RequestMapping("/updatesinger")
    public String updateAlbum(
            @ModelAttribute("singer") Singer singer,
            @RequestParam("Birthdate") String date,
            ModelMap modelMap
    ) throws ParseException {
        // Convert the date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date creationDate = dateFormat.parse(String.valueOf(date));
        singer.setBirthdate(creationDate);
        singerService.updateSinger(singer);
        Page<Singer> singers = singerService.getAllSingerByPage(0, 2);
        modelMap.addAttribute("singers", singers);
        modelMap.addAttribute("pages", new int[singers.getTotalPages()]);
        modelMap.addAttribute("currentPage", 0);
        return "listSinger";
    }
}
