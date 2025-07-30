package edu.pnu.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import edu.pnu.dao.LogDao;
import edu.pnu.dao.MemberDao;
import edu.pnu.domain.MemberDTO;

@Service
public class MemberService {
    
    private MemberDao memberDao;
    private LogDao logDao;
    
    public MemberService() {
        memberDao = new MemberDao();
        logDao = new LogDao();
    }

    public List<MemberDTO> getAllMember() {
        List<MemberDTO> result = null;
        String method = "get";
        String sqlstring = "SELECT * FROM member";
        boolean success = false;

        try {
            result = memberDao.getAllMember();
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<String, Object> log = new HashMap<>();
        log.put("method", method);
        log.put("sqlstring", sqlstring);
        log.put("success", success);
        logDao.addLog(log);

        return result;
    }

    public MemberDTO getMemberById(Integer id) {
        MemberDTO result = null;
        String method = "get";
        String sqlstring = "SELECT * FROM member WHERE id=?";
        boolean success = false;

        try {
            result = memberDao.getMemberById(id);
            success = (result != null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<String, Object> log = new HashMap<>();
        log.put("method", method);
        log.put("sqlstring", sqlstring);
        log.put("success", success);
        logDao.addLog(log);

        return result;
    }

    public MemberDTO postMember(MemberDTO memberDTO) {
        MemberDTO result = null;
        String method = "post";
        String sqlstring = "INSERT INTO member (name, pass) VALUES(?,?)";
        boolean success = false;

        try {
            result = memberDao.postMember(memberDTO);
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<String, Object> log = new HashMap<>();
        log.put("method", method);
        log.put("sqlstring", sqlstring);
        log.put("success", success);
        logDao.addLog(log);

        return result;
    }

    public MemberDTO putMember(Integer id, MemberDTO memberDTO) {
        MemberDTO result = null;
        String method = "put";
        String sqlstring = "UPDATE member SET name=?, pass=? WHERE id=?";
        boolean success = false;

        try {
            result = memberDao.putMember(id, memberDTO);
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<String, Object> log = new HashMap<>();
        log.put("method", method);
        log.put("sqlstring", sqlstring);
        log.put("success", success);
        logDao.addLog(log);

        return result;
    }

    public MemberDTO patchMember(Integer id, MemberDTO memberDTO) {
        MemberDTO result = null;
        String method = "patch";
        String sqlstring = "UPDATE member SET ... WHERE id = " + id;
        boolean success = false;

        try {
            result = memberDao.patchMember(id, memberDTO);
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<String, Object> log = new HashMap<>();
        log.put("method", method);
        log.put("sqlstring", sqlstring);
        log.put("success", success);
        logDao.addLog(log);

        return result;
    }

    public void deleteMember(Integer id) {
        String method = "delete";
        String sqlstring = "DELETE FROM member WHERE id=?";
        boolean success = false;

        try {
            memberDao.deleteMember(id);
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<String, Object> log = new HashMap<>();
        log.put("method", method);
        log.put("sqlstring", sqlstring);
        log.put("success", success);
        logDao.addLog(log);
    }
}
