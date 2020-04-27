package com.gself.study.jpattern;

import com.gself.study.jpattern.share.ShareClient;
import org.junit.Test;

/**
 * @Author:gtt
 * @Description
 * @Date: 2020/4/27 17:04
 */
public class ShareDemoTest {


    @Test
    public void test(){
        ShareClient sc =  new ShareClient();
        sc.test();
    }
    @Test
    public void test2(){
        ShareClient sc =  new ShareClient();
        sc.test2();
    }
}
