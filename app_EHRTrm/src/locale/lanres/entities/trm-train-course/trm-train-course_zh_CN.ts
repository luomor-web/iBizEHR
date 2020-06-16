export default {
  fields: {
    createman: '建立人',
    jb: '级别',
    updateman: '更新人',
    kcbm: '课程编码',
    kclb: '课程类别',
    bbh: '版本号',
    pxmb: '培训目标',
    kcjs: '课程介绍',
    trmtraincoursename: '培训课程名称',
    trmtraincourseid: '培训课程标识',
    skfs: '授课方式',
    bb: '版本',
    kcxs: '累积学时',
    updatedate: '更新时间',
    enable: '逻辑有效标志',
    sffc: '是否封存',
    createdate: '建立时间',
    sfgx: '是否共享',
    ormorgname: '组织',
    trmtrainagencyname: '培训机构名称',
    nr: '培训内容',
    trmcoursesystemname: '培训模块',
    trmtrainagencyid: '培训机构标识',
    ormorgid: '组织标识',
    trmcoursesystemid: '课程体系标识',
  },
	views: {
		pickupgridview: {
			caption: '培训课程',
      title: '培训课程选择表格视图',
		},
		gridview: {
			caption: '培训课程',
      title: '培训课程表格视图',
		},
		editview: {
			caption: '培训课程',
      title: '培训课程编辑视图',
		},
		pickupview: {
			caption: '培训课程',
      title: '培训课程数据选择视图',
		},
		mpickupview: {
			caption: '培训课程',
      title: '培训课程数据多项选择视图',
		},
	},
	main_form: {
		details: {
			group1: '培训课程信息', 
			formpage1: '基本信息', 
			srfupdatedate: '更新时间', 
			srforikey: '', 
			srfkey: '培训课程标识', 
			srfmajortext: '培训课程名称', 
			srftempmode: '', 
			srfuf: '', 
			srfdeid: '', 
			srfsourcekey: '', 
			trmtraincoursename: '课程名称', 
			trmcoursesystemname: '培训模块', 
			jb: '级别', 
			bb: '版本', 
			kcxs: '累积学时', 
			pxmb: '培训目标', 
			nr: '培训内容', 
			sfgx: '是否共享', 
			kcjs: '课程介绍', 
			trmcoursesystemid: '课程体系标识', 
			trmtraincourseid: '培训课程标识', 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			trmtraincoursename: '课程名称',
			trmcoursesystemname: '培训模块',
			jb: '级别',
			bb: '版本',
			kcxs: '累积学时',
			nr: '培训内容',
			pxmb: '培训目标',
			sfgx: '是否共享',
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: '常规条件', 
			n_trmtraincoursename_like: '课程名称', 
			n_kclb_eq: '课程类别(=)', 
			n_skfs_eq: '授课方式(=)', 
			n_trmtrainagencyname_eq: '所属机构', 
			n_ormorgname_eq: '创建公司', 
			n_ormorgid_eq: '', 
			n_trmtrainagencyid_eq: '', 
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
		tbitem19: {
			caption: '过滤',
			tip: '过滤',
		},
		tbitem13: {
			caption: '导出',
			tip: '导出',
		},
		tbitem18: {
			caption: '帮助',
			tip: '帮助',
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