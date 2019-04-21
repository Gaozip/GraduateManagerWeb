package org.whale.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
	
	@Transactional
	@Override
	public void doSave(Resume resume,List<ResumeWork> workList,List<ResumeProject> projectList) {
		
		//保存简历
		if(resume != null){
			this.resumeMapper.doSave(resume);
		}

		//获取当前简历ID
		Long resumeId = this.resumeMapper.getResumeId();
		
		if(!workList.isEmpty() && workList != null){
			for(ResumeWork work : workList){
				work.setIsValid((short)1);
				work.setFkResumeId(resumeId);
				this.resumeWorkMapper.doSave(work);
			}
		}
		
		if(!projectList.isEmpty() && projectList != null){
			for(ResumeProject project : projectList ){
				project.setIsValid((short)1);
				project.setFkResumeId(resumeId);
				this.resumeProjectMapper.doSave(project);
			}
		}
	}

	@Override
	public Page queryResumePage(Page page, Map<String, String> paramMap,Long userId) {
		
		String resumeId = paramMap.get("resumeId");
		
		//1.查询此用户所有简历基本信息
		List<Resume> resumeList = this.resumeMapper.queryPageByFkId(userId,resumeId);
		
		List<Resume> arrayList = new ArrayList<Resume>();
		
		if(resumeList.size() != 0){
			for(int i = 0;i < resumeList.size();i++){
				Resume resume = resumeList.get(i);
			    resume.setWorkList(this.resumeWorkMapper.queryPageByFkId(resume.getPkResumeId()));
			    resume.setProjectList(this.resumeProjectMapper.queryPageByFkId(resume.getPkResumeId()));
			    resume.setGraduateInfo(this.graduateInfoMapper.queryBasicInfoById(userId));
			    arrayList.add(resume);
			}
		}
		
		page.setTotalNum((long)arrayList.size());
		page.setDatas(arrayList);
		
		return page;
	}

	@Override
	public void doUpdateByResumeId(Long resumeId, Resume resume2, List<ResumeWork> workList,List<ResumeProject> projectList) {
		
		//先更新resume
		Resume resume = this.resumeMapper.queryResumeById(resumeId);
		resume.setPkResumeId(resume2.getPkResumeId());
		resume.setJobType(resume2.getJobType());
		resume.setExpertIndustry(resume2.getExpertIndustry());
		resume.setExpertJobIntension(resume2.getExpertJobIntension());
		resume.setExpertSalary(resume2.getExpertSalary());
		resume.setJobStatus(resume2.getJobStatus());
		resume.setProfessionalAbility(resume2.getProfessionalAbility());
		resume.setCertificate(resume2.getCertificate());
		resume.setCity(resume2.getCity());
		resume.setProvince(resume2.getProvince());
		
		this.resumeMapper.doUpdateByResumeId(resume);
		
		//获取这个简历的所有工作经验 ID和项目经验ID(pk)
		List<Long> resumeWorkIdList = this.resumeWorkMapper.getResumeWorkIdByResumeId(resume.getPkResumeId());
		List<Long> resumeProjectIdList = this.resumeProjectMapper.getResumeProjectIdByResumeId(resume.getPkResumeId());
		
		
		//删除前台简历中的工作经验和项目经验
		//工作经验
		List<Long> workIdList = new ArrayList<Long>();
		for(ResumeWork work : workList){
			if(work.getPkResumeWorkId() != null){
				workIdList.add(work.getPkResumeWorkId());
			}
		}
		List<Long> delWorkIdList = comparePkId(resumeWorkIdList,workIdList);
		for(Long id : delWorkIdList){
			this.resumeWorkMapper.doDelete(id);
		}
		//项目经验
		List<Long> projectIdList = new ArrayList<Long>();
		for(ResumeProject project : projectList){
			if(project.getPkResumeProject() != null){
				projectIdList.add(project.getPkResumeProject());
			}
		}
		List<Long> delProjectIdList = comparePkId(resumeProjectIdList,projectIdList);
		for(Long id : delProjectIdList){
			this.resumeProjectMapper.doDelete(id);
		}
		
		//再更新工作经验
		for(ResumeWork work2 : workList){
			if(work2.getPkResumeWorkId() == null){	//如果是新增的，则插入
				work2.setFkResumeId(resume.getPkResumeId());
				work2.setIsValid((short)1);
				this.resumeWorkMapper.doSave(work2);
			}else{	//更新
				//先获取
				ResumeWork work = this.resumeWorkMapper.getResumeWorkByPkId(work2.getPkResumeWorkId());
				work.setCompanyName(work2.getCompanyName());
				work.setJobType(work2.getJobType());
				work.setJobIntension(work2.getJobIntension());
				work.setJobDescription(work2.getJobDescription());
				work.setMonthSalary(work2.getMonthSalary());
				work.setWorkDate(work2.getWorkDate());
				work.setIndustry(work2.getIndustry());
				this.resumeWorkMapper.doUpdate(work);
			}
		}
		
		//最后更新项目经验
		for(ResumeProject project2 : projectList){
			//如果pk不为空，且不在原来存入数据库的idList中，则视为删除
			if(project2.getPkResumeProject() == null){ //新增则插入
				project2.setFkResumeId(resume.getPkResumeId());
				project2.setIsValid((short)1);
				this.resumeProjectMapper.doSave(project2);
			}else{	//更新
				//先获取
				ResumeProject project = this.resumeProjectMapper.getResumeProjectByPkId(project2.getPkResumeProject());
				project.setCompanyName(project2.getCompanyName());
				project.setPersonalResponsibility(project2.getPersonalResponsibility());
				project.setProjectDate(project2.getProjectDate());
				project.setProjectDescription(project2.getProjectDescription());
				project.setProjectName(project2.getProjectName());
				this.resumeProjectMapper.doUpdate(project);
			}
		}
	}

	@Override
	@Transactional
	public void doDeleteByResumeId(Long resumeId) {
		resumeMapper.doDeleteByResumeId(resumeId);
		resumeWorkMapper.doDeleteByResumeId(resumeId);
		resumeProjectMapper.doDeleteByResumeId(resumeId);
	}

	@Override
	public Page getResumeByEmployer(Page page,Map<String, String> paramMap) {
		
		String name = paramMap.get("name");
		String age = paramMap.get("age");
		String sex = paramMap.get("sex");
		String province = paramMap.get("province");
		String city = paramMap.get("city");
		String education = paramMap.get("education");
		String gradCollege = paramMap.get("gradCollege");
		String specialty = paramMap.get("specialty");
		String workYear = paramMap.get("workYear");
		String FUZZY_WORD = paramMap.get("FUZZY_WORD");
		
		//先找出满足这些条件的毕业生对应的userId
		List<Long> userIdList = this.graduateInfoMapper.queryIdByRequire(name,age,sex,province,city,education,gradCollege,specialty,workYear,FUZZY_WORD);
		
		
		List<Object> totalList = new ArrayList<Object>();
		for(Long id : userIdList){
			System.out.println(id);
			List<Resume> resumeList = this.resumeMapper.queryPageByFkId(id,""); //根据userId查询所有简历
			List<Resume> arrayList = new ArrayList<Resume>();
			
			if(resumeList.size() != 0){
				for(int i = 0;i < resumeList.size();i++){
					Resume resume = resumeList.get(i);
				    resume.setWorkList(this.resumeWorkMapper.queryPageByFkId(resume.getPkResumeId()));
				    resume.setProjectList(this.resumeProjectMapper.queryPageByFkId(resume.getPkResumeId()));
				    resume.setGraduateInfo(this.graduateInfoMapper.queryBasicInfoById(id));
				    arrayList.add(resume);
				}
			}
			if(arrayList.size() != 0){
				totalList.add(arrayList);
			}
		}
		page.setTotalNum((long)totalList.size());
		page.setDatas(totalList);
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
	
	/**
	 * 比较pkid，看是否存在，不存在视为删除，并返回删除的id
	 * @param list:数据库内属于该简历的所有id
	 * @param IdList:前台传回来的id，可能比list少
	 * @return 不同的idList,即为要删除的idList
	 */
	public List<Long> comparePkId(List<Long> list,List<Long> IdList){
		List<Long> arrayList = new ArrayList<Long>();
		for(Long id1 : list){
			boolean del = false;
			for(Long id2 : IdList){
				if(id1 == id2){
					del = true;
				}
			}
			if(!del){
				arrayList.add(id1);
			}
		}
		return arrayList;
	}

}

