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
	id: '4176781E-2367-44AA-ACD5-D7142B8BDA83',
	name: 'menuitem1',
	text: '基础信息',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '基础信息',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '',
	textcls: '',
	appfunctag: '',
	resourcetag: '',
	authtag:'EHRSoc-Index-menuitem1',
	items: [
		{
	id: '644835C8-0CD2-4186-90A3-70E9C1A1C57C',
	name: 'menuitem2',
	text: '参保地',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '参保地',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '',
	textcls: '',
	appfunctag: '_3',
	resourcetag: '',
	authtag:'EHRSoc-Index-menuitem2',
},
		{
	id: 'F91CFF61-8640-4CD6-8583-FB96A9FE77B3',
	name: 'menuitem3',
	text: '参保账户',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '参保账户',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '',
	textcls: '',
	appfunctag: '_2',
	resourcetag: '',
	authtag:'EHRSoc-Index-menuitem3',
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