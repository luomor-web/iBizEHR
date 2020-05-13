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
	id: '0f50e185937758486cec3b68b642fb8a',
	name: 'menuitem45',
	text: '门户首页',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '门户首页',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/zzgl/1/zuzhiguanli.png',
	textcls: '',
	appfunctag: 'Auto479',
	resourcetag: '',
},
            {
	id: 'f7851cfe39370a4c0e62d1535c0ffeab',
	name: 'menuitem1',
	text: '人员信息',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '人员信息',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/gerenxinxi.png',
	textcls: '',
	appfunctag: '',
	resourcetag: '',
	items: [
		{
	id: '28b61b95856a278ba65c06e2328c2a68',
	name: 'menuitem2',
	text: '员工信息',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '员工信息',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/gerenxinxi.png',
	textcls: '',
	appfunctag: 'Auto477',
	resourcetag: '',
},
		{
	id: '45a615e824d06c5a334ddd706ad2418b',
	name: 'menuitem3',
	text: '自助信息审核',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '自助信息审核',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/1/xinyuangongzhuanzheng.png',
	textcls: '',
	appfunctag: 'Auto484',
	resourcetag: '',
},
		{
	id: 'd3cbd35d764f4cb6502374d5d6655bcd',
	name: 'menuitem10',
	text: '黑名单',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '黑名单',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/gongzuolvli.png',
	textcls: '',
	appfunctag: 'Auto464',
	resourcetag: '',
},
	],
},
            {
	id: 'cb401306e3edcc6037833bb5acdb5b3d',
	name: 'menuitem46',
	text: '人员花名册',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '人员花名册',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/1/chengshurencaizhaopin.png',
	textcls: '',
	appfunctag: '',
	resourcetag: '',
	items: [
		{
	id: '3784190772f4c6a853ac58beecc9a19c',
	name: 'menuitem11',
	text: '人员花名册',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '人员花名册',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/1/chengshurencaizhaopin.png',
	textcls: '',
	appfunctag: 'Auto480',
	resourcetag: '',
},
		{
	id: 'ced33fe11b10a66069492c0db5d7fbc1',
	name: 'menuitem4',
	text: '见习员工',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '见习员工',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/1/jianxiqiguanli.png',
	textcls: '',
	appfunctag: 'Auto469',
	resourcetag: '',
},
		{
	id: '52f83565d2e69d6fec44cea703a3d752',
	name: 'menuitem5',
	text: '试用员工',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '试用员工',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/1/shiyongqiguanli.png',
	textcls: '',
	appfunctag: 'Auto458',
	resourcetag: '',
},
		{
	id: 'af156768f414ea5c9d402ad858399f9b',
	name: 'menuitem6',
	text: '离(退)休人员',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '离(退)休人员',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/1/tuixiuguanli.png',
	textcls: '',
	appfunctag: 'Auto457',
	resourcetag: '',
},
		{
	id: '43972b8432de4db95162d594c9e38a7e',
	name: 'menuitem7',
	text: '离职人员',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '离职人员',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/newimage/1/guazhidaoqiguanli.png',
	textcls: '',
	appfunctag: 'Auto472',
	resourcetag: '',
},
		{
	id: '1d93d7ea58010fbe653292671927586f',
	name: 'menuitem8',
	text: '借调员工',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '借调员工',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/newimage/1/jiediaodaoqiguanli.png',
	textcls: '',
	appfunctag: 'Auto467',
	resourcetag: '',
},
		{
	id: 'ed6a25cfeaa7c2152b45101e66aa92b3',
	name: 'menuitem9',
	text: '挂职员工',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '挂职员工',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/newimage/1/guazhidaoqiguanli.png',
	textcls: '',
	appfunctag: 'Auto476',
	resourcetag: '',
},
	],
},
            {
	id: '579d4386b35c4153fb709bdaba0b67f4',
	name: 'menuitem13',
	text: '合同管理',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '合同管理',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/hetongxinxi.png',
	textcls: '',
	appfunctag: '',
	resourcetag: '',
	items: [
		{
	id: 'c55cd8d85fed9eadbe7a6d3c5d5b8d85',
	name: 'menuitem20',
	text: '劳务派遣公司',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '劳务派遣公司',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/laowupaiqiangongsiguanli.png',
	textcls: '',
	appfunctag: 'Auto475',
	resourcetag: '',
},
		{
	id: 'c5f9f12c9c3af1970c9fe18052cbf0e4',
	name: 'menuitem21',
	text: '合同信息',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '合同信息',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/hetongxinxi.png',
	textcls: '',
	appfunctag: 'Auto474',
	resourcetag: '',
},
		{
	id: '07c1ca214f70ca4dc8eeb54eee962b16',
	name: 'menuitem22',
	text: '初签(续签)提醒',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '初签(续签)提醒',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/kaoqinxinxi.png',
	textcls: '',
	appfunctag: 'Auto471',
	resourcetag: '',
},
		{
	id: '754e3718a04ad23b3e8795f40a77e95f',
	name: 'menuitem23',
	text: '终止提醒',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '终止提醒',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/newimage/1/kaoqinleixing.png',
	textcls: '',
	appfunctag: 'Auto454',
	resourcetag: '',
},
	],
},
            {
	id: '5c42d3a4354cda382b5e971f256334c1',
	name: 'menuitem14',
	text: '档案管理',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '档案管理',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/danganguanli.png',
	textcls: '',
	appfunctag: '',
	resourcetag: '',
	items: [
		{
	id: '29ecd1927102d3bd6287edb7288e5428',
	name: 'menuitem24',
	text: '档案信息',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '档案信息',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/danganguanli.png',
	textcls: '',
	appfunctag: 'Auto494',
	resourcetag: '',
},
		{
	id: 'd245f7f6f3eb29576ca2e1c6f119f068',
	name: 'menuitem25',
	text: '非员工在档提醒',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '非员工在档提醒',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/1/jianzhijilu.png',
	textcls: '',
	appfunctag: 'Auto492',
	resourcetag: '',
},
		{
	id: 'c5faa3d71f0b9a0e2a564895920be511',
	name: 'menuitem26',
	text: '员工不在档提醒',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '员工不在档提醒',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/kfgl/1/peixunjiluguanli.png',
	textcls: '',
	appfunctag: 'Auto459',
	resourcetag: '',
},
		{
	id: '7040989ed614f80e5770b53de116488f',
	name: 'menuitem27',
	text: '档案转出记录',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '档案转出记录',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/1/guazhiguanli.png',
	textcls: '',
	appfunctag: 'Auto489',
	resourcetag: '',
},
	],
},
            {
	id: 'aa09768aa71c38b87cd698279054b4b8',
	name: 'menuitem15',
	text: '证书管理',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '证书管理',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/zhiyezige.png',
	textcls: '',
	appfunctag: '',
	resourcetag: '',
	items: [
		{
	id: 'a79e5ca30970fca1dcc809b07fdf12c5',
	name: 'menuitem28',
	text: '证书信息',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '证书信息',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/zhiyezige.png',
	textcls: '',
	appfunctag: 'Auto488',
	resourcetag: '',
},
	],
},
            {
	id: '3779f3d3a686eb9bba4bbf899b406027',
	name: 'menuitem16',
	text: '职称管理',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '职称管理',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/newimage/1/penxunjihua.png',
	textcls: '',
	appfunctag: '',
	resourcetag: '',
	items: [
		{
	id: 'dc03ce202df9a833e1c1a256c1e3beb3',
	name: 'menuitem29',
	text: '职称信息',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '职称信息',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/newimage/1/penxunjihua.png',
	textcls: '',
	appfunctag: 'Auto460',
	resourcetag: '',
},
	],
},
            {
	id: '05a6e5be49010b4b03b169e43fd70742',
	name: 'menuitem17',
	text: '出(国)境管理',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '出(国)境管理',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/chujing.png',
	textcls: '',
	appfunctag: '',
	resourcetag: '',
	items: [
		{
	id: '3779d2c57afa299383c64ab869e3f772',
	name: 'menuitem30',
	text: '因公出(国)境',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '因公出(国)境',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/chujing.png',
	textcls: '',
	appfunctag: 'Auto493',
	resourcetag: '',
},
		{
	id: 'ac4ad6db606a02471b0ef03cf697cce5',
	name: 'menuitem31',
	text: '因私出(国)境',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '因私出(国)境',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/chujing.png',
	textcls: '',
	appfunctag: 'Auto455',
	resourcetag: '',
},
	],
},
            {
	id: '315f681bad02389867175b5e53450433',
	name: 'menuitem18',
	text: '离(退)休管理',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '离(退)休管理',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/1/tuixiuguanli.png',
	textcls: '',
	appfunctag: '',
	resourcetag: '',
	items: [
		{
	id: 'ab0ae703e2eabc60768d99da99ba0d6d',
	name: 'menuitem32',
	text: '离(退)休人员',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '离(退)休人员',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/1/tuixiuguanli.png',
	textcls: '',
	appfunctag: 'Auto457',
	resourcetag: '',
},
		{
	id: '2c055c21ec8205ef618f3f7b654be430',
	name: 'menuitem33',
	text: '老干部活动',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '老干部活动',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/junzhuanganbu.png',
	textcls: '',
	appfunctag: 'Auto462',
	resourcetag: '',
},
		{
	id: '6438730c51a35ffe8753e2872d8294db',
	name: 'menuitem34',
	text: '费用台账',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '费用台账',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/1/guazhiguanli.png',
	textcls: '',
	appfunctag: 'Auto487',
	resourcetag: '',
},
	],
},
            {
	id: 'a8bea59ad98ff35d0ef0dd1cea00f96f',
	name: 'menuitem19',
	text: '标准化数据设置',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '标准化数据设置',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/peixunxinxi.png',
	textcls: '',
	appfunctag: '',
	resourcetag: '',
	items: [
		{
	id: '7c48770b3cff54ca6c6c7dbbf1c000e6',
	name: 'menuitem35',
	text: '员工类型',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '员工类型',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/peixunxinxi.png',
	textcls: '',
	appfunctag: 'Auto490',
	resourcetag: '',
},
		{
	id: '8eedc5a8347eac073b4299fadb558a30',
	name: 'menuitem36',
	text: '合同类别',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '合同类别',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/hetongleixing.png',
	textcls: '',
	appfunctag: 'Auto481',
	resourcetag: '',
},
		{
	id: 'a60a3f3ccebb90b7a995e212f5f17468',
	name: 'menuitem37',
	text: '合同类型',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '合同类型',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/hetongxinxi.png',
	textcls: '',
	appfunctag: 'Auto498',
	resourcetag: '',
},
		{
	id: '5d9e028238da4f4ab6ffb65e788a6852',
	name: 'menuitem38',
	text: '专业序列类型',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '专业序列类型',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/1/rencaixulie.png',
	textcls: '',
	appfunctag: 'Auto470',
	resourcetag: '',
},
		{
	id: '94a81f32c2232dc085f64892f8def1f8',
	name: 'menuitem39',
	text: '见习期',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '见习期',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/1/jianxiqiguanli.png',
	textcls: '',
	appfunctag: 'Auto463',
	resourcetag: '',
},
		{
	id: 'f2742bfcc2356ab52f0fee92d5afd18f',
	name: 'menuitem40',
	text: '执业资格证书',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '执业资格证书',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/newimage/1/penxunkecheng.png',
	textcls: '',
	appfunctag: 'Auto491',
	resourcetag: '',
},
		{
	id: 'e57baa86399c1c9cb9292bcdfce8fea0',
	name: 'menuitem41',
	text: '岗位(技能)证书',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '岗位(技能)证书',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/newimage/1/kaoqinleixing.png',
	textcls: '',
	appfunctag: 'Auto496',
	resourcetag: '',
},
		{
	id: '2b1895b1f12f26eebabe4e273891e7f4',
	name: 'menuitem43',
	text: '职称目录',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '职称目录',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/zhichengmuluguanli.png',
	textcls: '',
	appfunctag: 'Auto473',
	resourcetag: '',
},
		{
	id: '4fed58fa04a78c56232e7874bba7066a',
	name: 'menuitem42',
	text: '档案类别',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '档案类别',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/zhiyezigemuluguanli.png',
	textcls: '',
	appfunctag: 'Auto466',
	resourcetag: '',
},
		{
	id: '9668ce150b60537b7bf2edec4881cbf7',
	name: 'menuitem44',
	text: '档案室',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '档案室',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/danganxinxi.png',
	textcls: '',
	appfunctag: 'Auto451',
	resourcetag: '',
},
	],
},
        ],
    }];
});
