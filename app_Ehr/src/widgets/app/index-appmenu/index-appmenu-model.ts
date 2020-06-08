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
	id: '0F92CD84-D833-41BE-93CD-BA1A1225469E',
	name: 'menuitem6',
	text: '首页',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '首页',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: true,
	iconcls: 'fa fa-home',
	icon: '',
	textcls: '',
	appfunctag: 'EhrPortal',
	resourcetag: '',
	authtag:'Ehr-Index-menuitem6',
},
        {
	id: '32A14A67-DCE3-4FFF-AE07-CFAF9BAA9956',
	name: 'menuitem1',
	text: '组织管理',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '组织管理',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/hetongguanli.png',
	textcls: '',
	appfunctag: 'EHROrm',
	resourcetag: '',
	authtag:'Ehr-Index-menuitem1',
},
        {
	id: 'C1650E4A-B02E-4AA0-80F4-845867CF1A74',
	name: 'menuitem2',
	text: '基础管理',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '基础管理',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/gerenxinxi.png',
	textcls: '',
	appfunctag: 'EHRPim',
	resourcetag: '',
	authtag:'Ehr-Index-menuitem2',
},
        {
	id: '2B856896-661C-43B3-B819-9EAED44F8FB5',
	name: 'menuitem3',
	text: '招聘管理',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '招聘管理',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/1/xiaoyuanzhaopin.png',
	textcls: '',
	appfunctag: 'EHRPcm',
	resourcetag: '',
	authtag:'Ehr-Index-menuitem3',
},
        {
	id: '737F99E3-1510-4A3D-B2E6-2C9697FC94AF',
	name: 'menuitem4',
	text: '人员异动',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '人员异动',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/zzgl/1/xiangmurenyuanpeizhi.png',
	textcls: '',
	appfunctag: 'EHRPcm2',
	resourcetag: '',
	authtag:'Ehr-Index-menuitem4',
},
        {
	id: 'A2924D79-9F36-410F-986B-2919301E93FB',
	name: 'menuitem5',
	text: '假勤管理',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '假勤管理',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/newimage/1/kaiqinguanli.png',
	textcls: '',
	appfunctag: 'EHRAtt',
	resourcetag: '',
	authtag:'Ehr-Index-menuitem5',
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
            appfunctag: 'EHRAtt',
            appfuncyype: 'OPENHTMLPAGE',
        },
        {
            appfunctag: 'EHRPcm',
            appfuncyype: 'OPENHTMLPAGE',
        },
        {
            appfunctag: 'EhrPortal',
            appfuncyype: 'APPVIEW',
            openmode: '',
            codename: 'ehrportalview',
            deResParameters: [],
            routepath: '/index/:index?/ehrportalview/:ehrportalview?',
            parameters: [
                { pathName: 'ehrportalview', parameterName: 'ehrportalview' },
            ],
        },
        {
            appfunctag: 'EHRPcm2',
            appfuncyype: 'OPENHTMLPAGE',
        },
        {
            appfunctag: 'EHRPim',
            appfuncyype: 'OPENHTMLPAGE',
        },
        {
            appfunctag: 'EHROrm',
            appfuncyype: 'OPENHTMLPAGE',
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