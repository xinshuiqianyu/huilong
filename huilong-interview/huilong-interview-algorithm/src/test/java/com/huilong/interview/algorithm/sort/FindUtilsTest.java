package com.huilong.interview.algorithm.sort;

import com.huilong.interview.algorithm.find.FindUtils;
import com.sun.glass.ui.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Date: 2020/10/19 22:59
 * @Author: DengHuiLong
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class FindUtilsTest {

    int[] array = {3, 4, 6, 20, 40, 45, 51, 62, 70, 99, 110};

    int[] array2 = {4, 5, 6, 7, 0, 1, 2};

    @Test
    public void testBinarySearch() {
        int index = FindUtils.binarySearch(array, 62);
        System.out.println(index);
    }

    @Test
    public void testFindMid() {
        int mid = FindUtils.findMid(array2);
        System.out.println(mid);
    }
}
