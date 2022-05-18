package ru.avevdokimov.home.newmoney.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.avevdokimov.home.newmoney.model.KindOfExpenditure;
import ru.avevdokimov.home.newmoney.model.KindOfIncome;
import ru.avevdokimov.home.newmoney.repo.KindOfExpenditureDao;
import ru.avevdokimov.home.newmoney.repo.KindOfIncomeDao;

import java.util.Comparator;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final KindOfIncomeDao kindOfIncomeDao;
    private final KindOfExpenditureDao kindOfExpenditureDao;

    @GetMapping("/money/kindofincome")
    public String kindOfIncome (Model model, @RequestParam(required = false) Long id) {
        List<KindOfIncome> list = kindOfIncomeDao.findAll();
        list.sort(Comparator.comparingLong(KindOfIncome::getId));
        model.addAttribute("kindOfIncomeList" ,list);
        if (id != null) {
            KindOfIncome kindOfIncome = kindOfIncomeDao.getById(id);
            if (kindOfIncome != null) {
                model.addAttribute("recordId" ,id);
                model.addAttribute("element" ,kindOfIncome);
            } else {
                model.addAttribute("recordId" ,-1L);
            }
        } else {
            model.addAttribute("recordId" ,-1L);
        }
        return "kindofincome";
    }

    @PostMapping("/money/kindofincome/create")
    public String createKindOfIncome(KindOfIncome kindOfIncome) {
        kindOfIncomeDao.save(kindOfIncome);
        return "redirect:/money/kindofincome";
    }

    @GetMapping("/money/kindofincome/delete/{id}")
    public String deleteKindOfIncome(@PathVariable Long id) {
        KindOfIncome kindOfIncome = kindOfIncomeDao.findById(id).orElse(null);
        if (kindOfIncome != null) {
            kindOfIncomeDao.deleteById(kindOfIncome.getId());
        }
        return "redirect:/money/kindofincome";
    }

    @GetMapping("/money/kindofexpenditure")
    public String kindOfExpenditure (Model model, @RequestParam(required = false) Long id) {
        List<KindOfExpenditure> list = kindOfExpenditureDao.findAll();
        list.sort(Comparator.comparingLong(KindOfExpenditure::getId));
        model.addAttribute("kindOfExpenditureList" ,list);
        if (id != null) {
            KindOfExpenditure kindOfExpenditure = kindOfExpenditureDao.getById(id);
            if (kindOfExpenditure != null) {
                model.addAttribute("recordId" ,id);
                model.addAttribute("element" ,kindOfExpenditure);
            } else {
                model.addAttribute("recordId" ,-1L);
            }
        } else {
            model.addAttribute("recordId" ,-1L);
        }
        return "kindofexpenditure";
    }

    @PostMapping("/money/kindofexpenditure/create")
    public String createKindOfExpenditure(KindOfExpenditure kindOfExpenditure) {
        kindOfExpenditureDao.save(kindOfExpenditure);
        return "redirect:/money/kindofexpenditure";
    }

    @GetMapping("/money/kindofexpenditure/delete/{id}")
    public String deleteKindOfExpenditure(@PathVariable Long id) {
        KindOfExpenditure kindOfExpenditure = kindOfExpenditureDao.findById(id).orElse(null);
        if (kindOfExpenditure != null) {
            kindOfExpenditureDao.deleteById(kindOfExpenditure.getId());
        }
        return "redirect:/money/kindofexpenditure";
    }

}
