package com.runing.dao;

import com.runing.entity.RuningApply;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lovelyz
 * on 2019-04-01 16:27
 */
@Repository
public class RuningApplyDao {

    private Logger logger = Logger.getLogger(RuningApplyDao.class);

    public int insert(SqlSession session, RuningApply runingApply) {
        int num = 0;

        try {
            logger.info("RuningApplyDao");

            num = session.insert("com.runing.dao.mapper.RuningApply.insert", runingApply);
        } catch (Exception e) {
            logger.error("RuningApplyDao--insert--error:" + e.getMessage());
        }

        return num;
    }

    public int insertSelective(SqlSession session, RuningApply runingApply) {
        int num = 0;

        try {
            logger.info("RuningApplyDao");

            num = session.insert("com.runing.dao.mapper.RuningApply.insertSelective", runingApply);
        } catch (Exception e) {
            logger.error("RuningApplyDao--insertSelective--error:" + e.getMessage());
        }

        return num;
    }

    public int updateByPrimaryKeySelective(SqlSession session, RuningApply runingApply) {
        int num = 0;

        try {
            logger.info("RuningApplyDao");

            num = session.update("com.runing.dao.mapper.RuningApply.updateByPrimaryKeySelective", runingApply);
        } catch (Exception e) {
            logger.error("RuningApplyDao--updateByPrimaryKeySelective--error:" + e.getMessage());
        }

        return num;
    }

    public int updateByPrimaryKey(SqlSession session, RuningApply runingApply) {
        int num = 0;

        try {
            logger.info("RuningApplyDao");

            num = session.update("com.runing.dao.mapper.RuningApply.updateByPrimaryKey", runingApply);
        } catch (Exception e) {
            logger.error("RuningApplyDao--updateByPrimaryKey--error:" + e.getMessage());
        }

        return num;
    }

    public int selectCountByPrimaryKey(SqlSession session, Integer id) {
        int num = 0;

        try {
            logger.info("RuningApplyDao");

            num = session.selectOne("com.runing.dao.mapper.RuningApply.selectCountByPrimaryKey", id);
        } catch (Exception e) {
            logger.error("RuningApplyDao--selectCountByPrimaryKey--error:" + e.getMessage());
        }

        return num;
    }

    public RuningApply selectByPrimaryKey(SqlSession session, Integer id) {
        RuningApply runingApply = new RuningApply();

        try {
            logger.info("RuningApplyDao");

            runingApply = session.selectOne("com.runing.dao.mapper.RuningApply.selectByPrimaryKey", id);
        } catch (Exception e) {
            logger.error("RuningApplyDao--selectByPrimaryKey--error:" + e.getMessage());
        }

        return runingApply;
    }

    public int deleteByPrimaryKey(SqlSession session, String id) {
        int num = 0;

        try {
            logger.info("RuningApplyDao");

            num = session.delete("com.runing.dao.mapper.RuningApply.deleteByPrimaryKey", id);
        } catch (Exception e) {
            logger.error("RuningApplyDao--deleteByPrimaryKey--error:" + e.getMessage());
        }

        return num;
    }




    /**
     * 根据RuningApply实体添加
     *
     * @param runingApply
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int insertByRuningApply(SqlSession session, RuningApply runingApply) {
        int num = 0;

        try {
            logger.info("RuningApplyDao");

            num = session.insert("com.runing.dao.mapper.RuningApply.insertByRuningApply", runingApply);
        } catch (Exception e) {
            logger.error("RuningApplyDao--insertByRuningApply--error:" + e.getMessage());
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
    public int updateByRuningApply(SqlSession session, RuningApply runingApply) {
        int num = 0;

        try {
            logger.info("RuningApplyDao");

            num = session.update("com.runing.dao.mapper.RuningApply.updateByRuningApply", runingApply);
        } catch (Exception e) {
            logger.error("RuningApplyDao--updateByRuningApply--error:" + e.getMessage());
        }

        return num;
    }

    /**
     * 根据RuningApply实体查询
     *
     * 查询数量
     *
     * @param runingApply
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int selectCountByRuningApply(SqlSession session, RuningApply runingApply) {
        int num = 0;

        try {
            logger.info("RuningApplyDao");

            num = session.selectOne("com.runing.dao.mapper.RuningApply.selectCountByRuningApply", runingApply);
        } catch (Exception e) {
            logger.error("RuningApplyDao--selectCountByRuningApply--error:" + e.getMessage());
        }

        return num;
    }

    /**
     * 根据RuningApply实体查询
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
    public List<RuningApply> selectByRuningApply(SqlSession session, RuningApply runingApply) {
        List<RuningApply> runingApplyList = new ArrayList<RuningApply>();

        try {
            logger.info("RuningApplyDao");

            runingApplyList = session.selectList("com.runing.dao.mapper.RuningApply.selectByRuningApply", runingApply);
        } catch (Exception e) {
            logger.error("RuningApplyDao--selectByRuningApply--error:" + e.getMessage());
        }

        return runingApplyList;
    }

    /**
     * 根据RuningApply实体模糊查询
     *
     * 查询数量
     *
     * @param runingApply
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int selectCountBySelectData(SqlSession session, RuningApply runingApply) {
        int num = 0;

        try {
            logger.info("RuningApplyDao");

            num = session.selectOne("com.runing.dao.mapper.RuningApply.selectCountBySelectData", runingApply);
        } catch (Exception e) {
            logger.error("RuningApplyDao--selectCountBySelectData--error:" + e.getMessage());
        }

        return num;
    }

    /**
     * 根据RuningApply实体模糊查询
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
    public List<RuningApply> selectBySelectData(SqlSession session, RuningApply runingApply) {
        List<RuningApply> runingApplyList = new ArrayList<RuningApply>();

        try {
            logger.info("RuningApplyDao");

            runingApplyList = session.selectList("com.runing.dao.mapper.RuningApply.selectBySelectData", runingApply);
        } catch (Exception e) {
            logger.error("RuningApplyDao--selectBySelectData--error:" + e.getMessage());
        }

        return runingApplyList;
    }

    /**
     * 根据Id实体删除(假删、更改删除状态)
     *
     * @param runingApply
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int updateByRuningApplyDeleteState(SqlSession session, RuningApply runingApply) {
        int num = 0;

        try {
            logger.info("RuningApplyDao");

            num = session.update("com.runing.dao.mapper.RuningApply.updateByRuningApplyDeleteState", runingApply);
        } catch (Exception e) {
            logger.error("RuningApplyDao--updateByRuningApplyDeleteState--error:" + e.getMessage());
        }

        return num;
    }



    /**
     * 根据RuningApply实体删除
     *
     * @param runingApply
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int deleteByRuningApply(SqlSession session, RuningApply runingApply) {
        int num = 0;

        try {
            logger.info("RuningApplyDao");

            num = session.delete("com.runing.dao.mapper.RuningApply.deleteByRuningApply", runingApply);
        } catch (Exception e) {
            logger.error("RuningApplyDao--deleteByRuningApply--error:" + e.getMessage());
        }

        return num;
    }
}

