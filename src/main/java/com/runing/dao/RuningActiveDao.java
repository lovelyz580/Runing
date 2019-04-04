package com.runing.dao;

import com.runing.entity.RuningActive;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lovelyz
 * on 2019-04-01 16:51
 */
@Repository
public class RuningActiveDao {

    private Logger logger = Logger.getLogger(RuningActiveDao.class);

    public int insert(SqlSession session, RuningActive runingActive) {
        int num = 0;

        try {
            logger.info("RuningActiveDao");

            num = session.insert("com.runing.dao.mapper.RuningActive.insert", runingActive);
        } catch (Exception e) {
            logger.error("RuningActiveDao--insert--error:" + e.getMessage());
        }

        return num;
    }

    public int insertSelective(SqlSession session, RuningActive runingActive) {
        int num = 0;

        try {
            logger.info("RuningActiveDao");

            num = session.insert("com.runing.dao.mapper.RuningActive.insertSelective", runingActive);
        } catch (Exception e) {
            logger.error("RuningActiveDao--insertSelective--error:" + e.getMessage());
        }

        return num;
    }

    public int updateByPrimaryKeySelective(SqlSession session, RuningActive runingActive) {
        int num = 0;

        try {
            logger.info("RuningActiveDao");

            num = session.update("com.runing.dao.mapper.RuningActive.updateByPrimaryKeySelective", runingActive);
        } catch (Exception e) {
            logger.error("RuningActiveDao--updateByPrimaryKeySelective--error:" + e.getMessage());
        }

        return num;
    }

    public int updateByPrimaryKey(SqlSession session, RuningActive runingActive) {
        int num = 0;

        try {
            logger.info("RuningActiveDao");

            num = session.update("com.runing.dao.mapper.RuningActive.updateByPrimaryKey", runingActive);
        } catch (Exception e) {
            logger.error("RuningActiveDao--updateByPrimaryKey--error:" + e.getMessage());
        }

        return num;
    }

    public int selectCountByPrimaryKey(SqlSession session, Integer id) {
        int num = 0;

        try {
            logger.info("RuningActiveDao");

            num = session.selectOne("com.runing.dao.mapper.RuningActive.selectCountByPrimaryKey", id);
        } catch (Exception e) {
            logger.error("RuningActiveDao--selectCountByPrimaryKey--error:" + e.getMessage());
        }

        return num;
    }

    public RuningActive selectByPrimaryKey(SqlSession session, Integer id) {
        RuningActive runingActive = new RuningActive();

        try {
            logger.info("RuningActiveDao");

            runingActive = session.selectOne("com.runing.dao.mapper.RuningActive.selectByPrimaryKey", id);
        } catch (Exception e) {
            logger.error("RuningActiveDao--selectByPrimaryKey--error:" + e.getMessage());
        }

        return runingActive;
    }

    public int deleteByPrimaryKey(SqlSession session, String id) {
        int num = 0;

        try {
            logger.info("RuningActiveDao");

            num = session.delete("com.runing.dao.mapper.RuningActive.deleteByPrimaryKey", id);
        } catch (Exception e) {
            logger.error("RuningActiveDao--deleteByPrimaryKey--error:" + e.getMessage());
        }

        return num;
    }




    /**
     * 根据RuningActive实体添加
     *
     * @param runingActive
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int insertByRuningActive(SqlSession session, RuningActive runingActive) {
        int num = 0;

        try {
            logger.info("RuningActiveDao");

            num = session.insert("com.runing.dao.mapper.RuningActive.insertByRuningActive", runingActive);
        } catch (Exception e) {
            logger.error("RuningActiveDao--insertByRuningActive--error:" + e.getMessage());
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
    public int updateByRuningActive(SqlSession session, RuningActive runingActive) {
        int num = 0;

        try {
            logger.info("RuningActiveDao");

            num = session.update("com.runing.dao.mapper.RuningActive.updateByRuningActive", runingActive);
        } catch (Exception e) {
            logger.error("RuningActiveDao--updateByRuningActive--error:" + e.getMessage());
        }

        return num;
    }

    /**
     * 根据RuningActive实体查询
     *
     * 查询数量
     *
     * @param runingActive
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int selectCountByRuningActive(SqlSession session, RuningActive runingActive) {
        int num = 0;

        try {
            logger.info("RuningActiveDao");

            num = session.selectOne("com.runing.dao.mapper.RuningActive.selectCountByRuningActive", runingActive);
        } catch (Exception e) {
            logger.error("RuningActiveDao--selectCountByRuningActive--error:" + e.getMessage());
        }

        return num;
    }

    /**
     * 根据RuningActive实体查询
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
    public List<RuningActive> selectByRuningActive(SqlSession session, RuningActive runingActive) {
        List<RuningActive> runingActiveList = new ArrayList<RuningActive>();

        try {
            logger.info("RuningActiveDao");

            runingActiveList = session.selectList("com.runing.dao.mapper.RuningActive.selectByRuningActive", runingActive);
        } catch (Exception e) {
            logger.error("RuningActiveDao--selectByRuningActive--error:" + e.getMessage());
        }

        return runingActiveList;
    }

    /**
     * 根据RuningActive实体模糊查询
     *
     * 查询数量
     *
     * @param runingActive
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int selectCountBySelectData(SqlSession session, RuningActive runingActive) {
        int num = 0;

        try {
            logger.info("RuningActiveDao");

            num = session.selectOne("com.runing.dao.mapper.RuningActive.selectCountBySelectData", runingActive);
        } catch (Exception e) {
            logger.error("RuningActiveDao--selectCountBySelectData--error:" + e.getMessage());
        }

        return num;
    }

    /**
     * 根据RuningActive实体模糊查询
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
    public List<RuningActive> selectBySelectData(SqlSession session, RuningActive runingActive) {
        List<RuningActive> runingActiveList = new ArrayList<RuningActive>();

        try {
            logger.info("RuningActiveDao");

            runingActiveList = session.selectList("com.runing.dao.mapper.RuningActive.selectBySelectData", runingActive);
        } catch (Exception e) {
            logger.error("RuningActiveDao--selectBySelectData--error:" + e.getMessage());
        }

        return runingActiveList;
    }

    /**
     * 根据Id实体删除(假删、更改删除状态)
     *
     * @param runingActive
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int updateByRuningActiveDeleteState(SqlSession session, RuningActive runingActive) {
        int num = 0;

        try {
            logger.info("RuningActiveDao");

            num = session.update("com.runing.dao.mapper.RuningActive.updateByRuningActiveDeleteState", runingActive);
        } catch (Exception e) {
            logger.error("RuningActiveDao--updateByRuningActiveDeleteState--error:" + e.getMessage());
        }

        return num;
    }



    /**
     * 根据RuningActive实体删除
     *
     * @param runingActive
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int deleteByRuningActive(SqlSession session, RuningActive runingActive) {
        int num = 0;

        try {
            logger.info("RuningActiveDao");

            num = session.delete("com.runing.dao.mapper.RuningActive.deleteByRuningActive", runingActive);
        } catch (Exception e) {
            logger.error("RuningActiveDao--deleteByRuningActive--error:" + e.getMessage());
        }

        return num;
    }
}


