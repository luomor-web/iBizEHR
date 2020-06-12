export default {
  fields: {
    orgsectorid: '部门ID',
    jlss: '记录所属',
    zjh: '证件号',
    createdate: '建立时间',
    nl: '年龄',
    sfjjllr: '是否紧急联络人',
    zzmm: '政治面貌',
    jlglbh: '记录管理编号',
    zw: '职务',
    createman: '建立人',
    pimfaminfoname: '姓名',
    zjlx: '证件类型',
    csrq: '出生日期',
    sruvivors: '是否遗属',
    ybrgx: '与本人关系',
    gzdw: '工作单位',
    updatedate: '更新时间',
    spstate: '审批状态',
    orgid: '组织ID',
    xb: '性别',
    jlczz: '记录操作者',
    pimfaminfoid: '家庭情况标识',
    nj: '年龄',
    enable: '逻辑有效标志',
    reason: '拒绝原因',
    jlspzt: '记录审批状态',
    updateman: '更新人',
    telphone: '联系电话',
    ormorgid: '组织标识',
    ormorgsectorid: '部门标识',
    ygbh: '员工编号',
    pimpersonname: '员工姓名',
    pimpersonid: '人员信息标识',
  },
	views: {
		greditview: {
			caption: '家庭情况',
      title: '家庭情况编辑视图',
		},
		grpimfimgridview: {
			caption: '家庭情况',
      title: '家庭情况表格视图',
		},
	},
	main_2_form: {
		details: {
			group1: '家庭情况基本信息', 
			formpage1: '基本信息', 
			srfupdatedate: '更新时间', 
			srforikey: '', 
			srfkey: '家庭情况标识', 
			srfmajortext: '姓名', 
			srftempmode: '', 
			srfuf: '', 
			srfdeid: '', 
			srfsourcekey: '', 
			pimpersonid: '人员信息标识', 
			ybrgx: '与本人关系', 
			pimfaminfoname: '姓名', 
			zjlx: '证件类型', 
			zjh: '证件号', 
			xb: '性别', 
			csrq: '出生日期', 
			nl: '年龄', 
			gzdw: '工作单位', 
			zw: '职务', 
			zzmm: '政治面貌', 
			sfjjllr: '是否紧急联络人', 
			telphone: '联系电话', 
			sruvivors: '是否遗属', 
			jlss: '记录所属', 
			pimfaminfoid: '家庭情况标识', 
		},
		uiactions: {
		},
	},
	main_family_grid: {
		columns: {
			ybrgx: '与本人关系',
			pimfaminfoname: '姓名',
			xb: '性别',
			nl: '年龄',
			gzdw: '工作单位',
			zw: '职务',
			zzmm: '政治面貌',
			zjh: '证件号',
			csrq: '出生日期',
			sfjjllr: '是否紧急联络人',
			jlspzt: '审批状态',
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: '常规条件', 
			n_pimfaminfoname_like: '姓名(%)', 
			n_xb_eq: '性别(=)', 
			n_zzmm_eq: '政治面貌(=)', 
			n_sfjjllr_eq: '是否紧急联络人(=)', 
		},
		uiactions: {
		},
	},
	greditviewtoolbar_toolbar: {
		tbitem3: {
			caption: '提交',
			tip: '提交',
		},
		tbitem5: {
			caption: '提交并关闭',
			tip: '提交并关闭',
		},
	},
	grpimfimgridviewtoolbar_toolbar: {
		tbitem3: {
			caption: '新建',
			tip: '新建',
		},
		tbitem8: {
			caption: '删除',
			tip: '删除',
		},
	},
};