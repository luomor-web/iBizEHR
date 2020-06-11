/**
 * Index 部件模型
 *
 * @export
 * @class IndexModel
 */
export default class IndexModel {

    /**
     * 菜单项集合
     *
     * @public
     * @type {any[]}
     * @memberof IndexModel
     */
    public items: any[] = [
        {
	id: 'F7678570-4284-4B33-965C-03C544E3BCE6',
	name: 'menuitem1',
	text: '通知发布',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '通知发布',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/newimage/1/lianghuamubiaotianbao.png',
	textcls: '',
	appfunctag: '',
	resourcetag: '',
	authtag:'EHRPar-Index-menuitem1',
	items: [
		{
	id: 'FC6CD42F-45FF-4CB2-9850-5E8D9218B0D2',
	name: 'menuitem7',
	text: '通知发布',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '通知发布',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jlgl/1/xiangmugongzibiaozhun.png',
	textcls: '',
	appfunctag: '_3',
	resourcetag: '',
	authtag:'EHRPar-Index-menuitem7',
},
	],
},
        {
	id: 'B79E0B4B-11A3-4C16-985A-7C55F7F490C7',
	name: 'menuitem2',
	text: '基础设置',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '基础设置',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/xiujiaxinxi.png',
	textcls: '',
	appfunctag: '',
	resourcetag: '',
	authtag:'EHRPar-Index-menuitem2',
	items: [
		{
	id: 'E19489FC-D484-4DE0-B218-6DCA4FF50339',
	name: 'menuitem6',
	text: '考核周期设置',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '考核周期设置',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/newimage/1/kaoqinshezhi.png',
	textcls: '',
	appfunctag: '_2',
	resourcetag: '',
	authtag:'EHRPar-Index-menuitem6',
},
	],
},
        {
	id: 'E7E5CD4C-661D-4349-96C9-EBBA3F060DFE',
	name: 'menuitem3',
	text: '绩效考核',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '绩效考核',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/newimage/1/jixiaoguanli.png',
	textcls: '',
	appfunctag: '',
	resourcetag: '',
	authtag:'EHRPar-Index-menuitem3',
},
        {
	id: '2F60AB7A-CF33-494F-A31A-AC27911B89A8',
	name: 'menuitem4',
	text: '绩效定级',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '绩效定级',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/newimage/1/jixiaojieguo.png',
	textcls: '',
	appfunctag: '',
	resourcetag: '',
	authtag:'EHRPar-Index-menuitem4',
},
        {
	id: '68BAE88C-A429-4EC7-BF6D-097AFDF05202',
	name: 'menuitem5',
	text: '绩效应用',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '绩效应用',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/newimage/1/jixiaoyingyong.png',
	textcls: '',
	appfunctag: '',
	resourcetag: '',
	authtag:'EHRPar-Index-menuitem5',
},
    ];

	/**
	 * 应用功能集合
	 *
	 * @public
	 * @type {any[]}
	 * @memberof IndexModel
	 */
	public funcs: any[] = [
        {
            appfunctag: '_2',
            appfuncyype: 'APPVIEW',
            openmode: '',
            codename: 'parexamcyclegridview',
            deResParameters: [],
            routepath: '/index/:index?/parexamcycles/:parexamcycle?/gridview/:gridview?',
            parameters: [
                { pathName: 'parexamcycles', parameterName: 'parexamcycle' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
        },
        {
            appfunctag: '_3',
            appfuncyype: 'APPVIEW',
            openmode: '',
            codename: 'partzgggridview',
            deResParameters: [],
            routepath: '/index/:index?/partzggs/:partzgg?/gridview/:gridview?',
            parameters: [
                { pathName: 'partzggs', parameterName: 'partzgg' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
        },
	];

    /**
     * 获取所有菜单项集合
     *
     * @returns {any[]}
     * @memberof IndexModel
     */
    public getAppMenuItems(): any[] {
        return this.items;
    }

    /**
     * 获取所有应用功能集合
     *
     * @returns {any[]}
     * @memberof IndexModel
     */
    public getAppFuncs(): any[] {
        return this.funcs;
    }
}