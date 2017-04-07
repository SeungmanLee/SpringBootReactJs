package org.smlee.repository;

import org.apache.commons.io.FileUtils;
import org.smlee.model.LottoryVo;
import org.springframework.stereotype.Repository;
import org.springframework.util.FileSystemUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by smlee on 2017-01-29.
 */
@Repository
public class LottoryRepository {

    private ArrayList<LottoryVo> lottoryVoArrayList;

    @PostConstruct
    public void setup() {
        lottoryVoArrayList = new ArrayList<>();

        File file = new File("E:/Development_2016/SpringBootReactJs/lotto.csv");
        try {
            List<String> lines = FileUtils.readLines(file, "utf-8");
            for( String line : lines ) {
                LottoryVo lottoryVo = convertLineToLottoryVo(line);
                lottoryVoArrayList.add(lottoryVo);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private LottoryVo convertLineToLottoryVo(String line) {
        ArrayList<Integer> arrayList = new ArrayList<>();
//
//        int pos = line.indexOf(",");
//        while( -1 < pos ) {
//            arrayList.add(pos);
//            pos = line.indexOf(",", pos);
//        }

        boolean bSkip = false;
        int len = line.length();
        for( int i = 0 ; i < len ; i ++ ) {
            char c = line.charAt(i);
            if( '"' == c ) {
                // skip
                bSkip = ! bSkip;
            }else if( ',' == c ) {
                if( bSkip ) {

                }else {
                    arrayList.add(i);
                }

            }
        }

        Integer[] posArray = new Integer[arrayList.size()];
        arrayList.toArray(posArray);

        String no = line.substring(0, posArray[0] );  // 회차
        String date = line.substring( posArray[0] +1 , posArray[1] ); // 날짜
        String cnt1 = line.substring( posArray[1] +1 , posArray[2] ); // 1등 당첨자 수
        String money1 = line.substring( posArray[2] +1 , posArray[3] );// 1등 당첨금
        String cnt2 = line.substring( posArray[3] +1 , posArray[4] ); // 2등 당첨자 수
        String money2 = line.substring( posArray[4] +1 , posArray[5] ); // 2등 당첨금
        String cnt3 = line.substring( posArray[5] +1 , posArray[6] ); // 3등 당첨자 수
        String money3 = line.substring( posArray[6] +1 , posArray[7] ); // 3등 당첨금
        String cnt4 = line.substring( posArray[7] +1 , posArray[8] ); // 4등 당첨자 수
        String money4 = line.substring( posArray[8] +1 , posArray[9] ); // 4등 당첨금
        String cnt5 = line.substring( posArray[9] +1 , posArray[10] ); // 5등 당첨자 수
        String money5 = line.substring( posArray[10] +1 , posArray[11] ); // 5등 당첨금
        String lucky1 = line.substring( posArray[11] +1 , posArray[12] ); // 당첨번호 #1
        String lucky2 = line.substring( posArray[12] +1 , posArray[13] ); // 당첨번호 #2
        String lucky3 = line.substring( posArray[13] +1 , posArray[14] ); // 당첨번호 #3
        String lucky4 = line.substring( posArray[14] +1 , posArray[15] ); // 당첨번호 #4
        String lucky5 = line.substring( posArray[15] +1 , posArray[16] ); // 당첨번호 #5
        String lucky6 = line.substring( posArray[16] +1 , posArray[17] ); // 당첨번호 #6
        String luckyBonus = line.substring( posArray[17] +1  ); // 당첨번호 보너스

        LottoryVo lottoryVo = new LottoryVo(no, new Integer[]{Integer.valueOf(lucky1),
                Integer.valueOf(lucky2),
                Integer.valueOf(lucky3),
                Integer.valueOf(lucky4),
                Integer.valueOf(lucky5),
                Integer.valueOf(lucky6)});

        return lottoryVo;
    }
}
