package com.runing.restful;

import com.runing.entity.RuningUser;
import com.runing.service.RuningUserService;
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

/**
 * Created by Lovelyz
 * on 2019-04-01 14:54
 */
@Controller
@RequestMapping("/runinguser")
public class H_RuningUserRestful {
    @Autowired
    private RuningUserService runingUserService;

    /**
     * 根据RuningUser实体添加
     *
     * @param runingUser
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/insertByRuningUser")
    public LayuiDataTemplet<RuningUser> insertByRuningUser(@RequestBody RuningUser runingUser) {
        LayuiDataTemplet<RuningUser> returnData = new LayuiDataTemplet<RuningUser>();
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null
        // 版本号不能为空，验证版本号
        try {
            if (null != runingUser.getVersion() && !runingUser.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(runingUser.getVersion(), Config.VERSION);
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
        RuningUser runingUserSelectData = new RuningUser();
        runingUserSelectData.setPagenumber(-1);//不分页
        runingUserSelectData.setUserName(runingUser.getUserName());
        List<RuningUser> runingUserList = runingUserService.selectByRuningUser(runingUserSelectData); // 查询数据
        if (runingUserList.size() > 0) {
            returnData.setMsg("已注册、请更换！");
            return returnData;
        }
        // 添加数据
        // 添加
        int count = 0;
        runingUser.setUserIsdel(1);
        runingUser.setUserCreatetime(new Date());
        runingUser.setUserUpdatetime(new Date());
        count = runingUserService.insertByRuningUser(runingUser);
        // 返回数据
        if (count == 0) {
            returnData.setMsg("添加失败！");
        } else {
            returnData.setCount(count);
            returnData.setMsg("添加成功！");
        }

        return returnData;
    }

    /**
     * 根据RuningUser实体更新
     *
     * @param runingUser
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/updateByRuningUser")
    public LayuiDataTemplet<RuningUser> updateByRuningUser(@RequestBody RuningUser runingUser) {
        LayuiDataTemplet<RuningUser> returnData = new LayuiDataTemplet<RuningUser>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null

        // 版本号不为空，则验证版本号
        try {
            if (runingUser.getVersion() != null && !runingUser.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(runingUser.getVersion(), Config.VERSION);
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
        runingUser.setUserId("f9137018-07c9-4520-ab77-80086d6a2da0");
        // 更新判断
        if (runingUser.getUserId() == null || runingUser.getUserId() == "") {
            if (runingUser.getUserId() == null || runingUser.getUserId().isEmpty()) {
                returnData.setMsg("缺少更新条件，更新失败！");
                return returnData;
            }
        }

        // 更新数据
        //MD5加密
//        if (null != user.getUserpassword() && !user.getUserpassword().equals("")){
//            user.setUserpassword(MD5Util.encrypt(user.getUserpassword()));
//        }
        runingUser.setUserCreatetime(new Date());
        runingUser.setUserName("大名");
//        user.setUserupdatetime(new Date()); // 更新时间

        // 更新
        int count = 0;
        count = runingUserService.updateByRuningUser(runingUser);

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
     * 根据RuningUser实体联表查询
     *
     * 可以进行分页查询
     *
     * pageNumber 当前页数(如果不进行分页，该条数据默认为-1)
     *
     * pageSize 每页的数据量
     *
     * @param runingUser
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/selectByRuningUser")
    public LayuiDataTemplet<RuningUser> selectByRuningUser(@RequestBody RuningUser runingUser) {
        LayuiDataTemplet<RuningUser> returnData = new LayuiDataTemplet<RuningUser>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null

        // 版本号不为空，则验证版本号
        try {
            if (runingUser.getVersion() != null && !runingUser.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(runingUser.getVersion(), Config.VERSION);
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
        if (runingUser.getPagenumber() != null) {
            // 计算偏移量
            if (runingUser.getPagenumber() != -1) {
                if (runingUser.getPagesize() == null) {
                    returnData.setMsg("传递的分页数据(每页数量)错误！");
                    return returnData;
                }

                // 获取传递过来的数据
                int pageNumber = runingUser.getPagenumber();
                int pageSize = runingUser.getPagesize();
                runingUser.setPagenumber((pageNumber - 1) * pageSize); // 当前页数(如果不进行分页，该条数据默认为-1)
                runingUser.setPagesize(pageSize); // 每页的数据量
            }

            // 查询数量
            int count = 0;
            count = runingUserService.selectCountByRuningUser(runingUser);

            // 返回数据
            if (count == 0) {
                returnData.setMsg("暂无数据！");
            } else {
                returnData.setCount(count);
                returnData.setMsg("查询成功！");
                List<RuningUser> runingUserList = runingUserService.selectByRuningUser(runingUser); // 查询数据
                returnData.setData(runingUserList);
            }
        } else {
            returnData.setMsg("传递的分页数据(页数)错误！");
        }

        return returnData;
    }

    /**
     * 根据RuningUser实体联表模糊查询
     *
     * 可以进行分页查询
     *
     * pageNumber 当前页数(如果不进行分页，该条数据默认为-1)
     *
     * pageSize 每页的数据量
     *
     * @param runingUser
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/selectBySelectData")
    public LayuiDataTemplet<RuningUser> selectBySelectData(@RequestBody RuningUser runingUser) {
        LayuiDataTemplet<RuningUser> returnData = new LayuiDataTemplet<RuningUser>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null

        // 版本号不为空，则验证版本号
        try {
            if (runingUser.getVersion() != null && !runingUser.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(runingUser.getVersion(), Config.VERSION);
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
        if (runingUser.getPagenumber() != null) {
            // 计算偏移量
            if (runingUser.getPagenumber() != -1) {
                if (runingUser.getPagesize() == null) {
                    returnData.setMsg("传递的分页数据(每页数量)错误！");
                    return returnData;
                }

                // 获取传递过来的数据
                int pageNumber = runingUser.getPagenumber();
                int pageSize = runingUser.getPagesize();
                runingUser.setPagenumber((pageNumber - 1) * pageSize); // 当前页数(如果不进行分页，该条数据默认为-1)
                runingUser.setPagesize(pageSize); // 每页的数据量
            }

            // 查询数量
            int count = 0;
            count = runingUserService.selectCountBySelectData(runingUser); // 查询数量

            // 返回数据
            if (count == 0) {
                returnData.setMsg("暂无数据！");
            } else {
                returnData.setCount(count);
                returnData.setMsg("查询成功！");
                List<RuningUser> runingUserList = runingUserService.selectBySelectData(runingUser); // 查询数据
                returnData.setData(runingUserList);
            }
        } else {
            returnData.setMsg("传递的分页数据(页数)错误！");
        }

        return returnData;
    }
    /**
     * 根据RuningUser实体删除信息(假删，更改UserDelete状态)(Y:删除、N：未删除)
     *
     * @param runingUser
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/updateByRuningUserDeleteState")
    public LayuiDataTemplet<RuningUser> updateByRuningUserDeleteState(@RequestBody RuningUser runingUser) {
        LayuiDataTemplet<RuningUser> returnData = new LayuiDataTemplet<RuningUser>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null

        // 版本号不为空，则验证版本号
        try {
            if (runingUser.getVersion() != null && !runingUser.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(runingUser.getVersion(), Config.VERSION);
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
        count = runingUserService.updateByRuningUserDeleteState(runingUser.getUuidlist());

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
     * @param runingUser
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/deleteByIdList")
    public LayuiDataTemplet<RuningUser> deleteByIdList(@RequestBody RuningUser runingUser) {
        LayuiDataTemplet<RuningUser> returnData = new LayuiDataTemplet<RuningUser>(); // 返回数据
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null

        // 版本号不为空，则验证版本号
        try {
            if (runingUser.getVersion() != null && !runingUser.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(runingUser.getVersion(), Config.VERSION);
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
        count = runingUserService.deleteByIdList(runingUser.getUuidlist());

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
