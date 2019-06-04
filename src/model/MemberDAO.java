package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import model.Member;
import model.MemberFileWriter;

public class MemberDAO {
	private ArrayList<Member> memberList = null;
	
	private File file = null;
	private MemberFileReader fr = null;
	private MemberFileWriter fw = null;
	
	public MemberDAO(File file) {	
		this.file = file;
		try {
			fr = new MemberFileReader(file);
			memberList = fr.readMember();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<Member> selectAll() { 
		// �Է��� �޸� �� �����ϴ� ��� ��� ������ ������ ���			
		return memberList;
	}
	
	public Member selectMember(Member member) {
		int index = -1;
		if((index = searchByID(member)) >= 0)
			return memberList.get(index);
		else
			return null;
	}
	
	public int searchByID(Member member) { 
		int ret = -1; // ret�� 0 �̻��̸� �˻� ����, -1 �̸� �˻� ����
		int index = 0;
		for(Member m : memberList) {
			if(m.getUid().equals(member.getUid())) {
				ret = index;
				break;
			}
			index++;
		}				
		return ret;
	}
	
	public int insert(Member member) {
		int ret = -1;
		try {
			int index = searchByID(member);
			if(index < 0) { // -1�̸� �˻� ����, ��� ������
				fw = new MemberFileWriter(file);
				memberList.add(member);
				fw.saveMember(memberList);
				ret = 0;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return ret;
	}
	
	public int update(Member member) {
		int ret = -1; // 0 �̻��̸� �ش� ���̵� �����ϹǷ� ����, -1�����̸� ���� ����		
		
		
		return ret;
	}	
	public int delete(Member member) {		
		int ret = -1; // 0 �̻��̸� �ش� ���̵� �����ϹǷ� ����, -1�����̸� ���� ����
		
		return ret;
	}
	public void printMemberList() {
		for(Member m : memberList)
			System.out.println(m.getUname() + ":" + m.getUid());
	}
}
