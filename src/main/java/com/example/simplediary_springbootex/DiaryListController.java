package com.example.simplediary_springbootex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class DiaryListController {

    private static final String user = "yeji";

    @Autowired
    private DiaryListRepository diaryListRepository;

    @RequestMapping(method= RequestMethod.GET)
    public String usersDiarys(Model model) {
        //List<Diary> diaryList = diaryListRepository.findByUser(user);
        List<Diary> diaryList = diaryListRepository.findAll();
        if (diaryList != null) {
            model.addAttribute("diarys", diaryList);
        }
        return "diaryList";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addToReadingList(Diary diary) {
        diary.setUser(user);
        diaryListRepository.save(diary);
        return "redirect:/";
    }

    /*@GetMapping(value = "/",produces = MediaType.APPLICATION_JSON_VALUE)
    public String usersDiarys(Model model){
        //List<Diary> diaryList = diaryListRepository.findByUser(user);
        List<Diary> diaryList = diaryListRepository.findAll();
        if(diaryList != null){
            model.addAttribute("diarys",diaryList);
        }
        System.out.println("Controller 실행");
        return "diayList";
    }

    @PostMapping(value = "/")
    public String addToReadingList(Diary diary){
        diary.setUser(user);
        diaryListRepository.save(diary);
        return "redirect:/";
    }*/
}
