package com.yang.dior;

import com.yang.dior.core.PageBean;
import com.yang.dior.model.Product;
import com.yang.dior.request.ProductRequest;
import com.yang.dior.service.ProductService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/***
 *
 * @Author zhangjiqiang
 * @Description
 * @Date 2018-12-06 20:41
 *
 ***/
public class ProductTest extends DiorApplicationTests {

    @Autowired
    private ProductService productService;

    @Test
    public void saveProduct() {
        ProductRequest request =new ProductRequest();
        request.setName("安然纳米腹带");
        request.setSimpleName("腹带");
        request.setPrice(BigDecimal.valueOf(360));
        productService.saveOrUpdate(request);
    }

    @Test
    public void list() {
        ProductRequest request = new ProductRequest();
        request.setPage(0);
        request.setLimit(2);
        PageBean<Product> list = productService.list(request);
        System.out.println(list);
    }
}
