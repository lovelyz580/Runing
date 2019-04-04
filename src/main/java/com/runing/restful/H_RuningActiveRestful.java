package com.runing.restful;

import com.runing.entity.RuningActive;
import com.runing.service.RuningActiveService;
import com.util.Config;
import com.util.LayuiDataTemplet;
import com.util.VersionCompare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/runingactive")
public class H_RuningActiveRestful {
    @Autowired
    private RuningActiveService runingActiveService;

    /**
     * 根据RuningActive实体添加
     *
     * @param runingActive
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/insertByRuningActive")
    public LayuiDataTemplet<RuningActive> insertByRuningActive(@RequestBody RuningActive runingActive) {
        LayuiDataTemplet<RuningActive> returnData = new LayuiDataTemplet<RuningActive>();
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null
        // 版本号不能为空，验证版本号
        try {
            if (null != runingActive.getVersion() && !runingActive.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(runingActive.getVersion(), Config.VERSION);
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
        RuningActive runingActiveSelectData = new RuningActive();
        runingActiveSelectData.setPagenumber(-1);//不分页
        //登录名
        runingActiveSelectData.setActiveName(runingActive.getActiveName());
//        runingActiveSelectData.setActiveInfo(runingActive.getActiveInfo());
        runingActiveSelectData.setActivePredictnum(runingActive.getActivePredictnum());
        List<RuningActive> runingActiveList = runingActiveService.selectByRuningActive(runingActiveSelectData); // 查询数据
        if (runingActiveList.size() > 0) {
            returnData.setMsg("活动已创建、请加入活动！");
            return returnData;
        }
        // 添加数据
        // 添加
        int count = 0;
        runingActive.setActiveId(UUID.randomUUID().toString());
        runingActive.setActiveIsdel(1);
        runingActive.setActiveCreatetime(new Date());
        count = runingActiveService.insertByRuningActive(runingActive);

        // 返回数据
        if (count == 0) {
            returnData.setMsg("发布活动失败！");
        } else {
            returnData.setCount(count);
            returnData.setMsg("发布活动成功！");
        }

        return returnData;
    }

    /**
     * 根据RuningActive实体更新
     *
     * @param runingActive
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/updateByRuningActive")
    public LayuiDataTemplet<RuningActive> updateByRuningActive(@RequestBody RuningActive runingActive) {
        LayuiDataTemplet<RuningActive> returnData = new LayuiDataTemplet<RuningActive>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null

        // 版本号不为空，则验证版本号
        try {
            if (runingActive.getVersion() != null && !runingActive.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(runingActive.getVersion(), Config.VERSION);
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
        if (runingActive.getActiveId() == null || runingActive.getActiveId() == "") {
            if (runingActive.getActiveId() == null || runingActive.getActiveId().isEmpty()) {
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
        runingActive.setActiveUpdatetime(new Date());
//        runingActive.setActiveName("微信小程序");
        // 更新
        int count = 0;
        count = runingActiveService.updateByRuningActive(runingActive);

        // 返回数据
        if (count == 0) {
            returnData.setMsg("活动修改失败！");
        } else {
            returnData.setCount(count);
            returnData.setMsg("活动修改成功！");
        }

        return returnData;
    }

    /**
     * 根据RuningActive实体联表查询
     *
     * 可以进行分页查询
     *
     * pageNumber 当前页数(如果不进行分页，该条数据默认为-1)
     *
     * pageSize 每页的数据量
     *
     * @param runingActive
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/selectByRuningActive")
    public LayuiDataTemplet<RuningActive> selectByRuningActive(@RequestBody RuningActive runingActive) {
        LayuiDataTemplet<RuningActive> returnData = new LayuiDataTemplet<RuningActive>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null

        // 版本号不为空，则验证版本号
        try {
            if (runingActive.getVersion() != null && !runingActive.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(runingActive.getVersion(), Config.VERSION);
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
        if (runingActive.getPagenumber() != null) {
            // 计算偏移量
            if (runingActive.getPagenumber() != -1) {
                if (runingActive.getPagesize() == null) {
                    returnData.setMsg("传递的分页数据(每页数量)错误！");
                    return returnData;
                }

                // 获取传递过来的数据
                int pageNumber = runingActive.getPagenumber();
                int pageSize = runingActive.getPagesize();
                runingActive.setPagenumber((pageNumber - 1) * pageSize); // 当前页数(如果不进行分页，该条数据默认为-1)
                runingActive.setPagesize(pageSize); // 每页的数据量
            }

            // 查询数量
            int count = 0;
            count = runingActiveService.selectCountByRuningActive(runingActive);

            // 返回数据
            if (count == 0) {
                returnData.setMsg("暂无数据！");
            } else {
                returnData.setCount(count);
                returnData.setMsg("查询成功！");
                List<RuningActive> runingActiveList = runingActiveService.selectByRuningActive(runingActive); // 查询数据
                returnData.setData(runingActiveList);
            }
        } else {
            returnData.setMsg("传递的分页数据(页数)错误！");
        }

        return returnData;
    }

    /**
     * 根据RuningActive实体联表模糊查询
     *
     * 可以进行分页查询
     *
     * pageNumber 当前页数(如果不进行分页，该条数据默认为-1)
     *
     * pageSize 每页的数据量
     *
     * @param runingActive
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/selectBySelectData")
    public LayuiDataTemplet<RuningActive> selectBySelectData(@RequestBody RuningActive runingActive) {
        LayuiDataTemplet<RuningActive> returnData = new LayuiDataTemplet<RuningActive>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null

        // 版本号不为空，则验证版本号
        try {
            if (runingActive.getVersion() != null && !runingActive.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(runingActive.getVersion(), Config.VERSION);
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
        if (runingActive.getPagenumber() != null) {
            // 计算偏移量
            if (runingActive.getPagenumber() != -1) {
                if (runingActive.getPagesize() == null) {
                    returnData.setMsg("传递的分页数据(每页数量)错误！");
                    return returnData;
                }

                // 获取传递过来的数据
                int pageNumber = runingActive.getPagenumber();
                int pageSize = runingActive.getPagesize();
                runingActive.setPagenumber((pageNumber - 1) * pageSize); // 当前页数(如果不进行分页，该条数据默认为-1)
                runingActive.setPagesize(pageSize); // 每页的数据量
            }

            // 查询数量
            int count = 0;
            count = runingActiveService.selectCountBySelectData(runingActive); // 查询数量

            // 返回数据
            if (count == 0) {
                returnData.setMsg("暂无数据！");
            } else {
                returnData.setCount(count);
                returnData.setMsg("查询成功！");
                List<RuningActive> runingActiveList = runingActiveService.selectBySelectData(runingActive); // 查询数据
                returnData.setData(runingActiveList);
            }
        } else {
            returnData.setMsg("传递的分页数据(页数)错误！");
        }

        return returnData;
    }
    /**
     * 根据RuningActive实体删除信息(假删，更改UserDelete状态)(Y:删除、N：未删除)
     *
     * @param runingActive
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/updateByRuningActiveDeleteState")
    public LayuiDataTemplet<RuningActive> updateByRuningActiveDeleteState(@RequestBody RuningActive runingActive) {
        LayuiDataTemplet<RuningActive> returnData = new LayuiDataTemplet<RuningActive>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null

        // 版本号不为空，则验证版本号
        try {
            if (runingActive.getVersion() != null && !runingActive.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(runingActive.getVersion(), Config.VERSION);
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
        count = runingActiveService.updateByRuningActiveDeleteState(runingActive);

        // 返回数据
        if (count == 0) {
            returnData.setMsg("取消活动失败！");
        } else {
            returnData.setCount(count);
            returnData.setMsg("取消活动成功！");
        }

        return returnData;
    }



    /**
     * 根据idList删除信息
     *
     * @param runingActive
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/deleteByIdList")
    public LayuiDataTemplet<RuningActive> deleteByIdList(@RequestBody RuningActive runingActive) {
        LayuiDataTemplet<RuningActive> returnData = new LayuiDataTemplet<RuningActive>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null

        // 版本号不为空，则验证版本号
        try {
            if (runingActive.getVersion() != null && !runingActive.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(runingActive.getVersion(), Config.VERSION);
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
        count = runingActiveService.deleteByIdList(runingActive.getUuidlist());

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

