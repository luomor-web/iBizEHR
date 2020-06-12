export default {
  fields: {
    createman: '建立人',
    questionman: '提出人',
    createdate: '提出时间',
    twurl: '问题页面Url',
    jjcd: '紧急程度',
    ymmc: '问题页面代码',
    ym: '页面',
    gn: '功能',
    jt: '界面截图',
    wtfk: '问题反馈',
    lxdh: '联系电话',
    wtms: '问题描述',
    updateman: '更新人',
    mk: '模块',
    questionsname: '问题',
    updatedate: '更新时间',
    kfz: '开发者',
    tcsj: '提出时间',
    wcsj: '完成时间',
    questionsid: '问题收集标识',
    wtzt: '问题状态',
    wtbh: '问题编号',
  },
	views: {
		yh_checkeditview: {
			caption: '问题收集',
      title: '用户查看表单',
		},
		editview: {
			caption: '问题收集',
      title: '问题收集编辑视图',
		},
		currentquestionsgridview: {
			caption: '问题收集',
      title: '本页问题表格',
		},
		gridview: {
			caption: '问题收集',
      title: '问题收集表格视图',
		},
		dev_checkeditview: {
			caption: '问题收集',
      title: '开发者查看表单',
		},
	},
	yh_check_form: {
		details: {
			group1: '问题收集基本信息', 
			formpage1: '基本信息', 
			srfupdatedate: '更新时间', 
			srforikey: '', 
			srfkey: '问题收集标识', 
			srfmajortext: '问题', 
			srftempmode: '', 
			srfuf: '', 
			srfdeid: '', 
			srfsourcekey: '', 
			wtbh: '问题编号', 
			questionsname: '问题', 
			jjcd: '紧急程度', 
			ym: '页面', 
			wtms: '问题描述', 
			jt: '界面截图', 
			wtzt: '问题状态', 
			kfz: '开发者', 
			wcsj: '完成时间', 
			wtfk: '问题反馈', 
			questionsid: '问题收集标识', 
		},
		uiactions: {
		},
	},
	main_form: {
		details: {
			group1: '问题收集基本信息', 
			druipart1: '', 
			grouppanel1: '本页问题', 
			formpage1: '基本信息', 
			srfupdatedate: '更新时间', 
			srforikey: '', 
			srfkey: '问题收集标识', 
			srfmajortext: '问题', 
			srftempmode: '', 
			srfuf: '', 
			srfdeid: '', 
			srfsourcekey: '', 
			twurl: '问题页面Url', 
			ymmc: '问题页面代码', 
			questionsname: '问题', 
			jjcd: '紧急程度', 
			ym: '页面', 
			wtms: '问题描述', 
			jt: '界面截图', 
			wtzt: '问题状态', 
			questionman: '提出人', 
			questionsid: '问题收集标识', 
		},
		uiactions: {
		},
	},
	dev_check_form: {
		details: {
			group1: '问题收集基本信息', 
			formpage1: '基本信息', 
			srfupdatedate: '更新时间', 
			srforikey: '', 
			srfkey: '问题收集标识', 
			srfmajortext: '问题', 
			srftempmode: '', 
			srfuf: '', 
			srfdeid: '', 
			srfsourcekey: '', 
			twurl: '问题页面Url', 
			ymmc: '问题页面代码', 
			wtbh: '问题编号', 
			questionsname: '问题', 
			jjcd: '紧急程度', 
			ym: '页面', 
			wtms: '问题描述', 
			jt: '界面截图', 
			wtzt: '问题状态', 
			wcsj: '完成时间', 
			wtfk: '问题反馈', 
			questionsid: '问题收集标识', 
		},
		uiactions: {
		},
	},
	currentquestions_grid: {
		columns: {
			wtbh: '问题编号',
			questionsname: '问题',
			jjcd: '紧急程度',
			createman: '提出人',
			createdate: '提出时间',
			wtms: '问题描述',
			wtzt: '问题状态',
			wcsj: '完成时间',
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			wtbh: '问题编号',
			ym: '页面',
			questionsname: '问题',
			jjcd: '紧急程度',
			createman: '提出人',
			createdate: '提出时间',
			wtms: '问题描述',
			wtzt: '问题状态',
			wcsj: '完成时间',
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: '常规条件', 
			n_ym_like: '页面(%)', 
			n_questionman_like: '提出人(%)', 
			n_createdate_gtandeq: '提出时间从', 
			n_createdate_ltandeq: '至', 
			n_jjcd_eq: '紧急程度(=)', 
			n_wtzt_eq: '问题状态(=)', 
		},
		uiactions: {
		},
	},
	yh_checkeditviewtoolbar_toolbar: {
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
	editviewtoolbar_toolbar: {
		tbitem5: {
			caption: '提交问题',
			tip: '提交问题',
		},
		tbitem22: {
			caption: '帮助',
			tip: '帮助',
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
	dev_checkeditviewtoolbar_toolbar: {
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