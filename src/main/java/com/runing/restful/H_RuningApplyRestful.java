package com.runing.restful;

import com.runing.entity.RuningActive;
import com.runing.entity.RuningApply;
import com.runing.service.RuningActiveService;
import com.runing.service.RuningApplyService;
import com.util.Config;
import com.util.LayuiDataTemplet;
import com.util.VersionCompare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Lovelyz
 * on 2019-04-01 16:43
 * 参加活动
 */
@Controller
@RequestMapping("/runingapply")
public class H_RuningApplyRestful {
    @Autowired
    private RuningApplyService runingApplyService;
    @Autowired
    private RuningActiveService runingActiveService;

    /**
     * 根据RuningApply实体添加
     *
     * @param runingApply
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/insertByRuningApply")
    public LayuiDataTemplet<RuningApply> insertByRuningApply(@RequestBody RuningApply runingApply) {
        LayuiDataTemplet<RuningApply> returnData = new LayuiDataTemplet<RuningApply>();
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null
        // 版本号不能为空，验证版本号
        try {
            if (null != runingApply.getVersion() && !runingApply.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(runingApply.getVersion(), Config.VERSION);
                if (compare < 0) {
                    returnData.setMsg("版本较低，请更新版本！");
                    return returnData;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            returnData.setMsg("版本比较发生异常！");
            return returnData;
        }

        //判断登录名不能重复
        RuningApply runingApplySelectData = new RuningApply();
        runingApplySelectData.setPagenumber(-1);//不分页
        //登录名
        runingApplySelectData.setApplyUserid(runingApply.getApplyUserid());//用户id
        runingApplySelectData.setApplyActiveid(runingApply.getApplyActiveid());//活动id
        List<RuningApply> runingApplyList = runingApplyService.selectByRuningApply(runingApplySelectData); // 查询数据
        if (runingApplyList.size() > 0) {
            returnData.setMsg("您已参与活动，请勿重复报名！");
            return returnData;
        }
        RuningActive runingActive = new RuningActive();
        runingActive.setActiveId(runingApply.getApplyActiveid());
        runingActive.setPagenumber(-1);
        List<RuningActive>  runingactiveone = runingActiveService.selectBySelectData(runingActive);
        runingActive =  runingactiveone.get(0);
        int count = 0;
        if (runingApply.getApplyUserid().equals(runingActive.getActiveUserid())){
            returnData.setCount(0);
            returnData.setMsg("您是活动创建人，请勿参加自己创建的活动！");
            return returnData;
        }
        if (runingActive.getActiveYetnum()>=runingActive.getActivePredictnum()){
            returnData.setCount(0);
            returnData.setMsg("该活动已报满，请参与其他活动！");
            return returnData;
        }else {
            // 更新已报名人数
            runingActive.setActiveYetnum(runingActive.getActiveYetnum()+1);
            runingActiveService.updateByRuningActive(runingActive);
            // 添加数据
            runingApply.setApplyId(UUID.randomUUID().toString());
            runingApply.setApplyIsdel(1);
            runingApply.setApplyCreatetime(new Date());
            count = runingApplyService.insertByRuningApply(runingApply);
        }
        // 返回数据
        if (count == 0) {
            returnData.setCount(0);
            returnData.setMsg("报名参与活动失败！");
        } else {
            returnData.setCount(count);
            returnData.setMsg("报名参与活动成功！");
        }
        return returnData;
    }

    /**
     * 根据RuningApply实体更新
     *
     * @param runingApply
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/updateByRuningApply")
    public LayuiDataTemplet<RuningApply> updateByRuningApply(@RequestBody RuningApply runingApply) {
        LayuiDataTemplet<RuningApply> returnData = new LayuiDataTemplet<RuningApply>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null

        // 版本号不为空，则验证版本号
        try {
            if (runingApply.getVersion() != null && !runingApply.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(runingApply.getVersion(), Config.VERSION);
                if (compare < 0) {
                    returnData.setMsg("版本较低，请更新版本！");
                    return returnData;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

            returnData.setMsg("版本比较发生异常！");
            return returnData;
        }

        // 更新判断
        runingApply.setApplyId("c64aa282-a67a-4d58-aff0-aef7a32e2a3e");
        if (runingApply.getApplyId() == null || runingApply.getApplyId() == "") {
            if (runingApply.getApplyId() == null || runingApply.getApplyId().isEmpty()) {
                returnData.setMsg("缺少更新条件，更新失败！");
                return returnData;
            }
        }

        // 更新数据
        //MD5加密
//        if (null != user.getUserpassword() && !user.getUserpassword().equals("")){
//            user.setUserpassword(MD5Util.encrypt(user.getUserpassword()));
//        }
//        user.setUserupdatetime(new Date()); // 更新时间
        runingApply.setApplyUpdatetime(new Date());
        // 更新
        int count = 0;
        count = runingApplyService.updateByRuningApply(runingApply);

        // 返回数据
        if (count == 0) {
            returnData.setMsg("更新失败！");
        } else {
            returnData.setCount(count);
            returnData.setMsg("更新成功！");
        }

        return returnData;
    }

    /**
     * 根据RuningApply实体联表查询
     *
     * 可以进行分页查询
     *
     * pageNumber 当前页数(如果不进行分页，该条数据默认为-1)
     *
     * pageSize 每页的数据量
     *
     * @param runingApply
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/selectByRuningApply")
    public LayuiDataTemplet<RuningActive> selectByRuningApply(@RequestBody RuningApply runingApply) {
        LayuiDataTemplet<RuningActive> returnData = new LayuiDataTemplet<RuningActive>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null
        // 版本号不为空，则验证版本号
        try {
            if (runingApply.getVersion() != null && !runingApply.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(runingApply.getVersion(), Config.VERSION);
                if (compare < 0) {
                    returnData.setMsg("版本较低，请更新版本！");
                    return returnData;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            returnData.setMsg("版本比较发生异常！");
            return returnData;
        }
        // 分页数据
        // 使用limit分页查询，根据偏移量查询
        // 第一个参数为第一个返回记录行的偏移量，第二个参数为返回记录行的最大数目
        // MySQL > SELECT * FROM table LIMIT 5, 10; // 查询第6-15行数据
        if (runingApply.getPagenumber() != null) {
            // 计算偏移量
            if (runingApply.getPagenumber() != -1) {
                if (runingApply.getPagesize() == null) {
                    returnData.setMsg("传递的分页数据(每页数量)错误！");
                    return returnData;
                }
                // 获取传递过来的数据
                int pageNumber = runingApply.getPagenumber();
                int pageSize = runingApply.getPagesize();
                runingApply.setPagenumber((pageNumber - 1) * pageSize); // 当前页数(如果不进行分页，该条数据默认为-1)
                runingApply.setPagesize(pageSize); // 每页的数据量
            }

            // 查询数量
            int count = 0;
            count = runingApplyService.selectCountByRuningApply(runingApply);

            // 返回数据
            if (count == 0) {
                returnData.setMsg("暂无数据！");
            } else {
                returnData.setCount(count);
                returnData.setMsg("查询成功！");
                List<RuningApply> runingApplyList = runingApplyService.selectByRuningApply(runingApply); // 查询数据
                List<RuningActive> runingActiveLists = new ArrayList<RuningActive>();
                List<RuningActive> runingActiveList = new ArrayList<RuningActive>();
                for (int a = 0;a<runingApplyList.size();a++){
                    RuningActive runingActive = new RuningActive();
                    runingActive.setActiveId(runingApplyList.get(a).getApplyActiveid());
                    runingActive.setPagenumber(-1);
                    runingActiveList =runingActiveService.selectByRuningActive(runingActive);
                    runingActiveLists.add(runingActiveList.get(0));
                }
                RuningActive runingActive = new RuningActive();
                runingActive.setActiveUserid(runingApply.getApplyUserid());
                runingActive.setPagenumber(-1);
                runingActiveList = runingActiveService.selectByRuningActive(runingActive);
                for (int a = 0;a<runingActiveList.size();a++){
                    runingActiveLists.add(runingActiveList.get(0));
                }
                returnData.setData(runingActiveLists);
            }
        } else {
            returnData.setMsg("传递的分页数据(页数)错误！");
        }

        return returnData;
    }

    /**
     * 根据RuningApply实体联表模糊查询
     *
     * 可以进行分页查询
     *
     * pageNumber 当前页数(如果不进行分页，该条数据默认为-1)
     *
     * pageSize 每页的数据量
     *
     * @param runingApply
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/selectBySelectData")
    public LayuiDataTemplet<RuningApply> selectBySelectData(@RequestBody RuningApply runingApply) {
        LayuiDataTemplet<RuningApply> returnData = new LayuiDataTemplet<RuningApply>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null

        // 版本号不为空，则验证版本号
        try {
            if (runingApply.getVersion() != null && !runingApply.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(runingApply.getVersion(), Config.VERSION);
                if (compare < 0) {
                    returnData.setMsg("版本较低，请更新版本！");
                    return returnData;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

            returnData.setMsg("版本比较发生异常！");
            return returnData;
        }

        // 分页数据
        // 使用limit分页查询，根据偏移量查询
        // 第一个参数为第一个返回记录行的偏移量，第二个参数为返回记录行的最大数目
        // MySQL > SELECT * FROM table LIMIT 5, 10; // 查询第6-15行数据
        if (runingApply.getPagenumber() != null) {
            // 计算偏移量
            if (runingApply.getPagenumber() != -1) {
                if (runingApply.getPagesize() == null) {
                    returnData.setMsg("传递的分页数据(每页数量)错误！");
                    return returnData;
                }

                // 获取传递过来的数据
                int pageNumber = runingApply.getPagenumber();
                int pageSize = runingApply.getPagesize();
                runingApply.setPagenumber((pageNumber - 1) * pageSize); // 当前页数(如果不进行分页，该条数据默认为-1)
                runingApply.setPagesize(pageSize); // 每页的数据量
            }

            // 查询数量
            int count = 0;
            count = runingApplyService.selectCountBySelectData(runingApply); // 查询数量

            // 返回数据
            if (count == 0) {
                returnData.setMsg("暂无数据！");
            } else {
                returnData.setCount(count);
                returnData.setMsg("查询成功！");
                List<RuningApply> runingApplyList = runingApplyService.selectBySelectData(runingApply); // 查询数据
                returnData.setData(runingApplyList);
            }
        } else {
            returnData.setMsg("传递的分页数据(页数)错误！");
        }

        return returnData;
    }
    /**
     * 根据RuningApply实体删除信息(假删，更改UserDelete状态)(Y:删除、N：未删除)
     *
     * @param runingApply
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/updateByRuningApplyDeleteState")
    public LayuiDataTemplet<RuningApply> updateByRuningApplyDeleteState(@RequestBody RuningApply runingApply) {
        LayuiDataTemplet<RuningApply> returnData = new LayuiDataTemplet<RuningApply>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null

        // 版本号不为空，则验证版本号
        try {
            if (runingApply.getVersion() != null && !runingApply.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(runingApply.getVersion(), Config.VERSION);
                if (compare < 0) {
                    returnData.setMsg("版本较低，请更新版本！");
                    return returnData;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

            returnData.setMsg("版本比较发生异常！");
            return returnData;
        }

        // 删除
        int count = 0;
        count = runingApplyService.updateByRuningApplyDeleteState(runingApply.getUuidlist());

        // 返回数据
        if (count == 0) {
            returnData.setMsg("删除失败！");
        } else {
            returnData.setCount(count);
            returnData.setMsg("删除成功！");
        }

        return returnData;
    }



    /**
     * 根据idList删除信息
     *
     * @param runingApply
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/deleteByIdList")
    public LayuiDataTemplet<RuningApply> deleteByIdList(@RequestBody RuningApply runingApply) {
        LayuiDataTemplet<RuningApply> returnData = new LayuiDataTemplet<RuningApply>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null

        // 版本号不为空，则验证版本号
        try {
            if (runingApply.getVersion() != null && !runingApply.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(runingApply.getVersion(), Config.VERSION);
                if (compare < 0) {
                    returnData.setMsg("版本较低，请更新版本！");
                    return returnData;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

            returnData.setMsg("版本比较发生异常！");
            return returnData;
        }

        // 删除
        int count = 0;
        count = runingApplyService.deleteByIdList(runingApply.getUuidlist());

        // 返回数据
        if (count == 0) {
            returnData.setMsg("删除失败！");
        } else {
            returnData.setCount(count);
            returnData.setMsg("删除成功！");
        }

        return returnData;
    }

}

