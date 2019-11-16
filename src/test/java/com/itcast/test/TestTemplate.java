package com.itcast.test;


import com.item.pojo.TbItem;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-tx.xml")
public class TestTemplate {

    @Autowired
    private SolrTemplate solrTemplate;

    @Test
    public void testAdd(){
        TbItem item = new TbItem();
        item.setId(11L);
        item.setTitle("华为METE10");
        item.setCategory("手机");
        item.setBrand("华为");
        item.setSeller("华为旗舰店");
        item.setGoodsId(1L);
        item.setPrice(new BigDecimal(3000.01));
        solrTemplate.saveBean(item);
        solrTemplate.commit();
    }

    @Test
    public void findById(){
        TbItem byId = solrTemplate.getById(10L, TbItem.class);
        System.out.println(byId.getTitle());
    }

    @Test
    public void deleteById(){
         solrTemplate.deleteById("11");
         solrTemplate.commit();
    }

}


