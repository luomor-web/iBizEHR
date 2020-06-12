/**
 * OrgPNum 部件模型
 *
 * @export
 * @class OrgPNumModel
 */
export default class OrgPNumModel {

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof OrgPNumPortlet_OrmPNumList_listMode
	 */
	public getDataItems(): any[] {
		return [
			{
				name: 'countnum',
			},
			{
				name: 'orgname',
			},
      {
        name:'size',
        prop:'size'
      },
      {
        name:'query',
        prop:'query'
      },
      {
        name:'sort',
        prop:'sort'
      },
      {
        name:'page',
        prop:'page'
      },
      // 前端新增修改标识，新增为"0",修改为"1"或未设值
      {
        name: 'srffrontuf',
        prop: 'srffrontuf',
        dataType: 'TEXT',
      },
		]
	}

}