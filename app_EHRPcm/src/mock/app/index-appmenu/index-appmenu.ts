import { MockAdapter } from '@/mock/mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'
const Random = Mock.Random;

// 获取应用数据
mock.onGet('v7/indexappmenu').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status, {
        name: 'appmenu',
        items:  [
            {
	id: '7442B171-FA03-4FE0-898D-A05DFDDDB8C5',
	name: 'menuitem2',
	text: '校园招聘',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '校园招聘',
	expanded: true,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/1/daigangguanli.png',
	textcls: '',
	appfunctag: 'Auto499',
	resourcetag: '',
	items: [
		{
	id: 'd7cd6c0305b469dd469ed647293f2cd7',
	name: 'menuitem1',
	text: '应聘者',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '应聘者',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/1/chengshurencaizhaopin.png',
	textcls: '',
	appfunctag: 'Auto499',
	resourcetag: '',
},
		{
	id: '2BDA8CB3-15F3-42AD-8CC6-0AC8B7C77530',
	name: 'menuitem3',
	text: '用人单位审核',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '用人单位审核',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/1/xiaoyuanzhaopin.png',
	textcls: '',
	appfunctag: 'Auto4',
	resourcetag: '',
},
		{
	id: '3B7D53A1-C97A-414E-8F5A-314F63373DEA',
	name: 'menuitem4',
	text: '人力上报',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '人力上报',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/1/yleiyuangongzhuanzheng.png',
	textcls: '',
	appfunctag: 'Auto16',
	resourcetag: '',
},
		{
	id: '6921287A-54F6-4BB5-A767-24F8BA49BA52',
	name: 'menuitem5',
	text: '总部审核',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '总部审核',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/1/zhijizhiwuguanxi.png',
	textcls: '',
	appfunctag: 'Auto7',
	resourcetag: '',
},
		{
	id: 'E4B23A6F-7E35-4690-87A9-A660AB229BDA',
	name: 'menuitem6',
	text: '编号审批',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '编号审批',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/hetongguanli.png',
	textcls: '',
	appfunctag: 'Auto17',
	resourcetag: '',
},
		{
	id: '5FF495D3-421E-4A19-BDA5-FDEEF2925FEB',
	name: 'menuitem7',
	text: '拟录用人员',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '拟录用人员',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/xinqianhetong.png',
	textcls: '',
	appfunctag: 'Auto8',
	resourcetag: '',
},
	],
},
            {
	id: 'A22398FB-85F4-43C9-86CA-A3059142C5FE',
	name: 'menuitem8',
	text: '成熟人才引进',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '成熟人才引进',
	expanded: true,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/1/neituiguanli.png',
	textcls: '',
	appfunctag: '',
	resourcetag: '',
	items: [
		{
	id: 'BE1F3DA6-03C5-4230-81A6-F802CC0B332E',
	name: 'menuitem9',
	text: '应聘者',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '应聘者',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/1/chengshurencaizhaopin.png',
	textcls: '',
	appfunctag: 'Auto14',
	resourcetag: '',
},
		{
	id: 'D6BC76ED-68F5-434E-819A-90384CA6E8FD',
	name: 'menuitem10',
	text: '用人单位审核',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '用人单位审核',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/1/xiaoyuanzhaopin.png',
	textcls: '',
	appfunctag: 'Auto1',
	resourcetag: '',
},
		{
	id: '3F3AD256-D204-486E-8DE2-EB7F53F71F7D',
	name: 'menuitem11',
	text: '人力上报',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '人力上报',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/1/yleiyuangongzhuanzheng.png',
	textcls: '',
	appfunctag: 'Auto6',
	resourcetag: '',
},
		{
	id: '99341193-BE31-4790-B539-138EAB86D419',
	name: 'menuitem12',
	text: '总部审核',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '总部审核',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/1/zhijizhiwuguanxi.png',
	textcls: '',
	appfunctag: 'Auto12',
	resourcetag: '',
},
		{
	id: 'BEAD1172-E61C-45A9-A556-0A706028CE1A',
	name: 'menuitem13',
	text: '编号审批',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '编号审批',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/hetongguanli.png',
	textcls: '',
	appfunctag: 'Auto13',
	resourcetag: '',
},
		{
	id: '7BBCD702-0D49-4EB2-B7EC-BADCC7FCA75F',
	name: 'menuitem14',
	text: '拟录用人员',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '拟录用人员',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/xinqianhetong.png',
	textcls: '',
	appfunctag: 'Auto11',
	resourcetag: '',
},
	],
},
            {
	id: '81E1ADAC-AA36-413B-B34F-E63937A5EB10',
	name: 'menuitem15',
	text: '标准化数据设置',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '标准化数据设置',
	expanded: true,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/zhiyezigemuluguanli.png',
	textcls: '',
	appfunctag: '',
	resourcetag: '',
	items: [
		{
	id: '423828DA-7116-414F-ACD3-B52D0169DBB7',
	name: 'menuitem16',
	text: '招聘名额管理',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '招聘名额管理',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/1/xiaoyuanzhaopin.png',
	textcls: '',
	appfunctag: 'Auto18',
	resourcetag: '',
},
		{
	id: '15BB5FA6-1931-4049-A227-BE7F95ECB954',
	name: 'menuitem17',
	text: '高校名录',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '高校名录',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/danganxinxi.png',
	textcls: '',
	appfunctag: 'Auto9',
	resourcetag: '',
},
		{
	id: '369B75B7-93E0-4C22-9621-4687EF533246',
	name: 'menuitem18',
	text: '学科目录',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '学科目录',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/zhichengmuluguanli.png',
	textcls: '',
	appfunctag: 'Auto15',
	resourcetag: '',
},
		{
	id: '043A6115-6C1E-4815-9F52-1878181498D5',
	name: 'menuitem19',
	text: '应聘者审批原因',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '应聘者审批原因',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/kfgl/1/peixunjiluguanli.png',
	textcls: '',
	appfunctag: 'Auto3',
	resourcetag: '',
},
	],
},
        ],
    }];
});

