package com.runing.service;

import com.runing.dao.RuningActiveDao;
import com.runing.entity.RuningActive;
import com.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lovelyz
 * on 2019-04-01 16:56
 */
@Service
public class RuningActiveService {

    @Autowired
    private RuningActiveDao runingActiveDao;

    private Logger logger = Logger.getLogger(RuningActiveService.class);

    /**
     * 根据RuningActive实体添加
     *
     * @param runingActive
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int insertByRuningActive(RuningActive runingActive) {
        int num = 0;

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            num = runingActiveDao.insertByRuningActive(session, runingActive);

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("RuningActiveService--insertByRuningActive--error:" + e.getMessage());
        }

        return num;
    }

    /**
     * 根据RuningActive实体更新
     *
     * @param runingActive
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int updateByRuningActive(RuningActive runingActive) {
        int num = 0;

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            num = runingActiveDao.updateByRuningActive(session, runingActive);

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("RuningActiveService--updateByRuningActive--error:" + e.getMessage());
        }

        return num;
    }

    /**
     * 根据RuningActive实体联表查询
     *
     * 查询数量
     *
     * @param runingActive
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int selectCountByRuningActive(RuningActive runingActive) {
        int num = 0;

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            num = runingActiveDao.selectCountByRuningActive(session, runingActive);

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("RuningActiveService--selectCountByRuningActive--error:" + e.getMessage());
        }

        return num;
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
    public List<RuningActive> selectByRuningActive(RuningActive runingActive) {
        List<RuningActive> runingActiveList = new ArrayList<RuningActive>();

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            runingActiveList = runingActiveDao.selectByRuningActive(session, runingActive);

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("RuningActiveService--selectByRuningActive--error:" + e.getMessage());
        }

        return runingActiveList;
    }

    /**
     * 根据RuningActive实体联表模糊查询
     *
     * 查询数量
     *
     * @param runingActive
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int selectCountBySelectData(RuningActive runingActive) {
        int num = 0;

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            num = runingActiveDao.selectCountBySelectData(session, runingActive);

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("RuningActiveService--selectCountBySelectData--error:" + e.getMessage());
        }

        return num;
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
    public List<RuningActive> selectBySelectData(RuningActive runingActive) {
        List<RuningActive> runingActiveList = new ArrayList<RuningActive>();

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            runingActiveList = runingActiveDao.selectBySelectData(session, runingActive);

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("RuningActiveService--selectBySelectData--error:" + e.getMessage());
        }

        return runingActiveList;
    }



    /**
     * 根据idList删除信息(假删、更改状态)
     *
     * @param list
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int updateByRuningActiveDeleteState(RuningActive runingActive) {
        int deleteNum = 0;

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();
                deleteNum = deleteNum + runingActiveDao.updateByRuningActiveDeleteState(session, runingActive);

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("RuningActiveService--updateByRuningActiveDeleteState--error:" + e.getMessage());
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
                deleteNum = deleteNum + runingActiveDao.deleteByPrimaryKey(session, list.get(i));
            }

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("RuningActiveService--deleteByIdList--error:" + e.getMessage());
        }

        return deleteNum;
    }

}

