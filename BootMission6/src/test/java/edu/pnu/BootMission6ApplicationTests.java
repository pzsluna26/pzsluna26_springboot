package edu.pnu;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Member;
import edu.pnu.persistence.MemberRepository;

@SpringBootTest
public class BootMission6ApplicationTests {

    @Autowired
    private MemberRepository memberRepo;

    @Test
    public void testInsertMember() {
        List<Member> list = memberRepo.findAll();
        for (Member m : list) {
            System.out.println(m);
        }
    }
}
