package com.example.demo.paper.controller;

import com.example.demo.paper.entity.PaperClassification;
import com.example.demo.paper.service.PaperClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paperClassification")
public class PaperClassificationController {
    @Autowired
    private PaperClassificationService paperClassificationService;
    @RequestMapping("/edit")
    public void edit(PaperClassification paperClassification){
        paperClassificationService.edit(paperClassification);
    }
    @RequestMapping("/delete")
    public void delete(long id){
        paperClassificationService.deleteByPrimaryKey(id);
    }


}
