package com.runing.dao;

import com.runing.entity.RuningUser;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lovelyz
 * on 2019-04-01 14:40
 */
@Repository
public class RuningUserDao {

    private Logger logger = Logger.getLogger(RuningUserDao.class);

    public int insert(SqlSession session, RuningUser runingUser) {
        int num = 0;

        try {
            logger.info("RuningUserDao");

            num = session.insert("com.runing.dao.mapper.RuningUser.insert", runingUser);
        } catch (Exception e) {
            logger.error("RuningUserDao--insert--error:" + e.getMessage());
        }

        return num;
    }

    public int insertSelective(SqlSession session, RuningUser runingUser) {
        int num = 0;

        try {
            logger.info("RuningUserDao");

            num = session.insert("com.runing.dao.mapper.RuningUser.insertSelective", runingUser);
        } catch (Exception e) {
            logger.error("RuningUserDao--insertSelective--error:" + e.getMessage());
        }

        return num;
    }

    public int updateByPrimaryKeySelective(SqlSession session, RuningUser runingUser) {
        int num = 0;

        try {
            logger.info("RuningUserDao");

            num = session.update("com.runing.dao.mapper.RuningUser.updateByPrimaryKeySelective", runingUser);
        } catch (Exception e) {
            logger.error("RuningUserDao--updateByPrimaryKeySelective--error:" + e.getMessage());
        }

        return num;
    }

    public int updateByPrimaryKey(SqlSession session, RuningUser runingUser) {
        int num = 0;

        try {
            logger.info("RuningUserDao");

            num = session.update("com.runing.dao.mapper.RuningUser.updateByPrimaryKey", runingUser);
        } catch (Exception e) {
            logger.error("RuningUserDao--updateByPrimaryKey--error:" + e.getMessage());
        }

        return num;
    }

    public int selectCountByPrimaryKey(SqlSession session, Integer id) {
        int num = 0;

        try {
            logger.info("RuningUserDao");

            num = session.selectOne("com.runing.dao.mapper.RuningUser.selectCountByPrimaryKey", id);
        } catch (Exception e) {
            logger.error("RuningUserDao--selectCountByPrimaryKey--error:" + e.getMessage());
        }

        return num;
    }

    public RuningUser selectByPrimaryKey(SqlSession session, Integer id) {
        RuningUser runingUser = new RuningUser();

        try {
            logger.info("RuningUserDao");

            runingUser = session.selectOne("com.runing.dao.mapper.RuningUser.selectByPrimaryKey", id);
        } catch (Exception e) {
            logger.error("RuningUserDao--selectByPrimaryKey--error:" + e.getMessage());
        }

        return runingUser;
    }

    public int deleteByPrimaryKey(SqlSession session, String id) {
        int num = 0;

        try {
            logger.info("RuningUserDao");

            num = session.delete("com.runing.dao.mapper.RuningUser.deleteByPrimaryKey", id);
        } catch (Exception e) {
            logger.error("RuningUserDao--deleteByPrimaryKey--error:" + e.getMessage());
        }

        return num;
    }




    /**
     * 根据RuningUser实体添加
     *
     * @param runingUser
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int insertByRuningUser(SqlSession session, RuningUser runingUser) {
        int num = 0;

        try {
            logger.info("RuningUserDao");

            num = session.insert("com.runing.dao.mapper.RuningUser.insertByRuningUser", runingUser);
        } catch (Exception e) {
            logger.error("RuningUserDao--insertByRuningUser--error:" + e.getMessage());
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
    public int updateByRuningUser(SqlSession session, RuningUser runingUser) {
        int num = 0;

        try {
            logger.info("RuningUserDao");

            num = session.update("com.runing.dao.mapper.RuningUser.updateByRuningUser", runingUser);
        } catch (Exception e) {
            logger.error("RuningUserDao--updateByRuningUser--error:" + e.getMessage());
        }

        return num;
    }

    /**
     * 根据RuningUser实体查询
     *
     * 查询数量
     *
     * @param runingUser
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int selectCountByRuningUser(SqlSession session, RuningUser runingUser) {
        int num = 0;

        try {
            logger.info("RuningUserDao");

            num = session.selectOne("com.runing.dao.mapper.RuningUser.selectCountByRuningUser", runingUser);
        } catch (Exception e) {
            logger.error("RuningUserDao--selectCountByRuningUser--error:" + e.getMessage());
        }

        return num;
    }

    /**
     * 根据RuningUser实体查询
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
    public List<RuningUser> selectByRuningUser(SqlSession session, RuningUser runingUser) {
        List<RuningUser> runingUserList = new ArrayList<RuningUser>();

        try {
            logger.info("RuningUserDao");

            runingUserList = session.selectList("com.runing.dao.mapper.RuningUser.selectByRuningUser", runingUser);
        } catch (Exception e) {
            logger.error("RuningUserDao--selectByRuningUser--error:" + e.getMessage());
        }

        return runingUserList;
    }

    /**
     * 根据RuningUser实体模糊查询
     *
     * 查询数量
     *
     * @param runingUser
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int selectCountBySelectData(SqlSession session, RuningUser runingUser) {
        int num = 0;

        try {
            logger.info("RuningUserDao");

            num = session.selectOne("com.runing.dao.mapper.RuningUser.selectCountBySelectData", runingUser);
        } catch (Exception e) {
            logger.error("RuningUserDao--selectCountBySelectData--error:" + e.getMessage());
        }

        return num;
    }

    /**
     * 根据RuningUser实体模糊查询
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
    public List<RuningUser> selectBySelectData(SqlSession session, RuningUser runingUser) {
        List<RuningUser> runingUserList = new ArrayList<RuningUser>();

        try {
            logger.info("RuningUserDao");

            runingUserList = session.selectList("com.runing.dao.mapper.RuningUser.selectBySelectData", runingUser);
        } catch (Exception e) {
            logger.error("RuningUserDao--selectBySelectData--error:" + e.getMessage());
        }

        return runingUserList;
    }

    /**
     * 根据Id实体删除(假删、更改删除状态)
     *
     * @param runingUser
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int updateByRuningUserDeleteState(SqlSession session, RuningUser runingUser) {
        int num = 0;

        try {
            logger.info("RuningUserDao");

            num = session.update("com.runing.dao.mapper.RuningUser.updateByRuningUserDeleteState", runingUser);
        } catch (Exception e) {
            logger.error("RuningUserDao--updateByRuningUserDeleteState--error:" + e.getMessage());
        }

        return num;
    }



    /**
     * 根据RuningUser实体删除
     *
     * @param runingUser
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int deleteByRuningUser(SqlSession session, RuningUser runingUser) {
        int num = 0;

        try {
            logger.info("RuningUserDao");

            num = session.delete("com.runing.dao.mapper.RuningUser.deleteByRuningUser", runingUser);
        } catch (Exception e) {
            logger.error("RuningUserDao--deleteByRuningUser--error:" + e.getMessage());
        }

        return num;
    }
}
