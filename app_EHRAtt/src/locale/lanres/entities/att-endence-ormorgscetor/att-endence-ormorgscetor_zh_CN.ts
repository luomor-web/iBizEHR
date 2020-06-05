export default {
  fields: {
    createman: '建立人',
    updateman: '更新人',
    updatedate: '更新时间',
    dz: '考勤地址',
    attendenceormorgsectorname: '考勤部门名称',
    createdate: '建立时间',
    kqdz: '考勤地址（废弃）',
    attendenceormorgsectorid: '考勤部门标识',
    attendencesetupname: '考勤表名称',
    orgname: '组织名称',
    orgid: '组织机构标识',
    ormorgsectorname: '部门名称',
    ormorgsectorid: '部门标识',
    attendencesetupid: '考勤设置标识',
  },
	views: {
		gridview: {
			caption: '考勤部门',
      title: '考勤部门',
		},
		editview: {
			caption: '考勤部门',
      title: '考勤部门',
		},
	},
	main_form: {
		details: {
			group1: '考勤部门基本信息', 
			formpage1: '基本信息', 
			srfupdatedate: '更新时间', 
			srforikey: '', 
			srfkey: '考勤部门标识', 
			srfmajortext: '考勤部门名称', 
			srftempmode: '', 
			srfuf: '', 
			srfdeid: '', 
			srfsourcekey: '', 
			attendencesetupid: '考勤设置标识', 
			attendencesetupname: '考勤表名称', 
			orgid: '组织机构标识', 
			orgname: '组织名称', 
			ormorgsectorid: '部门标识', 
			ormorgsectorname: '部门名称', 
			attendenceormorgsectorid: '考勤部门标识', 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			ormorgsectorname: '部门名称',
			dz: '考勤地址',
			uagridcolumn1: '修改部门考勤地址',
		},
		uiactions: {
			xgkqdz: '修改考勤地址',
		},
	},
	default_searchform: {
		details: {
			formpage1: '常规条件', 
		},
		uiactions: {
		},
	},
	gridviewtoolbar_toolbar: {
		tbitem3: {
			caption: '新建',
			tip: '新建',
		},
		tbitem8: {
			caption: '删除',
			tip: '删除',
		},
	},
	editviewtoolbar_toolbar: {
		tbitem3: {
			caption: '保存',
			tip: '保存',
		},
		tbitem4: {
			caption: '保存并新建',
			tip: '保存并新建',
		},
		tbitem5: {
			caption: '保存并关闭',
			tip: '保存并关闭',
		},
		tbitem7: {
			caption: '删除并关闭',
			tip: '删除并关闭',
		},
		tbitem22: {
			caption: '帮助',
			tip: '帮助',
		},
	},
};