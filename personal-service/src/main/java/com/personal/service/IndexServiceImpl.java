package com.personal.service;

import com.personal.dao.HeadPictureDao;
import com.personal.dao.PersonalDao;
import com.personal.dao.VisitRecordDao;
import com.personal.dao.VisitTotalDao;
import com.personal.entity.VisitRecord;
import com.personal.entity.VisitTotal;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/15.
 * Author : ZhouYang
 * Email : zhouyang_young@163.com
 * Date : 2016/10/15
 */
public class IndexServiceImpl implements IndexService {

    private VisitRecordDao visitRecordDao;

    private VisitTotalDao visitTotalDao;

    private HeadPictureDao headPictureDao;

    private PersonalDao personalDao;

    public void setVisitRecordDao(VisitRecordDao visitRecordDao) {
        this.visitRecordDao = visitRecordDao;
    }

    public void setVisitTotalDao(VisitTotalDao visitTotalDao) {
        this.visitTotalDao = visitTotalDao;
    }

    public void setHeadPictureDao(HeadPictureDao headPictureDao) {
        this.headPictureDao = headPictureDao;
    }

    public void setPersonalDao(PersonalDao personalDao) {
        this.personalDao = personalDao;
    }

    @Override
    public Map<String, Object> visitIndex(String ipaddr,String seaaionid) {

        Map<String, Object> result = new HashMap<String, Object>();
        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String todayStr = sdf.format(today);

        /* 插入访问记录 */
        VisitTotal totals = visitTotalDao.selectByPrimaryKey("20000101");//总访问次数
        VisitTotal visitTotal = visitTotalDao.selectByPrimaryKey(todayStr);//当日访问次数

        Map<String, Object> oldmap = new HashMap<String, Object>();
        oldmap.put("id",todayStr+"%");
        oldmap.put("ipaddr",ipaddr);

        Long totalnumber=visitRecordDao.getTotalNumber(oldmap);
        Long totalcount=visitRecordDao.getTotalVisitRecord(oldmap);


        if(totalnumber!=null && totalnumber!=null && (totalnumber>300 || totalcount>50)){
            result.put("error","访问过于频繁！");
            return result;
        }

        oldmap.put("sessionid",seaaionid);
        VisitRecord oldRecord=visitRecordDao.selectByMap(oldmap);

        if(oldRecord==null){
            VisitRecord visitRecord = new VisitRecord();
            visitRecord.setIpaddr(ipaddr);
            visitRecord.setSessionid(seaaionid);
            visitRecord.setDate(today);
            Map<String, Object> recordmap = new HashMap<String, Object>();
            recordmap.put("prefix", todayStr + "%");
            String id = visitRecordDao.getMaxID(recordmap);
            if (null == id) {
                id = sdf.format(today) + "00000001";
            } else {
                id = todayStr + Generating(Long.valueOf(id.substring(8)), 8);
            }
            visitRecord.setId(id);

            visitRecordDao.insertSelective(visitRecord);


        /* 统计每日访问人数*/

            if (null != visitTotal) {
                visitTotal.setNumber(visitTotal.getNumber() + 1);
                visitTotalDao.updateByPrimaryKeySelective(visitTotal);
            } else {
                visitTotal = new VisitTotal();
                visitTotal.setId(todayStr);
                visitTotal.setNumber(1);
                visitTotalDao.insertSelective(visitTotal);
            }

            totals.setNumber(totals.getNumber() + 1);
            visitTotalDao.updateByPrimaryKeySelective(totals);
        }else{

            oldRecord.setNumber(oldRecord.getNumber()+1);
            visitRecordDao.updateByPrimaryKeySelective(oldRecord);

        }
        result.put("total",totals.getNumber());
        result.put("today",visitTotal.getNumber());

        /* 获取头像*/
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", 1);//启用状态
        result.put("headpicture", headPictureDao.findHeadPicture(map).get(0));

        /* 获取背景信息*/
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        int minute = calendar.get(Calendar.MINUTE);
        long total = personalDao.getTotalPersonal(map);
        int sum=(int)total;
        int number=0;
        if(minute<sum){
            number=minute;
        }else{
            number =(minute+1) % sum;
            if(number==0){
                number= sum;
            }
            number=number-1;
        }

        map.put("start", number);
        map.put("size", 1);
        result.put("personal", personalDao.findPersonal(map).get(0));

        return result;
    }

    public static String Generating(Long num, int width) {
        if (0 > num || width <= 0) {
            throw new RuntimeException("GenerateCode.generating 生成id失败 num:" + num + " width" + width);
        }
        Long tmp = num + 1;

        String str = tmp.toString();
        int w = str.length();
        if (w > width) {
            throw new RuntimeException("GenerateCode.generating 生成id失败 num:" + num + " width" + width);
        } else if (w < width) {
            for (int i = 0; i < width - w; i++) {
                str = "0" + str;
            }
        }
        if (str.isEmpty()) {
            throw new RuntimeException("GenerateCode.generating 生成id失败 num:" + num + " width" + width);
        }
        return str;
    }
}
