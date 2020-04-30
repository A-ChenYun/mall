package com.chen.mall.service.impl;

import com.chen.mall.consts.MallConst;
import com.chen.mall.dao.CategoryMapper;
import com.chen.mall.pojo.Category;
import com.chen.mall.service.ICategoryService;
import com.chen.mall.vo.CategoryVo;
import com.chen.mall.vo.ResponseVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
@Transactional
@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public ResponseVo<List<CategoryVo>> selectAll() {

        List<Category> categories = categoryMapper.selectAll();
        List<CategoryVo> categoryVoList = new ArrayList<>();

        for (Category category : categories){
            if(category.getParentId().equals(MallConst.ROOT_PARRENT_ID)){

                categoryVoList.add(category2categoryVo(category));
                categoryVoList.sort(Comparator.comparing(CategoryVo::getSortOrder).reversed());
            }
        }
        findSubCategory(categoryVoList,categories);
        return ResponseVo.success(categoryVoList);

    }
    public void findSubCategory(List<CategoryVo> categoryVoList, List<Category> categories){
        for(CategoryVo categoryVo : categoryVoList){
            List<CategoryVo> subCategoryVoList = new ArrayList<>();
            //全数据库查找
            for(Category category :categories){
                //如果查到继续查
               if ( categoryVo.getId().equals(category.getParentId())){
                   CategoryVo subCategoryVo = category2categoryVo(category);
                   subCategoryVoList.add(subCategoryVo);
               }
               //排序

                subCategoryVoList.sort(Comparator.comparing(CategoryVo::getSortOrder).reversed());

               categoryVo.setSubCategories(subCategoryVoList);
                //查到继续查
                findSubCategory(subCategoryVoList,categories);
            }
        }

    }

    private CategoryVo category2categoryVo(Category category){
        CategoryVo categoryVo = new CategoryVo();
        BeanUtils.copyProperties(category,categoryVo);
        return categoryVo;
    }

    //子类id查询
    @Override
    public void findSubCategoryId(Integer id, Set<Integer> resultSet) {
        List<Category> categories = categoryMapper.selectAll();
        findSubCategoryId(id,resultSet,categories);

    }
    //遍历父id与子id，找出父子id相关联的
    private void findSubCategoryId(Integer id, Set<Integer> resultSet, List<Category> categories) {
        for(Category category: categories){
            if(  category.getParentId().equals(id)){
                resultSet.add(category.getId());
                findSubCategoryId(category.getId(), resultSet,categories);
            }
        }
    }




    }
