package com.huilong.interview.algorithm.sort;

import com.sun.glass.ui.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Date: 2020/10/18 11:32
 * @Author: DengHuiLong
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class SortUtilsTest {

    int[] attr = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};

    @Test
    public void testQuickSort() {
        SortUtils.quickSort(attr, 0, attr.length - 1);
        for (int j : attr) {
            System.out.println(j);
        }
    }
}
