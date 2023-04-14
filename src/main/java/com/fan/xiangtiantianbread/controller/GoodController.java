package com.fan.xiangtiantianbread.controller;

import cn.hutool.core.io.resource.InputStreamResource;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fan.xiangtiantianbread.mapper.GoodMapper;
import com.fan.xiangtiantianbread.pojo.Good;
import com.fan.xiangtiantianbread.service.GoodService;
import com.fan.xiangtiantianbread.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/good")
@CrossOrigin
public class GoodController {

    @Autowired
    private GoodService goodService;

    @Autowired
    private GoodMapper goodMapper;

    /**
     * 获取今日商品贩卖情况,逆序返回商品ID和今日贩卖数量
     *
     * @return
     */
    @GetMapping("/getTodaySaleGood/{page}")
    public Result getTodaySaleGood(@PathVariable Integer page) {
        return Result.success(goodService.getTodaySaleGood(page));
    }

    @GetMapping("/getTodaySaleGoodTotal")
    public Result getTodaySaleGoodTotal() {
        return Result.success(goodService.getTodaySaleGoodTotal());
    }


    @GetMapping("/getGoodList/{current}")
    public Result getGoodList(@PathVariable Integer current) {
        List<Good> goodList = goodService.getGoodIPage(current, null).getRecords();
        return Result.success(goodList);
    }

    @GetMapping("/getGoodListByType/{current}/{type}")
    public Result getGoodListByType(@PathVariable Integer current, @PathVariable String type) {
        LambdaQueryWrapper<Good> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Good::getType, type);
        List<Good> goodList = goodService.getGoodIPage(current, wrapper).getRecords();
        return Result.success(goodList);
    }


    /**
     * 获取折扣商品
     *
     * @param current
     * @return
     */
    @GetMapping("/getDiscountGoodList/{current}")
    public Result getDiscountGoodList(@PathVariable Integer current) {
        LambdaQueryWrapper<Good> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Good::getIsDiscount, 1);
        Page<Good> goodPage = new Page<>(current, 5);
        Page<Good> page = goodService.page(goodPage, wrapper);
        List<Good> goodList = page.getRecords();
        Long total = page.getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("goodList", goodList);
        return Result.success(map);
    }


    /**
     * 获取新品商品
     *
     * @param current
     * @return
     */
    @GetMapping("/getNewGoodList/{current}")
    public Result getNewGoodList(@PathVariable Integer current) {
        LambdaQueryWrapper<Good> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Good::getIsNew, 1);
        Page<Good> goodPage = new Page<>(current, 5);
        Page<Good> page = goodService.page(goodPage, wrapper);
        List<Good> goodList = page.getRecords();
        Long total = page.getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("goodList", goodList);
        return Result.success(map);
    }

    @GetMapping("/getBreadTotal")
    public Result getBreadTotal() {
        return Result.success(goodService.getBreadTotal());
    }

    @GetMapping("/getCakeTotal")
    public Result getCakeTotal() {
        return Result.success(goodService.getCakeTotal());
    }

    @DeleteMapping("/deleteGood/{id}")
    public Result deleteGood(@PathVariable Integer id) {
        return Result.success(goodService.removeById(id));
    }

    @PutMapping("/updateGood")
    public Result updateGood(@RequestBody Good good) {
        return Result.success(goodService.updateById(good));
    }

    @PostMapping("/upload")
    public Result upload(@RequestParam("file") MultipartFile file,
                         @RequestParam(value = "id", required = false) Integer id,
                         @RequestParam("goodName") String goodName,
                         @RequestParam("type") String type,
                         @RequestParam("sweetness") String sweetness,
                         @RequestParam("price") BigDecimal price,
                         @RequestParam("nowPrice") BigDecimal nowPrice,
                         @RequestParam("description") String description) {
        String resp = null;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("file", new InputStreamResource(file.getInputStream(), file.getOriginalFilename()));
            params.put("output", "json2");
            resp = HttpUtil.post("http://localhost:21730/group1/upload", params);
            Map fastdfsData = JSON.parseObject(JSON.parseObject(resp, Map.class).get("data").toString(), Map.class);
            String domain = fastdfsData.get("domain").toString();
            String src = fastdfsData.get("src").toString();
            String url = domain + src;
            Good good = new Good();
            good.setImage(url);
            good.setGoodName(goodName);
            good.setDescription(description);
            good.setId(id);
            good.setType(type);
            good.setSweetness(sweetness);
            good.setPrice(price);
            good.setNowPrice(nowPrice);
            good.setGoodName(goodName);
            System.out.println(good.getId());
            goodService.saveOrUpdate(good);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return Result.success(resp);
    }

}
