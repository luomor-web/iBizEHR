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
	id: 'E889CC85-4929-4A4B-AC8A-BD25EAE4360C',
	name: 'menuitem1',
	text: '基础数据',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '基础数据',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jlgl/1/gongzidanmingxi.png',
	textcls: '',
	appfunctag: '',
	resourcetag: '',
	authtag:'EHRSal-Index-menuitem1',
	items: [
		{
	id: 'C25FBF7B-A076-44AF-A5C5-8FEE247C28FB',
	name: 'menuitem2',
	text: '薪酬类型',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '薪酬类型',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jlgl/1/gongzidanmingxi.png',
	textcls: '',
	appfunctag: '_6',
	resourcetag: '',
	authtag:'EHRSal-Index-menuitem2',
},
		{
	id: '57943DDD-3E1F-4796-939E-CB3906CF1E16',
	name: 'menuitem3',
	text: '薪酬计算源',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '薪酬计算源',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jlgl/1/xinchoujisuanyuan.png',
	textcls: '',
	appfunctag: '_4',
	resourcetag: '',
	authtag:'EHRSal-Index-menuitem3',
},
		{
	id: '39A731AF-766B-4AE0-8762-019277A8789A',
	name: 'menuitem4',
	text: '薪酬计算指标',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '薪酬计算指标',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jlgl/1/xinchoujisuanzhibiao.png',
	textcls: '',
	appfunctag: '_3',
	resourcetag: '',
	authtag:'EHRSal-Index-menuitem4',
},
		{
	id: '1B95461E-E287-4883-8821-67E436708D7E',
	name: 'menuitem5',
	text: '薪酬规则',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '薪酬规则',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jlgl/1/xinchoukemu.png',
	textcls: '',
	appfunctag: '_2',
	resourcetag: '',
	authtag:'EHRSal-Index-menuitem5',
},
		{
	id: 'BF32A34B-2291-4E92-A0E3-76D88D6FD723',
	name: 'menuitem6',
	text: '薪酬要素项',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '薪酬要素项',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jlgl/1/xinchoujisuanyaosu.png',
	textcls: '',
	appfunctag: '_7',
	resourcetag: '',
	authtag:'EHRSal-Index-menuitem6',
},
		{
	id: '8FC8C8D8-37F1-462F-8E0A-B5BE483E6E0A',
	name: 'menuitem7',
	text: '工资单',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '工资单',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jlgl/1/xinchoujisuanfangan.png',
	textcls: '',
	appfunctag: '_5',
	resourcetag: '',
	authtag:'EHRSal-Index-menuitem7',
},
	],
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