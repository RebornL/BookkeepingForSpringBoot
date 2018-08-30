package com.reborn.bookkeeping.controller;


import com.reborn.bookkeeping.entity.Category;
import com.reborn.bookkeeping.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {
    
    @Autowired
    private CategoryMapper categoryMapper;

    @RequestMapping("getAll")
    public List<Category> getAll() {
        List<Category> categoryEntities = categoryMapper.getAll();
//        System.out.println(categoryEntities.toString());
        return categoryEntities;
    }
    
    @RequestMapping("getAllCategory")
    public List<Category> getAllCategoryByUid(@RequestParam("uid") int uid) {
        return categoryMapper.getCategoryByUid(uid);
    }
    
    @RequestMapping("delCategory")
    public int deleteCategory(@RequestParam("id") Integer id, @RequestParam
            ("uid") Integer uid) {//从参数传进来都是String对象
//        System.out.println(id);
//        System.out.println(uid);
        //返回1成功,返回0失败
        return categoryMapper.delete(id, uid);
    }
//    @RequestMapping(value = "addCategory", method = RequestMethod.POST)
//    public void addCategory(@RequestParam("id") int id, @RequestParam
//            ("name") String name, @RequestParam("uid") int uid) {
//        System.out.println(id + name + uid);
//    }
    
    @PostMapping("addCategory")
    public void addCategory(@RequestBody Category category) {
        System.out.println(category);
        categoryMapper.add(category);
    }
}
