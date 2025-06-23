package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

/**
 * 处理 Item 实体的 Web 层控制器，提供 CRUD 接口。
 */
@Controller
@RequestMapping("/items")
public class ItemController {

    private final ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }

    /**
     * 显示所有条目列表。
     */
    @GetMapping
    public String list(Model model) {
        model.addAttribute("items", service.findAll());
        return "list";
    }

    /**
     * 显示创建新条目的表单。
     */
    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("item", new Item());
        return "form";
    }

    /**
     * 保存或更新条目。
     */
    @PostMapping
    public String save(@Valid Item item, BindingResult result) {
        if (result.hasErrors()) {
            return "form";
        }
        service.save(item);
        return "redirect:/items";
    }

    /**
     * 显示编辑指定条目的表单。
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        return service.findById(id)
                .map(item -> {
                    model.addAttribute("item", item);
                    return "form";
                })
                .orElse("redirect:/items");
    }

    /**
     * 删除指定条目。
     */
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/items";
    }
}
