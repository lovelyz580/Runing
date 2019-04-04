package com.runing.service;

import com.runing.dao.RuningUserDao;
import com.runing.entity.RuningUser;
import com.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lovelyz
 * on 2019-04-01 14:48
 */
@Service
public class RuningUserService {

    @Autowired
    private RuningUserDao runingUserDao;

    private Logger logger = Logger.getLogger(RuningUserService.class);

    /**
     * 根据RuningUser实体添加
     *
     * @param runingUser
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int insertByRuningUser(RuningUser runingUser) {
        int num = 0;

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            num = runingUserDao.insertByRuningUser(session, runingUser);

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("RuningUserService--insertByRuningUser--error:" + e.getMessage());
        }

        return num;
    }

    /**
     * 根据RuningUser实体更新
     *
     * @param runingUser
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int updateByRuningUser(RuningUser runingUser) {
        int num = 0;

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            num = runingUserDao.updateByRuningUser(session, runingUser);

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("RuningUserService--updateByRuningUser--error:" + e.getMessage());
        }

        return num;
    }

    /**
     * 根据RuningUser实体联表查询
     *
     * 查询数量
     *
     * @param runingUser
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int selectCountByRuningUser(RuningUser runingUser) {
        int num = 0;

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            num = runingUserDao.selectCountByRuningUser(session, runingUser);

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("RuningUserService--selectCountByRuningUser--error:" + e.getMessage());
        }

        return num;
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
    public List<RuningUser> selectByRuningUser(RuningUser runingUser) {
        List<RuningUser> runingUserList = new ArrayList<RuningUser>();

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            runingUserList = runingUserDao.selectByRuningUser(session, runingUser);

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("RuningUserService--selectByRuningUser--error:" + e.getMessage());
        }

        return runingUserList;
    }

    /**
     * 根据RuningUser实体联表模糊查询
     *
     * 查询数量
     *
     * @param runingUser
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int selectCountBySelectData(RuningUser runingUser) {
        int num = 0;

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            num = runingUserDao.selectCountBySelectData(session, runingUser);

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("RuningUserService--selectCountBySelectData--error:" + e.getMessage());
        }

        return num;
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
    public List<RuningUser> selectBySelectData(RuningUser runingUser) {
        List<RuningUser> runingUserList = new ArrayList<RuningUser>();

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            runingUserList = runingUserDao.selectBySelectData(session, runingUser);

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("RuningUserService--selectBySelectData--error:" + e.getMessage());
        }

        return runingUserList;
    }



    /**
     * 根据idList删除信息(假删、更改状态)
     *
     * @param list
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int updateByRuningUserDeleteState(List<String> list) {
        int deleteNum = 0;

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            for (int i = 0; i < list.size(); i++) {
                RuningUser runingUser = new RuningUser();

                deleteNum = deleteNum + runingUserDao.updateByRuningUserDeleteState(session, runingUser);
            }

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("RuningUserService--updateByRuningUserDeleteState--error:" + e.getMessage());
        }

        return deleteNum;
    }


    /**
     * 根据idList删除信息
     *
     * @param list
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int deleteByIdList(List<String> list) {
        int deleteNum = 0;

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            for (int i = 0; i < list.size(); i++) {
                deleteNum = deleteNum + runingUserDao.deleteByPrimaryKey(session, list.get(i));
            }

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("RuningUserService--deleteByIdList--error:" + e.getMessage());
        }

        return deleteNum;
    }

}
