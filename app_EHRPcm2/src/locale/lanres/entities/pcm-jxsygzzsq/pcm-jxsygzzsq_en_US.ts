
export default {
  fields: {
    czrq: '操作时间',
    orgid: '组织机构标识',
    czr: '操作人',
    istemp: '是否为临时数据',
    bz: '备注',
    updateman: '更新人',
    createdate: '建立时间',
    updatedate: '更新时间',
    czrid: '操作人标志',
    pcmjxsygzzsqname: '标题',
    sxrq: '生效日期',
    createman: '建立人',
    zzlx: '转正类型',
    pcmjxsygzzsqid: '见习生员工转正申请标识',
  },
	views: {
		jxszzsqjmeditview: {
			caption: "见习生员工转正申请",
      title: '见习生员工转正申请',
		},
	},
	jxszzsqeditform_form: {
		details: {
			group1: "见习生转正基本信息", 
			druipart2: "", 
			grouppanel1: "见习生转正明细", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "见习生员工转正申请标识", 
			srfmajortext: "标题", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			pcmjxsygzzsqid: "见习生员工转正申请标识", 
			pcmjxsygzzsqname: "标题", 
			czr: "操作人", 
			czrq: "操作时间", 
			sxrq: "生效日期", 
			zzlx: "转正类型", 
			bz: "备注", 
			czrid: "操作人标志", 
		},
		uiactions: {
		},
	},
	jxszzsqjmeditviewtoolbar_toolbar: {
		deuiaction2_saveandexit: {
			caption: "确认",
			tip: "确认",
		},
		deuiaction1: {
			caption: "退出",
			tip: "退出",
		},
	},
};