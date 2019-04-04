package com.runing.service;

import com.runing.dao.RuningApplyDao;
import com.runing.entity.RuningApply;
import com.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lovelyz
 * on 2019-04-01 16:38
 */
@Service
public class RuningApplyService {

    @Autowired
    private RuningApplyDao runingApplyDao;

    private Logger logger = Logger.getLogger(RuningApplyService.class);

    /**
     * 根据RuningApply实体添加
     *
     * @param runingApply
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int insertByRuningApply(RuningApply runingApply) {
        int num = 0;

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            num = runingApplyDao.insertByRuningApply(session, runingApply);

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("RuningApplyService--insertByRuningApply--error:" + e.getMessage());
        }

        return num;
    }

    /**
     * 根据RuningApply实体更新
     *
     * @param runingApply
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int updateByRuningApply(RuningApply runingApply) {
        int num = 0;

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            num = runingApplyDao.updateByRuningApply(session, runingApply);

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("RuningApplyService--updateByRuningApply--error:" + e.getMessage());
        }

        return num;
    }

    /**
     * 根据RuningApply实体联表查询
     *
     * 查询数量
     *
     * @param runingApply
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int selectCountByRuningApply(RuningApply runingApply) {
        int num = 0;

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            num = runingApplyDao.selectCountByRuningApply(session, runingApply);

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("RuningApplyService--selectCountByRuningApply--error:" + e.getMessage());
        }

        return num;
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
    public List<RuningApply> selectByRuningApply(RuningApply runingApply) {
        List<RuningApply> runingApplyList = new ArrayList<RuningApply>();

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            runingApplyList = runingApplyDao.selectByRuningApply(session, runingApply);

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("RuningApplyService--selectByRuningApply--error:" + e.getMessage());
        }

        return runingApplyList;
    }

    /**
     * 根据RuningApply实体联表模糊查询
     *
     * 查询数量
     *
     * @param runingApply
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int selectCountBySelectData(RuningApply runingApply) {
        int num = 0;

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            num = runingApplyDao.selectCountBySelectData(session, runingApply);

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("RuningApplyService--selectCountBySelectData--error:" + e.getMessage());
        }

        return num;
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
    public List<RuningApply> selectBySelectData(RuningApply runingApply) {
        List<RuningApply> runingApplyList = new ArrayList<RuningApply>();

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            runingApplyList = runingApplyDao.selectBySelectData(session, runingApply);

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("RuningApplyService--selectBySelectData--error:" + e.getMessage());
        }

        return runingApplyList;
    }



    /**
     * 根据idList删除信息(假删、更改状态)
     *
     * @param list
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int updateByRuningApplyDeleteState(List<String> list) {
        int deleteNum = 0;

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            for (int i = 0; i < list.size(); i++) {
                RuningApply runingApply = new RuningApply();

                deleteNum = deleteNum + runingApplyDao.updateByRuningApplyDeleteState(session, runingApply);
            }

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("RuningApplyService--updateByRuningApplyDeleteState--error:" + e.getMessage());
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
                deleteNum = deleteNum + runingApplyDao.deleteByPrimaryKey(session, list.get(i));
            }

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("RuningApplyService--deleteByIdList--error:" + e.getMessage());
        }

        return deleteNum;
    }

}

