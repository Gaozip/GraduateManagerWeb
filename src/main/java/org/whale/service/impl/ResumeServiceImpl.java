package org.whale.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.junit.runner.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.whale.dao.GraduateInfoMapper;
import org.whale.dao.ResumeMapper;
import org.whale.dao.ResumeProjectMapper;
import org.whale.dao.ResumeWorkMapper;
import org.whale.pojo.Page;
import org.whale.pojo.Resume;
import org.whale.pojo.ResumeProject;
import org.whale.pojo.ResumeWork;
import org.whale.service.ResumeService;
import org.whale.utils.Log4jUtils;
import org.whale.utils.PageUtils;

/**
* @ClassName： ResumeServiceImpl
* @Description：
* @author： 皮卡尔稽
* @date：2019年2月20日
*/
@Transactional
@Service
public class ResumeServiceImpl implements ResumeService {

	@Autowired
	private ResumeMapper resumeMapper;
	
	@Autowired
	private ResumeWorkMapper resumeWorkMapper;
	
	@Autowired
	private ResumeProjectMapper resumeProjectMapper;
	
	@Autowired
	private GraduateInfoMapper graduateInfoMapper;
	
	@Resource
	private PageUtils pageUtils;
	
	@Override
	public void doSave(Resume resume,List<ResumeWork> workList,List<ResumeProject> projectList) {
		
		System.err.println(resume.toString());
		for(ResumeWork work : workList){
			System.out.println(work.toString());
		}
		
		for(ResumeProject p : projectList ){
			System.out.println(p.toString());
		}
//		resumeMapper.doSave(resume);
//		
//		Long resumeId = resumeMapper.getResumeId(resume);//获取简历ID
//		
//		for(ResumeWork w : workList ){
//			w.setFkResumeId(resumeId);
//			Log4jUtils.getLogger().info(w.toString());
//		}
//		
//		for(ResumeProject p : projectList){
//			p.setFkResumeId(resumeId);
//			Log4jUtils.getLogger().info(p.toString());
//		}
//		if(!workList.isEmpty() && workList != null){
//			resumeWorkMapper.doSave(workList);
//		}
//		
//		if(!projectList.isEmpty() && projectList != null){
//			resumeProjectMapper.doSave(projectList);
//		}
		
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Page queryResumePage(Page page, Long userId) {
		
		//1.查询此用户所有简历基本信息
		HashMap resumeMap = pageUtils.queryPageById(userId, "SYS_RESUME");
		
		return null;
	}

	@Override
	public void doUpdateByResumeId(Long resumeId, Resume resume, List<ResumeWork> workList,
			List<ResumeProject> projectList) {
		
		resume.setPkResumeId(resumeId);
		resumeMapper.doUpdateByResumeId(resume);
		
		for(ResumeWork w : workList){
			w.setFkResumeId(resumeId);
			Log4jUtils.getLogger().info(w);
		}
		
		for(ResumeProject p : projectList){
			p.setFkResumeId(resumeId);
			Log4jUtils.getLogger().info(p);
		}
		
		resumeWorkMapper.doUpdateByResumeId(workList);
		resumeProjectMapper.doUpdateByResumeId(projectList);
	}

	@Override
	public void doDeleteByResumeId(Long resumeId) {
		resumeMapper.doDeleteByResumeId(resumeId);
		resumeWorkMapper.doDeleteByResumeId(resumeId);
		resumeProjectMapper.doDeleteByResumeId(resumeId);
	}

	@Override
	public Page doSearch(Page page, Long resumeId) {
		
		Page pages = doSearchByRequire(page,resumeId,"","","",(Long)null,"","","",(Long)null);
		return pages;
	}

	@Override
	public Page getResumeByEmployer(Page page) {
		
		List<Resume> resumeList = resumeMapper.getResumeByEmployer();
		for(Resume r : resumeList){
			r.setWorkList(resumeWorkMapper.getResumeWorkByResumeId(r.getPkResumeId()));
			r.setProjectList(resumeProjectMapper.getResumeProjectByResumeId(r.getPkResumeId()));
			r.setGraduateInfo(graduateInfoMapper.queryBasicInfoById(r.getFkUserId()));
			Log4jUtils.getLogger().info(r.toString());
		}
		
		page.setTotalNum((long)resumeList.size());
		page.setDatas(resumeList);
		
		return page;
	}

	@Override
	public Page doSearchByRequire(Page page, Long resumeId, String expertIndustry, String education, String sex,
			Long age, String workYear, String gradCollege, String expertJobIntension,Long userId) {

		List<Resume> resumeList = resumeMapper.doSearchByRequire(resumeId,expertIndustry,education,sex,age,workYear,gradCollege,expertJobIntension,userId);
		for(Resume resume : resumeList){
			Log4jUtils.getLogger().info(resume.toString());
		}
		
		page.setTotalNum((long)resumeList.size());
		page.setDatas(resumeList);
		
		return page;
	}

}

